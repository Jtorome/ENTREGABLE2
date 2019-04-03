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
import models.Servicio;

/**
 *
 * @author juana
 */
@WebServlet(name = "EliminarPasajeroCon", urlPatterns = {"/EliminarPasajeroCon"})
public class EliminarPasajeroCon extends HttpServlet {

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
            HttpSession session = request.getSession();
            List<Pasajero> RidersList= (List<Pasajero>) session.getAttribute("RidersList");
            Pasajero rider =Pasajero.BuscadorPasajero(request.getParameter("txtEmail"), RidersList);
            Servicio CurrentService = ((List<Servicio>) ((Conductor) session.getAttribute("InfoUsuario")).getCurrentService()).get(0);
            CurrentService.DeleteRider(rider);
            request.getRequestDispatcher("VerViajeActualCon.jsp").forward(request, response);
        } catch (Exception exc) {
            request.getRequestDispatcher("VerViajeActualCon.jsp").forward(request, response);
        }
    }
}
