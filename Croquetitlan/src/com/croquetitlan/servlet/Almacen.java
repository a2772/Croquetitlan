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
import src.com.croquetitlan.bs.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import src.com.croquetitlan.dao.DAOInitializationException;


@WebServlet("/almacen.view")
public class Almacen extends HttpServlet implements Servlet {
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
		List<CatProducto> catProductoS = null;
		List<Producto> productoS = null;
		List<Gramaje> gramajeS = null;
		try {
			ConsultasBD consultas = new ConsultasBD();
			catProductoS = consultas.obtenerCatProductos();
			productoS = consultas.obtenerProductos();
			gramajeS = consultas.obtenerGramajes();
		}catch(ClassNotFoundException | SQLException | DAOInitializationException ex) {
			
		}
		response.setContentType("text/html"); // // Establece tipo de contenido a enviar al cliente (browser)
		
		PrintWriter out = response.getWriter(); // regresa una refencia al stream de salida hacia el cliente
		
		out.println("<html lang=\"es\">");
		out.println("<head>");
		
		out.println("<meta charset=\"UTF-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");

	
		out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
	        
		out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
	        
		out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">");
		out.println("<link href=\"https://fonts.googleapis.com/css2?family=Titillium+Web:wght@600&display=swap\" rel=\"stylesheet\">");
	        
		out.println("<link rel=\"icon\" href=\"/img/logo.jpg\">");
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
		out.println("<h1 class=\"font-weight-bold mb-0\">Bienvenido al Almacén</h1>");
		out.println("<p class=\"lead text-muted\">Control de Almacén</p>");
	                          
		out.println("</div>");
		out.println("<div class=\"col-lg-3\">");
	                              
		out.println("</div>");
		//Inicia Omise go Pt-0 viejo
		out.println("<table style=\"text-align:center;\">");
		//TAITEL
		out.println("<tr class=\"tr-consultas-taitel\">");
		out.println("<td colspan=\"3\">Lista de productos</th>");
		out.println("</tr>");
		//FIN TAITEL
		out.println("<tr class=\"tr-consultas-main\">");
		out.println("<th>Id del producto (Almacén)</th>");
		out.println("<th>Nombre del producto</th>");
		out.println("<th>Descripción</th>");
		out.println("</tr>");
		//Renglones
		for(int i=0;i<catProductoS.size();i++) {
			if(i%2==0)
				out.println("<tr class=\"tr-consultas-one\">");
			else
				out.println("<tr class=\"tr-consultas-two\">");
			//Imprimimos todo en cada renglón
			out.println("<td>");out.println( catProductoS.get(i).getIdProducto() );out.println("</td>");
			out.println("<td>");out.println( catProductoS.get(i).getNombre() );out.println("</td>");
			out.println("<td>");out.println( catProductoS.get(i).getDescripcion() );out.println("</td>");
			//Cerramos renglón
			out.println("</tr>");
		} 
		out.println("</table>");            
        //Fin OMG
		//Inicia Omise go Pt-1 viejo
		out.println("<table style=\"text-align:center;\">");
		//TAITEL
		out.println("<tr class=\"tr-consultas-taitel\">");
		out.println("<td colspan=\"6\">Productos unitarios</th>");
		out.println("</tr>");
		//FIN TAITEL
		out.println("<tr class=\"tr-consultas-main\">");
		out.println("<th>Id artículo unitario</th>");
		out.println("<th>Id de producto (Almacén)</th>");
		out.println("<th>Fecha de caducidad</th>");
		out.println("<th>Existencias</th>");
		out.println("<th>Precio por unidad</th>");
		out.println("<th>Peso del costal (Solo alimentos)</th>");
		out.println("</tr>");
		//Renglones
		for(int i=0;i<productoS.size();i++) {
			if(i%2==0)
				out.println("<tr class=\"tr-consultas-one\">");
			else
				out.println("<tr class=\"tr-consultas-two\">");
			//Imprimimos todo en cada renglón
			out.println("<td>");out.println( productoS.get(i).getIdProd() );out.println("</td>");
			out.println("<td>");out.println( productoS.get(i).getIdProducto() );out.println("</td>");
			if(productoS.get(i).getFechaCaducidad() == null) {
				out.println("<td>");out.println( "No aplica" );out.println("</td>");
			}else {
				out.println("<td>");out.println( productoS.get(i).getFechaCaducidad() );out.println("</td>");
			}
			out.println("<td>");out.println( productoS.get(i).getCantidad() );out.println("</td>");
			out.println("<td>");out.println( "$" + productoS.get(i).getPrecioUnit() );out.println("</td>");
			if(productoS.get(i).getPesoCostal() <= 0 ) {
				out.println("<td>");out.println( "No aplica" );out.println("</td>");
			}else {
				out.println("<td>");out.println( productoS.get(i).getPesoCostal() + " Kg" );out.println("</td>");
			}
			//Cerramos renglón
			out.println("</tr>");
		} 
		out.println("</table>");            
        //Fin OMG	
		//Inicia Omise go Pt-2 viejo
		out.println("<table style=\"text-align:center;\">");
		//TAITEL
		out.println("<tr class=\"tr-consultas-taitel\">");
		out.println("<td colspan=\"6\">Productos por gramaje</th>");
		out.println("</tr>");
		//FIN TAITEL
		out.println("<tr class=\"tr-consultas-main\">");
		out.println("<th>Id artículo gramaje</th>");
		out.println("<th>Id de producto (Almacén)</th>");
		out.println("<th>Fecha de caducidad</th>");
		out.println("<th>Peso de la mercancía abierta</th>");
		out.println("<th>Precio por Kilogramo</th>");
		out.println("<th>Gramaje mínimo por venta</th>");
		out.println("</tr>");
		//Renglones
		for(int i=0;i<gramajeS.size();i++) {
			if(i%2==0)
				out.println("<tr class=\"tr-consultas-one\">");
			else
				out.println("<tr class=\"tr-consultas-two\">");
			//Imprimimos todo en cada renglón
			out.println("<td>");out.println( gramajeS.get(i).getIdGram() );out.println("</td>");
			out.println("<td>");out.println( gramajeS.get(i).getIdProducto() );out.println("</td>");
			if(gramajeS.get(i).getFechaCaducidad() == null) {
				out.println("<td>");out.println( "No aplica" );out.println("</td>");
			}else {
				out.println("<td>");out.println( gramajeS.get(i).getFechaCaducidad() );out.println("</td>");
			}
			out.println("<td>");out.println( gramajeS.get(i).getCantidad() + " Kg" );out.println("</td>");//En este caso debe haber si o si
			out.println("<td>");out.println( "$" + gramajeS.get(i).getPrecioKg() );out.println("</td>");
			out.println("<td>");out.println( gramajeS.get(i).getGramajeMin() + " Kg" );out.println("</td>");
			//Cerramos renglón
			out.println("</tr>");
		} 
		out.println("</table>");            
        //Fin OMG
	                         
		out.println("</div>");
		out.println("<br><br>");
		out.println("<center>");
		out.println("<a class=\"boton-personalizado\" href=\"registrop.view\">Agregar Producto Nuevo</a>");
		out.println("<a class=\"boton-personalizado\" href=\"registroproductoexistencia.view\">Agregar Existencias</a>");
		out.println("<a class=\"boton-personalizado\" href=\"actualizarproductoexistencia.view\">Actualizar Existencias</a>");
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