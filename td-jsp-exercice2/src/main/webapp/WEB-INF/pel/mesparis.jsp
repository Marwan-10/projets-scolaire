<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marwa
  Date: 25/01/2024
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page de mes paris</title>
    <jsp:useBean id="pari" scope="request" type="java.util.Collection<modele.Pari>"/>
    <jsp:useBean id="user" scope="session" type="modele.Utilisateur"/>
    <jsp:useBean id="erreur" type="java.lang.String" class="java.lang.String" scope="request"/>

</head>
<body>
<span style="color: red">
    ${erreur}
</span>
<h1>Bienvenue ${user.login}</h1>
<ul>
    <c:forEach items="${pari}" var="pari">
        <li>sport : ${pari.match.sport} - ${pari.match.equipe1} vs ${pari.match.equipe2} - le ${pari.match.quand}. Mise de ${pari.montant} sur ${pari.vainqueur} <a href="/pel/annulerpari/?idPari=${pari.idPari}">Annuler</a></li>
    </c:forEach>
</ul>
<p><a href="/pel/retouraumenu">Retour au menu</a></p>

</body>
</html>
