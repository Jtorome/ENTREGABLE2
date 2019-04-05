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
import models.Servicio;

/**
 *
 * @author juana
 */
@WebServlet(name = "VehiculoFavorito", urlPatterns = {"/VehiculoFavorito"})
public class VehiculoFavorito extends HttpServlet {
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
        List<Servicio> ServicesList = (List<Servicio>) session.getAttribute("ServicesList");
        List<String> Vehicle = new ArrayList<String>();
        List<Integer> Conteo = new ArrayList<Integer>();
        List<String> FavoriteVehicle = new ArrayList<String>();
        for (Servicio service : ServicesList) {
            String vehiculo = service.getVehicle().getVehicleType() + "," + service.getVehicle().getVehicleModel();
            if (Vehicle.isEmpty()) {
                Vehicle.add(vehiculo);
                Conteo.add(1);
            } else {
                int posicion = Vehicle.indexOf(vehiculo);
                if (posicion == -1) {
                    Vehicle.add(vehiculo);
                    Conteo.add(1);
                } else {
                    Conteo.set(posicion, Conteo.get(posicion) + 1);
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            if (Conteo.isEmpty()) {
                break;
            }
            int mayor = (int) Conteo.stream().mapToDouble(i -> i).max().getAsDouble();
            int posicion = Conteo.indexOf(mayor);
            FavoriteVehicle.add(Vehicle.get(posicion)+","+mayor);
            Conteo.remove(posicion);
            Vehicle.remove(Vehicle.get(posicion));
        }
        request.setAttribute("FavoriteVehicle", FavoriteVehicle);
        if (request.getParameter("cual").equals("Conductor")) {
            request.getRequestDispatcher("VehiculoFavoritoCon.jsp").forward(request, response);
        }
        else if (request.getParameter("cual").equals("Pasajero")) {
            request.getRequestDispatcher("VehiculoFavoritoPas.jsp").forward(request, response);
        }
    }
}
