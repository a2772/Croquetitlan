package src.com.croquetitlan.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import src.com.croquetitlan.dao.DAOInitializationException;
import src.com.croquetitlan.dao.DataAccessObject;
import src.com.croquetitlan.bs.*;

public class IdBD extends DataAccessObject {
	public IdBD() throws ClassNotFoundException, SQLException 
	{
		super();
	}
	public int getIdCatEstados() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'catestados' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdCatEstatus() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'catestatus' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdCatGastos() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'catgastos' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdCatGramaje() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'catgramaje' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdCatJerarquia() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'catjerarquia' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdCatMunicipios() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'catmunicipios' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdCatProducto() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'catproducto' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdClienteFrecuente() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'clientefrecuente' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdDatos() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'datos' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdDescuentos() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'descuentos' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdGastos() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'gastos' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdGramaje() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'gramaje' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdProducto() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'producto' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdTrabajadores() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'trabajadores' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
	public int getIdTransacciones() throws SQLException, DAOInitializationException {
        ResultSet rs = null;
        int id=0;
        PreparedStatement stmt = null;
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'transacciones' AND table_schema = 'croquetitlan_db'";
        try {
            stmt = prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("AUTO_INCREMENT");
            }else
                id=1;
        } catch (DAOInitializationException | SQLException ex) {
            id=0;
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
        }
        return id;
    }
}
