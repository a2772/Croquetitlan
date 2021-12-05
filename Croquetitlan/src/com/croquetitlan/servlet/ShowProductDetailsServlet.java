package com.croquetitlan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.valueobject.ProductValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;
import src.com.croquetitlan.bs.Trabajadores;


@WebServlet("/product_details.view")
public class ShowProductDetailsServlet extends HttpServlet implements Servlet {
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
		
		ProductValueObject product = (ProductValueObject) request.getAttribute("product");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>La Bicla</title>");
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
				
		if(product == null)
		{
			out.println("<font color=\"red\">No se encontro el producto indicado</font>");
		}
		else
		{
			out.println("<p> Nombre ");
			out.println(product.getName());
			out.println("</p>");
			out.println("<p> Descripcion");
			out.println(product.getDescription());
			out.println("</p>");			
			out.println("<p> Marca");
			out.println(product.getBrand());
			out.println("</p>");
			out.println("<p> Precio");
			out.println(product.getPrice());
			out.println("</p>");
		}

		out.println("<br>");
		out.println("<br>");
		
		out.println("<a href=\"/LaBicla\">Principal</a>");
		out.println("</body>");
		out.println("</html>");

	}
}
