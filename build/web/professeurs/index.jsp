<%@page import="modele.Professeur"%>
<% Professeur[] professeurs = (Professeur[]) request.getAttribute("professeurs");%>
<jsp:include page="/layout/tete.jsp" />
<h1>Liste des Professeurs</h1>
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
<jsp:include page="/layout/pieds.jsp"/>