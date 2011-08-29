<%@page import="modele.Professeur"%>
<%@page import="modele.Cycle"%>
<% Cycle cycle = new Cycle();%>
<% Professeur[] professeurs = (Professeur[]) request.getAttribute("professeurs");%>
<jsp:include page="/layout/tete.jsp" />
<h1>Ajout d'un cycle</h1>
<form method="post" action="Cycles" >
    <div class="form_blog_1">
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>Sigle</td>
                <td><input type="text" name="cygle"> </td>
            </tr>
            <tr>
                <td>libell&eacute;</td>
                <td><input type="text" name="libelle"> </td>
            </tr>
            <tr>
                <td>Responsable P&eacute;da</td>
                <td><select name="responsablePedagogiqueid">
                        <% for (int i = 0; i < professeurs.length; i++) {%>
                        <option value="<%= professeurs[i].getId()%>" ><%= professeurs[i].getPrenom()%> <%= professeurs[i].getNom()%></option>
                        <% }%>
                    </select> </td>
            </tr>
            <tr>
                <td>Nombre de niveaux</td>
                <td>
                    <select name="nbniveau">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>
                </td>
            </tr>

        </table>
        <p class="groupe_bouton">
            <input type="submit" value="Ajouter"/>
            <a href="Cycles" class="bouton">annuler</a>
        </p>
    </div>
</form>
<jsp:include page="/layout/pieds.jsp" />