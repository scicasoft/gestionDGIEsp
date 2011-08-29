<%@page import="modele.Professeur"%>
<%@page import="modele.Cycle"%>
<% Cycle cycle = (Cycle) request.getAttribute("cycle");%>
<% Professeur[] professeurs = (Professeur[]) request.getAttribute("professeurs");%>
<jsp:include page="/layout/tete.jsp" />
<h1>Modification d'un cycle</h1>
<form method="post" action="Cycles" >
    <div class="form_blog_1">
        <input type="hidden" name="id" value="<%= cycle.getId()%>">
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>Sigle</td>
                <td><input type="text" name="cygle" value="<%= cycle.getCygle()%>"> </td>
            </tr>
            <tr>
                <td>libell&eacute;</td>
                <td><input type="text" name="libelle" value="<%= cycle.getLibelle()%> "> </td>
            </tr>
            <tr>
                <td>Responsable P&eacute;da</td>
                <td>
                    <select name="responsablePedagogiqueid">
                        <% for (int i = 0; i < professeurs.length; i++) {%>
                        <option value="<%= professeurs[i].getId()%>" ><%= professeurs[i].getPrenom()%> <%= professeurs[i].getNom()%></option>
                        <% }%>
                    </select> </td>
            </tr>
        </table>
        <p class="groupe_bouton">
            <input type="submit" value="Mettre a jour"/>
            <a href="Cycles" class="bouton">annuler</a>
        </p>
    </div>
</form>
<jsp:include page="/layout/pieds.jsp" />