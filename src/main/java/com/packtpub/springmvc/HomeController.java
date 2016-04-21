package com.packtpub.springmvc;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packtpub.springmvc.model.Restaurant;
import com.packtpub.springmvc.model.Role;
import com.packtpub.springmvc.model.Staff;
import com.packtpub.springmvc.model.User;
import com.packtpub.springmvc.service.PersonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private PersonService personService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired(required = true)
	@Qualifier(value = "personService")
	public void setPersonService(PersonService ps) {
		this.personService = ps;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		if(null != session.getAttribute("logedUser")){
			return "redirect:/home";
		}
		return "index";
	}
		
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home2(Locale locale, Model model, HttpSession session) {
		if(null == session.getAttribute("logedUser")){
			return "redirect:/";
		}
		List<Restaurant> restaurants = this.personService.listRestaurants();
		model.addAttribute("restaurants", restaurants);
		
		User u = (User) session.getAttribute("logedUser");
		if (u.getRole().getRoleName().equalsIgnoreCase("Manager")){
			Staff s = this.personService.getStaff(u.getEmail());
			Restaurant restaurant = this.personService.getRestaurant(s.getRestaurant().getId());
			
			Set<Staff> temp = restaurant.getStaff();
			List<Staff> staffList = new ArrayList<Staff>();
			
			for(Staff st: temp){
				
				if (st.getRole().getId()!=5){
					staffList.add(st);
				}
//				System.out.println(st.getFirstName());
			}
			model.addAttribute("staffList",staffList);
			
			model.addAttribute("restoran", restaurant);
			model.addAttribute("menadzer",s);
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/addNewStaff",method = RequestMethod.POST)
	public String addNewStaff(@ModelAttribute("radnik") Staff staff,@RequestParam("role_id") String rol,@RequestParam("birth_day")String bd,@RequestParam("restaurant_id")String idR) {
		
		Role temp = this.personService.getRole(Integer.parseInt(rol));
		Restaurant temp2 = this.personService.getRestaurant(Integer.parseInt(idR));
		staff.setRole(temp);
		staff.setRestaurant(temp2);
		
		try {
			Date tempDate = getFormatedDate(bd);
			staff.setBirth_date(tempDate);
			this.personService.addNewStaff(staff);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/editRestaurant",method = RequestMethod.POST)
	public String editRestaurant(@ModelAttribute("restoran1") Restaurant rest){
		this.personService.updateRestaurant(rest);
		
		return "redirect:/home";
	}
	
	public Date getFormatedDate(String date) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsed = format.parse(date);
        Date sql = new Date(parsed.getTime());
		return sql;
	}
	
}
