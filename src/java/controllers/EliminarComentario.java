/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Comentario;

/**
 *
 * @author juana
 */
@WebServlet(name = "EliminarComentario", urlPatterns = {"/EliminarComentario"})
public class EliminarComentario extends HttpServlet {

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
        List<Comentario> CommentsList=(List<Comentario>) session.getAttribute("CommentsList");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(request.getParameter("txtDate"), formatter);
        Comentario comment=Comentario.BuscadorDeComentario(request.getParameter("txtDes"), request.getParameter("txtEmail"), localDate, CommentsList);
        CommentsList.remove(comment);
        session.setAttribute("CommentsList", CommentsList);
        request.getRequestDispatcher("ListaComentarios.jsp").forward(request, response);
        
    }
}
