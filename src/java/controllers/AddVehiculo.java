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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Vehiculo;
import models.Conductor;

/**
 *
 * @author juana
 */
@WebServlet(name = "AddVehiculo", urlPatterns = {"/AddVehiculo"})
public class AddVehiculo extends HttpServlet {

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

        RequestDispatcher view = request.getRequestDispatcher("AddVehiculo.jsp");
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
        try {

            String stMensaje = "";

            if (request.getParameter("txtLicensePlate").equals("")) {
                stMensaje += "Ingrese una placa, ";
            }
            if (request.getParameter("txtColor").equals("")) {
                stMensaje += "Ingrese un color, ";
            }
            if (!request.getParameter("txtType").equals("Carro") && !request.getParameter("txtType").equals("Moto")) {
                stMensaje += "Ingrese Carro o Moto, ";
            }
            if (request.getParameter("txtModel").equals("")) {
                stMensaje += "Ingrese el modelo, ";
            }
            if (!request.getParameter("txtActive").equals("Si") && !request.getParameter("txtActive").equals("No")) {
                stMensaje += "Ingrese Si o No, ";
            }
            if (!stMensaje.equals("")) {
                throw new Exception(stMensaje.substring(0, stMensaje.length() - 2) + ".");
            }
            HttpSession session = request.getSession();
            List<Vehiculo> VehiclesList = new ArrayList<Vehiculo>();
            if (null != session.getAttribute("VehiclesList")) {
                VehiclesList = (List<Vehiculo>) session.getAttribute("VehiclesList");
            }
            String LicensePlate = request.getParameter("txtLicensePlate");
            String color = request.getParameter("txtColor");
            String type = request.getParameter("txtType");
            int seats;
            if (type.equals("Carro")) {
                seats = 5;
            } else {
                seats = 2;
            }
            String model = request.getParameter("txtModel");
            String active = request.getParameter("txtActive");
            Conductor driver = (Conductor) session.getAttribute("InfoUsuario");
            for (Vehiculo rider : VehiclesList) {
                if (rider.getLicensePlate().equals(LicensePlate)) {
                    throw new Exception("Placa existente por favor registre una que no exista.");
                }
            }
            Vehiculo p = new Vehiculo(LicensePlate, color, type, model, seats, driver, active);
            VehiclesList.add(p);

            session.setAttribute("VehiclesList", VehiclesList);
            RequestDispatcher view = request.getRequestDispatcher("LoginConductor.jsp");
            view.forward(request, response);
        } catch (Exception exc) {
            request.setAttribute("stError", exc.getMessage());
            request.getRequestDispatcher("AddVehiculo.jsp").forward(request, response);
        }
    }
}
