<%@page import="modele.Classe"%>
<%@page import="java.util.Iterator"%>
<%@page import="modele.ClasseEleve"%>
<%@page import="java.util.Set"%>
<% Classe classe = (Classe) request.getAttribute("classe");%>
<% Set<ClasseEleve> eleves = classe.getClasseEleveSet();
            Iterator<ClasseEleve> iter = eleves.iterator();
%>
<table class="tableau" width="100%">
    <tr>
        <th>NCE</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Date de Naissance</th>
        <th width="25px"></th>
        <th width="25px"></th>
    </tr>
    <%while (iter.hasNext()) {
                    ClasseEleve ce = iter.next();
    %>
    <tr>
        <td><%= ce.getEleve().getNce()%></td>
        <td><%= ce.getEleve().getNom()%></td>
        <td><%= ce.getEleve().getPrenom()%></td>
        <td><%= ce.getEleve().getDatenaissance()%></td>
        <td align="center"><a href="Classes?action=edit_eleve&id=<%= ce.getEleve().getId()%>&id_classe=<%= classe.getId() %>"><img src="images/modifier.png" /></a></td>
        <td align="center"><a href="Classes?action=delete_eleve&id=<%= ce.getId()%>&id_classe=<%= classe.getId() %>"><img src="images/supprimer.png" /></a></td>
    </tr>
    <%}%>
</table>
<p class="groupe_bouton">
    <a href="Classes?action=new_eleve&id=<%=classe.getId()%>">ajouter un &eacute;l&egrave;ve</a>
</p>