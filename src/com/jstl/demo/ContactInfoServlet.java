package com.jstl.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jstl.demo.PersonalInfoBean;


public class ContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonalInfoBean personalInfoBean = (PersonalInfoBean) request.getSession().getAttribute("pInfo");
		if (personalInfoBean == null) {
			personalInfoBean = new PersonalInfoBean(); /*
														 * if null, create a new
														 * PersonalInfoBean
														 * instance
														 */
		}
		// STEP 1:

		personalInfoBean.setAddress(request.getParameter("address"));
		personalInfoBean.setCity(request.getParameter("city"));
		personalInfoBean.setCountry(request.getParameter("country"));
		personalInfoBean.setState(request.getParameter("state"));
		personalInfoBean.setPhone(request.getParameter("phone"));

		

		HttpSession ses = request.getSession();
		ses.setAttribute("pInfo", personalInfoBean);

		response.sendRedirect("html/bankinfo.html");
		
	}

}
