package com.croquetitlan.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.valueobject.ProductValueObject;
import src.com.croquetitlan.bd.ConsultasBD;
import src.com.croquetitlan.bs.*;


@WebServlet("/get_product_details.controller")
public class GetProductDetailsServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/usuarios_db?serverTimezone=UTC";
	private static final String USER = credenciales.getUser();
	private static final String PASSWORD = credenciales.getPassword();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/*//Con esto llamaremos a las listas que aqui se envían
		List<CatProducto> catProductoS = (List<CatProducto>) request.getSession().getAttribute("catproductoS");
		List<CatGramaje> catGramajeS = (List<CatGramaje>) request.getSession().getAttribute("catgramajeS");
		List<Gramaje> gramajeS = (List<Gramaje>) request.getSession().getAttribute("gramajeS");
		List<Producto> productoS = (List<Producto>) request.getSession().getAttribute("productoS");
		*/
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		
		String sql = "SELECT * FROM products WHERE id = " + id;
		
		System.out.println(sql);
		
		try {
			Class.forName(DRIVER);
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			ProductValueObject product = null;

			if(rs.next())
			{
				product = new ProductValueObject();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getFloat("price"));
				product.setQuantity(rs.getInt("quantity"));
			}
			
			request.setAttribute("product", product);
			
			RequestDispatcher rd = request.getRequestDispatcher("product_details.view");
			rd.forward(request, response);
			return;
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
			
			StackTraceElement[] st = ex.getStackTrace();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i =0 ; i < st.length; i++)
			{
				sb.append(st[i].toString());
			}
		
			String mensajeError = "<font color=\"red\"><h1>Ocurrio un error</h1></font>"
					            + "<p>" +  ex.getMessage() + "</p>"
					            + "<p>" + sb.toString() + "</p>";
			
			request.setAttribute("error", mensajeError);

			RequestDispatcher rd = request.getRequestDispatcher("error.view");
			rd.forward(request, response);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			
			StackTraceElement[] st = ex.getStackTrace();
			
			StringBuffer sb = new StringBuffer();
			
			for(int i =0 ; i < st.length; i++)
			{
				sb.append(st[i].toString());
			}
		
			String mensajeError = "<font color=\"red\"><h1>Ocurrio un error con la base de datos</h1></font>"
					            + "<p>El query ejecutado fue [" + sql + "]"
					            + "<p>" +  ex.getMessage() + "</p>"
					            + "<p>" + sb.toString() + "</p>";
			
			request.setAttribute("error", mensajeError);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.view");
			rd.forward(request, response);
		}
		finally
		{
			try{ if(rs != null) rs.close(); } catch(SQLException exi) { exi.printStackTrace();}
			try{ if(stmt != null) stmt.close(); } catch(SQLException exi) { exi.printStackTrace();}
			try{ if(con != null) con.close(); } catch(SQLException exi) { exi.printStackTrace();}
		}
	}
}
