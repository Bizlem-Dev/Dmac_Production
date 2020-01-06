
package com.schedular;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShedularServlet
 */

public class ShedularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  


	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.callJob();
	}
	
	public void callJob(){
		System.out.println("inside servlet");
		CronTriggerTest.callCronJob();
	}
	

}
