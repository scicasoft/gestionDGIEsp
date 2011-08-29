/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Classe;
import modele.Cycle;
import modele.Professeur;

/**
 *
 * @author flore
 */
public class CycleController extends HttpServlet {

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
            out.println("<title>Servlet CycleController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CycleController at " + request.getContextPath () + "</h1>");
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
        //processRequest(request, response);
        String action = request.getParameter("action");
        String forwardTo = "";
        if (action != null) {
            if (action.equals("new")) {
                request.setAttribute("professeurs", Professeur.getAll());
                forwardTo = "/cycles/new.jsp";
            } else if (action.equals("show")) {
                String id = request.getParameter("id");
                request.setAttribute("cycle", Cycle.get(id));
                forwardTo = "/cycles/show.jsp";
            } else if (action.equals("edit")) {
                String id = request.getParameter("id");
                request.setAttribute("cycle", Cycle.get(id));
                request.setAttribute("professeurs", Professeur.getAll());
                forwardTo = "/cycles/edit.jsp";
            } else if (action.equals("delete")) {
                String id = request.getParameter("id");
                Cycle.delete(Integer.parseInt(id));
                request.setAttribute("cycles", Cycle.getAll());
                forwardTo = "/cycles/index.jsp";
            } else {
                request.setAttribute("cycles", Cycle.getAll());
                forwardTo = "/cycles/index.jsp";
            }
        } else {
            request.setAttribute("cycles", Cycle.getAll());
            forwardTo = "/cycles/index.jsp";
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
        Cycle cycle = new Cycle();
        String id = request.getParameter("id");
        if (id != null) {
            cycle = Cycle.get(id);
        }
        cycle.setCygle((String) request.getParameter("cygle"));
        cycle.setLibelle((String) request.getParameter("libelle"));
        String idresp = request.getParameter("responsablePedagogiqueid");
        cycle.setProfesseur(Professeur.get(idresp));
        cycle.save();
        String nbNiveau = request.getParameter("nbniveau");
        if (nbNiveau != null) {
            int d = new Date().getYear();
            for (int i = 0; i < Integer.parseInt(nbNiveau); i++) {
                Classe classe = new Classe();
                classe.setNiveau(i+1);
                classe.setCycle(Cycle.get(cycle.getId()));
                classe.setAnnee(d);
                classe.save();
            }
        }
        request.setAttribute("cycles", Cycle.getAll());
        request.getRequestDispatcher("/cycles/index.jsp").forward(request, response);
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
