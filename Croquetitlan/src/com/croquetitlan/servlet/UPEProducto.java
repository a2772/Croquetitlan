package src.com.croquetitlan.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.croquetitlan.servlet.credenciales;
import com.croquetitlan.bd.Bd;
import java.time.LocalDate;
import com.croquetitlan.bd.Bd.Conexion;
import java.util.ArrayList;
import java.util.List;

import src.com.croquetitlan.bd.*;
import src.com.croquetitlan.bs.*;
import src.com.croquetitlan.dao.DAOInitializationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

@WebServlet("/upeproducto.controller")
public class UPEProducto extends HttpServlet implements Servlet {
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
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		RequestDispatcher rd = null;
		boolean isValid=false;
		ModificacionBD mod = null;
		
		int idProd = Integer.parseInt(request.getParameter("idprod"));//Recuperamos id de la seleccion y llenamos objeto
		//Recuperamos valores
		ConsultasBD consultas = null;
		Producto p = null;
		try {
			mod = new ModificacionBD();
			consultas = new ConsultasBD();
			List<Producto> pS = consultas.obtenerProductos();
			p = new Producto();
			p.setIdProd(idProd);
			for(int i=0;i<pS.size();i++) {//buscamos por id
				if(p.getIdProd()==pS.get(i).getIdProd()) {
					p=pS.get(i);
					i=pS.size();//Salimos
				}
			}
			//Ya tenemos el objeto, ahora lo actualizamos
			//Vamos a actualizar aquellos valores que no se hayan dejado como nulos
			if(request.getParameter("fechacaducidad")!="")
				p.setFechaCaducidad(LocalDate.parse(request.getParameter("fechacaducidad")));
			if(request.getParameter("cantidad")!="")
				p.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
			if(request.getParameter("preciounitario")!="")
				p.setPrecioUnit(Float.parseFloat(request.getParameter("preciounitario")));
			if(request.getParameter("descripcion")!="")
				p.setDescripcion(request.getParameter("descripcion"));
			if(request.getParameter("pesocostal")!="")
				p.setPesoCostal(Float.parseFloat(request.getParameter("pesocostal")));
				
			mod.updProducto(p);
			rd = request.getRequestDispatcher("principal.view");
			rd.forward(request, response);
			return;
		}catch(ClassNotFoundException | SQLException | DAOInitializationException ex) {
			System.out.println(ex);
		}
	}
}
