package src.com.croquetitlan.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.croquetitlan.servlet.credenciales;
import com.croquetitlan.bd.Bd;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;
import com.croquetitlan.bd.Bd.Conexion;

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

@WebServlet("/ingventa.controller")
public class IngVenta extends HttpServlet implements Servlet {
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
		List<Transacciones> transaccionS = new ArrayList<>();//Esta se usa al final
		List<VProductoEnt> vProductoEntS = new ArrayList<>();//Productos que lleva
		List<VProductoGra> vProductoGraS = new ArrayList<>();//Productos Que lleva de gramos
		List<Producto> productoS = null;
		List<Gramaje> gramajeS = null;
		try {
			ins = new InsercionBD();
			ConsultasBD consultas = new ConsultasBD();
			productoS = consultas.obtenerProductos();
			gramajeS = consultas.obtenerGramajes();
		}catch(ClassNotFoundException | SQLException | DAOInitializationException ex) {
			
		}
		//Variables con las listas de los productos, si no ha agregado nada se quedan vacías
		try {
			vProductoEntS = (List<VProductoEnt>) request.getSession().getAttribute("vproductoents");
		}catch(Exception ex) {}
		try {
			vProductoGraS = (List<VProductoGra>) request.getSession().getAttribute("vproductogras");
		}catch(Exception ex) {}
		
		if(vProductoEntS == null && vProductoGraS == null)//Aun no selecciona producto
		{
			//request.getSession().setAttribute("vproductoents", vProductoEntS);
			RequestDispatcher rd = request.getRequestDispatcher("registroventa.view");
			rd.forward(request, response);
			return;
		}else if(vProductoGraS == null){//Solo ha ingresado enteros
			try {
				insertaEnteros();
				insertaTransaccion();
			}catch(Exception ex){
				
			}
		}else if(vProductoEntS == null) {//Solo ingresó gramajes
			try {
				insertaGramajes();
				insertaTransaccion();
			}catch(Exception ex){
				
			}
		}else {//Ingreso de ambos
			try {
				insertaEnteros();
				insertaGramajes();
				insertaTransaccion();
			}catch(Exception ex){
				
			}
		}
		/*
		if(request.getParameter("pesocostal")!="")//Opcional 2
			producto.setPesoCostal(Float.parseFloat(request.getParameter("pesocostal")));
		*/
		
	}
	private void insertaEnteros() {
		/*
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
		}*/
	}
	private void insertaGramajes() {
		
	}
	private void insertaTransaccion() {
		
	}
}
