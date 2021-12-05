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

import src.com.croquetitlan.bs.CatEstados;
import src.com.croquetitlan.dao.DAOInitializationException;
import src.com.croquetitlan.dao.DataAccessObject;

public class BorradoBD extends DataAccessObject {
	public BorradoBD() throws ClassNotFoundException, SQLException 
	{
		super();
	}
	public void delCatEstados(CatEstados obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Borrando Datos
	    try {
	        sql = "insert from catestados where idestado=?";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setInt(1, obj.getIdEstado());
	        
            pStmt.executeUpdate();
	    } catch (SQLException ex) {
	    	obj.setIdEstado(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
	}
}
