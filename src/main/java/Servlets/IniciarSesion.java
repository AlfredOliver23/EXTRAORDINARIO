/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Control.AccionesPropietario;
import Control.Conexiondos;
import Modelo.Propietario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class IniciarSesion extends HttpServlet {

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
            String cor,pass;
            
            
            Connection conexion = 
                    Conexiondos.getConnection(
                            request.getServletContext());
            //la instancia del propietario y sus accesos
            AccionesPropietario accionesPropietario = 
                    
                    new AccionesPropietario(conexion, 
                            request.getServletContext());
            AccionesPropietario accionesPropietario1 = new AccionesPropietario(
                    
                    request.getParameter(pass),
                    request.getParameter("pass")
            );
            
            
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            
            try{
                propietario = propietarioDAO.login(propietario);
                if(propietario != null){
                    //creo la sesion
                    request.getSession().setAttribute(
                            "propietario", propietario);
                    response.sendRedirect("inicio.jsp");
                }else{
                    response.sendRedirect("login.jsp");
                }
            }catch(Exception e ){
                System.out.println("Errror al iniciar la sesion : " 
                        + e.getMessage());
            }
        }
            
            
                   
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
        processRequest(request, response);
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
