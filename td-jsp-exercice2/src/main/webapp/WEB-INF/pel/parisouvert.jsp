<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: marwa
  Date: 18/01/2024
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page de paris ouvert</title>
    <jsp:useBean id="user" scope="session" type="modele.Utilisateur"/>
    <jsp:useBean id="matchs" scope="request" type="java.util.Collection<modele.Match>" />

</head>
<body>
<h1>${user.login}</h1>
<ul>
    <c:forEach items="${matchs}" var="match">
        <li>sport : ${match.sport} - ${match.equipe1} vs ${match.equipe2} - <a href="/pel/pariermontant/?idMatch=${match.idMatch}">parier</a></li>
    </c:forEach>
</ul>
<p><a href="/pel/retouraumenu">Retour au menu</a></p>
</body>
</html>
