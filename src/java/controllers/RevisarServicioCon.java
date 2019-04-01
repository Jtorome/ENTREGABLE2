/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
@WebServlet(name = "RevisarServicioCon", urlPatterns = {"/RevisarServicioCon"})
public class RevisarServicioCon extends HttpServlet {

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
        List<Conductor> DriversList = (List<Conductor>) session.getAttribute("DriversList");
        List<Servicio> ServiceListDri = ((Conductor) session.getAttribute("InfoUsuario")).getServiceListDri();
        String meetingtime = request.getParameter("txtMeetingTime");
        Conductor driver = Conductor.BuscadorDeConductor(request.getParameter("txtEmail"), DriversList);
        String[] date = request.getParameter("txtDateSer").split("-");
        LocalDate dateser = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        Servicio service = Servicio.BuscadorDeServicio(meetingtime, driver, dateser, ServiceListDri);
        session.setAttribute("service", service);
        request.getRequestDispatcher("RevisarServicioCon.jsp").forward(request, response);
    }
}
