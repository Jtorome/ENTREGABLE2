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
import models.Persona;

@WebServlet(urlPatterns = {"/CreatePerson"})
public class CreatePerson extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        
        HttpSession session = request.getSession();
        List<Persona> people = new ArrayList<Persona>();        
        if(null != session.getAttribute("people")){
            people=(ArrayList<Persona>) session.getAttribute("people");
        }
        
        request.setAttribute("people", people);        
        RequestDispatcher view = request.getRequestDispatcher("CreatePerson.jsp");
        view.forward(request, response);        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        
        HttpSession session = request.getSession();        
        List<Persona> people = new ArrayList<Persona>();
        if(null != session.getAttribute("people")){
            people=(ArrayList<Persona>) session.getAttribute("people");
        }
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String cellphone = request.getParameter("cellphone"); 
        Persona p = new Persona(email, password, name, cellphone);
        people.add(p);
        
        session.setAttribute("people", people);
        request.setAttribute("people", people);        
        RequestDispatcher view = request.getRequestDispatcher("CreatePerson.jsp");
        view.forward(request, response);
    }
}
