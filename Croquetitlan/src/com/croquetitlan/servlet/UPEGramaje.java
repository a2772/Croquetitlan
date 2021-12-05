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

@WebServlet("/upegramaje.controller")
public class UPEGramaje extends HttpServlet implements Servlet {
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
		
		int idGram = Integer.parseInt(request.getParameter("idgram"));//Recuperamos id de la seleccion y llenamos objeto
		//Recuperamos valores
		ConsultasBD consultas = null;
		Gramaje g = null;
		try {
			mod = new ModificacionBD();
			consultas = new ConsultasBD();
			List<Gramaje> gS = consultas.obtenerGramajes();
			g = new Gramaje();
			g.setIdGram(idGram);
			for(int i=0;i<gS.size();i++) {//buscamos por id
				if(g.getIdGram()==gS.get(i).getIdGram()) {
					g=gS.get(i);
					i=gS.size();//Salimos
				}
			}
			//Ya tenemos el objeto, ahora lo actualizamos
			//Vamos a actualizar aquellos valores que no se hayan dejado como nulos
			if(request.getParameter("fechacaducidad")!="")
				g.setFechaCaducidad(LocalDate.parse(request.getParameter("fechacaducidad")));
			if(request.getParameter("cantidad")!="")
				g.setCantidad(Float.parseFloat(request.getParameter("cantidad")));
			if(request.getParameter("preciokg")!="")
				g.setPrecioKg(Float.parseFloat(request.getParameter("preciokg")));
			if(request.getParameter("descripcion")!="")
				g.setDescripcion(request.getParameter("descripcion"));
			if(request.getParameter("gramajemin")!="")
				g.setGramajeMin(Float.parseFloat(request.getParameter("gramajemin")));
				
			mod.updGramaje(g);
			rd = request.getRequestDispatcher("principal.view");
			rd.forward(request, response);
			return;
		}catch(ClassNotFoundException | SQLException | DAOInitializationException ex) {
			System.out.println(ex);
		}
	}
}
