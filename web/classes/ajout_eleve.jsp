<%@page import="modele.Classe"%>
<% Classe classe = (Classe) request.getAttribute("classe");%>
<jsp:include page="/layout/tete.jsp" />
<h1>Ajout d'un &eacute;l&egrave;ve</h1>
<form action="Classes" method="post">
    <div class="form_blog_1">
        <input type="hidden" name="classe_id" value="<%= classe.getId() %>" />
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>Num&eacute;ro Carte Etudaint :</td>
                <td><input type="text" name="nce"/></td>
            </tr>
            <tr>
                <td>Prenom :</td>
                <td><input type="text" name="prenom"/></td>
            </tr>
            <tr>
                <td>Nom :</td>
                <td><input type="text" name="nom"/></td>
            </tr>
            <tr>
                <td>Date de Naissance :</td>
                <td><input type="text" name="datenaissance" date/></td>
            </tr>
           
        </table>
        <p class="groupe_bouton">
            <input type="submit" value="Ajouter"/>
            <a href="Classes?action=show&id=<%= classe.getId() %>" class="bouton">annuler</a>
        </p>
    </div>
</form>
<jsp:include page="/layout/pieds.jsp" />