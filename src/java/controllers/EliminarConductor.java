/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EliminarConductor", urlPatterns = {"/EliminarConductor"})
public class EliminarConductor extends HttpServlet {

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
        List<Conductor> DriversList=(List<Conductor>) session.getAttribute("DriversList");
        Conductor driver=Conductor.BuscadorDeConductor(request.getParameter("txtEmail"), DriversList);
        DriversList.remove(driver);
        session.setAttribute("DriversList", DriversList);
        request.getRequestDispatcher("ListaConductores.jsp").forward(request, response);
    }
}
