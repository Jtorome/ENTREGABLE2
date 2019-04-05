/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "EliminarPasajeroAdmin", urlPatterns = {"/EliminarPasajeroAdmin"})
public class EliminarPasajeroAdmin extends HttpServlet {

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
        List<Pasajero> RidersList=(List<Pasajero>) session.getAttribute("RidersList");
        Pasajero rider=Pasajero.BuscadorPasajero(request.getParameter("txtEmail"), RidersList);
        RidersList.remove(rider);
        session.setAttribute("RidersList", RidersList);
        request.getRequestDispatcher("ListaPasajeros.jsp").forward(request, response);
    }
}
