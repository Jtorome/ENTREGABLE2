/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Conductor;
import models.Pasajero;

/**
 *
 * @author juana
 */
@WebServlet(name = "CambioContra", urlPatterns = {"/CambioContra"})
public class CambioContra extends HttpServlet {

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

        HttpSession session = request.getSession();
        String password = request.getParameter("txtPassword");
        try {
            if (request.getParameter("cual").equals("Conductor")) {
                if (((Conductor) session.getAttribute("InfoUsuario")).getPassword().equals(password)) {
                    ((Conductor) session.getAttribute("InfoUsuario")).setPassword(request.getParameter("txtPasswordNew"));
                    request.setAttribute("stExito", "Cambio exitoso");

                    request.getRequestDispatcher("VerPerfilCon.jsp").forward(request, response);
                } else {
                    throw new Exception("Contraseña no coincide.");
                }
            } else if (request.getParameter("cual").equals("Pasajero")) {
                if (((Pasajero) session.getAttribute("InfoUsuario")).getPassword().equals(password)) {
                    ((Pasajero) session.getAttribute("InfoUsuario")).setPassword(request.getParameter("txtPasswordNew"));
                    request.setAttribute("stExito", "Cambio exitoso");

                    request.getRequestDispatcher("VerPerfilCon.jsp").forward(request, response);
                } else {
                    throw new Exception("Contraseña no coincide.");
                }
            }
        } catch (Exception exc) {
            request.setAttribute("stError", exc.getMessage());
            if (request.getParameter("cual").equals("Conductor")) {
                request.getRequestDispatcher("VerPerfilCon.jsp").forward(request, response);
            } else if (request.getParameter("cual").equals("Pasajero")) {
                request.getRequestDispatcher("VerPerfilPas.jsp").forward(request, response);
            }
        }
    }
}
