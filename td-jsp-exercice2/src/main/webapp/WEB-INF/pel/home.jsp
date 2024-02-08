<%--
  Created by IntelliJ IDEA.
  User: marwa
  Date: 11/01/2024
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page home</title>
    <jsp:useBean id="erreur" type="java.lang.String" class="java.lang.String" scope="request"/>

</head>
<body>
<span style="color: red">
    ${erreur}
</span>
<form method="post" action="/pel/connexion">
<p>pseudo: <input type="text" name="pseudo" id="pseudo"></p>
<p>password: <input type="password" name="password" id="password"></p>
<p><input type="submit" value="connexion"></p>
</form>
</body>
</html>
