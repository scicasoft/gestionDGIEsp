<jsp:include page="/layout/tete.jsp" />
<h1>Ajout d'un professeur</h1>
<form action="Professeurs" method="post">
    <div class="form_blog_1">
        <table width="100%" border="0" cellpadding="10px">
            <tr>
                <td>Matricule :</td>
                <td><input type="text" name="matricule"/></td>
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
            <tr>
                <td>Login :</td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td>Mot de passe :</td>
                <td><input type="password" name="password"/></td>
            </tr>
        </table>
        <p class="groupe_bouton">
            <input type="submit" value="Ajouter"/>
            <a href="Professeurs" class="bouton">annuler</a>
        </p>
    </div>
</form>
<jsp:include page="/layout/pieds.jsp" />