<%--
  Created by IntelliJ IDEA.
  User: marwa
  Date: 25/01/2024
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page de confermation paris</title>

    <jsp:useBean id="pari" scope="request" type="modele.Pari"/>

</head>
<body>
<h1>${pari.parieur.login}</h1>
<p> Vous avez parié ${pari.montant} sur le resultat ${pari.vainqueur} pour le match: ${pari.match.equipe1} vs ${pari.match.equipe2} le ${pari.match.quand}</p>
<p><a href="/pel/retouraumenu">Retour au menu</a></p>
</body>
</html>
