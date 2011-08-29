<%@page import="modele.Professeur"%>
<% Professeur professeur = (Professeur) request.getAttribute("professeur");%>
<jsp:include page="/layout/tete.jsp" />
<h1>Modification d'un professeur</h1>
<form action="Professeurs" method="post">
    <div class="form_blog_1">
        <input type="hidden" name="id" value="<%= professeur.getId() %>"/>
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>Matricule :</td>
                <td><input type="text" name="matricule" value="<%= professeur.getMatricule() %>"/></td>
            </tr>
            <tr>
                <td>Prenom :</td>
                <td><input type="text" name="prenom" value="<%= professeur.getPrenom() %>"/></td>
            </tr>
            <tr>
                <td>Nom :</td>
                <td><input type="text" name="nom" value="<%= professeur.getNom() %>"/></td>
            </tr>
            <tr>
                <td>Date de Naissance :</td>
                <td><input type="text" name="datenaissance" date value="<%= professeur.getDatenaissance().getYear() %>-<%= professeur.getDatenaissance().getMonth()+1 %>-<%= professeur.getDatenaissance().getDate() %>"/></td>
            </tr>
            <tr>
                <td>Login :</td>
                <td><input type="text" name="login" value="<%= professeur.getLogin() %>"/></td>
            </tr>
        </table>
        <p class="groupe_bouton">
            <input type="submit" value="Mettre a jour"/>
            <a href="Professeurs" class="bouton">annuler</a>
        </p>
    </div>
</form>
<jsp:include page="/layout/pieds.jsp" />