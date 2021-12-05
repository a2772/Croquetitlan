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
import src.com.croquetitlan.bd.ConsultasBD;
import src.com.croquetitlan.bd.InsercionBD;
import src.com.croquetitlan.bs.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import src.com.croquetitlan.dao.DAOInitializationException;


@WebServlet("/registroventa.view")
public class RegistroVenta extends HttpServlet implements Servlet {
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
		List<Producto> pS = null;
		List<Gramaje> gS = null;
		try {
			ConsultasBD consultas = new ConsultasBD();
			pS = consultas.obtenerProductos();
			gS = consultas.obtenerGramajes();
		}catch(ClassNotFoundException | SQLException | DAOInitializationException ex) {
			
		}
		response.setContentType("text/html"); // // Establece tipo de contenido a enviar al cliente (browser)
		
		PrintWriter out = response.getWriter(); // regresa una refencia al stream de salida hacia el cliente
		
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println("<!--Required meta tags-->");
		out.println("<meta charset=\"UTF-8\">");
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
		Trabajadores user = (Trabajadores) request.getSession().getAttribute("trabajador");
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
		out.println("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">");
		out.println("<img src=\"images/foto.jpg\" class=\"img-fluid rounded-circle foto mr-2\">");
		out.println( user.getNombre() );
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
		out.println("<h1 class=\"font-weight-bold mb-0\">Bienvenido a Ventas</h1>");
		out.println("<p class=\"lead text-muted\">Registro de Ventas</p>");

	                            
	                          
		out.println("</div>");
		out.println("<div class=\"col-lg-3\">");
	                              
		out.println("</div>");
		out.println("<br><br>");
		
		//Inicio FORM unidades
		out.println("<div class=\"container\">");
		out.println("<div class=\"content-center\">");
		out.println("<form action=\"ingventalistas.controller\" method=\"POST\">");
		//	Desplegable productos
		out.println("<div class=\"form-group\">");
		out.println("<center>");
		out.println("<label for=\"producto\">Lista de productos por unidades</label>");
		out.println("</center>");
		out.println("<select class=\"form-control\" name=\"idprod\">");
		for(int i=0;i<pS.size();i++) {
			out.println("<option value=" + (i+1) + ">Id: " + pS.get(i).getIdProd() + "; Nombre: " + pS.get(i).getNombre() + "; Caducidad: " + pS.get(i).getFechaCaducidad() + "; Existencias: "+ pS.get(i).getCantidad() + "; Peso del costal: " + pS.get(i).getPesoCostal() + "; Precio: $" + pS.get(i).getPrecioUnit() + "</option>");
		}
		out.println("</select>");
		out.println("</div>");
		//	FIN desplegable productos
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"exampleFormControlInput3\">Cantidad</label>");
		out.println("<input type=\"number\" class=\"form-control\" name=\"cantidadprod\" min=1 step=\"1\" id=\"exampleFormControlInput3\" placeholder=\" Cantidad de productos\">");
		out.println("</div>");
		out.println("</div>");
		out.println("<br>");
		out.println("<br>");
		out.println("<center>");
		out.println("<input type=\"submit\" class=\"boton-personalizado\" value=\"Agregar al carrito\">");
		out.println("<br><br><br><br>");
		out.println("</form>");
		
		//Inicio FORM gramos
		out.println("<div class=\"container\">");
		out.println("<div class=\"content-center\">");
		out.println("<form action=\"ingventalistas.controller\" method=\"POST\">");
		//	Desplegable productos
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"producto\">Lista de productos por gramo</label>");
		out.println("<select class=\"form-control\" name=\"idgram\">");
		for(int i=0;i<gS.size();i++) {
			out.println("<option value=" + (i+1) + ">Id: " + gS.get(i).getIdGram() + "; Nombre: " + gS.get(i).getNombre() + "; Caducidad: " + gS.get(i).getFechaCaducidad() + "; Disponible: "+ gS.get(i).getCantidad() + "; Gramaje mínimo: " + gS.get(i).getGramajeMin() + "; Precio por Kg: $" + gS.get(i).getPrecioKg() + "</option>");
		}
		out.println("</select>");
		out.println("</div>");
		//	FIN desplegable productos
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"exampleFormControlInput3\">Cantidad</label>");
		out.println("<input type=\"number\" class=\"form-control\" name=\"cantidadgram\" min=0.001 step=\"0.001\" id=\"exampleFormControlInput3\" placeholder=\" Cantidad de productos\">");
		out.println("</div>");
		out.println("</div>");
		out.println("<br>");
		out.println("<br>");
		out.println("<center>");
		out.println("<input type=\"submit\" class=\"boton-personalizado\" value=\"Agregar al carrito\">");
		out.println("<br><br><br><br>");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</center>");
		//Fin FORM
		
		
		//Inicio FORM Carrito, primero obtenemos las listas

		List<VProductoEnt> vProductoEntS = new ArrayList<>();//Productos que lleva
		List<VProductoGra> vProductoGraS = new ArrayList<>();//Productos Que lleva de gramos
		try {
			vProductoEntS = (List<VProductoEnt>) request.getSession().getAttribute("vproductoents");
		}catch(Exception ex) {}
		try {
			vProductoGraS = (List<VProductoGra>) request.getSession().getAttribute("vproductogras");
		}catch(Exception ex) {}
		//
		out.println("<div class=\"container\">");
		out.println("<div class=\"content-center\">");
		out.println("<form action=\"ingventa.controller\" method=\"POST\">");
		//	Desplegable productos
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"producto\">Lista de productos por gramo</label>");
		out.println("<ul class=\"form-control\">");
		for(int i=0;i<vProductoEntS.size();i++) {
			out.println("<li type=\"disc\">Id de producto unitario: " + vProductoEntS.get(i).getIdprod() + "Producto: "  + pS.get(vProductoEntS.get(i).getIdprod()).getNombre() + "Cantidad: " + vProductoEntS.get(i).getCantidad() + "; Precio subtotal: $" + (vProductoEntS.get(i).getCantidad() * pS.get(vProductoEntS.get(i).getIdprod()).getPrecioUnit()) + "</option>");
		}																						//Minuscula porque hereda el de mayus, abajo no
		for(int i=0;i<vProductoGraS.size();i++) {
			out.println("<li type=\"disc\">Id de producto por gramaje: " + vProductoGraS.get(i).getIdGram()  + "Cantidad: " + vProductoGraS.get(i).getGramaje().getCantidad() + "</option>");
			// + "; Precio subtotal: $" + (vProductoGraS.get(i).getGramaje().getCantidad() * gS.get(vProductoGraS.get(i).getIdGram()).getPrecioKg()) + + "Producto: "  + gS.get(vProductoGraS.get(i).getIdGram()).getNombre() 
		}
		out.println("</ul>");
		out.println("</div>");
		//	FIN desplegable productos
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"exampleFormControlInput3\">Cantidad</label>");
		out.println("<input type=\"number\" class=\"form-control\" name=\"cantidad\" min=1 step=\"1\" id=\"exampleFormControlInput3\" placeholder=\" Cantidad de productos\">");
		out.println("</div>");
		out.println("</div>");
		out.println("<br>");
		out.println("<br>");
		out.println("<center>");
		out.println("<input type=\"submit\" class=\"boton-personalizado\" value=\"Agregar al carrito\">");
		out.println("<br><br><br><br>");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</center>");
		//Fin FORM
		
		out.println("</div>");
		out.println("<br><br>");
		out.println("<center>");
		out.println("<a class=\"boton-personalizado\" href=\"\">Agregar Venta</a>");
		out.println("<br><br><br><br>");
		out.println("</center>");
		out.println("</div>");
		out.println("</section>");
		out.println("</div>");
	                  
		out.println("</div>");
	    
		out.println("</div>");
	                 


		out.println("<section id=\"footer\" class=\"bg-light\">");
		out.println("<div class=\"container\">");
		out.println("<small>©2019 All Rights Reserved. Created by Themes Bootstrap</small>");
		out.println("</div>");
		out.println("</section>");

	            
	  
	                    
		out.println("<script src=\"js/jquery-3.5.1.min.js\"></script>");
		out.println("<script src=\"js/popper.min.js\"></script>");
		out.println("<script src=\"js/bootstrap.min.js\"></script>");
		out.println("<script src=\"https://unpkg.com/ionicons@5.4.0/dist/ionicons.js\"></script>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}  
   

}