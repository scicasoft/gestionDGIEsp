<%@page import="modele.GroupeMatiere"%>
<% GroupeMatiere[] groupe_matieres = (GroupeMatiere[]) request.getAttribute("groupe_matieres");%>

<form class="fenetre_formulaire" action="Home" method="post" id="formulaireSpecialite" style="display: none">
    <div class="form_blog_1">
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>sp&eacute;cialite :</td>
                <td><input type="text" name="libelleSpecialite"/></td>
            </tr>
        </table>
    </div>
</form>

<form class="fenetre_formulaire" action="Home" method="post" id="formulaireGroupeMatiere" style="display: none">
    <div class="form_blog_1">
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>libelle Groupe Matiere :</td>
                <td><input type="text" name="libelleGroupeMatiere"/></td>
            </tr>
            <tr>
                <td>coef Groupe Matiere :</td>
                <td><input type="text" name="coefGroupeMatiere"/></td>
            </tr>
        </table>
    </div>
</form>

<form class="fenetre_formulaire" action="Home" method="post" id="formulaireMatiere" style="display: none">
    <div class="form_blog_1">
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>Groupe de Matiere :</td>
                <td>
                    <select name="idGroupeMatiere">
                        <%
                                    for (int i = 0; i < groupe_matieres.length; i++) {
                                        GroupeMatiere groupe_matiere = groupe_matieres[i];
                        %>
                        <option value="<%= groupe_matiere.getId()%>"><%= groupe_matiere.getLibelle()%></option>
                        <%
                                    }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>libelle Matiere :</td>
                <td><input type="text" name="libelleMatiere"/></td>
            </tr>
            <tr>
                <td>coef Matiere :</td>
                <td><input type="text" name="coefMatiere"/></td>
            </tr>
        </table>
    </div>
</form>