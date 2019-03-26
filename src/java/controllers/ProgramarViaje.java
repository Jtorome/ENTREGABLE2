/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Conductor;
import models.Vehiculo;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Pasajero;
import models.Servicio;

/**
 *
 * @author juana
 */
@WebServlet(name = "ProgramarViaje", urlPatterns = {"/ProgramarViaje"})
public class ProgramarViaje extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void UploadAvailableService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Servicio> AvailableService = new ArrayList<Servicio>();
        AvailableService = (List<Servicio>) session.getAttribute("AvailableService");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        String nowformat = now.format(format);
        LocalDate today = LocalDate.now();
        for (Servicio ser : AvailableService) {
            LocalDate dateSer = ser.getDateSer();
            if (dateSer.isBefore(today)) {
                AvailableService.remove(ser);
                ser.getDriver().getCurrentService().remove(ser);
                for (Pasajero pasa : ser.getRidersList()) {
                    pasa.getCurrentTrip().remove(ser);
                    pasa.setUnqualifiedService(ser);
                    ser.getDriver().setUnqualifiedRider(pasa);
                }
            } else {
                if (Integer.parseInt(nowformat.split(":")[0]) > Integer.parseInt(ser.getMeetingTime().split(":")[0])) {
                    AvailableService.remove(ser);
                    ser.getDriver().getCurrentService().remove(ser);
                    for (Pasajero pasa : ser.getRidersList()) {
                        pasa.getCurrentTrip().remove(ser);
                        pasa.setUnqualifiedService(ser);
                        ser.getDriver().setUnqualifiedRider(pasa);
                    }
                } else if (Integer.parseInt(nowformat.split(":")[0]) == Integer.parseInt(ser.getMeetingTime().split(":")[0])) {
                    if (Integer.parseInt(nowformat.split(":")[1]) > Integer.parseInt(ser.getMeetingTime().split(":")[1])) {
                        AvailableService.remove(ser);
                        ser.getDriver().getCurrentService().remove(ser);
                        for (Pasajero pasa : ser.getRidersList()) {
                            pasa.getCurrentTrip().remove(ser);
                            pasa.setUnqualifiedService(ser);
                            ser.getDriver().setUnqualifiedRider(pasa);
                        }
                    }
                }
            }
        }
    }

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
        UploadAvailableService(request, response);

        RequestDispatcher view = request.getRequestDispatcher("ProgramarViaje.jsp");
        view.forward(request, response);
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
        UploadAvailableService(request, response);
        HttpSession session = request.getSession();

        try {
            if (((Conductor) session.getAttribute("InfoUsuario")).getVehiclesList().isEmpty()) {
                throw new ArithmeticException("Registre un vehiculo para programar un viaje.");
            }

            if (request.getParameter("txtHours").equals("") || request.getParameter("txtMinutes").equals("") || request.getParameter("txtOutPutCore").equals("") || request.getParameter("txtArrivalNucleus").equals("") || request.getParameter("txtStartPlace").equals("") || request.getParameter("txtEndPlace").equals("") || request.getParameter("txtAvailableSeats").equals("") || request.getParameter("txtDateSer").equals("")) {
                throw new Exception("Llene todos los campos por favor.");
            }
            Vehiculo vehicle=null;
            for (Vehiculo vehi : ((Conductor) session.getAttribute("InfoUsuario")).getVehiclesList()) {
                if (vehi.getLicensePlate().equals(request.getParameter("txtVehi"))) {
                    vehicle=vehi;
                    break;
                }
            }
            if(vehicle.getSeats()>=Integer.parseInt(request.getParameter("txtAvailableSeats")) || Integer.parseInt(request.getParameter("txtAvailableSeats"))<0){
                throw new Exception("Numero de asientos invalido.");
            }
            if (request.getParameter("txtDateSer").equals("Hoy")) {
                LocalDateTime today = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
                String todayformat = today.format(format);
                if (Integer.parseInt(todayformat.split(":")[0]) > Integer.parseInt(request.getParameter("txtHours"))) {
                    throw new Exception("la hora ya paso");
                } else if (Integer.parseInt(todayformat.split(":")[0]) == Integer.parseInt(request.getParameter("txtHours"))) {
                    if (Integer.parseInt(todayformat.split(":")[1]) > Integer.parseInt(request.getParameter("txtMinutes"))) {
                        throw new Exception("la hora ya paso");
                    }
                }
            }
            if (((Conductor) session.getAttribute("InfoUsuario")).getCurrentService().size() == 1) {
                throw new Exception("Ya tiene un servicio en curso");
            }
            List<Servicio> ServicesList = new ArrayList<Servicio>();
            List<Servicio> AvailableService = new ArrayList<Servicio>();
            if (null != session.getAttribute("ServicesList")) {
                ServicesList = (List<Servicio>) session.getAttribute("ServicesList");
            }
            if (null != session.getAttribute("AvailableService")) {
                AvailableService = (List<Servicio>) session.getAttribute("AvailableService");
            }

            String meetingtime = request.getParameter("txtHours") + ":" + request.getParameter("txtMinutes");
            String outputcore = request.getParameter("txtOutPutCore");
            String arrivalnucleus = request.getParameter("txtArrivalNucleus");
            String startplace = request.getParameter("txtStartPlace");
            String endplace = request.getParameter("txtEndPlace");
            int availableseats = Integer.parseInt(request.getParameter("txtAvailableSeats"));
            Conductor driver = (Conductor) session.getAttribute("InfoUsuario");
            LocalDate dateser;
            if (request.getParameter("txtDateSer").equals("Hoy")) {
                dateser = LocalDate.now();
            } else {
                dateser = LocalDate.now().plusDays(1);
            }
            Servicio p = new Servicio(meetingtime, outputcore, arrivalnucleus, startplace, endplace, availableseats, driver, vehicle, dateser);
            ServicesList.add(p);
            AvailableService.add(p);

            session.setAttribute("ServicesList", ServicesList);
            session.setAttribute("AvailableService", AvailableService);
            RequestDispatcher view = request.getRequestDispatcher("IndexConductor.jsp");
            view.forward(request, response);
        } catch (ArithmeticException exce) {
            request.setAttribute("stError", exce.getMessage());
            request.getRequestDispatcher("IndexConductor.jsp").forward(request, response);
        } catch (Exception exce) {
            request.setAttribute("stError", exce.getMessage());
            request.getRequestDispatcher("ProgramarViaje.jsp").forward(request, response);
        }
    }
}
