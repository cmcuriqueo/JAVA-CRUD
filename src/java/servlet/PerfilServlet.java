/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import util.Perfil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Cliente;
import util.Consultas;
import static util.Session.control;
import util.Usuario;

/**
 *
 * @author cesar
 */
@WebServlet(name = "PerfilServlet", urlPatterns = {"/Perfil"})
public class PerfilServlet extends HttpServlet {


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
            request.getRequestDispatcher("WEB-INF/jsp/perfil_vista.jsp").forward(request, response);
            
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
