package src.com.croquetitlan.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import src.com.croquetitlan.dao.DAOInitializationException;
import src.com.croquetitlan.dao.DataAccessObject;
import src.com.croquetitlan.bs.*;
import src.com.croquetitlan.bd.*;

public class ConsultasBD extends DataAccessObject {
	public ConsultasBD() throws ClassNotFoundException, SQLException 
	{
		super();
	}
	public List<CatEstados> obtenerCatEstados() throws SQLException, DAOInitializationException{
		List<CatEstados> catEstados = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM catestados";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();
			while (rs.next()) {
				CatEstados catEstado = new CatEstados();
				catEstado.setIdEstado(rs.getInt("idEstado"));
				catEstado.setEstado(rs.getString("estado"));
				catEstados.add(catEstado);
			}
		} catch (SQLException e) {
			catEstados = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return catEstados;
	}
	///Lista de Estatus////
	public List<CatEstatus> obtenerCatEstatus() throws SQLException, DAOInitializationException{
		List<CatEstatus> catEstatus = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM catestatus"; 
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();
			while (rs.next()) {
				CatEstatus catSts = new CatEstatus();
				catSts.setIdStatus(rs.getInt("idEstatus"));
				catSts.setEstatus(rs.getString("estatus"));
				catSts.setPorcentaje(rs.getFloat("porcentaje"));
				catEstatus.add(catSts);
			}
		} catch (SQLException e) {
			catEstatus = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return catEstatus;
	}
	public List<CatGastos> obtenerCatGastos() throws SQLException, DAOInitializationException {
		List<CatGastos> catGastos = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM catgastos";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();
			while (rs.next()) {
				CatGastos catGasto = new CatGastos();
				catGasto.setIdGasto(rs.getInt("idGastos"));
				catGasto.setGasto(rs.getString("gasto"));
				catGastos.add(catGasto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			catGastos = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return catGastos;
	}
	//// Lista de Gramaje////
	public List<CatGramaje> obtenerCatGramaje() throws SQLException, DAOInitializationException {
		List<CatGramaje> catGramajes = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM catgramaje";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();
			while (rs.next()) {
				CatGramaje catGramaje = new CatGramaje();
				catGramaje.setIdGramaje(rs.getInt("idGramaje"));
				catGramaje.setIdProducto(rs.getInt("idProducto"));
				catGramaje.setPrecioKg(rs.getFloat("precioKg"));
				catGramaje.setGramajeMin(rs.getFloat("gramajeMin"));
				catGramajes.add(catGramaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			catGramajes = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return catGramajes;
	}
	//// Lista de Jerarqu�as////
	public List<CatJerarquia> obtenerCatJerarquias() throws SQLException, DAOInitializationException {
		List<CatJerarquia> catJerarquias = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM catjerarquia";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();
			while (rs.next()) {
				CatJerarquia catJerarquia = new CatJerarquia();
				catJerarquia.setIdJerarquia(rs.getInt("idJerarquia"));
				catJerarquia.setJerarquia(rs.getString("jerarquia"));
				catJerarquias.add(catJerarquia);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			catJerarquias = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return catJerarquias;
	}
	//// Lista de Municipios////
	public List<CatMunicipios> obtenerCatMunicipios() throws SQLException, DAOInitializationException {
		List<CatMunicipios> catMunicipios = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM catmunicipios";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();

			while (rs.next()) {
				// Tabla de Municipios.
				CatMunicipios catMunicipio = new CatMunicipios();
				catMunicipio.setIdMunicipio(rs.getInt("idMunicipios"));
				catMunicipio.setMunicipio(rs.getString("municipio"));
				catMunicipio.setIdEstado(rs.getInt("idEstado"));

				// Tabla de Estados.
				catMunicipio.setEstado(rs.getString("estado"));
				catMunicipios.add(catMunicipio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			catMunicipios = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return catMunicipios;
	}
	//// Lista de Cat�logos de Productos////
	public List<CatProducto> obtenerCatProductos() throws SQLException, DAOInitializationException {
		List<CatProducto> catProductos = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM catproducto";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();
			while (rs.next()) {
				CatProducto catProducto = new CatProducto();
				catProducto.setIdProducto(rs.getInt("idProducto"));
				catProducto.setNombre(rs.getString("nombre"));
				catProducto.setDescripcion(rs.getString("descripcion"));
				catProductos.add(catProducto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			catProductos = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return catProductos;
	}
	//// Lista de Clientes Frecuentes////
	public List<ClienteFrecuente> obtenerClientesFrecuentes() throws SQLException, DAOInitializationException {
		List<ClienteFrecuente> clnFrs = new ArrayList<>();
		ClienteFrecuente clntFrecuente = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM catestados ce, catmunicipios cm, clientefrecuente cf, datos d, catestatus e where cf.iddatos=d.iddatos and cf.idestatus=e.idestatus and ce.idestado=cm.idestado and cm.idmunicipio=d.idmunicipio";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();

			while (rs.next()) {
				clntFrecuente = new ClienteFrecuente();
				// Tabla de Clientes Frecuentes.
				
				clntFrecuente.setIdCliente(rs.getInt("idcliente"));
				clntFrecuente.setIdDatos(rs.getInt("iddatos"));
				clntFrecuente.setIdEstatus(rs.getInt("idestatus"));
				// Tabla de Datos.
				clntFrecuente.setTelefono(rs.getString("telefono"));
				clntFrecuente.setEmail(rs.getString("email"));
				clntFrecuente.setNombre(rs.getString("nombre"));
				clntFrecuente.setApPat(rs.getString("apPat"));
				clntFrecuente.setApMat(rs.getString("apMat"));
				clntFrecuente.setFechaNac(rs.getObject("fechanac", LocalDate.class));
				clntFrecuente.setCp(rs.getString("cp"));
				clntFrecuente.setIdMunicipio(rs.getInt("idMunicipio"));
				clntFrecuente.setCalle(rs.getString("calle"));
				clntFrecuente.setNumero(rs.getString("numero"));
				clntFrecuente.setNumInterior(rs.getString("numInterior"));
				//Tabla de Municipios y de Estados. Además del estatus como cadena
				clntFrecuente.setIdMunicipio(rs.getInt("idmunicipio"));
				clntFrecuente.setIdEstado(rs.getInt("idestado"));
				clntFrecuente.setMunicipio(rs.getString("municipio"));
				clntFrecuente.setEstado(rs.getString("estado"));
				CatEstatus cestatus= new CatEstatus();
				cestatus.setEstatus(rs.getString("estatus"));
				clntFrecuente.setCatEstatus(cestatus);

				clnFrs.add(clntFrecuente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			clnFrs = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return clnFrs;
	}
	//// Lista de Datos////
	public List<Datos> obtenerDatos() throws SQLException, DAOInitializationException {
		List<Datos> datos = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM datos";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();
			while (rs.next()) {
				Datos dato = new Datos();
				dato.setIdDatos(rs.getInt("idDatos"));
				dato.setTelefono(rs.getString("telefono"));
				dato.setTelefono(rs.getString("email"));
				dato.setTelefono(rs.getString("nombre"));
				dato.setTelefono(rs.getString("apPat"));
				dato.setTelefono(rs.getString("apMat"));
				dato.setTelefono(rs.getString("fechaNac"));
				dato.setTelefono(rs.getString("cp"));
				dato.setIdMunicipio(rs.getInt("idMunicipio"));
				dato.setCalle(rs.getString("calle"));
				dato.setNumero(rs.getString("numero"));
				dato.setNumInterior(rs.getString("numInterior"));
				datos.add(dato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			datos = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return datos;
	}
	//// Lista de Descuentos////
	public List<Descuentos> obtenerDescuentos() throws SQLException, DAOInitializationException {
		List<Descuentos> descuentos = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM descuentos d, catproducto p where d.idproducto3=p.idproducto";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();

			while (rs.next()) {
				// Tabla de Descuentos.
				Descuentos descuento = new Descuentos();
				descuento.setIdDescuento(rs.getInt("idDescuento"));
				descuento.setIdProducto(rs.getInt("idProducto"));
				descuento.setFechaInicio(rs.getObject("fechaInicio", LocalDate.class));
				descuento.setFechaFin(rs.getObject("fechaFin", LocalDate.class));
				descuento.setSoloCliente(rs.getString("soloCliente"));
				descuento.setPorcentaje(rs.getFloat("porcentaje"));
				descuento.setPrecioDesc(rs.getFloat("precioDesc"));
				descuento.setCantidadUnit(rs.getInt("cantidadUnit"));
				descuento.setCantidadGram(rs.getFloat("cantidadGram"));

				// Tabla de CatProductos.
				descuento.setNombre(rs.getString("nombre"));
				descuento.setDescripcion(rs.getString("descripcion"));
				descuentos.add(descuento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			descuentos = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return descuentos;
	}
	//// Lista de Gastos////
	public List<Gastos> obtenerGastos() throws SQLException, DAOInitializationException {
		List<Gastos> gastos = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM gastos g, catgastos cg where g.idgastos=cg.idgastos;";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();

			while (rs.next()) {
				// Tabla de Gastos.
				Gastos gasto = new Gastos();
				gasto.setIdGasto(rs.getInt("idGastos"));
				gasto.setIdGastMens(rs.getInt("idgastmens"));
				gasto.setFechaPago(rs.getObject("fechaPago", LocalDate.class));
				gasto.setTotal(rs.getFloat("total"));
				gasto.setPagado(rs.getString("pagado"));
				// Tabla de CatGastos.
				gasto.setGasto(rs.getString("gasto"));
				gastos.add(gasto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			gastos = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return gastos;
	}
	//// Lista de Gramajes////
	public List<Gramaje> obtenerGramajes() throws SQLException, DAOInitializationException {
		List<Gramaje> gramajes = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM gramaje g, catgramaje cg, catproducto cp where g.idgramaje=cg.idgramaje and cp.idproducto=cg.idproducto;";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();

			while (rs.next()) {
				// Tabla de Gramaje.
				Gramaje gramaje = new Gramaje();
				gramaje.setIdGram(rs.getInt("idGram"));
				gramaje.setIdGramaje(rs.getInt("idGramaje"));
				gramaje.setFechaCaducidad(rs.getObject("fechaCaducidad", LocalDate.class));
				gramaje.setCantidad(rs.getFloat("cantidad"));

				// Tabla de CatGramaje.
				gramaje.setPrecioKg(rs.getFloat("precioKg"));
				gramaje.setGramajeMin(rs.getFloat("gramajeMin"));
				gramajes.add(gramaje);
				
				//Tabla de CatProducto
				gramaje.setIdProducto(rs.getInt("idproducto"));
				gramaje.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			gramajes = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return gramajes;
	}
	//// Lista de Productos////
	public List<Producto> obtenerProductos() throws SQLException, DAOInitializationException {
		List<Producto> productos = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM producto p, catproducto cp where p.idproducto2=cp.idproducto;";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();

			while (rs.next()) {
				// Tabla de Producto.
				Producto producto = new Producto();
				producto.setIdProd(rs.getInt("idProd"));
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setFechaCaducidad(rs.getObject("fechaCaducidad", LocalDate.class));
				producto.setCantidad(rs.getInt("cantidad"));
				producto.setPrecioUnit(rs.getInt("precioUni"));
				producto.setPesoCostal(rs.getInt("pesoCostal"));

				// Tabla de CatProducto.
				producto.setNombre(rs.getString("nombre"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPesoCostal(rs.getFloat("pesocostal"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			productos = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return productos;
	}
	//// Lista de Transacciones////
	public List<Transacciones> obtenerTransacciones() throws SQLException, DAOInitializationException {
		List<Transacciones> transacciones = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM transacciones t, datos d, clientefrecuente cf where t.idcliente=cf.idcliente and cf.iddatos=d.iddatos;";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();
			while (rs.next()) {
				//Tabla transacciones
				Transacciones transaccion = new Transacciones();
				transaccion.setIdTransaccion(rs.getInt("idtransaccion"));
				transaccion.setFechaHora(rs.getObject("fechahora", LocalDateTime.class));
				transaccion.setTotalCompra(rs.getFloat("totalcompra"));
				transaccion.setIdcliente(rs.getInt("idcliente"));
				transaccion.setNombre(rs.getString("nombre"));//No pertenece a datos, pero la usaremos como si lo fuera
				transacciones.add(transaccion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			transacciones = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return transacciones;
	}
	public List<Trabajadores> obtenerTrabajadores() throws SQLException, DAOInitializationException {
		List<Trabajadores> trabajadores = new ArrayList<>();
		Trabajadores tabajador = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM catestados ce, catmunicipios cm, datos d, trabajadores t, catjerarquia j where t.iddatos2=d.iddatos and j.idjerarquia=t.idjerarquia2 and ce.idestado=cm.idestado and cm.idmunicipio=d.idmunicipio;";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();

			while (rs.next()) {
				tabajador = new Trabajadores();
				// Tabla de Trabajadores.
				tabajador.setIdTrabajador(rs.getInt("idtrabajador"));
				tabajador.setIdDatos(rs.getInt("iddatos"));
				tabajador.setRfc(rs.getString("rfc"));
				tabajador.setCurp(rs.getString("curp"));
				tabajador.setHoras(rs.getInt("horas"));
				tabajador.setSueldoHora(rs.getFloat("sueldohora"));
				tabajador.setHoras(rs.getInt("idjerarquia2"));
				// Tabla de Datos.
				tabajador.setTelefono(rs.getString("telefono"));
				tabajador.setEmail(rs.getString("email"));
				tabajador.setNombre(rs.getString("nombre"));
				tabajador.setApPat(rs.getString("apPat"));
				tabajador.setApMat(rs.getString("apMat"));
				tabajador.setFechaNac(rs.getObject("fechanac", LocalDate.class));
				tabajador.setCp(rs.getString("cp"));
				tabajador.setIdMunicipio(rs.getInt("idMunicipio"));
				tabajador.setCalle(rs.getString("calle"));
				tabajador.setNumero(rs.getString("numero"));
				tabajador.setNumInterior(rs.getString("numInterior"));
				//Tabla de Municipios y de Estados. Además de la jerarquía
				tabajador.setIdMunicipio(rs.getInt("idmunicipio"));
				tabajador.setIdEstado(rs.getInt("idestado"));
				tabajador.setMunicipio(rs.getString("municipio"));
				tabajador.setEstado(rs.getString("estado"));
				//Jerarquia
				CatJerarquia cj = new CatJerarquia();
				cj.setJerarquia(rs.getString("jerarquia"));
				tabajador.setCatJerarquia(cj);
				
				trabajadores.add(tabajador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			tabajador = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return trabajadores;
	}
	public List<VProductoEnt> obtenerVProductoEnt() throws SQLException, DAOInitializationException {
		List<VProductoEnt> prods = new ArrayList<>();
		VProductoEnt prod = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from vproductoent ve, transacciones tr, producto pr, catproducto cp where ve.idtransaccion=tr.idtransaccion and ve.idprod=pr.idprod and pr.idproducto2=cp.idproducto;";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();

			while (rs.next()) {
				prod = new VProductoEnt();
				//Tabla VProducto
				prod.setIdvproductoent(rs.getInt("idvproductoent"));
				prod.setCantidad(rs.getInt("cantidad"));
				prod.setIdProducto(rs.getInt("idproducto"));
				prod.setIdTransaccion(rs.getInt("idtransaccion"));
				//Tabla de transacciones
				prod.setPrecioUnit(rs.getFloat("preciouni"));//esta no pertenece a Transacciones sino a producto
				prod.setTotalCompra(prod.getCantidad()*prod.getPrecioUnit());//Como es el total parcial de cantidad por precio...
				prod.setFechaHora(rs.getObject("fechahora", LocalDateTime.class));
				prod.setIdcliente(rs.getInt("idcliente"));
				//Tablas Producto y catProducto
				prod.setIdProd(rs.getInt("idprod"));
				prod.setNombre(rs.getString("nombre"));
				prods.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			prods = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return prods;
	}
	public List<VProductoGra> obtenerVProductoGra() throws SQLException, DAOInitializationException {
		List<VProductoGra> prods = new ArrayList<>();
		VProductoGra prod = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from vproductogra vg, transacciones tr, gramaje gr, catgramaje cg, catproducto cp where vg.idtransaccion2=tr.idtransaccion and vg.idgram=gr.idgram and gr.idgramaje=cg.idgramaje and cp.idproducto=cg.idproducto;";
		try {
			stmt = prepareStatement(sql);
			stmt.execute();
			rs = stmt.getResultSet();

			while (rs.next()) {
				prod = new VProductoGra();
				//Tabla VProducto
				prod.setIdvproductgra(rs.getInt("idvproductogra"));
				prod.setGramoscom(rs.getFloat("gramoscom"));
				prod.setIdGram(rs.getInt("idgram"));
				prod.setIdtransaccion2(rs.getInt("idtransaccion2"));
				//Tabla de transacciones
				Gramaje gr = new Gramaje();
				gr.setPrecioKg(rs.getFloat("preciokg"));//esta no pertenece a Transacciones sino a producto
				gr.setIdGramaje(rs.getInt("idgramaje"));
				gr.setIdProducto(rs.getInt("idproducto"));//Id prod no está porque de catgramaje va a catproducto
				gr.setNombre(rs.getString("nombre"));
				
				prod.setGramaje(gr);
				prod.setTotalCompra(prod.getGramoscom()*gr.getPrecioKg());//Como es el total parcial de cantidad por precio...
				prod.setFechaHora(rs.getObject("fechahora", LocalDateTime.class));
				prod.setIdcliente(rs.getInt("idcliente"));
				//Tablas Producto y catProducto
				prod.setIdGram(rs.getInt("idgram"));
				prod.setNombre(rs.getString("nombre"));
				prods.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			prods = null;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return prods;
	}
}
