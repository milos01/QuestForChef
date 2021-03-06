package com.packtpub.springmvc.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.packtpub.springmvc.model.User;
import com.packtpub.springmvc.model.VerificationToken;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void updatePerson(User p,User u) {
		Session session = this.sessionFactory.getCurrentSession();
		p.setFirstName(u.getFirstName());
		p.setLastName(u.getLastName());
		p.setPassword(u.getPassword());
		session.merge(p);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();

		List<User> personsList = session.createQuery("from Person").list();
		// for(Person p : personsList){
		// }
		return personsList;
	}

	@Override
	public User getPerson(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query1 = session.createQuery("FROM User u WHERE u.email = :string_email");
		query1.setParameter("string_email", email);
		List<User> userList = query1.list();
		User tk = null;
		for (User users : userList) {
			tk = users;
		}
		return tk;

	}

	@Override
	public boolean getPersonByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query1 = session.createQuery("FROM User u WHERE u.email = :string_email");
		query1.setParameter("string_email", email);
		List<User> userList = query1.list();
		boolean tk = false;
		for (User users : userList) {
			tk = true;
		}
		if (tk){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void removePerson(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUserByName(String fname, String lname) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query1 = session.createQuery("FROM User u WHERE lower(u.firstName) = :string_fname and lower(u.lastName) = :string_lname");
		query1.setParameter("string_fname", fname.toLowerCase());
		query1.setParameter("string_lname", lname.toLowerCase());
		List<User> userList = query1.list();
		User tk = null;
		for (User users : userList) {
			tk = users;
		}
		return tk;
	}

	@Override
	public void updatePerson(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(p);
	}

	@Override
	public User findUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query1 = session.createQuery("FROM User u WHERE u.id = :string_id");
		query1.setParameter("string_id", id);
		List<User> userList = query1.list();
		User tk = null;
		for (User users : userList) {
			tk = users;
		}
		return tk;
	}

}
