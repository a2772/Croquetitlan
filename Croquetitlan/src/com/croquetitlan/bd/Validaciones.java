package src.com.croquetitlan.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;
import src.com.croquetitlan.dao.DAOInitializationException;	
import src.com.croquetitlan.dao.DataAccessObject;
import src.com.croquetitlan.bs.Trabajadores;


public class Validaciones extends DataAccessObject{
	public Validaciones() throws ClassNotFoundException, SQLException 
	{
		super();
	}
	public Trabajadores Login(Trabajadores trab) throws SQLException, DAOInitializationException
	{
		ResultSet rs = null;

		Trabajadores trabajador = new Trabajadores();
		PreparedStatement stmt = null;
		boolean isValid = false;
		String sql = "select * from catjerarquia cj,datos d,trabajadores t,pass p where cj.idjerarquia=t.idjerarquia2 and d.iddatos=t.iddatos2 and t.idtrabajador=p.idtrabajador and d.email= ? and p.pass= ?";
		try
		{
			stmt = prepareStatement(sql);
			
			stmt.setString(1, trab.getEmail());
			stmt.setString(2, trab.getNombre());//Como no guardamos su password, pondremos el Nombre como si fuera la contraseña que nos dio

			rs = stmt.executeQuery();
			
			if(rs.next())
			{
				isValid=true;
				trabajador = new Trabajadores();
				//Tabla trabajador
				trabajador.setIdTrabajador(rs.getInt("idtrabajador"));
				trabajador.setIdDatos(rs.getInt("iddatos"));
				trabajador.setRfc(rs.getString("rfc"));
				trabajador.setCurp(rs.getString("curp"));
				trabajador.setHoras(rs.getInt("horas"));
				trabajador.setSueldoHora(rs.getFloat("sueldohora"));
				//Tabla Datos
				trabajador.setNombre(rs.getString("nombre"));
				trabajador.setApPat(rs.getString("appat"));
				trabajador.setApMat(rs.getString("apmat"));
			}
		}catch(Exception ex) {
			trabajador= null;
		}finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
		return trabajador;
	}
}
