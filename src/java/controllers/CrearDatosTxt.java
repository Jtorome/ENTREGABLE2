/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CrearDatosTxt", urlPatterns = {"/CrearDatosTxt"})
public class CrearDatosTxt extends HttpServlet {

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
            if (session.getAttribute("CrearDatosTxt") != null) {
                throw new Exception("Los datos ya fueron creados.");
            }
            List<Conductor> DriversList = (List<Conductor>) session.getAttribute("DriversList");
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\juana\\Downloads\\Universidad\\unal 2018-2\\POO\\Entregable2\\src\\java\\controllers\\datos.txt"));
            String sCadena;
            while ((sCadena = bf.readLine()) != null) {
                String[] line = sCadena.split(",");
                Conductor c = new Conductor(line[0], line[1], line[2], line[3]);
                DriversList.add(c);
            }
            session.setAttribute("CrearDatosTxt", 1);
            response.sendRedirect("/Entregable2/Start");
        } catch (Exception exc) {
            request.setAttribute("stError", exc.getMessage());
            request.getRequestDispatcher("Start.jsp").forward(request, response);
        }
    }
}
