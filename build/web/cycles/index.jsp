<%@page import="java.util.Iterator"%>
<%@page import="modele.Classe"%>
<%@page import="java.util.Set"%>
<%@page import="modele.Cycle"%>
<% Cycle[] cycles = (Cycle[]) request.getAttribute("cycles");%>
<jsp:include page="/layout/tete.jsp" />
<h1>Liste des Cycles</h1>
<table class="tableau" width="100%">
    <tr>
        <th width="70px">Sigle</th>
        <th width="120px">Libell&eacute;</th>
        <th width="25px"></th>
        <th width="25px"></th>
    </tr>
    <% for (int i = 0; i < cycles.length; i++) { %>
    <tr>
        <td><%= cycles[i].getCygle()%></td>
        <td> <a href="Cycles?action=show&id=<%= cycles[i].getId()%>"><%= cycles[i].getLibelle()%></a></td>
        <td align="center"><a href="Cycles?action=edit&id=<%= cycles[i].getId()%>"><img src="images/modifier.png" /></a> </td>
        <td align="center"><a href="Cycles?action=delete&id=<%= cycles[i].getId()%>"><img src="images/supprimer.png" /></a></td>
    </tr>
    <%}%>
</table>
<p class="groupe_bouton">
    <a href="Cycles?action=new">ajouter un cycle</a>
<jsp:include page="/layout/pieds.jsp" />