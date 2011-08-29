<%@page import="modele.Cours"%>
<%@page import="modele.Matiere"%>
<%@page import="modele.Professeur"%>
<%@page import="modele.Classe"%>
<%@page  import="modele.Matiere" %>
<%
Cours cour = (Cours) request.getAttribute("cous");
Classe classe = (Classe) request.getAttribute("classe");
            Professeur[] professeurs = Professeur.getAll();
            Matiere[] matieres = Matiere.getAll();
            Cours[] cours = Cours.getAll();
%>
<jsp:include page="/layout/tete.jsp" />
<h1>Ajout d'un cours</h1>
<form action="Classes" method="post">
    <div class="form_blog_1">
        <input type="hidden" name="classe_id_cours" value="<%= classe.getId()%>" />
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>Mati&eacute;re :</td>
                <td><select name="matiere"><% for (int i = 0; i < matieres.length; i++) {%>
                        <option <%= (matieres[i].getId() == cour.getMatiere().getId()) ? "selected" : "" %> value="<%= matieres[i].getId()%>" ><%= matieres[i].getLibelle()%></option>
                        <% }%>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Professeur :</td>
                <td><select name="professeur">
                        <% for (int i = 0; i < professeurs.length; i++) {%>
                        <option <%= (professeurs[i].getId() == cour.getProfesseur().getId()) ? "selected" : "" %> value="<%= professeurs[i].getId()%>" ><%= professeurs[i].getPrenom()%> <%= professeurs[i].getNom()%></option>
                        <% }%>
                    </select> </td>
            </tr>
            <tr>
                <td>Jour :</td>
                <td><select name="jour">
                        <option value="lundi">Lundi</option>
                        <option value="mardi">Mardi</option>
                        <option value="mercredi">Mercredi</option>
                        <option value="jeudi">Jeudi</option>
                        <option value="vendredi">Vendredi</option>
                        <option value="samedi">Samedi</option>
                    </select>
            </tr>
            <tr>
                <td>Heure de d&eacute;but :</td>
                <td><input type="text" name="heureDebut" date value="<%= cour.getHeureDebut()%> "/></td>
            </tr>
            <tr>
                <td>Heure de Fin :</td>
                <td><input type="text" name="heureFin" date value="<%= cour.getHeureFin() %>"/></td>
            </tr>
            <tr>
                <td>Date de d&eacute;but</td>
                <td><input type="text" name="dateDebut" date value="<%= cour.getDateDebut() %>"/></td>
            </tr>
            <tr>
                <td>Date de Fin</td>
                <td><input type="text" name="dateFin" date value="<%= cour.getDateFin() %>"/></td>
            </tr>

        </table>
        <p class="groupe_bouton">
            <input type="submit" value="Ajouter"/>
            <a href="Classes?action=show&id=<%= classe.getId()%>" class="bouton">annuler</a>
        </p>
    </div>
</form>
<jsp:include page="/layout/pieds.jsp" />