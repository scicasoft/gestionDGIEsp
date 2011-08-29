<%@page import="modele.Cours"%>
<%@page import="modele.Classe"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<% Classe classe = (Classe) request.getAttribute("classe");%>
<% Set<Cours> cours = classe.getCoursSet();
            Iterator<Cours> iter = cours.iterator();
%>
<table class="tableau" width="100%">
    <tr>
        <th>Mati&eacute;re</th>
        <th>Professeur</th>
        <th>Jour</th>
        <th>Duree</th>
        <th width="25px"></th>
        <th width="25px"></th>
    </tr>

    <% if (!iter.hasNext()) {%>
    <!--pas de cours-->

    <%        } else {
     while (iter.hasNext()) {
         Cours cour = iter.next();%>
    <tr>
        <td><%= cour.getMatiere().getLibelle()%> </td>
        <td><%= cour.getProfesseur().getNom() + " " + cour.getProfesseur().getPrenom()%> </td>
        <td><%= cour.getJour()%> </td>
        <td><%= cour.getHeureDebut() + " " + cour.getHeureFin()%> </td>
        <td align="center"><a href="Classes?action=edit_cours&id=<%= cour.getId()%>&id_classe=<%= classe.getId()%>"><img src="images/modifier.png" /></a></td>
        <td align="center"><a href="Classes?action=delete_cours&id=<%= cour.getId()%>&id_classe=<%= classe.getId()%>"><img src="images/supprimer.png" /></a></td>
    </tr>
    <%}
                }%>
</table>
<p class="groupe_bouton">
    <a href="Classes?action=new_cours&id=<%=classe.getId()%>">ajouter un cours</a>
</p>