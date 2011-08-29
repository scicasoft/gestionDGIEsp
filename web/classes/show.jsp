<%@page import="java.util.Iterator"%>
<%@page import="modele.ClasseEleve"%>
<%@page import="java.util.Set"%>
<%@page import="modele.Eleve"%>
<%@page import="modele.Classe"%>
<% Classe classe = (Classe) request.getAttribute("classe");%>

<jsp:include page="/layout/tete.jsp" />

<h1>Classe : <%= classe.getCycle().getCygle()%> <%= classe.getNiveau()%></h1>

<div id="accordion">
    <h3><a href="#">liste des eleves</a></h3>
    <div>
        <jsp:include page="/classes/_liste_eleve.jsp"/>
    </div>

    <h3><a href="#">Cours</a></h3>
    <div>
        <jsp:include page="/classes/_liste_cours.jsp"/>
    </div>

    <h3><a href="#">Emploi du temps</a></h3>
    <div>
        <jsp:include page="/classes/_edt.jsp"/>
    </div>
</div>
<jsp:include page="/layout/pieds.jsp" />

<script type="text/javascript">
    jQuery(document).ready(function(){
        $(function() {
            $( "#accordion" ).accordion({
                autoHeight: false,
                navigation: true
            });
        });
    });
</script>