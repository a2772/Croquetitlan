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

import src.com.croquetitlan.dao.DAOInitializationException;
import src.com.croquetitlan.dao.DataAccessObject;
import src.com.croquetitlan.bs.*;

public class InsercionBD extends DataAccessObject {
	
	public InsercionBD() throws ClassNotFoundException, SQLException 
	{
		super();
	}
	public int insCatEstados(CatEstados obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando Datos
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdEstado(cons.getIdCatEstados());//Obtenemos el ID

	        sql = "insert into catestados(estado) values(?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getEstado());
	        
            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdEstado(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdEstado();
	}
	public int insCatEstatus(CatEstatus obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdStatus(cons.getIdCatEstatus());

	    	sql = "insert into catestatus(estatus,porcentaje) values(?,?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getEstatus());
	        pStmt.setFloat(2, obj.getPorcentaje());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdStatus(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdStatus();
	}
	public int insCatGastos(CatGastos obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdGasto(cons.getIdCatGastos());

	    	sql = "insert into catgastos(gasto) values(?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getGasto());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdGasto(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdGasto();
	}
	public int insCatGramaje(CatGramaje obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdGramaje(cons.getIdCatGramaje());

	    	sql = "insert into catgramaje(idproducto, preciokg, gramajemin) values(?,?,?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setInt(1, obj.getIdProducto());
	        pStmt.setFloat(2, obj.getPrecioKg());
	        pStmt.setFloat(3, obj.getGramajeMin());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdGramaje(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdGramaje();
	}
	public int insCatJerarquia(CatJerarquia obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdJerarquia(cons.getIdCatJerarquia());

	    	sql = "insert into catjerarquia(jerarquia) values(?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getJerarquia());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdJerarquia(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdJerarquia();
	}


	//Receipt
	public int insCatMunicipios(CatMunicipios obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdMunicipio(cons.getIdCatMunicipios());

	    	sql = "insert into catmunicipios(municipio, idEstado) values(?, ?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getMunicipio());
	        pStmt.setInt(2, obj.getIdEstado());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdMunicipio(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdMunicipio();
	}
	public int insCatProducto(CatProducto obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdProducto(cons.getIdCatProducto());

	    	sql = "insert into catproducto(nombre, descripcion) values(?, ?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getNombre());
	        pStmt.setString(2, obj.getDescripcion());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdProducto(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdProducto();
	}
	public int insClienteFrecuente(ClienteFrecuente obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdCliente(cons.getIdClienteFrecuente());

	    	sql = "insert into clientefrecuente(iddatos, idstatus) values(?, ?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setInt(1, obj.getIdDatos());
	        pStmt.setInt(2, obj.getIdEstatus());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdCliente(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdCliente();
	}
	public int insDatos(Datos obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdDatos(cons.getIdDatos());

	    	sql = "insert into datos(telefono, email, nombre, appat, apmat, fechanac, cp, idmunicipio, calle, numero, numerointerior) values(?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setString(1, obj.getTelefono());
	        pStmt.setString(2, obj.getEmail());
	        pStmt.setString(3, obj.getNombre());
	        pStmt.setString(4, obj.getApPat());
	        pStmt.setString(5, obj.getApMat());
	        pStmt.setObject(6, obj.getFechaNac());
	        pStmt.setString(7, obj.getCp());
	        pStmt.setInt(8, obj.getIdMunicipio());
	        pStmt.setString(9, obj.getCalle());
	        pStmt.setString(10, obj.getNumero());
	        pStmt.setString(11, obj.getNumInterior());
	        
            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdDatos(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdDatos();
	}
	public int insDescuentos(Descuentos obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdDescuento(cons.getIdDescuentos());

	    	sql = "insert into descuentos(idproducto, fechainicio, fechafin, solocliente, porcentaje, preciodesc, cantidadunit, cantidadgram) values(?, ?, ?, ?, ?, ?, ?, ? )";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setInt(1, obj.getIdProducto());
	        pStmt.setObject(2, obj.getFechaInicio());
	        pStmt.setObject(3, obj.getFechaFin());
	        pStmt.setString(4, obj.getSoloCliente());
	        pStmt.setDouble(5, obj.getPorcentaje());
	        pStmt.setDouble(6, obj.getPrecioDesc());
	        pStmt.setInt(7, obj.getCantidadUnit());
	        pStmt.setFloat(8, obj.getCantidadGram());
	        
            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdDescuento(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdDescuento();
	}
	public int insGastos(Gastos obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdGastMens(cons.getIdGastos());

	    	sql = "insert into gastos(idgastos, total, fechapago, pagado) values(?,?,?,?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setInt(1, obj.getIdGasto());
	        pStmt.setFloat(2, obj.getTotal());
	        pStmt.setObject(3, obj.getFechaPago());
	        pStmt.setString(4, obj.getPagado());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdGastMens(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdGastMens();
	}
	public int insGramaje(Gramaje obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdGram(cons.getIdGramaje());

	    	sql = "insert into gramaje(idgramaje, fechacaducidad, cantidad) values(?,?,?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setInt(1, obj.getIdGramaje());
	        pStmt.setObject(2, obj.getFechaCaducidad());
	        pStmt.setFloat(3, obj.getCantidad());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdGram(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdGram();
	}
	public int insProducto(Producto obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdProd(cons.getIdProducto());

	    	sql = "insert into producto(idproducto2, fechacaducidad, cantidad, preciouni, pesocostal) values(?,?,?,?,?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setInt(1, obj.getIdProducto());
	        pStmt.setObject(2, obj.getFechaCaducidad());
	        pStmt.setInt(3, obj.getCantidad());
	        pStmt.setFloat(4, obj.getPrecioUnit());
	        pStmt.setFloat(5, obj.getPesoCostal());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdProd(0);
	    	System.out.println(ex);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdProd();
	}
	public int insTrabajadores(Trabajadores obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdTrabajador(cons.getIdTrabajadores());

	    	sql = "insert into trabajadores(iddatos, rfc, curp, horas, sueldohora, idjerarquia) values(?,?,?,?,?,?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setInt(1, obj.getIdDatos());
	        pStmt.setObject(2, obj.getRfc());
	        pStmt.setString(3, obj.getCurp());
	        pStmt.setInt(4, obj.getHoras());
	        pStmt.setFloat(5, obj.getSueldoHora());
	        pStmt.setInt(6, obj.getIdJerarquia());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdTrabajador(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdTrabajador();
	}
	public int insTransacciones(Transacciones obj) throws SQLException, DAOInitializationException, ClassNotFoundException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	    PreparedStatement pStmt = null;
	    String sql;
	    //Insertando la Data
	    IdBD cons = new IdBD();
	    try {
	    	obj.setIdTransaccion(cons.getIdTransacciones());

	    	sql = "insert into transacciones(totalcompra, fechahora) values(?,?)";
	        pStmt = con.prepareStatement(sql);
	        //Agregamos los valores
	        pStmt.setFloat(1, obj.getTotalCompra());
	        pStmt.setObject(2, obj.getFechaHora());

            pStmt.executeUpdate();
	    } catch (DAOInitializationException | SQLException ex) {
	    	obj.setIdTransaccion(0);
	    } finally {
	    	if (pStmt != null) {
	        	pStmt.close();
	    	}
	 	}
		return obj.getIdTransaccion();
	}
}
