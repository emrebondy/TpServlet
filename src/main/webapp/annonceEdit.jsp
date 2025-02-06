<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier une Annonce</title>
    <link rel="stylesheet" type="text/css" href="CSS/annonceEdit.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>
<div class="form-container">
    <h2>✏️ Modifier une Annonce</h2>

    <form method="post" action="updateAnnonce">
        <input type="hidden" name="id" value="${annonce.id}">

        <label for="title">📌 Titre :</label>
        <input type="text" id="title" name="title" value="${annonce.title}" required>

        <label for="description">📝 Description :</label>
        <textarea id="description" name="description" rows="4" required>${annonce.description}</textarea>

        <label for="adress">📍 Adresse :</label>
        <input type="text" id="adress" name="adress" value="${annonce.adress}" required>

        <label for="mail">📧 Email :</label>
        <input type="email" id="mail" name="mail" value="${annonce.mail}" required>

        <div class="button-container">
            <a href="annonce" class="btn btn-back">↩️ Retour à la liste</a>
            <button type="submit" class="btn btn-save">✅ Sauvegarder</button>
        </div>
    </form>
</div>
</body>
</html>
