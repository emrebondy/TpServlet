<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une Annonce</title>
    <link rel="stylesheet" type="text/css" href="CSS/annonceAdd.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
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

        <div class="button-container">
            <a href="index.jsp" class="btn btn-back">🏠 Retour</a>
            <button type="submit" class="btn btn-save">✅ Ajouter l'Annonce</button>
        </div>
    </form>
</div>
</body>
</html>
