/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import Utilidades.HelpersHTML;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

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
    String luis="Hola";
    
    HelpersHTML h = new HelpersHTML();
    
    String usuario = request.getParameter("usuario");
    String contrasenna = request.getParameter("contrasena");
    if (usuario.equals("josue") && contrasenna.equals("1234"))
    {
        String mensaje = "Bienvenido "+usuario+". Usted es un usuario visualizador.";
        request.setAttribute("mensaje", h.mensajeDeExito(mensaje));
        
        URL url = new URL("http://172.26.92.45:3000/api/competitions");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        
        String json = in.readLine();
        JSONArray competencias_json = null;
        JSONTokener tokener = new JSONTokener(json);
            try {
                competencias_json = new JSONArray(tokener);
                //System.out.println(competencias_json.getJSONObject(0).get("name"));
            } catch (JSONException ex) {
                Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        request.setAttribute("competencias", competencias_json);
        
        redireccionar(request, response, "/Competencias/index.jsp");
        //System.out.println("Antes de usuarioDAO. Usuario = "+usuario+", contrasenna = "+contrasenna);
    }
    if (usuario.equals("luis") && contrasenna.equals("1234")){
        String mensaje = "Bienvenido "+usuario+". Usted es un usuario votante.";
        request.setAttribute("mensaje", h.mensajeDeExito(mensaje));
        URL url = new URL("http://172.26.92.45:3000/api/competitions");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        
        String json = in.readLine();
        JSONArray competencias_json = null;
        JSONTokener tokener = new JSONTokener(json);
            try {
                competencias_json = new JSONArray(tokener);
                //System.out.println(competencias_json.getJSONObject(0).get("name"));
            } catch (JSONException ex) {
                Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        //
        ArrayList<ArrayList<String>> listaCompetencias = new ArrayList<ArrayList<String>>();     
        JSONArray jsonArray = (JSONArray)competencias_json; 
        try{ 
        if (jsonArray != null) { 
           int len = jsonArray.length();
           ArrayList<String> listaTemp = new ArrayList<String>();
           for (int i=0;i<len;i++){
               
            listaTemp.add(jsonArray.getJSONObject(i).get("name").toString());
            listaTemp.add(jsonArray.getJSONObject(i).get("description").toString());
            listaTemp.add(jsonArray.getJSONObject(i).get("start_date").toString());
            listaTemp.add(jsonArray.getJSONObject(i).get("end_date").toString());
            listaTemp.add(jsonArray.getJSONObject(i).get("state").toString());
            listaTemp.add(jsonArray.getJSONObject(i).get("_id").toString());
            listaCompetencias.add(listaTemp);
           } 
        } }catch(JSONException exx){}
        //luis=(competencias_json.getJSONObject(0).get("name")));
        request.setAttribute("competencias",listaCompetencias);
        
        
        redireccionar(request, response, "/Competencias/index.jsp");
    }
    else {
        String mensaje = "Usuario o contraseña incorrectos.";
        request.setAttribute("mensaje", h.mensajeDeError(mensaje));
        
        redireccionar(request, response, "/index.jsp");
    }

    }

    protected void redireccionar(HttpServletRequest request, HttpServletResponse response, String redireccion) throws ServletException, IOException {
        RequestDispatcher vista = request.getRequestDispatcher(redireccion);
        vista.forward(request, response);
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
