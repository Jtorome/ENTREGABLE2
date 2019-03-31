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
import models.Comentario;
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
        List<Comentario> CommentsList = new ArrayList<Comentario>();
        List<Conductor> DriversList = new ArrayList<Conductor>();
        List<Pasajero> RidersList = new ArrayList<Pasajero>();
        List<Vehiculo> VehiclesList = new ArrayList<Vehiculo>();
        List<Servicio> ServicesList = new ArrayList<Servicio>();
        List<Servicio> AvailableService = new ArrayList<Servicio>();
        if (null == session.getAttribute("CommentsList")) {
                session.setAttribute("CommentsList", CommentsList);
            }
        if (null == session.getAttribute("DriversList")) {
                session.setAttribute("DriversList", DriversList);
            }
        if (null == session.getAttribute("RidersList")) {
                session.setAttribute("RidersList", RidersList);
            }
        if (null == session.getAttribute("VehiclesList")) {
                session.setAttribute("VehiclesList", VehiclesList);
            }
        if (null == session.getAttribute("ServicesList")) {
                session.setAttribute("ServicesList", ServicesList);
            }
        if (null == session.getAttribute("AvailableService")) {
                session.setAttribute("AvailableService", AvailableService);
            }
        request.getRequestDispatcher("Start.jsp").forward(request, response);
    }
}
