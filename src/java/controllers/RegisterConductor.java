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
import models.Conductor;

/**
 *
 * @author juana
 */
@WebServlet(name = "RegisterConductor", urlPatterns = {"/RegisterConductor"})
public class RegisterConductor extends HttpServlet {

    protected void verifyNulls(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        RequestDispatcher view = request.getRequestDispatcher("RegisterConductor.jsp");
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

            if (request.getParameter("txtEmail").equals("")) {
                stMensaje += "Ingrese un correo, ";
            }
            if (request.getParameter("txtPassword").equals("")) {
                stMensaje += "Ingrese una contraseña, ";
            }
            if (request.getParameter("txtName").equals("")) {
                stMensaje += "Ingrese su nombre, ";
            }
            if (request.getParameter("txtCellphone").equals("")) {
                stMensaje += "Ingrese un numero de celular, ";
            }
            if (!stMensaje.equals("")) {
                throw new Exception(stMensaje.substring(0, stMensaje.length() - 2) + ".");
            }
            HttpSession session = request.getSession();
            List<Conductor> DriversList = new ArrayList<Conductor>();
            if (null != session.getAttribute("DriversList")) {
                DriversList = (List<Conductor>) session.getAttribute("DriversList");
            }
            String stError = "";
            String name = request.getParameter("txtName");
            String email = request.getParameter("txtEmail").toLowerCase()+"@unal.edu.co";
            String cellphone = request.getParameter("txtCellphone");
            String password = request.getParameter("txtPassword");
            for (Conductor driver : DriversList) {
                if (driver.getEmail().equals(email)) {
                    throw new Exception("Correo existente por favor inicie sesion.");
                }
            }
            Conductor p = new Conductor(email, password, name, cellphone);
            DriversList.add(p);

            session.setAttribute("InfoUsuario", p);
            session.setAttribute("DriversList", DriversList);
            RequestDispatcher view = request.getRequestDispatcher("IndexAddVehiCon.jsp");
            view.forward(request, response);
        } catch (Exception exc) {
            request.setAttribute("stError", exc.getMessage());
            request.getRequestDispatcher("RegisterConductor.jsp").forward(request, response);
        }
    }
}
