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

@WebServlet("/ingventalistas.controller")
public class IngVentaListas extends HttpServlet implements Servlet {
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
		IdBD ids = null;
		ConsultasBD consultas = null;
		List<VProductoEnt> vProductoEntS = new ArrayList<>();//Productos que lleva
		List<VProductoGra> vProductoGraS = new ArrayList<>();//Productos Que lleva de gramos
		List<Producto> productoS = new ArrayList<>();
		List<Gramaje> gramajeS = new ArrayList<>();
		try {
			consultas = new ConsultasBD();
			ids = new IdBD();
			productoS = consultas.obtenerProductos();
			gramajeS = consultas.obtenerGramajes();
		}catch(ClassNotFoundException | SQLException | DAOInitializationException ex) {
			System.out.println(ex+"UNO");
		}
		try {
			if(request.getParameter("vproductoents")!=null && request.getParameter("vproductoents")!="" ) {
				vProductoEntS = (List<VProductoEnt>) request.getSession().getAttribute("vproductoents");
			}
			VProductoEnt vProductoEnt = new VProductoEnt();//Productos que lleva
			VProductoGra vProductoGra = new VProductoGra();//Productos Que lleva de gramos
			//Para enteros
			if(request.getParameter("cantidadprod")!="") {
				vProductoEnt.setIdprod(Integer.parseInt(request.getParameter("idprod")));
				vProductoEnt.setCantidad(Integer.parseInt(request.getParameter("cantidadprod")));
				vProductoEnt.setIdtransaccion(ids.getIdTransacciones());
				System.out.println(vProductoEnt.getIdprod()+"Cant: "+vProductoEnt.getCantidad() + "Id: " + vProductoEnt.getIdtransaccion());
				vProductoEntS.add(vProductoEnt);
				
				request.getSession().setAttribute("vproductoents", vProductoEntS);
				for(int i=0;i<vProductoEntS.size();i++)
					System.out.println(vProductoEntS.get(i).getNombre());
			}
		}catch(SQLException | DAOInitializationException ex) {
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("registroventa.view");
		rd.forward(request, response);
		return;
	}
}
