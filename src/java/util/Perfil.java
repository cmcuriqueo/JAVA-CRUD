/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author cesar
 */
public class Perfil {
    private String nombre;
    private String apellido;
    private String dni;
    private Date fecha_nacimiento;

    public Perfil(String nombre, String apellido, String dni, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Perfil(){}
    
    
    
    public static boolean update(Integer id, String nombre, String apellido, String dni, Date fecha_nacimiento){
        Usuario usr = null;
        Connection conn = null;
        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");
            conn = ds.getConnection();
            StringBuilder query = new StringBuilder();
            
            query.append(" UPDATE usuario.persona p ");
            query.append(" SET ");
            query.append("      p.nom,bre = ? ");
            query.append("      p.apellido = ? ");
            query.append("      p.dni = ? ");
            query.append("      p.fecha_nacimiento = ? ");
            query.append(" WHERE ");
            query.append("      true ");
            query.append("      AND p.id = ? ");
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, dni);
            pstmt.setDate(4, fecha_nacimiento);
            pstmt.setInt(5, id);
            
            pstmt.execute();
            
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
        return true;
    }
    
    public static Perfil getPerfil(Integer id){
        Perfil perfil = null;
        Connection conn = null;
        try{
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");
            conn = ds.getConnection();
            StringBuilder query = new StringBuilder();
            query.append("SELECT    p.nombre as nombre, ");
            query.append("          p.apellido as apellido");
            query.append("          p.apellido as dni");
            query.append("          p.apellido as fecha_nacimiento");
            query.append("FROM usuario.persona p ");
            query.append("WHERE");
            query.append("     true ");
            query.append("     AND p.id = ? ");
            PreparedStatement pstmt = conn.prepareStatement(query.toString());
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                perfil = new Perfil(rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getDate("fecha_nacimiento"));
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
        
        return perfil;
    } 
}
