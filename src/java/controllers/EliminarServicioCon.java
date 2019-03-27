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
import models.Servicio;

/**
 *
 * @author juana
 */
@WebServlet(name = "EliminarServicioCon", urlPatterns = {"/EliminarServicioCon"})
public class EliminarServicioCon extends HttpServlet {
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
        List<Servicio> CurrentService=((Conductor) session.getAttribute("InfoUsuario")).getCurrentService();
        List<Servicio> ServicesList = ((List<Servicio>) session.getAttribute("ServicesList"));
        List<Servicio> AvailableService = ((List<Servicio>) session.getAttribute("AvailableService"));
        Servicio service=CurrentService.get(0);
        CurrentService.remove(service);
        ServicesList.remove(service);
        AvailableService.remove(service);
        session.setAttribute("ServicesList", ServicesList);
        session.setAttribute("AvailableService", AvailableService);
        request.getRequestDispatcher("VerViajeActualCon.jsp").forward(request, response);
    }
}
