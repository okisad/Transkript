package com.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.abstracts.SchoolInfo;
import com.entity.UserDAO;
import com.interfaces.UserDatabaseService;



public class UserDatabaseServiceImp implements UserDatabaseService{

	Session session;
	
	SessionFactory sessionFactory;
	
	UserDAO user;
	
	String info;
	
	public UserDatabaseServiceImp() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		openConnection();
		
	}
	
	private boolean openConnection() {
		try {

			this.session = sessionFactory.openSession();
		} catch (HibernateException ex) {
			this.setInfo("Database hatasi");
			return false;
		}
		return true;
	}

	private void closeConnection() {
		try {
			this.session.close();

		} catch (HibernateException e) {

			this.setInfo("Database hatasi");

		}
	}
	
	@Override
	public boolean isExistUser(UserDAO user) {
		
		if (!this.session.isOpen()) {

			openConnection();

		}

		this.session.beginTransaction();

		Query query = this.session
				.createQuery("FROM UserDAO u WHERE u.email=:email");

		List<Object> personList = query.setProperties(user).list();

		if (personList.size() > 0) {

			this.setInfo("Email daha önceden alınmış");

			if (this.session.isOpen()) {

				closeConnection();

			}
			return true;

		} else {

			if (this.session.isOpen()) {

				closeConnection();

			}
			return false;

		}

	}

	@Override
	public boolean isRegisterSuccess(UserDAO user) {
		try {

			if (this.isExistUser(user)) {

				return false;

			} else {

				if (!this.session.isOpen()) {

					openConnection();

				}

				this.session.beginTransaction();

				this.session.save(user);

				this.session.getTransaction().commit();

				if (this.session.isOpen()) {

					closeConnection();

				}
				this.setInfo("Kayıt başarı ile oluşturuldu");

				return true;

			}

		} catch (HibernateException e) {

			this.setInfo("Database hatasi");

			return false;

		}
	}

	@Override
	public boolean isLoginSuccess(UserDAO user) {
		
		if (!this.session.isOpen()) {

			openConnection();

		}

		this.session.beginTransaction();

		Query query = this.session
				.createQuery("FROM UserDAO u WHERE u.email=:email AND u.password1=:password1");

		List<Object> userList = query.setProperties(user).list();

		if (userList.size() > 0) {

			UserDAO takedUser = (UserDAO) userList.get(0);

			//p1.getCourses();
			
			this.setUser(takedUser);
			
			if (this.session.isOpen()) {

				closeConnection();

			}

			return true;

		} else {

			this.setInfo("Email veya şifre hatali");

			if (this.session.isOpen()) {

				closeConnection();

			}

			return false;

		}
		
	}
	
	

	@Override
	public boolean inputProcess(UserDAO user) {
		

		if (!this.session.isOpen()) {

			openConnection();

		}

		this.session.beginTransaction();

		UserDAO p = (UserDAO) this.session.get(UserDAO.class, user.getId());
		
		System.out.println(p);
		
		p.getCourses().clear();

		p.getCourses().addAll(user.getCourses());
		
		System.out.println(p);

		this.session.getTransaction().commit();

		if (this.session.isOpen()) {

			closeConnection();

		}
		return true;
		
	}

	@Override
	public UserDAO getPersonFromEmail(String email) {
		
openConnection();
		
		session.beginTransaction();
		
		UserDAO pGet = null;
		
		Query query = this.session.createQuery("FROM UserDAO p WHERE p.email=:email");
		
		List<Object> personList = query.setParameter("email", email).list();
		
		if(personList.size()>=1){
			
			pGet = (UserDAO) personList.get(0);
			
		}
		
		UserDAO p = (UserDAO) session.get(UserDAO.class, pGet.getId());
		
		p.getCourses();
		
		closeConnection();
		
		return p;
		
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}
	
	

	
	
}
