package com.jstl.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jstl.demo.PersonalInfoBean;


public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonalInfoBean personalInfoBean = (PersonalInfoBean) request.getSession().getAttribute("pInfo");
		if (personalInfoBean == null) {
			personalInfoBean = new PersonalInfoBean();
		}
		personalInfoBean.setBankName(request.getParameter("bankname"));
		personalInfoBean.setAccountNumber(request.getParameter("accountname"));
		personalInfoBean.setSsn(request.getParameter("ssn"));

		HttpSession ses = request.getSession();
		ses.setAttribute("pInfo", personalInfoBean);
		response.sendRedirect("jsp/outputsuccess.jsp");
	}

}
