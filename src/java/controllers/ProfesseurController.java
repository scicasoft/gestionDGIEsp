/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Professeur;

/**
 *
 * @author scicasoft
 */
public class ProfesseurController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String forwardTo = "";
        if (action != null) {
            if (action.equals("new")) {
                forwardTo = "/professeurs/new.jsp";
            } else if (action.equals("show")) {
                String id = request.getParameter("id");
                request.setAttribute("professeur", Professeur.get(id));
                forwardTo = "/professeurs/show.jsp";
            } else if (action.equals("delete")) {
                String id = request.getParameter("id");
                Professeur.delete(Integer.parseInt(id));
                request.setAttribute("professeurs", Professeur.getAll());
                forwardTo = "/professeurs/index.jsp";
            } else if (action.equals("edit")) {
                String id = request.getParameter("id");
                request.setAttribute("professeur", Professeur.get(id));
                forwardTo = "/professeurs/edit.jsp";
            } else {
                request.setAttribute("professeurs", Professeur.getAll());
                forwardTo = "/professeurs/index.jsp";
            }
        } else {
            request.setAttribute("professeurs", Professeur.getAll());
            forwardTo = "/professeurs/index.jsp";
        }
        request.getRequestDispatcher(forwardTo).forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Professeur professeur = new Professeur();
        String id = request.getParameter("id");
        if (id != null) {
            professeur = Professeur.get(id);
        } else {
            professeur.setPassword((String) request.getParameter("password"));
        }
        Date d = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        d = formatter.parse((String) request.getParameter("datenaissance"), pos);
        professeur.setDatenaissance(d);
        professeur.setLogin((String) request.getParameter("login"));
        professeur.setNom((String) request.getParameter("nom"));
        professeur.setPrenom((String) request.getParameter("prenom"));
        professeur.setMatricule((String) request.getParameter("matricule"));
        professeur.save();
        request.setAttribute("professeurs", Professeur.getAll());
        request.getRequestDispatcher("/professeurs/index.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
