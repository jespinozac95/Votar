/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import Utilidades.HelpersHTML;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josue
 */
@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

    private final HelpersHTML helper = HelpersHTML.getSingletonHelpersHTML();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IniciarSesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IniciarSesion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        request.getRequestDispatcher("/index.htm").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");

    PrintWriter out;
    out = response.getWriter();
    request.setCharacterEncoding("UTF-8");

    HelpersHTML h = new HelpersHTML();
    
    String usuario = request.getParameter("usuario");
    String contrasenna = request.getParameter("contrasena");
    if (usuario.equals("josue") && contrasenna.equals("1234"))
    {
        String message = "Bienvenido "+usuario+". Usted es un usuario visualizador.";
        request.setAttribute("message", h.mensajeDeExito(message));
        response.sendRedirect("/Votar/Competencias/index.jsp");
        //System.out.println("Antes de usuarioDAO. Usuario = "+usuario+", contrasenna = "+contrasenna);
    }
    if (usuario.equals("luis") && contrasenna.equals("1234")){
        String message = "Bienvenido "+usuario+". Usted es un usuario votante.";
        request.setAttribute("message", h.mensajeDeExito(message));
        response.sendRedirect("/Votar/Competencias/index.jsp");
    }
    else {
        String message = "Usuario o contraseña incorrectos.";
        request.setAttribute("message", h.mensajeDeError(message));
        response.sendRedirect("/Votar/index.jsp");
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
