/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Calificacion;
import models.Conductor;
import models.Pasajero;
import models.Servicio;

/**
 *
 * @author juana
 */
@WebServlet(name = "CalificarServicioPas", urlPatterns = {"/CalificarServicioPas"})
public class CalificarServicioPas extends HttpServlet {

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

        request.getRequestDispatcher("ServiciosPorCalificar.jsp").forward(request, response);
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

        HttpSession session = request.getSession();
        try {
            if (request.getParameter("nbScore").isEmpty()) {
                throw new Exception("Llene los campos.");
            }
            String Description = null;
            if (!request.getParameter("txtDescription").isEmpty()) {
                Description = request.getParameter("txtDescription");
            }
            List<Conductor> DriversList = (List<Conductor>) session.getAttribute("DriversList");
            List<Servicio> ServiceList = (List<Servicio>) session.getAttribute("ServicesList");
            String meetingtime = request.getParameter("txtMeetingTime");
            Conductor driver = Conductor.BuscadorDeConductor(request.getParameter("txtEmail"), DriversList);
            String[] date = request.getParameter("txtDateSer").split("-");
            LocalDate dateser = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            Servicio service = Servicio.BuscadorDeServicio(meetingtime, driver, dateser, ServiceList);
            int Score = Integer.parseInt(request.getParameter("nbScore"));
            new Calificacion(Score, Description, service);
            ((Pasajero) session.getAttribute("InfoUsuario")).getUnqualifiedService().remove(service);
            request.getRequestDispatcher("ServiciosPorCalificar.jsp").forward(request, response);
        } catch (Exception exc) {
            request.setAttribute("stError", exc.getMessage());
            request.getRequestDispatcher("ServiciosPorCalificar.jsp").forward(request, response);
        }
    }
}
