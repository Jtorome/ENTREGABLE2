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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Conductor;
import models.Pasajero;
import models.Vehiculo;
import models.Servicio;

/**
 *
 * @author juana
 */
@WebServlet(name = "Start", urlPatterns = {"/Start"})
public class Start extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        List<Conductor> DriversList = new ArrayList<Conductor>();
        List<Pasajero> RidersList = new ArrayList<Pasajero>();
        List<Vehiculo> VehiclesList = new ArrayList<Vehiculo>();
        List<Servicio> ServicesList = new ArrayList<Servicio>();
        List<Servicio> AvailableService = new ArrayList<Servicio>();
        session.setAttribute("DriversList", DriversList);
        session.setAttribute("RidersList", RidersList);
        session.setAttribute("VehiclesList", VehiclesList);
        session.setAttribute("ServicesList", ServicesList);
        session.setAttribute("AvailableService", AvailableService);
        RequestDispatcher view = request.getRequestDispatcher("Start.jsp");
        view.forward(request, response);
    }
}
