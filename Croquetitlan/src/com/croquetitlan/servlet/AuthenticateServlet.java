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
import src.com.croquetitlan.bd.Validaciones;
import src.com.croquetitlan.bs.Trabajadores;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

@WebServlet("/authenticate.controller")
public class AuthenticateServlet extends HttpServlet implements Servlet {
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
		Validaciones val = null;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		if(email==null || email.trim().equals("") || password == null || password.trim().equals(""))
		{
			RequestDispatcher rd = request.getRequestDispatcher("error_parametros.html");
			rd.forward(request, response);
			return;
		}
		try {
			val= new Validaciones();
			Trabajadores trabajador = new Trabajadores(email, password);
			//Llenamos
			trabajador=val.Login(trabajador);
			//Validamos si es correcto
			if(trabajador!=null) // Encontro un registro -- Credenciales validas
			{
				request.getSession().setAttribute("error", "0");
				//Terminamos la TIRANÍA del User value object y de la Bicla >:)
				request.getSession().setAttribute("trabajador", trabajador);
				
				RequestDispatcher rd = request.getRequestDispatcher("principal.view");
				rd.forward(request, response);
				return;				
			}
			else // Las credenciales NO son validas
			{
				request.setAttribute("error", "<font color=\"red\">Credenciales son invalidas</font>");
				request.getSession().setAttribute("error", "1");
				RequestDispatcher rd = request.getRequestDispatcher("main.view");
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
