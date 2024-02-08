<%--
  Created by IntelliJ IDEA.
  User: marwa
  Date: 25/01/2024
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page d'annulation pari</title>
    <jsp:useBean id="pari" scope="request" type="modele.Pari"/>
    <jsp:useBean id="user" scope="session" type="modele.Utilisateur"/>
</head>
<body>
<h1>Bienvenue ${user.login}</h1>
<p>La mise de ${pari.montant} euros sur le resultat ${pari.vainqueur} pour le match: ${pari.match.equipe1} vs ${pari.match.equipe2} le ${pari.match.quand} a bien été annulée ! </p>
<p><a href="/pel/retouraumenu">Retour au menu</a></p>
</body>
</html>
