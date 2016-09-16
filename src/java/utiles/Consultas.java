/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Cesar
 */
public class Consultas {

    public static LinkedList getNacionalidades() {
        Context initContext;
        Connection conn = null;
        LinkedList<HashMap<String, Object>> resultado = new LinkedList();
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");
            conn = ds.getConnection();

            StringBuilder query = new StringBuilder();

            //Lista de nacionalidades
            query.append("SELECT id, LOWER(descripcion) as descripcion ");
            query.append("FROM nacionalidades");

            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                HashMap row = new HashMap();
                row.put("id", rs.getInt("id"));
                row.put("descripcion", rs.getString("descripcion"));
                resultado.add(row);
            }
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    public static LinkedList getClientes() {
        Context initContext;
        Connection conn = null;
        LinkedList<HashMap<String, Object>> resultado = new LinkedList();
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");
            conn = ds.getConnection();

            StringBuilder query = new StringBuilder();

            //lista de clientes
            query.append("SELECT clientes.id as id,");
            query.append(" LOWER( apellido ) as apellido, ");
            query.append(" LOWER( nombre ) as nombre, ");
            query.append(" TIMESTAMPDIFF(YEAR, fecha_nacimiento, CURDATE()) as edad,");
            query.append(" activo,");
            query.append(" LOWER(nacionalidades.descripcion) as nacionalidad");
            query.append(" FROM clientes ");
            query.append(" join nacionalidades ");
            query.append(" on clientes.nacionalidad_id = nacionalidades.id");

            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                HashMap row = new HashMap();
                row.put("id", rs.getInt("id"));
                row.put("nombre", rs.getString("nombre"));
                row.put("edad", rs.getInt("edad"));
                row.put("activo", rs.getInt("activo"));
                row.put("nacionalidad", rs.getString("nacionalidad"));
                resultado.add(row);
            }
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }
}
