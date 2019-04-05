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
import models.Pasajero;

/**
 *
 * @author juana
 */
@WebServlet(name = "MejorPasajeros", urlPatterns = {"/MejorPasajeros"})
public class MejorPasajeros extends HttpServlet {

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
        List<Pasajero> RidersList = (List<Pasajero>) session.getAttribute("RidersList");
        List<Float> AverageScore = new ArrayList<Float>();
        List<Pasajero> Riders = new ArrayList<Pasajero>();
        List<Pasajero> BestRiders = new ArrayList<Pasajero>();
        for (Pasajero rider : RidersList) {
            AverageScore.add(rider.getAverageScore());
            Riders.add(rider);
        }
        for (int j = 0; j < 3; j++) {
            if (AverageScore.isEmpty()) {
                break;
            }
            Float mayor = (float) AverageScore.stream().mapToDouble(i -> i).max().getAsDouble();
            int posicion = AverageScore.indexOf(mayor);
            BestRiders.add(Riders.get(posicion));
            AverageScore.remove(mayor);
            Riders.remove(Riders.get(posicion));
        }
        request.setAttribute("BestRiders", BestRiders);
        if (request.getParameter("cual").equals("Conductor")) {
            request.getRequestDispatcher("MejorPasajerosCon.jsp").forward(request, response);
        }
        else if (request.getParameter("cual").equals("Pasajero")) {
            request.getRequestDispatcher("MejorPasajerosPas.jsp").forward(request, response);
        }
    }
}
