package com.croquetitlan.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import src.com.croquetitlan.bd.ConsultasBD;
import src.com.croquetitlan.bs.*;
import src.com.croquetitlan.dao.DAOInitializationException;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;


@WebServlet("/apeproductoent.view")
public class APEProducto extends HttpServlet implements Servlet {
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
		//Desplegables
		List<CatProducto> catProductoS = null;
		try {
			ConsultasBD consultas = new ConsultasBD();
			catProductoS = consultas.obtenerCatProductos();
		}catch(ClassNotFoundException | SQLException | DAOInitializationException ex) {
			
		}
		//Fin desplegables
		
		//Si es 1, es para producto, si es 2 es para gramaje, si es 3 es para abrir alguna bolsa
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
		//out.println("<link href=\"css/producto.css\" rel=\"stylesheet\">");
	        
		out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">");
		out.println("<link href=\"https://fonts.googleapis.com/css2?family=Titillium+Web:wght@600&display=swap\" rel=\"stylesheet\">");
	        
		out.println("<link rel=\"icon\" href=\"/images/logo.jpg\">");
		out.println("<title>CROQUETITL?N</title>");
	   
		out.println("</head>");
		out.println("<body>");
		Trabajadores user = (Trabajadores) request.getSession().getAttribute("trabajador");
		out.println("<div class=\"d-flex\">");
		out.println("<div id=\"sidebar-container\" class=\"bg-primary\">");
		out.println("<div class=\"control\">");
		out.println("<h3 class=\"text-light font-weight-bold p-3\"><img src=\"images/logo.jpg\" class=\"logo-C mr-2\" alt=\"logo\">CROQUETITL?N</h3>");
		out.println("<h5 class=\"text-light p-3\">Control de Tienda</h5>");
		out.println("</div>");
		out.println("<div class=\"menu\">");
		out.println("<a href=\"almacen.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"cube\"></ion-icon>Almac?n</a>");
		out.println("<a href=\"ventas.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"basket\"></ion-icon> Ventas</a>");
		out.println("<a href=\"gastos.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"cash\"></ion-icon> Gastos</a>");
		out.println("<a href=\"promociones.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"pricetags\"></ion-icon> Promociones</a>");
		out.println("<a href=\"clientes.view\" class=\"d-block text-light p-3\"><ion-icon class=\"mr-2 lead\" name=\"people\"></ion-icon> Clientes Frecuentes</a>");
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
		out.println("<a class=\"dropdown-item\" href=\"logout.controller\">Cerrar Sesi?n</a>");
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
		out.println("<h1 class=\"font-weight-bold mb-0\">Bienvenido " + user.getNombre());
		out.println("</h1>");
		out.println("<p class=\"lead text-muted\">Formulario para Actualizar las Existencias</p>");
		out.println("</div>");
		out.println("<div class=\"col-lg-3\">");
	    
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</section>");
		try {
			//Recuperamos valores
			ConsultasBD consultas = new ConsultasBD();
			List<Producto> pS = consultas.obtenerProductos();
			//Inicio FORM
			out.println("<div class=\"container\">");
			out.println("<div class=\"content-center\">");
			out.println("<form action=\"upeproducto.controller\" method=\"POST\">");
			//Inician
			//				Desplegable productos
			out.println("<div class=\"form-group\">");
			out.println("<label for=\"producto\">Nombre del producto</label>");
			out.println("<select class=\"form-control\" name=\"idprod\">");
			for(int i=0;i<pS.size();i++) {
				out.println("<option value=" + (i+1) + ">Id: " + pS.get(i).getIdProd() + "; Nombre: " + pS.get(i).getNombre() + "; Caducidad: " + pS.get(i).getFechaCaducidad() + "; Existencias: "+ pS.get(i).getCantidad() + "; Peso del costal: " + pS.get(i).getPesoCostal() + "; Precio: $" + pS.get(i).getPrecioUnit() + "</option>");
			}
			out.println("</select>");
			out.println("</div>");
			//	FIN desplegable productos
			out.println("<div class=\"form-group\">");
			out.println("<label for=\"exampleFormControlInput6\">Nueva descripci?n</label>");
			out.println("<input type=\"text\" class=\"form-control\" name=\"descripcion\" id=\"exampleFormControlInput6\"  placeholder=\"Ingresa la nueva descripci?n\">");
			out.println("</div>");
			out.println("<div class=\"form-group\">");
			out.println("<label for=\"exampleFormControlInput6\">Fecha de Caducidad (Solo en alimentos)</label>");
			out.println("<input type=\"date\" class=\"form-control\" name=\"fechacaducidad\" id=\"exampleFormControlInput6\" placeholder=\"Ingresa la nueva fecha en la que caducan los productos\">");
			out.println("</div>");
			out.println("<div class=\"form-group\">");
			out.println("<label for=\"exampleFormControlInput3\">Cantidad</label>");
			out.println("<input type=\"number\" class=\"form-control\" name=\"cantidad\" min=1  id=\"exampleFormControlInput3\" placeholder=\"Cantidad nueva de productos\">");
			out.println("</div>");
			out.println("<div class=\"form-group\">");
			out.println("<label for=\"exampleFormControlInput4\">Precio por unidad</label>");
			out.println("<input type=\"number\" class=\"form-control\" step=\"0.01\" min=0.01 name=\"preciounitario\" id=\"exampleFormControlInput4\" placeholder=\"$\">");
			out.println("</div>");
			out.println("<div class=\"form-group\">");
			out.println("<label for=\"exampleFormControlInput5\">Peso del costal (Solo en alimentos)</label>");
			out.println("<input type=\"number\" class=\"form-control\" step=\"0.01\" min=0.01 name=\"pesocostal\" id=\"exampleFormControlInput5\" placeholder=\"Kg\">");
			out.println("</div>");
			out.println("</div>");
			out.println("<br>");
			out.println("<br>");
			out.println("<center>");
			out.println("<input type=\"submit\" class=\"boton-personalizado\" value=\"Update\">");
			out.println("<br><br><br><br>");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</center>");
			//Fin FORM
			
		}catch(Exception exe) {
			System.out.println(exe);
		}
		out.println("<br>");
		out.println("<br>");

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