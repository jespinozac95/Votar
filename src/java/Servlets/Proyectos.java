/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

/**
 *
 * @author Josue
 */
@WebServlet(name = "Proyectos", urlPatterns = {"/Proyectos"})
public class Proyectos extends HttpServlet {

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
            out.println("<title>Servlet Competencias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Competencias at " + request.getContextPath() + "</h1>");
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
        String competencias = ";";
        
        String id = request.getParameter("id");
        
        URL url = new URL("http://172.26.92.45:3000/api/competitions/"+id+"/projects");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        
        String json = in.readLine();
        JSONArray proyectos_json = null;
        JSONTokener tokener = new JSONTokener(json);
            try {
                proyectos_json = new JSONArray(tokener);
                //System.out.println(competencias_json.getJSONObject(0).get("name"));
            } catch (JSONException ex) {
                Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //NO sé que hace de aquí para abajo.
        request.setAttribute("message", request.getAttribute("message"));
        request.getRequestDispatcher("/Competencias/index.jsp").forward(request, response);
        request.setAttribute("competencias", competencias);
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
        processRequest(request, response);
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
