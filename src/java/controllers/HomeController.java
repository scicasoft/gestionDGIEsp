/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Cycle;
import modele.GroupeMatiere;
import modele.Matiere;
import modele.Professeur;
import modele.Specialite;

/**
 *
 * @author scicasoft
 */
public class HomeController extends HttpServlet {

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
        String modele = request.getParameter("modele");
        String id = request.getParameter("id");
        String forwardTo = "";
        if (action != null) {
            if (action.equals("delete")) {
                if (modele.equals("specialite")) {
                    Specialite.delete(id);
                } else if (modele.equals("groupe_matiere")) {
                    GroupeMatiere.delete(id);
                } else if (modele.equals("matiere")) {
                    Matiere.delete(id);
                }
            }
        }
        request.setAttribute("professeurs", Professeur.getAll());
        request.setAttribute("cycles", Cycle.getAll());
        request.setAttribute("specialites", Specialite.getAll());
        request.setAttribute("groupe_matieres", GroupeMatiere.getAll());
        forwardTo = "/home/index.jsp";
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
        String libelleSpecialite = request.getParameter("libelleSpecialite");
        String libelleGroupeMatiere = request.getParameter("libelleGroupeMatiere");
        String libelleMatiere = request.getParameter("libelleMatiere");
        if (libelleSpecialite != null) {
            Specialite specialite = new Specialite();
            specialite.setLibelle(libelleSpecialite);
            specialite.save();
        } else if (libelleGroupeMatiere != null) {
            String coef = request.getParameter("coefGroupeMatiere");
            GroupeMatiere groupe_matiere = new GroupeMatiere();
            groupe_matiere.setCoef(Float.parseFloat(coef));
            groupe_matiere.setLibelle(libelleGroupeMatiere);
            groupe_matiere.save();
        } else if (libelleMatiere != null) {
            String coef = request.getParameter("coefMatiere");
            String idGroupeMatiere = request.getParameter("idGroupeMatiere");
            Matiere matiere = new Matiere();
            matiere.setCoef(Float.parseFloat(coef));
            matiere.setLibelle(libelleMatiere);
            matiere.setGroupeMatiere(GroupeMatiere.get(idGroupeMatiere));
            matiere.save();
        }
        doGet(request, response);
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
