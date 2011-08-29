<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="modele.Classe"%>
<%@page import="modele.Cycle"%>

<% Cycle cycle = (Cycle) request.getAttribute("cycle");%>
<jsp:include page="/layout/tete.jsp" />
<h1>Infos sur un cycle</h1>
Sigle : <%= cycle.getCygle()%><br/>
Libell&eacute; : <%= cycle.getLibelle()%><br/>
Responsable P&eacute;dagogique : <%= cycle.getProfesseur().getPrenom()%> <%= cycle.getProfesseur().getNom()%><br/>
<%
            Set<Classe> classes = cycle.getClasseSet();
            Iterator<Classe> iter = classes.iterator();
            if (!iter.hasNext()) {%>
<%= "Il n y a pas de classe pour ce cycle"%>
<% }
            while (iter.hasNext()) {
                Classe c = (Classe) iter.next();%>
<%= c.getAnnee()%>
<a href="Classes?action=show&id=<%= c.getId()%>"> <%= cycle.getCygle() + "" + c.getNiveau()+" "+c.getClasseEleveSet().size() %></a>

<%}%>

<a href="Cycles">retour</a>
<jsp:include page="/layout/pieds.jsp" />