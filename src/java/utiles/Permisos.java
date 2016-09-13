/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Permisos implements Serializable{
    private LinkedList<String> permisos;

    public Permisos( LinkedList permisos ) {
        this.permisos = permisos;
    }

    public static Permisos getPermisos(Integer idCliente) {
        Permisos perm = null;
        Connection conn = null;
        try {
            InitialContext initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/clientes_db");
            conn = ds.getConnection();
            
            String sql = "SELECT usuario.p.descripcion as permiso "
                            + "FROM usuario.usuario u "
                                + "JOIN usuario.rol_usuario ru "
                                + "ON u.id = ru.id_usuario "
                                + "JOIN usuario.rol r "
                                + "ON r.id = ru.id_rol "
                                + "JOIN usuario.permiso_rol pr " 
                                + "ON pr.id_rol = r.id "
                                + "JOIN usuario.permiso p "
                                + "ON p.id = pr.id_permiso "
                            + "WHERE u.id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idCliente);
        
            ResultSet rs = pstmt.executeQuery();
            LinkedList<String> permiso = new  LinkedList<>();
            
            while ( rs.next() ) {
                permiso.add( rs.getString( "permiso" ) );
            }
            
            perm = new Permisos(permiso);
            
            sql = "SELECT usuario.permiso.descripcion as permiso"//permisos adicionales
                    + "FROM usuario.permiso "
                    + "JOIN usuario.permiso_usuario "
                    + "ON permiso.id = permiso_usuario.id_permiso "
                    + "JOIN usuario.usuario "
                    + "ON usuario.usuario.id = permiso_usuario.id_usuario "
                    + "WHERE usuario.id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idCliente);
            rs = pstmt.executeQuery();
            
            while ( rs.next() ) {
                if( !permiso.contains(rs.getString( "permiso" )) )
                    permiso.add( rs.getString( "permiso" ) );
            }
            
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if( conn != null && !conn.isClosed() ) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return perm;
    }

    public void setPermisos(LinkedList permisos) {
        this.permisos = permisos;
    } 

    public LinkedList getPermisos() {
        return permisos;
    }
    
    
    public boolean tienePermiso(String pms){
        for (String permiso : permisos) {
            if (permiso.equals(pms.toUpperCase())) {
                return true;
            }
        }
        return true;       
    }
}
