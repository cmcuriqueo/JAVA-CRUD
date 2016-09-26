/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Perfil;
import static util.Session.control;
import util.Usuario;

/**
 *
 * @author cesar
 */
@WebServlet(name = "ModificarPErfilServlet", urlPatterns = {"/ModificarPerfil"})
public class ModificarPerfilServlet extends HttpServlet {
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (control(request, response)) {
            response.sendRedirect("LoginServlet");//redirijo al formulario de login
        } else {

            HttpSession session = request.getSession();//recupero session
            Usuario usr = (Usuario) session.getAttribute("usuario");//recupero usuario
            Perfil perfil = Perfil.getPerfil(usr.getId());
            request.setAttribute("perfil", perfil);//perfil
            request.getRequestDispatcher("WEB-INF/jsp/perfil_formulario.jsp").forward(request, response);
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (control(request, response)) {
            response.sendRedirect("LoginServlet");
        } else {
            HashMap<String, Object> errores = new HashMap();

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String fecha = request.getParameter("fecha_nacimiento");
            Date fecha_nacimiento = null;
            
            //valido nacionalidad
            if (dni != null && !dni.equals("") && !dni.matches("^[0-9]{7,8}$")) {
                errores.put("dni", "El dni es requerido");
            }
            if (fecha != null && !fecha.equals(""))
            {
                try {
                    fecha_nacimiento = Date.valueOf(fecha);
                } catch (IllegalArgumentException e) {
                    errores.put("fecha_nacimiento", "Ingrese una fecha de nacimiento valida");
                }
            }

            if (!errores.isEmpty()) {
                //seteo los errores
                request.setAttribute("errores", errores);
                HttpSession session = request.getSession();//recupero session
                Usuario usr = (Usuario) session.getAttribute("usuario");//recupero usuario
                Perfil perfil = Perfil.getPerfil(usr.getId());
                request.setAttribute("perfil", perfil);//perfil
                request.getRequestDispatcher("WEB-INF/jsp/perfil_formulario.jsp").forward(request, response);

            } else {
                //inserto y redirecciono
                HttpSession session = request.getSession();
                Usuario usr = (Usuario) session.getAttribute("usuario");//recupero usuario
                Perfil.update(usr.getId(), nombre, apellido, dni, fecha_nacimiento);
                response.sendRedirect("Perfil");
            }
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
