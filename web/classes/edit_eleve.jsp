<%@page import="modele.Eleve"%>
<%@page import="modele.Classe"%>
<% Classe classe = (Classe) request.getAttribute("classe");
            Eleve eleve = (Eleve) request.getAttribute("eleve");
%>
<jsp:include page="/layout/tete.jsp" />
<h1>Modification d'un &eacute;l&egrave;ve</h1>
<form action="Classes" method="post">
    <div class="form_blog_1">
        <input type="hidden" name="classe_id" value="<%= classe.getId()%>" />
        <input type="hidden" name="eleve_id" value="<%= eleve.getId()%>" />
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>Num&eacute;ro Carte Etudaint :</td>
                <td><input type="text" name="nce" value="<%= eleve.getNce()%> " /></td>
            </tr>
            <tr>
                <td>Prenom :</td>
                <td><input type="text" name="prenom" value="<%= eleve.getPrenom()%>"/></td>
            </tr>
            <tr>
                <td>Nom :</td>
                <td><input type="text" name="nom" value="<%= eleve.getNom()%>"/></td>
            </tr>
            <tr>
                <td>Date de Naissance :</td>
                <td><input type="text" name="datenaissance" value="<%= eleve.getDatenaissance()%>"date/></td>
            </tr>

        </table>
        <p class="groupe_bouton">
            <input type="submit" value="Modifier"/>
            <a href="Classes?action=show&id=<%= classe.getId()%>" class="bouton">annuler</a>
        </p>
    </div>
</form>
<jsp:include page="/layout/pieds.jsp" />