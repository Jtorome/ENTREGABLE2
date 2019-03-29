/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
@WebServlet(name = "TomarServicioPas", urlPatterns = {"/TomarServicioPas"})
public class TomarServicioPas extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        try {
            if(!((Pasajero) session.getAttribute("InfoUsuario")).getCurrentTrip().isEmpty()){
                throw new Exception("Usted ya tiene un servicio inscrito.");
            }
            List<Conductor> DriversList = (List<Conductor>) session.getAttribute("DriversList");
            List<Servicio> AvailableService = (List<Servicio>) session.getAttribute("AvailableService");
            String meetingtime=request.getParameter("txtMeetingTime");
            Conductor driver =Conductor.BuscadorDeConductor(request.getParameter("txtEmail"), DriversList);
            String[] date =request.getParameter("txtDateSer").split("-");
            //for(Servicio servicio: AvailableService){
            //    if(!request.getParameter("txtMeetingTime,"+servicio).isEmpty() && !request.getParameter("txtEmail,"+servicio).isEmpty() && !request.getParameter("txtDateSer,"+servicio).isEmpty()){
            //       meetingtime=request.getParameter("txtMeetingTime,"+servicio);
            //        driver = Conductor.BuscadorDeConductor(request.getParameter("txtEmail,"+servicio), DriversList);
            //        date = request.getParameter("txtDateSer,"+servicio).split("-");
            //    }
            //}
            LocalDate dateser = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            Servicio service = Servicio.BuscadorDeServicio(meetingtime, driver, dateser, AvailableService);
            if(service.getAvailableSeats()-Integer.parseInt(request.getParameter("txtSeats"))<0){
                throw new Exception("Numero de asientos no permitidos.");
            }
            service.setRidersList((Pasajero) session.getAttribute("InfoUsuario"), Integer.parseInt(request.getParameter("txtSeats")));
            request.setAttribute("stExito", "Servicio Tomado");
            request.getRequestDispatcher("IndexPasajero.jsp").forward(request, response);
        } catch (Exception exc){
            request.setAttribute("stError", exc.getMessage());
            request.getRequestDispatcher("IndexPasajero.jsp").forward(request, response);
        }
        }
    }
