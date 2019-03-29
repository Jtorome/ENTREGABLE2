/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Conductor;

/**
 *
 * @author juana
 */
@WebServlet(name = "LoginConductor", urlPatterns = {"/LoginConductor"})
public class LoginConductor extends HttpServlet {

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

        request.getRequestDispatcher("LoginConductor.jsp").forward(request, response);
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

        try {

            String stMensaje = "";

            if (request.getParameter("txtEmail").equals("")) {
                stMensaje += "Ingrese un correo, ";
            }
            if (request.getParameter("txtPassword").equals("")) {
                stMensaje += "Ingrese una contraseña, ";
            }
            if (!stMensaje.equals("")) {
                throw new Exception(stMensaje.substring(0, stMensaje.length() - 2) + ".");
            }

            HttpSession session = request.getSession();
            List<Conductor> DriversList = new ArrayList<Conductor>();
            if (null != session.getAttribute("DriversList")) {
                DriversList = (List<Conductor>) session.getAttribute("DriversList");
            }
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");
            if (DriversList.isEmpty()) {
                throw new Exception("Correo y/o contraseña invalido.");
            }
            for (Conductor driver : DriversList) {
                if (driver.getEmail().equals(email) && driver.getPassword().equals(password)) {
                    session.setAttribute("InfoUsuario", driver);
                    response.sendRedirect("/Entregable2/IndexConductor");
                    //request.getRequestDispatcher("IndexConductor.jsp").forward(request, response);
                    break;
                } else {
                    session.setAttribute("InfoUsuario", null);
                }
            }
            if (session.getAttribute("InfoUsuario") == null) {
                throw new Exception("Correo y/o contraseña invalido.");
            }
        } catch (Exception exc) {
            request.setAttribute("stError", exc.getMessage());
            request.getRequestDispatcher("LoginConductor.jsp").forward(request, response);
        }
    }
}
