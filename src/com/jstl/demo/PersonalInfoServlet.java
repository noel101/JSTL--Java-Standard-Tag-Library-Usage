package com.jstl.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jstl.demo.PersonalInfoBean;


public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PersonalInfoServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonalInfoBean personalInfoBean = new PersonalInfoBean();
		personalInfoBean.setFirstName(request.getParameter("firstname"));
		personalInfoBean.setLastName(request.getParameter("lastname"));
		personalInfoBean.setGender(request.getParameter("gender"));
		
		HttpSession ses = request.getSession();
		ses.setAttribute("pInfo", personalInfoBean);

		response.sendRedirect("html/contactinfo.html");
		
	}

	
	

}
