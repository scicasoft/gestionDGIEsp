<%@page import="modele.Professeur"%>
<% Professeur professeur = (Professeur) request.getAttribute("professeur");%>
<jsp:include page="/layout/tete.jsp" />
<h1>Informations sur le professeur <%= professeur.getPrenom() %> <%= professeur.getNom() %></h1>
Matricule : <%= professeur.getMatricule()%><br/>
Pseudo : <%= professeur.getLogin()%><br/>
Date de naissance : <%= professeur.getDatenaissance() %><br/>
<p class="groupe_bouton">
    <a href="Professeurs">Liste des professeurs</a>
</p>
<jsp:include page="/layout/pieds.jsp" />