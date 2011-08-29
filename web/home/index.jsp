<%@page import="modele.Matiere"%>
<%@page import="modele.GroupeMatiere"%>
<%@page import="modele.Specialite"%>
<%@page import="java.util.Iterator"%>
<%@page import="modele.Classe"%>
<%@page import="java.util.Set"%>
<%@page import="modele.Cycle"%>
<%@page import="modele.Professeur"%>
<% Cycle[] cycles = (Cycle[]) request.getAttribute("cycles");%>
<% Specialite[] specialites = (Specialite[]) request.getAttribute("specialites");%>
<% Professeur[] professeurs = (Professeur[]) request.getAttribute("professeurs");%>
<% GroupeMatiere[] groupe_matieres = (GroupeMatiere[]) request.getAttribute("groupe_matieres");%>
<jsp:include page="/layout/tete.jsp" />
<h1>Tableau de bord</h1>

<div class="blocs">
    <div class="blocg">
        <h4>Mati&egrave;res</h4>

        <table class="tableau" width="100%">
            <tr>
                <th>Groupe de Matiere</th>
                <th>Matieres</th>
                <th>Coef</th>
                <th width="25px"></th>
                <th width="25px"></th>
            </tr>
            <%
                        for (int i = 0; i < groupe_matieres.length; i++) {
                            GroupeMatiere groupe_matiere = groupe_matieres[i];
                            Matiere[] matieres = groupe_matiere.matieres();
            %>
            <tr>
                <td><%= groupe_matiere.getLibelle()%></td>
                <td></td>
                <td><%= groupe_matiere.getCoef()%></td>
                <td align="center"><a href="Home?action=edit&modele=groupe_matiere&id=<%= groupe_matiere.getId()%>"><img alt=""  src="images/modifier.png" /></a></td>
                <td align="center"><a href="Home?action=delete&modele=groupe_matiere&id=<%= groupe_matiere.getId()%>"><img alt=""  src="images/supprimer.png" /></a></td>
            </tr>
            <%
                                        for (int j = 0; j < matieres.length; j++) {
                                            Matiere matiere = matieres[j];
            %>
            <tr>
                <td></td>
                <td><%= matiere.getLibelle()%></td>
                <td><%= matiere.getCoef()%></td>
                <td align="center"><a href="Home?action=edit&modele=matiere&id=<%= matiere.getId()%>"><img alt=""  src="images/modifier.png" /></a></td>
                <td align="center"><a href="Home?action=delete&modele=matiere&id=<%= matiere.getId()%>"><img alt=""  src="images/supprimer.png" /></a></td>
            </tr>
            <%
                                        }
            %>
            <%
                        }
            %>
        </table>

        <p class="groupe_bouton">
            <a href="#" class="bouton lien_fenetre" fenetre="formulaireGroupeMatiere">Ajouter Groupe Mati&egrave;re</a>
            <a href="#" class="bouton lien_fenetre" fenetre="formulaireMatiere">Ajouter Mati&egrave;re</a>
        </p>
    </div>
    <div class="blocd">
        <h4>Sp&eacute;cialit&eacute;s</h4>

        <table class="tableau" width="100%">
            <tr>
                <th>Sp&eacute;cialit&eacute;s</th>
                <th width="25px"></th>
                <th width="25px"></th>
            </tr>
            <%
                        for (int i = 0; i < specialites.length; i++) {
                            Specialite specialite = specialites[i];
            %>
            <tr>
                <td><%= specialite.getLibelle()%></td>
                <td align="center"><a href="Home?action=edit&modele=specialite&id=<%= specialite.getId()%>"><img src="images/modifier.png" /></a></td>
                <td align="center"><a href="Home?action=delete&modele=specialite&id=<%= specialite.getId()%>"><img src="images/supprimer.png" /></a></td>
            </tr>
            <%
                        }
            %>
        </table>
        <p class="groupe_bouton">
            <a href="#" class="bouton lien_fenetre" fenetre="formulaireSpecialite">Ajouter Sp&eacute;cialit&eacute;</a>
        </p>
    </div>
</div>
<div class="blocs">
    <div class="blocg">
        <h4>Les classes</h4>
        <%
                    for (int i = 0; i < cycles.length; i++) {
                        Cycle cycle = cycles[i];
        %>
        <table>
            <tr>
                <%
                                        Set<Classe> classes = cycle.getClasseSet();
                                        Iterator<Classe> iter = classes.iterator();
                                        while (iter.hasNext()) {
                                            Classe c = (Classe) iter.next();
                %>
                <td width="60px" align="center">
                    <a href="Classes?action=show&id=<%= c.getId()%>"><img alt=""  src="images/classe.png" /></a>
                    <a href="Classes?action=show&id=<%= c.getId()%>"> <%= cycle.getCygle() + " " + c.getNiveau()%></a>
                </td>
                <%
                                        }
                %>
            </tr>
        </table>
        <%
                    }
        %>
    </div>
    <div class="blocd">
        <h4>Liste des Professeurs</h4>
        <table class="tableau" width="100%">
            <tr>
                <th width="70px">Matricule</th>
                <th width="120px">Pseudo</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th width="25px"></th>
                <th width="25px"></th>
            </tr>
            <% for (int i = 0; i < professeurs.length; i++) {%>
            <tr>
                <td><%= professeurs[i].getMatricule()%></td>
                <td><a href="Professeurs?action=show&id=<%= professeurs[i].getId()%>"><%= professeurs[i].getLogin()%></a></td>
                <td><%= professeurs[i].getNom()%></td>
                <td><%= professeurs[i].getPrenom()%></td>
                <td align="center"><a href="Professeurs?action=edit&id=<%= professeurs[i].getId()%>"><img src="images/modifier.png" /></a></td>
                <td align="center"><a data-confirm="voulez vous bien supprimer ce professeur ?" href="Professeurs?action=delete&id=<%= professeurs[i].getId()%>"><img src="images/supprimer.png" /></a></td>
            </tr>
            <% }%>
        </table>
        <p class="groupe_bouton">
            <a href="Professeurs?action=new">ajouter un professeur</a>
        </p>
    </div>
</div>

<jsp:include page="/home/_formulaires.jsp" />
<jsp:include page="/layout/pieds.jsp" />