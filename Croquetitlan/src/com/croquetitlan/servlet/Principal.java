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


@WebServlet("/principal.view")
public class Principal extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
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
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html"); // // Establece tipo de contenido a enviar al cliente (browser)
		
		PrintWriter out = response.getWriter(); // regresa una refencia al stream de salida hacia el cliente
		
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		
		out.println("<!--Boostrap CSS-->");
		out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
		        
		out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
		        
		out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">");
		out.println("<link href=\"https://fonts.googleapis.com/css2?family=Titillium+Web:wght@600&display=swap\" rel=\"stylesheet\">");
		        
		out.println("<link rel=\"icon\" href=\"/images/logo.jpg\">");
		out.println("<title>CROQUETITLÁN</title>");
		   
			out.println("</head>");
			out.println("<body>");
			
			Trabajadores trabajador = (Trabajadores) request.getSession().getAttribute("trabajador");
			
			out.println("<div class=\"d-flex\">");
			out.println("<div id=\"sidebar-container\" class=\"bg-primary\">");
			out.println("<div class=\"control\">");
			out.println("<h3 class=\"text-light font-weight-bold p-3\"><img src=\"images/logo.jpg\" class=\"logo-C mr-2\" alt=\"logo\">CROQUETITLÁN</h3>");
			out.println("<h5 class=\"text-light p-3\">Control de Tienda</h5>");
			out.println("</div>");
			out.println("<div class=\"menu\">");
			out.println("<a href=\"almacen.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"cube\"></ion-icon>Almacén</a>");
			out.println("<a href=\"ventas.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"basket\"></ion-icon> Ventas</a>");
			out.println("<a href=\"gastos.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"cash\"></ion-icon> Gastos</a>");
			out.println("<a href=\"promociones.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"pricetags\"></ion-icon> Promociones</a>");
			out.println("<a href=\"clientes.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"people\"></ion-icon> Clientes Frecuentes</a>");
			out.println("<a href=\"trabajadoresserv.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"people\"></ion-icon>Trabajadores</a>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class=\"w-100\">");
			out.println("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">");
			out.println("<div class=\"container\">");
			out.println("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
			out.println("<span class=\"navbar-toggler-icon\"></span>");
			out.println("</button>");

			out.println("<form class=\"form-inline position-relative my-2 d-inline-block\">");
			out.println("<input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Buscar\" aria-label=\"Buscar\">");
			out.println("<button class=\"btn btn-search position-absolute\" type=\"submit\"><ion-icon name=\"search-outline\"></ion-icon></button>");
			out.println("</form>");
		        
			out.println("<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">");
			out.println("<ul class=\"navbar-nav ml-auto\">");
			out.println("<li class=\"nav-item dropdown\">");
			out.println(" <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">");
			out.println("<img src=\"images/foto.jpg\" class=\"img-fluid rounded-circle foto mr-2\">");
			out.println( trabajador.getNombre() );
			out.println("</a>");
			out.println("<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">");
			out.println("<a class=\"dropdown-item\" href=\"principal.view\">Inicio</a>");
			out.println("<div class=\"dropdown-divider\"></div>");
			out.println("<a class=\"dropdown-item\" href=\"logout.controller\">Cerrar Sesión</a>");
			out.println("</div>");    
			out.println("</li>");
			out.println("</ul>");
			out.println("</div>");
			out.println("</div>");
			out.println("</nav>");

			out.println("<div id=\"content\">");
			out.println("<section class=\"py-3\">");
			out.println("<div class=\"container\">");
			out.println("<div class=\"row\">");
			out.println("<div class=\"col-lg-9\">");
			out.println("<h1 class=\"font-weight-bold mb-0\">Bievenido "+ trabajador.getNombre() +"</h1>");
			out.println("<p class=\"lead text-muted\">Productos de tienda</p>");
			out.println("</div>");
			out.println("<div class=\"col-lg-3\">");
		    
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("</section>");

			out.println("<section id=\"tarjetas\"  class=\"btn-light-grey\">");
			out.println("<div class=\"card-deck\">");
			out.println("<div class=\"card\">");
			out.println("<img class=\"card-img-top\" src=\"images/p1.jpg\" alt=\"Card image cap\">");
			out.println("<div class=\"card-body\">");
			out.println("<h5 class=\"card-title\">Camisa de Leopardo</h5>");
			out.println("<p class=\"card-text\">Talla: Chica | Mediana | Grande</p>");
			out.println("<p class=\"card-text\">Precio: $</p>");
			out.println("<p class=\"card-text\">Material: </p>");
			out.println("<p class=\"card-text\">Color: Negro, Naranja y Café</p>");
			out.println("<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class=\"card\">");
			out.println("<img class=\"card-img-top\" src=\"images/p2.jpg\" alt=\"Card image cap\">");
			out.println("<div class=\"card-body\">");
			out.println("<h5 class=\"card-title\">Arnés y Correa</h5>");
			out.println("<p class=\"card-text\">Talla: Chica | Mediana | Grande</p>");
			out.println("<p class=\"card-text\">Precio: $</p>");
			out.println("<p class=\"card-text\">Material: </p>");
			out.println("<p class=\"card-text\">Color: Rosa </p>");
			out.println("<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>");                            
			out.println("</div>");
			out.println("</div>");
			out.println("<div class=\"card\">");
			out.println("<img class=\"card-img-top\" src=\"images/p3.jpg\" alt=\"Card image cap\">");
			out.println("<div class=\"card-body\">");
			out.println("<h5 class=\"card-title\">Collar para nombre y dirección</h5>");
			out.println("<p class=\"card-text\">Talla: Chica | Mediana | Grande</p>");
			out.println("<p class=\"card-text\">Precio: $</p>");
			out.println("<p class=\"card-text\">Material: </p>");
			out.println("<p class=\"card-text\">Color: Plata </p>");
			out.println("<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>");                            
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class=\"card-deck\">");
			out.println("<div class=\"card\">");
			out.println("<img class=\"card-img-top\" src=\"images/p4.jpg\" alt=\"Card image cap\">");
			out.println("<div class=\"card-body\">");
			out.println("<h5 class=\"card-title\">Arnés y Correa</h5>");
			out.println("<p class=\"card-text\">Talla: Chica | Mediana | Grande</p>");
			out.println("<p class=\"card-text\">Precio: $</p>");
			out.println("<p class=\"card-text\">Material: </p>");
			out.println("<p class=\"card-text\">Color: Negro </p>");
			out.println("<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class=\"card\">");
			out.println("<img class=\"card-img-top\" src=\"images/p5.jpg\" alt=\"Card image cap\">");
			out.println("<div class=\"card-body\">");
			out.println("<h5 class=\"card-title\">Vestido</h5>");
			out.println("<p class=\"card-text\">Talla: Chica | Mediana | Grande</p>");
			out.println("<p class=\"card-text\">Precio: $</p>");
			out.println("<p class=\"card-text\">Material: </p>");
			out.println("<p class=\"card-text\">Color: Rosa </p>");
			out.println("<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>");
		                            
			out.println("</div>");
			out.println("</div>");
			out.println("<div class=\"card\">");
			out.println("<img class=\"card-img-top\" src=\"images/p6.jpg\" alt=\"Card image cap\">");
			out.println("<div class=\"card-body\">");
			out.println("<h5 class=\"card-title\">Collar con dije de luna</h5>");
			out.println("<p class=\"card-text\">Talla: Chica | Mediana | Grande</p>");
			out.println("<p class=\"card-text\">Precio: $</p>");
			out.println("<p class=\"card-text\">Material: </p>");
			out.println("<p class=\"card-text\">Color: Rosa </p>");
			out.println("<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>");                         
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class=\"card-deck\">");
			out.println("<div class=\"card\">");
			out.println("<img class=\"card-img-top\" src=\"images/p7.jpg\" alt=\"Card image cap\">");
			out.println("<div class=\"card-body\">");
			out.println("<h5 class=\"card-title\">Traje con corbata de moño</h5>");
			out.println("<p class=\"card-text\">Talla: Chica | Mediana | Grande</p>");
			out.println("<p class=\"card-text\">Precio: $</p>");
			out.println("<p class=\"card-text\">Material: </p>");
			out.println("<p class=\"card-text\">Color: Negro con Blanco </p>");
			out.println("<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class=\"card\">");
			out.println("<img class=\"card-img-top\" src=\"images/p8.jpg\" alt=\"Card image cap\">");
			out.println("<div class=\"card-body\">");
			out.println("<h5 class=\"card-title\">Bolsa de Juegos</h5>");
			out.println("<p class=\"card-text\">Talla: Chica | Mediana | Grande</p>");
			out.println("<p class=\"card-text\">Precio: $</p>");
			out.println("<p class=\"card-text\">Material: </p>");
			out.println("<p class=\"card-text\">Color: Morada </p>");
			out.println("<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>");                            
			out.println("</div>");
			out.println("</div>");
			out.println("<div class=\"card\">");
			out.println("<img class=\"card-img-top\" src=\"images/p9.jpg\" alt=\"Card image cap\">");
			out.println("<div class=\"card-body\">");
			out.println("<h5 class=\"card-title\">Cama</h5>");
			out.println("<p class=\"card-text\">Talla: Chica | Mediana | Grande</p>");
			out.println("<p class=\"card-text\">Precio: $</p>");
			out.println("<p class=\"card-text\">Material: </p>");
			out.println("<p class=\"card-text\">Color: Gris con Blanco </p>");
			out.println("<p class=\"card-text\"><small class=\"text-muted\">Last updated 3 mins ago</small></p>");                            
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("</section>");

			out.println("<section id=\"footer\" class=\"bg-light\">");
			out.println("<div class=\"container\">");
			out.println("<small>©2019 All Rights Reserved. Created by Themes Bootstrap</small>");
			out.println("</div>");
			out.println("</section>");
		    out.println("</div>");
		    out.println("</div>");
		    out.println("</div>");
		  
		                    
		    out.println("<script src=\"js/jquery-3.5.1.min.js\"></script>");
		    out.println("<script src=\"js/popper.min.js\"></script>");
		    out.println("<script src=\"js/bootstrap.min.js\"></script>");
		    out.println("<script src=\"https://unpkg.com/ionicons@5.4.0/dist/ionicons.js\"></script>");
		    
		    out.println("</body>");
		    out.println("</html>");
		    
		out.close();
	}  
   

}