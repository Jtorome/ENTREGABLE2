/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import models.Calificacion;
import models.Conductor;
import models.Pasajero;
import models.Servicio;
import models.Vehiculo;

/**
 *
 * @author juana
 */
@WebServlet(name = "CrearDatosFicticios", urlPatterns = {"/CrearDatosFicticios"})
public class CrearDatosFicticios extends HttpServlet {

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

        try {
            HttpSession session = request.getSession();
            if(session.getAttribute("CrearDatosFicticios")!=null){
                throw new Exception("Los datos ya fueron creados.");
            }
            List<Conductor> DriversList = (List<Conductor>) session.getAttribute("DriversList");
            List<Vehiculo> VehiclesList = (List<Vehiculo>) session.getAttribute("VehiclesList");
            List<Servicio> ServicesList = (List<Servicio>) session.getAttribute("ServicesList");
            List<Servicio> AvailableService = (List<Servicio>) session.getAttribute("AvailableService");
            List<Pasajero> RidersList = (List<Pasajero>) session.getAttribute("RidersList");
            Conductor c = new Conductor("juan@unal.edu.co", "hola", "juan", "312");
            Conductor c2 = new Conductor("luis@unal.edu.co", "luis", "luis", "312");
            Conductor c3 = new Conductor("manuel@unal.edu.co", "manuel", "manuel", "2443");
            Vehiculo v = new Vehiculo("abc123", "rojo", "Carro", "bocho", 5, c);
            Vehiculo v12 = new Vehiculo("def456", "azul", "Moto", "Pulsar", 2, c);
            Vehiculo v2 = new Vehiculo("afs231", "verde", "Carro", "bmw", 5, c2);
            Vehiculo v3 = new Vehiculo("asd213", "morado", "Carro", "bocho", 5, c3);
            LocalDate dateser = LocalDate.now();
            Servicio s = new Servicio("00:01", "Volador", "Minas", "Agora", "M8", 4, c, v, dateser);
            Servicio s2 = new Servicio("23:59", "Volador", "Rio", "Agora", "4", 4, c2, v2, dateser);
            Servicio s3 = new Servicio("00:01", "Volador", "Minas", "Agora", "M8", 4, c3, v3, dateser);
            Pasajero p = new Pasajero("juan@unal.edu.co", "hola", "juan", "312");
            s.setRidersList(p, 1);
            new Calificacion(4, "bonito", s);
            new Calificacion(3, "regular", p);
            DriversList.add(c);
            DriversList.add(c2);
            DriversList.add(c3);
            VehiclesList.add(v);
            VehiclesList.add(v12);
            VehiclesList.add(v2);
            VehiclesList.add(v3);
            AvailableService.add(s);
            AvailableService.add(s2);
            AvailableService.add(s3);
            ServicesList.add(s);
            ServicesList.add(s2);
            ServicesList.add(s3);
            RidersList.add(p);
            session.setAttribute("CrearDatosFicticios", 1);
            response.sendRedirect("/Entregable2/Start");
        } catch (Exception exc) {
            request.setAttribute("stError", exc.getMessage());
            request.getRequestDispatcher("Start.jsp").forward(request, response);
        }
    }
}
