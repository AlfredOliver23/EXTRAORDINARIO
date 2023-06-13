/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Control.AccionesPropietario;
import Modelo.Propietario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class actualizarPropietario extends HttpServlet {

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
            
        String cor,nom,ap,am,dir,pas;
        
            int id = Integer.parseInt(request.getParameter("id2"));
            
            cor = request.getParameter("correo2");
            nom = request.getParameter("nombre2");
            ap = request.getParameter("appat2");
            am = request.getParameter("apmat2");
            dir = request.getParameter("password2");
            pas = request.getParameter("email2");             

            //a que obtuve los parametros debemos hacer la isntancia del emplead
            Propietario e = new Propietario();
            
            e.setId_pro(id);
            e.setCorreo(cor);
            e.setNombre(nom);
            e.setAppat(ap);
            e.setApmat(am);
            e.setDir(dir);
            e.setPass(pas);
            
            
            int estatus = AccionesPropietario.actualizarPropietario(e);
            
            if (estatus > 0 ) {
                response.sendRedirect("consultarUsuarios.jsp");
                
            }else{
                response.sendRedirect("error.jsp");
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
