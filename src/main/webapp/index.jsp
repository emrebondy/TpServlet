<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
<h1>Bienvenue !</h1>

<form action="hello" method="GET">
    <label for="name">Entrez votre nom :</label>
    <input type="text" id="name" name="name" required>
    <button type="submit">Envoyer</button>
</form>

<form action="annonce" method="GET">
    <button type="submit">Voir les annonces</button>
</form>

<form action="AnnonceAdd.jsp" method="GET">
    <button type="submit">➕ Ajouter une Annonce</button>
</form>


</body>
</html>