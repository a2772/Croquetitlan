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

@WebServlet("/search_products.controller")
public class SearchProductsServlet extends HttpServlet implements Servlet {
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
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String criterio = request.getParameter("criterio");
		
		String sql = "SELECT * FROM products WHERE name LIKE \'%" + criterio + "%\'";
		
		System.out.println(sql);
		
		try {
			Class.forName(DRIVER);
			
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			ProductValueObject product;
			List<ProductValueObject> productList = new ArrayList<ProductValueObject>();
			
			while(rs.next())
			{
				product = new ProductValueObject();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				//product.setDescription(rs.getString("description"));
				//product.setBrand(rs.getString("brand"));
				//product.setPrice(rs.getFloat("price"));
				product.setQuantity(rs.getInt("quantity"));
				
				productList.add(product);
			}
			
			request.setAttribute("productList", productList);
			
			RequestDispatcher rd = request.getRequestDispatcher("product_list.view");
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
