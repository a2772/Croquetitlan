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


@WebServlet("/main.view")
public class MainServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doSomething(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doSomething(request, response);
	}
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html"); // // Establece tipo de contenido a enviar al cliente (browser)
		
		PrintWriter out = response.getWriter(); // regresa una refencia al stream de salida hacia el cliente
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		out.println("<meta name=\"description\" content=\"\">");
		out.println("<meta name=\"author\" content=\"\">");
		out.println("<link rel=\"icon\" href=\"logo.jpg\">");
		out.println("<title>Croquetitlan</title>");
		out.println(" <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.0/examples/sign-in/\">");
		out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
		out.println("<link href=\"css/signin.css\" rel=\"stylesheet\">");
		out.println("<link rel=\"stylesheet\" href=\"css/estilos.css\">");
		out.println("<link rel=\"stylesheet\" href=\"css/fondos.css\">");
		
		out.println("</head>");
		
		out.println("<body class=\"text-center\" id=\"b1\">");
		
		Trabajadores user = (Trabajadores) request.getSession().getAttribute("trabajador");
		String error = (String) request.getSession().getAttribute("error");
		if(user == null)
		{
			// No hay usuario autenticado
			out.println("<div class=\"container \">");
			out.println("<div class=\"row justify-content-center pt-5 mt-5 mr-1\">");
			out.println("<div class=\"col-md-4 oscuro\">");
			out.println("<div class=\"form-group mx-sm-4 my-1\">");
			out.println("<form action=\"authenticate.controller\" method=\"POST\" class=\"form-signin\">");
			out.println(" <img class=\"mb-4\" src=\"images\\logo.jpg\" alt=\"\" width=\"72\" height=\"72\"> ");
			out.println(" <h1 class=\"h3 mb-3 font-weight-normal\">CROQUETITLÁN</h1>");
			out.println("</div>");
			out.println("<div class=\"form-group mx-sm-4 text-center\">");
			out.println("<label for=\"inputEmail\" class=\"sr-only\">Correo electrónico</label>");
			out.println("<input type=\"email\" id=\"inputEmail\" name=\"email\" class=\"form-control\" placeholder=\"Correo electrónico\" required autofocus>");
			out.println("<label for=\"inputPassword\" class=\"sr-only\">Contraseña</label> ");
			out.println("<input type=\"password\" id=\"inputPassword\" name=\"password\"class=\"form-control\" placeholder=\"Contraseña\" required>");
			if(error=="1")
				out.println("<label class=\"login-error\">  Credenciales no válidas  </label> ");
			out.println("<input type=\"submit\" class=\"btn btn-lg btn-primary btn-block\" value=\"Ingresar\">");
			out.println("<p class=\"mt-5 mb-3 text-muted\">&copy; 2021 </p>");
			out.println("</div>");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
		}
		else
		{
			// Si hay usuario autenticado
			out.println("<div>" + user.getNombre() + " <a href=\"logout.controller\">Salir</a></div>");
		}
		
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}
