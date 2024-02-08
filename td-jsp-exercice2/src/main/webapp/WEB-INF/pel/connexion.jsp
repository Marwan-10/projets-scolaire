<%--
  Created by IntelliJ IDEA.
  User: marwa
  Date: 11/01/2024
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page de connexion</title>
    <jsp:useBean id="user" scope="session" type="modele.Utilisateur"/>
</head>
<body>

<h1>Bienvenue ${user.login}</h1>

<h2>Menu</h2>
<ul>
    <li><a href="/pel/parisouvert">Afficher les matchs sur lequels parier</a></li>
    <li><a href="/pel/mesparis">Afficher mes paris</a></li>
    <li><a href="/pel/deconnexion">Deconnexion</a></li>
</ul>
</body>
</html>
