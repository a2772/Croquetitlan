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
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

@WebServlet("/inggasto.controller")
public class IngGasto extends HttpServlet implements Servlet {
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
		src.com.croquetitlan.bs.Gastos gasto = new src.com.croquetitlan.bs.Gastos();
		
		
		if(request.getParameter("idgasto") == "" || request.getParameter("pagar") == "" || request.getParameter("fechalimite") == "" || request.getParameter("idgasto") == "")
		{
			request.getSession().setAttribute("errorinsgasto", "1");
			RequestDispatcher rd = request.getRequestDispatcher("registrogasto.view");
			rd.forward(request, response);
			return;
		}
		//Si pasa la validacion de datos necesarios
		gasto.setIdGasto(Integer.parseInt(request.getParameter("idgasto")));
		gasto.setFechaPago(LocalDate.parse(request.getParameter("fechalimite")));
		gasto.setTotal(Float.parseFloat(request.getParameter("pagar")));
		String pag = request.getParameter("pagado");
		if(pag=="1")
			pag="No pagado";
		else
			pag="Pagado";
		gasto.setPagado(pag);
		try {
			ins= new InsercionBD();
			//Insertamos
			gasto.setIdGasto(ins.insGastos(gasto));
			//Validamos si es correcto
			if(gasto.getIdGasto()>0) // Inserción exitosa
			{
				request.getSession().setAttribute("errorinsgasto", "0");
				RequestDispatcher rd = request.getRequestDispatcher("principal.view");
				rd.forward(request, response);
				return;				
			}
			else // Inserccion fallida
			{
				request.getSession().setAttribute("errorinsgasto", "1");
				RequestDispatcher rd = request.getRequestDispatcher("registrogasto.view");
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
