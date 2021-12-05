package com.croquetitlan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;
import src.com.croquetitlan.bs.Trabajadores;

@WebServlet("/error.view")
public class ShowErrorServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doSomething(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doSomething(request, response);
	}
	
	/**
	 * @see HttpServlet#doSomething(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  // Establece el tipo de contenido que el servlet va a enviar al cliente
		PrintWriter out = response.getWriter(); // Abre un canal de comunicacion con el cliente   // Portal multidimensional from Toulouse
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>La Bicla</title>");
		//out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
		out.println("</head>");
		
		out.println("<body>");
		
		Trabajadores user = (Trabajadores) request.getSession().getAttribute("trabajador");		
		if(user == null)
		{
			// No hay usuario autenticado
			
			out.println("<form action=\"authenticate.controller\" method=\"GET\">");
			out.println("Email ");
			out.println("<input type=\"text\" name=\"email\">");
			out.println("Password ");
			out.println("<input type=\"text\" name=\"password\">");
			out.println("<input type=\"submit\" value=\"Entrar\">");
			out.println("</form>");
		}
		else
		{
			// SI hay usuario autenticado
			out.println("<div>" + user.getNombre() + " <a href=\"logout.controller\">Salir</a></div>");
		}
		out.println("<br>");
		
		String error = (String) request.getAttribute("error");
				
		if(error == null)
		{
			out.println("<font color=\"red\">No se encontro informacion del error a mostrar</font>");
		}
		else
		{
			out.println(error);
		}
		out.println("<br>");
		out.println("<br>");
		
		out.println("<a href=\"/LaBicla\">Principal</a>");
		out.println("</body>");
		out.println("</html>");
	}
}

