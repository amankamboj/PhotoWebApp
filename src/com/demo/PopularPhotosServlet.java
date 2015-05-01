package com.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jinstagram.auth.oauth.InstagramService;

 
/**
 * Servlet implementation class ControllerServlet
 */

public class PopularPhotosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		request.setAttribute("code", code);
		InstagramService instagramService = (InstagramService)request.getSession().getAttribute("SERVICE_OBJ");
		List<PhotoBean> photos = PhotoUtil.getPopularPhotos(code,instagramService);
		request.setAttribute("photos", photos);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/popularPhotos.jsp");  
        rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
	
	 


	

