<%@page import="modele.Matiere"%>
<%@page import="modele.Professeur"%>
<%@page import="modele.Classe"%>
<%
            Classe classe = (Classe) request.getAttribute("classe");
            Professeur[] professeurs = (Professeur[]) request.getAttribute("professeurs");
            Matiere[] matieres = (Matiere[]) request.getAttribute("matieres");
%>
<jsp:include page="/layout/tete.jsp" />
<h1>Ajout d'un cours</h1>
<form action="Classes" method="post">
    <div class="form_blog_1">
        <input type="hidden" name="classe_id_cours" value="<%= classe.getId()%>" />
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>Mati&eacute;re :</td>
                <td>
                    <select name="matiere">
                        <%
                                    for (int i = 0; i < matieres.length; i++) {
                                        Matiere matiere = matieres[i];
                        %>
                        <option value="<%= matiere.getId()%>" ><%= matiere.getLibelle()%></option>
                        <%
                                    }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Professeur :</td>
                <td>
                    <select name="professeur">
                        <% for (int i = 0; i < professeurs.length; i++) {%>
                        <option value="<%= professeurs[i].getId()%>" ><%= professeurs[i].getPrenom()%> <%= professeurs[i].getNom()%></option>
                        <% }%>
                    </select>
                </td>
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
                <td><input type="text" name="heureDebutCours" time/></td>
            </tr>
            <tr>
                <td>Heure de Fin :</td>
                <td><input type="text" name="heureFinCours" time/></td>
            </tr>
            <tr>
                <td>Date de d&eacute;but</td>
                <td><input type="text" name="dateDebutCours" date/></td>
            </tr>
            <tr>
                <td>Date de Fin</td>
                <td><input type="text" name="dateFinCours" date/></td>
            </tr>

        </table>
        <p class="groupe_bouton">
            <input type="submit" value="Ajouter"/>
            <a href="Classes?action=show&id=<%= classe.getId()%>" class="bouton">annuler</a>
        </p>
    </div>
</form>
<jsp:include page="/layout/pieds.jsp" />