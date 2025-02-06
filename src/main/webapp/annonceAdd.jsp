<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter une Annonce</title>
</head>
<body>
<div class="form-container">
    <h2>📝 Ajouter une Annonce</h2>

    <form method="post" action="addAnnonce">
        <label for="title">📌 Titre :</label>
        <input type="text" id="title" name="title" required>

        <label for="description">📝 Description :</label>
        <textarea id="description" name="description" rows="4" required></textarea>

        <label for="adress">📍 Adresse :</label>
        <input type="text" id="adress" name="adress" required>

        <label for="mail">📧 Email :</label>
        <input type="email" id="mail" name="mail" required>

        <button type="submit">✅ Ajouter l'Annonce</button>
    </form>

    <!-- Bouton retour -->
    <form action="index.jsp">
        <button type="submit" class="back-button">🏠 Retour</button>
    </form>
</div>
</body>
</html>
