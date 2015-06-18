package com.model;

import java.util.Iterator;
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
import com.entity.School.Department;
import com.entity.School.Faculty;
import com.entity.School.Subject;
import com.entity.School.Year;
import com.interfaces.WebServicesDatabaseService;

public class WebServicesDatabaseServiceImp implements
		WebServicesDatabaseService {

	Session session;

	SessionFactory sessionFactory;

	UserDAO user;

	String info;

	public WebServicesDatabaseServiceImp() {

		Configuration configuration = new Configuration();

		configuration.configure();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();

		this.sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		openConnection();

	}

	private void openConnection() {

		try {

			this.session = sessionFactory.openSession();
		} catch (HibernateException ex) {
			this.setInfo("Database hatasi");
		}

	}

	@Override
	public List<Department> getDepartmentFromFaculty(String fak) {
		// TODO Auto-generated method stub
		openConnection();

		session.beginTransaction();

		Query query = this.session
				.createQuery("FROM fakulte f WHERE f.facultyName=:fak");

		List<Faculty> liste = query.setParameter("fak", fak).list();

		Faculty faculty = (Faculty) liste.get(0);

		query = this.session
				.createQuery("FROM bolumler b WHERE b.faculty=:fac");

		List<Department> departments = query.setParameter("fac", faculty)
				.list();

		return departments;
	}

	@Override
	public List<Year> getYearOfDepartmantFromDepartment(String dep) {

		openConnection();

		session.beginTransaction();

		Query query = this.session
				.createQuery("FROM bolumler b WHERE b.dep_name=:dep");

		List<Department> deps = query.setParameter("dep", dep).list();

		Department department = (Department) deps.get(0);

		query = this.session
				.createQuery("FROM yillar y WHERE y.department=:dep");

		List<Year> years = query.setParameter("dep", department).list();

		return years;

	}

	@Override
	public List<Subject> getSubjectsOfYearFromYearAndDepartment(Department dep,
			String yearNo) {

		openConnection();

		session.beginTransaction();

		Query query = this.session
				.createQuery("FROM yillar y WHERE y.department=:dep");

		List<Year> years = query.setParameter("dep", dep).list();

		Iterator<Year> it = years.listIterator();

		Year y1 = null;

		while (it.hasNext()) {

			Year y = it.next();

			if (yearNo.equals(y.getYear())) {

				y1 = y;

			}

		}

		query = this.session.createQuery("FROM dersler d WHERE d.year=:year");

		List<Subject> subs = query.setParameter("year", y1).list();

		return subs;

	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
