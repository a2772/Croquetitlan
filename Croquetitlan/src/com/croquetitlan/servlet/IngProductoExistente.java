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

@WebServlet("/ingproductoexistente.controller")
public class IngProductoExistente extends HttpServlet implements Servlet {
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
		Producto producto = new Producto();
		
		
		if(request.getParameter("producto") == "" || request.getParameter("cantidad") == "" || request.getParameter("preciounitario") == "")
		{
			request.getSession().setAttribute("errorinsproductoexistente", "1");
			RequestDispatcher rd = request.getRequestDispatcher("registroproductoexistencia.view");
			rd.forward(request, response);
			return;
		}
		//Si pasa la validacion de datos necesarios
		producto.setIdProducto(Integer.parseInt(request.getParameter("producto")));
		if(request.getParameter("fechacaducidad")!="")//Opcional 1
			producto.setFechaCaducidad(LocalDate.parse(request.getParameter("fechacaducidad")));
		producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		producto.setPrecioUnit(Float.parseFloat(request.getParameter("preciounitario")));
		if(request.getParameter("pesocostal")!="")//Opcional 2
			producto.setPesoCostal(Float.parseFloat(request.getParameter("pesocostal")));
		
		
		try {
			ins= new InsercionBD();
			//Insertamos
			producto.setIdProd(ins.insProducto(producto));
			//Validamos si es correcto
			if(producto.getIdProducto()>0) // Inserción exitosa
			{
				request.getSession().setAttribute("errorinsproductoexistente", "0");
				RequestDispatcher rd = request.getRequestDispatcher("principal.view");
				rd.forward(request, response);
				return;				
			}
			else // Inserccion fallida
			{
				request.getSession().setAttribute("errorinsproductoexistente", "1");
				RequestDispatcher rd = request.getRequestDispatcher("registroproductoexistencia.view");
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
