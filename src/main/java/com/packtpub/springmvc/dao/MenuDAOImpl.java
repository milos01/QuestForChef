package com.packtpub.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.packtpub.springmvc.model.AlcoholicDrink;
import com.packtpub.springmvc.model.Appetizer;
import com.packtpub.springmvc.model.Desert;
import com.packtpub.springmvc.model.MainCourse;
import com.packtpub.springmvc.model.Menu;
import com.packtpub.springmvc.model.NonAlcoholicDrink;
import com.packtpub.springmvc.model.VineCard;


@Repository
public class MenuDAOImpl implements MenuDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addAppetizer(Appetizer a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
		
	}

	@Override
	public void updateAppetizer(Appetizer a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(a);
		
		
	}

	@Override
	public List<Appetizer> listAppetizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDesert(Desert d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		
	}

	@Override
	public void updateDesert(Desert d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(d);
		
	}

	@Override
	public List<Desert> listDesert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMainCourse(MainCourse mc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(mc);
		
	}

	@Override
	public void updateMainCourse(MainCourse mc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(mc);
		
	}

	@Override
	public List<MainCourse> listMainCourse() {
		Session session = this.sessionFactory.getCurrentSession();
		
		List<MainCourse> list = session.createQuery("from Main_course").list();
		return list;
	}

	@Override
	public Menu getMenu(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query1 = session.createQuery("FROM Menu u WHERE u.id = :string_email");
		query1.setParameter("string_email", id);
		List<Menu> userList = query1.list();
		Menu tk = null;
		for (Menu users : userList) {
			tk = users;
		}
		return tk;
	}

	@Override
	public void updateMenu(Menu m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(m);
		
	}

	@Override
	public VineCard getVineCard(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query1 = session.createQuery("FROM Vine_card u WHERE u.id = :string_email");
		query1.setParameter("string_email", id);
		List<VineCard> userList = query1.list();
		VineCard tk = null;
		for (VineCard users : userList) {
			tk = users;
		}
		return tk;
	}

	@Override
	public void updateVineCard(VineCard c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(c);
		
	}

	@Override
	public void addAlcoholicDrink(AlcoholicDrink a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
	}

	@Override
	public void AddNonAlcoholicDrink(NonAlcoholicDrink a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(a);
	}
}
