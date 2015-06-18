package com.model;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.entity.CourseDAO;
import com.entity.UserDAO;
import com.interfaces.UserDatabaseService;


public class FormService {

	int rowNo = 0;

	private String domName;

	HttpServletRequest req;

	public FormService(HttpServletRequest req) {

		this.req = req;

	}

	public boolean handleAllInput(Enumeration<String> pageContext, UserDAO user) {

		UserDatabaseService dataService = new UserDatabaseServiceImp();

		user.getCourses().clear();
		
		int i = 0;
		
		CourseDAO course=null;

		while (pageContext.hasMoreElements()) {

			setDomName(pageContext.nextElement());
			
			if(getDomName().equals("kaydet")){
				continue;
			}

			if (i % 4 == 0) {

				course = isNewCourse(course);

			}
			
			courseSetProcess(course, user);

			System.out.println(course);
			
			System.out.println(getDomName());
			
			if (whichColumn(domName) == 4) {

				user.getCourses().add(
						new CourseDAO(course.getCourseCode(), course
								.getCourseDescription(), course.getCredit(),
								course.getCourseGrade(), course.getTerm(),
								course.getUserDAO()));

			}

			System.out.println(user);
			
			i++;

		}

		if (dataService.inputProcess(user)) {

			return true;

		} else {

			return false;

		}

	}

	public void courseSetProcess(CourseDAO c, UserDAO user) {

		if (whichColumn(domName) == 1) {

			c.setUserDAO(user);

			c.setTerm(whichTerm(domName));

			c.setCourseCode(this.req.getParameter(domName));

		} else if (whichColumn(domName) == 2) {

			c.setCourseDescription(this.req.getParameter(domName));

		} else if (whichColumn(domName) == 3) {

			c.setCourseGrade(this.req.getParameter(domName));

		} else if (whichColumn(domName) == 4) {

			c.setCredit((this.req.getParameter(domName)));

		}

	}

	public CourseDAO isNewCourse(CourseDAO c) {

		if (whichRow(domName) == 1) {

			rowNo = 0;

		}

		if (rowNo != whichRow(domName)) {

			System.out.println("girdi");
			
			c = new CourseDAO();

			rowNo++;

			return c;

		} else {

			return c;

		}

	}

	public boolean isNewTerm(String termName) {

		int first = Character.getNumericValue(termName.charAt(0));

		int middle = Character.getNumericValue(termName.charAt(2));

		int last = Character.getNumericValue(termName.charAt(4));

		if (first == middle) {

			if (first == last) {

				return true;

			} else {
				return false;
			}

		} else {
			return false;
		}

	}

	public int whichTerm(String termName) {

		int first = Character.getNumericValue(termName.charAt(0));

		return first;

	}

	public int whichRow(String termName) {

		int middle = Character.getNumericValue(termName.charAt(2));

		return middle;

	}

	public int whichColumn(String termName) {

		int last = Character.getNumericValue(termName.charAt(4));

		return last;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public String getDomName() {
		return domName;
	}

	public void setDomName(String domName) {
		this.domName = domName;
	}

}
