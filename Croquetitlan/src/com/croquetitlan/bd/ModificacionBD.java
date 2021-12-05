package src.com.croquetitlan.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import src.com.croquetitlan.bs.*;
import src.com.croquetitlan.dao.DAOInitializationException;
import src.com.croquetitlan.dao.DataAccessObject;

public class ModificacionBD extends DataAccessObject {
	public ModificacionBD() throws ClassNotFoundException, SQLException 
	{
		super();
	}
	public void updCatEstados(CatEstados obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Modificando Datos
	    try {
	        sql = "update catestados set estado=? where idestado=?";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getEstado());
	        pStmt.setInt(2, obj.getIdEstado());
	        
            pStmt.executeUpdate();
	    } catch (SQLException ex) {
	    	obj.setIdEstado(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
	}
	public void updProducto(Producto obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Modificando Datos
	    try {
	        sql = "update producto set fechacaducidad=?,cantidad=?,preciouni=?,pesocostal=? where idprod=?";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setObject(1, obj.getFechaCaducidad());
	        pStmt.setInt(2, obj.getCantidad());
	        pStmt.setFloat(3, obj.getPrecioUnit());
	        pStmt.setFloat(4, obj.getPesoCostal());
	        pStmt.setInt(5, obj.getIdProd());
	        pStmt.executeUpdate();
	    } catch (SQLException ex) {
	    	System.out.println(ex);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
	    try {
	        sql = "update catproducto set descripcion=? where idproducto=?";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getDescripcion());
	        pStmt.setInt(2, obj.getIdProducto());
            pStmt.executeUpdate();
	    } catch (SQLException ex) {
	    	System.out.println(ex);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
	}
	public void updGramaje(Gramaje obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Modificando Datos gramaje
	    try {
	        sql = "update gramaje set fechacaducidad=?,cantidad=? where idgram=?";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setObject(1, obj.getFechaCaducidad());
	        pStmt.setFloat(2, obj.getCantidad());
	        pStmt.setInt(3, obj.getIdGram());
	        pStmt.executeUpdate();
	    } catch (SQLException ex) {
	    	System.out.println(ex);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
	    //Modificando datos cat gramaje
	    try {
	        sql = "update catgramaje set preciokg=?,gramajemin=? where idgramaje=?";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        //Fase 2
	        pStmt.setFloat(1, obj.getPrecioKg());
	        pStmt.setFloat(2, obj.getGramajeMin());
	        pStmt.setInt(3, obj.getIdGramaje());
	        pStmt.executeUpdate();
	    } catch (SQLException ex) {
	    	System.out.println(ex);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
	    //Modificando cat producto
	    try {
	        sql = "update catproducto set descripcion=? where idproducto=?";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getDescripcion());
	        pStmt.setInt(2, obj.getIdProducto());
            pStmt.executeUpdate();
	    } catch (SQLException ex) {
	    	System.out.println(ex);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
	}
}
