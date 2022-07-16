package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Discos;
import java.sql.*;
import java.util.List;

public class DiscografiaDAO {
    
    private static final String SQL_CREATE = "INSERT INTO discos(nombre, autor, canciones, precio, stock) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ = "SELECT * FROM discos";
    private static final String SQL_UPDATE_PRECIO = "UPDATE discos SET precio = ? WHERE idddiscos = ?";
    private static final String SQL_UPDATE_COPIAS = "UPDATE discos SET stock = ? WHERE idddiscos = ?";
    private static final String SQL_UPDATE= "UPDATE discos SET nombre = ?, autor = ?, canciones = ?, precio = ?, stock = ? WHERE iddiscos = ?";
    private static final String SQL_DELETE = "DELETE FROM discos WHERE iddiscos = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM discos WHERE iddiscos = ?";
    
    public List<Discos> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Discos disco = null;
        List<Discos> discos = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idDiscos = rs.getInt(1);
                String nombre = rs.getString(2);
                String autor = rs.getString(3);
                int canciones = rs.getInt(4);
                double precio = rs.getDouble(5);
                int stock = rs.getInt(6);

                disco = new Discos(idDiscos, nombre, autor, canciones, precio, stock);

                discos.add(disco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return discos;
    }
    
    public Discos findDiscoById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Discos disco = null;
        
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idDiscos = rs.getInt(1);
                String nombre = rs.getString(2);
                String autor = rs.getString(3);
                int canciones = rs.getInt(4);
                double precio = rs.getDouble(5);
                int stock = rs.getInt(6);

                disco = new Discos(idDiscos, nombre, autor, canciones, precio, stock);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return disco;
    }
    
    public int create(Discos disco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, disco.getNombre());
            stmt.setString(2, disco.getAutor());
            stmt.setInt(3, disco.getCanciones());
            stmt.setDouble(4, disco.getPrecio());
            stmt.setInt(5, disco.getStock());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updatePrecio(Discos disco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, disco.getPrecio());
            stmt.setInt(2, disco.getIdDiscos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updateStock(Discos disco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_COPIAS);
            stmt.setInt(1, disco.getStock());
            stmt.setInt(2, disco.getIdDiscos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int update(Discos disco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, disco.getNombre());
            stmt.setString(2, disco.getAutor());
            stmt.setInt(3, disco.getCanciones());
            stmt.setDouble(4, disco.getPrecio());
            stmt.setInt(5, disco.getStock());
            stmt.setInt(6, disco.getIdDiscos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int delete(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
