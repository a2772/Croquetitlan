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

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

@WebServlet("/updproductoexistecias.controller")
public class UpdProductoExistencias extends HttpServlet implements Servlet {
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
		InsercionBD ins = null;
		int opcion = Integer.parseInt(request.getParameter("opcion"));
		System.out.println(opcion);
		//Según la opción
		switch(opcion) {
			case 0:
				request.getSession().setAttribute("erroractualizarproductoexistencia", "1");
				rd = request.getRequestDispatcher("actualizarproductoexistencia.view");
				rd.forward(request, response);
				return;
			case 1:
				request.getSession().setAttribute("erroractualizarproductoexistencia", "0");
				rd = request.getRequestDispatcher("apeproductoent.view");
				rd.forward(request, response);
				return;
			case 2:
				request.getSession().setAttribute("erroractualizarproductoexistencia", "0");
				rd = request.getRequestDispatcher("apeproductogra.view");
				rd.forward(request, response);
				break;
			case 3:
				break;
		}
	}
}
