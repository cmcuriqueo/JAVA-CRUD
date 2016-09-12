/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import utiles.Usuario;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author universidad
 */
@WebServlet(name = "SessionServlet", urlPatterns = {"/Login"})
public class SessionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario  = request.getParameter( "usuario" );
        String pass      = request.getParameter( "contrasenia" );
        
        HashMap<String, Object> errores = new HashMap();
        
        //validacion
        if( usuario != null && usuario.equals("") )
            errores.put("usuario", "Campo obligatorio");
        
        if ( pass != null && pass.equals("") )
            errores.put("contraseña", "Campo obligatorio");
        
        if(!errores.isEmpty()){
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
        }

        Usuario usr = Usuario.getUsuario( usuario, pass );
        
        if ( usr != null ) {
            //obtengo permisos
            HttpSession session = request.getSession();
            session.setAttribute("esta_logueado", true);
            session.setAttribute("usuario", usr);
            response.sendRedirect("index");
        }
        

        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
