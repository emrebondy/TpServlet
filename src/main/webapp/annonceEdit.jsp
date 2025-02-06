<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier une Annonce</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
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

        <button type="submit">✅ Sauvegarder</button>
    </form>

    <!-- Bouton Retour à la Liste -->
    <form action="annonce">
        <button type="submit" class="back-button">↩️ Retour à la liste</button>
    </form>
</div>
</body>
</html>
