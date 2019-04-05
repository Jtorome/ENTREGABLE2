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
@WebServlet(name = "RutaFavorita", urlPatterns = {"/RutaFavorita"})
public class RutaFavorita extends HttpServlet {

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
        List<String> Route = new ArrayList<String>();
        List<Integer> Conteo = new ArrayList<Integer>();
        List<String> FavoriteRoute = new ArrayList<String>();
        for (Servicio service : ServicesList) {
            String ruta = service.getOutputCore() + "," + service.getArrivalNucleus();
            if (Route.isEmpty()) {
                Route.add(ruta);
                Conteo.add(1);
            } else {
                int posicion = Route.indexOf(ruta);
                if (posicion == -1) {
                    Route.add(ruta);
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
            FavoriteRoute.add(Route.get(posicion)+","+mayor);
            Conteo.remove(posicion);
            Route.remove(Route.get(posicion));
        }
        request.setAttribute("FavoriteRoute", FavoriteRoute);
        if (request.getParameter("cual").equals("Conductor")) {
            request.getRequestDispatcher("RutaFavoritaCon.jsp").forward(request, response);
        }
        else if (request.getParameter("cual").equals("Pasajero")) {
            request.getRequestDispatcher("RutaFavoritaPas.jsp").forward(request, response);
        }
    }
}
