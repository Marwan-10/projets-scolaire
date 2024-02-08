<%--
  Created by IntelliJ IDEA.
  User: marwa
  Date: 18/01/2024
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page montant pari</title>
    <jsp:useBean id="user" scope="session" type="modele.Utilisateur"/>
    <jsp:useBean id="match" scope="session" type="modele.Match"/>
    <jsp:useBean id="erreur" type="java.lang.String" class="java.lang.String" scope="request"/>


</head>
<body>
<span style="color: red">
    ${erreur}
</span>
<h1>${user.login}</h1>
<form method="post" action="/pel/parisconfirme">
<h3>Vous voulez parier sur le match: ${match.equipe1} - ${match.equipe2} le ${match.quand}
  <br>
  Verdict du match <select name="resultat" id="resultat">
        <option >nul</option>
        <option>${match.equipe1}</option>
        <option >${match.equipe2}</option>
    </select>
  <br>
  Montant <input type="text" name="montant" id="montant" />
  <br>
  <input type="submit" value="Parier!" />

</h3>
<p><a href="/pel/retouraumenu">Retour au menu</a></p>

</form>
</body>
</html>
