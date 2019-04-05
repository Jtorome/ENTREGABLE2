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

/**
 *
 * @author juana
 */
@WebServlet(name = "MasViajesConductor", urlPatterns = {"/MasViajesConductor"})
public class MasViajesConductor extends HttpServlet {
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
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        HttpSession session = request.getSession();
        List<Conductor> DriversList = (List<Conductor>) session.getAttribute("DriversList");
        List<Integer> ServicesNumber = new ArrayList<Integer>();
        List<Conductor> Drivers = new ArrayList<Conductor>();
        List<Conductor> Mayor = new ArrayList<Conductor>();
        for (Conductor driver : DriversList) {
            ServicesNumber.add(driver.getServicesNumber());
            Drivers.add(driver);
        }
        for (int j = 0; j < 3; j++) {
            if (ServicesNumber.isEmpty()) {
                break;
            }
            int mayor = (int) ServicesNumber.stream().mapToDouble(i -> i).max().getAsDouble();
            int posicion = ServicesNumber.indexOf(mayor);
            Mayor.add(Drivers.get(posicion));
            ServicesNumber.remove(posicion);
            Drivers.remove(Drivers.get(posicion));
        }
        request.setAttribute("Mayor", Mayor);
        if (request.getParameter("cual").equals("Conductor")) {
            request.getRequestDispatcher("MasViajesConducCon.jsp").forward(request, response);
        }
        else if (request.getParameter("cual").equals("Pasajero")) {
            request.getRequestDispatcher("MasViajesConducPas.jsp").forward(request, response);
        }
    }
}
