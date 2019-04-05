/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Pasajero;
import models.Servicio;

/**
 *
 * @author juana
 */
@WebServlet(name = "IndexAdmin", urlPatterns = {"/IndexAdmin"})
public class IndexAdmin extends HttpServlet {
    
    protected void UploadAvailableService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Servicio> AvailableService = new ArrayList<Servicio>();
        List<Servicio> AvailableServiceCopi = new ArrayList<Servicio>();
        for(Servicio servi: (List<Servicio>) session.getAttribute("AvailableService")){
            AvailableService.add(servi);
            AvailableServiceCopi.add(servi);
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        String nowformat = now.format(format);
        LocalDate today = LocalDate.now();
        for (Servicio ser : AvailableServiceCopi) {
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
        session.setAttribute("AvailableService", AvailableService);
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
        request.getRequestDispatcher("IndexAdmin.jsp").forward(request, response);
    }
}
