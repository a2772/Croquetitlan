package com.croquetitlan.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.croquetitlan.servlet.credenciales;
import com.croquetitlan.bd.Bd;
import com.croquetitlan.bd.Bd.Conexion;

import src.com.croquetitlan.bd.*;
import src.com.croquetitlan.bs.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

@WebServlet("/ingproductonuevo.controller")
public class IngProducto extends HttpServlet implements Servlet {
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
		boolean isValid=false;
		InsercionBD ins = null;
		CatProducto catProducto = null;
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		if(nombre==null || nombre.trim().equals("") || descripcion == null || descripcion.trim().equals(""))
		{
			request.getSession().setAttribute("errorinsproductonuevo", "1");
			RequestDispatcher rd = request.getRequestDispatcher("registrop.view");
			rd.forward(request, response);
			return;
		}
		try {
			ins= new InsercionBD();
			catProducto = new CatProducto();
			catProducto.setNombre(nombre);
			catProducto.setDescripcion(descripcion);
			//Insertamos
			catProducto.setIdProducto(ins.insCatProducto(catProducto));
			//Validamos si es correcto
			if(catProducto.getIdProducto()>0) // Inserción exitosa
			{
				request.getSession().setAttribute("errorinsproductonuevo", "0");
				RequestDispatcher rd = request.getRequestDispatcher("principal.view");
				rd.forward(request, response);
				return;				
			}
			else // Inserccion fallida
			{
				request.getSession().setAttribute("errorinsproductonuevo", "1");
				RequestDispatcher rd = request.getRequestDispatcher("registrop.view");
				rd.forward(request, response);
				return;
			}
		}catch(Exception ex){
			
		}finally {
			try{ if(rs != null) rs.close(); } catch(SQLException exi) { exi.printStackTrace();}
			try{ if(stmt != null) stmt.close(); } catch(SQLException exi) { exi.printStackTrace();}
			try{ if(con != null) con.close(); } catch(SQLException exi) { exi.printStackTrace();}
			
			System.out.println("AutenticarServlet - database resources were closed");
		}
	}
}
