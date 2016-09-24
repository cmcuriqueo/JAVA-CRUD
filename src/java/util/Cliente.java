/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author universidad
 */
public class Cliente {

    //inserta un cliente en la base de datos
    public static boolean insert(String nombre, String apellido, Date fecha_nacimiento, int nacionalidad) {
        Connection conn = null;
        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");

            conn = ds.getConnection();

            StringBuilder query = new StringBuilder();

            query.append("INSERT INTO clientes ");
            query.append("     (nombre, apellido, fecha_nacimiento, nacionalidad_id, activo) ");
            query.append("VALUES ( ?, ?, ? , ? , 1 )");

            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setDate(3, fecha_nacimiento);
            pstmt.setInt(4, nacionalidad);

            pstmt.execute();

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    //actualiza un cliente de la base de datos
    public static boolean update(int id_cliente, String nombre, String apellido, Date fecha_nacimiento, int nacionalidad, int activo) {
        Connection conn = null;
        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");

            conn = ds.getConnection();

            StringBuilder query = new StringBuilder();
            query.append("UPDATE clientes ");
            query.append("SET apellido = UPPER( ? ), ");
            query.append("     nombre = UPPER( ?), ");
            query.append("     fecha_nacimiento = ?, ");
            query.append("     activo = ?, ");
            query.append("     nacionalidad_id = ? ");
            query.append("WHERE ");
            query.append("     true");
            query.append("     AND clientes.id = ?");
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(2, nombre);
            pstmt.setString(1, apellido);
            pstmt.setDate(3, fecha_nacimiento);
            pstmt.setInt(5, nacionalidad);
            pstmt.setInt(4, activo);
            pstmt.setInt(6, id_cliente);

            pstmt.execute();

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    //elimina un cliente de la base de datos
    public static boolean delete(int id) {
        Connection conn = null;
        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");
            conn = ds.getConnection();

            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM ");
            query.append("clientes ");
            query.append("WHERE id = ?");

            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setInt(1, id);

            pstmt.execute();

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    //obtiene la informacion de un cliente de la base de datos
    public static HashMap getCliente(int id) {
        HashMap<String, Object> cliente = new HashMap();
        Connection conn = null;
        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");
            conn = ds.getConnection();

            String sql = "SELECT "
                    + "clientes.id as id_cliente, "
                    + "LOWER( apellido ) as apellido, "
                    + "LOWER( nombre ) as nombre, "
                    + "fecha_nacimiento, "
                    + "activo, "
                    + "LOWER(nacionalidades.descripcion) as nacionalidad, "
                    + "nacionalidades.id as id_nacionalidad "
                    + "FROM clientes "
                    + "join nacionalidades "
                    + "on clientes.nacionalidad_id = nacionalidades.id "
                    + "WHERE clientes.id = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cliente.put("id_cliente", rs.getInt(1));
                cliente.put("nombre", rs.getString(3));
                cliente.put("apellido", rs.getString(2));
                cliente.put("fecha_nacimiento", rs.getDate(4));
                cliente.put("activo", rs.getInt(5));
                cliente.put("nacionalidad", rs.getString(6));
                cliente.put("id_nacionalidad", rs.getInt(7));
            }

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }
}
