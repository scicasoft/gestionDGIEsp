/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Classe;
import modele.ClasseEleve;
import modele.Cours;
import modele.Eleve;
import modele.Matiere;
import modele.Professeur;

/**
 *
 * @author flore
 */
public class ClasseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClasseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClasseController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            if (action.equals("show")) {
                String id = request.getParameter("id");
                request.setAttribute("classe", Classe.get(id));
                forwardTo = "/classes/show.jsp";
            } //cours
            else if (action.equals("delete_cours")) {
                String id = request.getParameter("id");
                Cours.delete(id);
                String id_classe = request.getParameter("id_classe");
                request.setAttribute("classe", Classe.get(id_classe));
                forwardTo = "/classes/show.jsp";
            } else if (action.equals("edit_cours")) {
                String id = request.getParameter("id");
                request.setAttribute("cour", Cours.get(id));
                String id_classe = request.getParameter("id_classe");
                request.setAttribute("classe", Classe.get(id_classe));
                forwardTo = "/classes/edit.jsp";
            } else if (action.equals("new_cours")) {
                String id_classe = request.getParameter("id");
                request.setAttribute("classe", Classe.get(id_classe));
                request.setAttribute("professeurs", Professeur.getAll());
                request.setAttribute("matieres", Matiere.getAll());
                forwardTo = "/classes/ajout_cours.jsp";
            } //eleve
            else if (action.equals("delete_eleve")) {
                String id = request.getParameter("id");
                ClasseEleve.delete(id);
                String id_classe = request.getParameter("id_classe");
                request.setAttribute("classe", Classe.get(id_classe));
                forwardTo = "/classes/show.jsp";
            } else if (action.equals("edit_eleve")) {
                String id = request.getParameter("id");
                request.setAttribute("eleve", Eleve.get(id));
                String id_classe = request.getParameter("id_classe");
                request.setAttribute("classe", Classe.get(id_classe));
                forwardTo = "/classes/edit_eleve.jsp";
            } else if (action.equals("new_eleve")) {
                String id = request.getParameter("id");
                request.setAttribute("classe", Classe.get(id));
                forwardTo = "/classes/ajout_eleve.jsp";
            }
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
        String classe_id = null;
        Eleve eleve = new Eleve();
        if (request.getParameter("nce") != null) {
            String eleve_id = request.getParameter("eleve_id");
            if (eleve_id != null) {
                eleve = Eleve.get(eleve_id);
            } else {
                eleve.setLogin(((String) request.getParameter("nce")).toUpperCase());
                eleve.setPassword(((String) request.getParameter("nce")).toUpperCase());
            }
            Date d = null;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            ParsePosition pos = new ParsePosition(0);
            d = formatter.parse((String) request.getParameter("datenaissance"), pos);
            eleve.setNce(((String) request.getParameter("nce")).toUpperCase());
            eleve.setNom((String) request.getParameter("nom"));
            eleve.setPrenom((String) request.getParameter("prenom"));
            eleve.setDatenaissance(d);
            eleve.save();
            if (eleve_id == null) {
                ClasseEleve classeeleve = new ClasseEleve();
                classe_id = request.getParameter("classe_id");
                classeeleve.setEleve(eleve);
                classeeleve.setClasse(Classe.get(classe_id));
                classeeleve.save();
            }
            classe_id = request.getParameter("classe_id");
        }
        if (request.getParameter("heureDebutCours")!=null) {
            classe_id = request.getParameter("classe_id_cours");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatter_time = new SimpleDateFormat("H:m");
            ParsePosition pos = new ParsePosition(0);
            Cours cours = new Cours();
            cours.setClasse(Classe.get(request.getParameter("classe_id_cours")));
            cours.setDateDebut(formatter.parse((String) request.getParameter("dateDebutCours"), pos));
            cours.setDateFin(formatter.parse((String) request.getParameter("dateFinCours"), pos));
            cours.setHeureDebut(formatter_time.parse((String) request.getParameter("dateDebutCours"), pos));
            cours.setHeureFin(formatter_time.parse((String) request.getParameter("dateDebutCours"), pos));
            cours.setJour(request.getParameter("jour"));
            cours.setMatiere(Matiere.get(request.getParameter("matiere")));
            cours.setProfesseur(Professeur.get(request.getParameter("professeur")));
            cours.save();
        }
//        request.setAttribute("id", classe_id);
//        request.setAttribute("action", "show");
        response.sendRedirect("/gestionPedagogiqueDGI/Classes?action=show&id=" + classe_id);
//        doGet(request, response);
//        request.getRequestDispatcher("/classes?action=show&id="+classe_id).forward(request, response);

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
