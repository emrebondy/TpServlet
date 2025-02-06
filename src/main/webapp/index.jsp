<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil</title>
    <link rel="stylesheet" href="CSS/index.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>🎉 Bienvenue sur mon magnifique projet Servlet !</h1>
    <p>📢 Trouvez, ajoutez et gérez vos annonces facilement.</p>

    <div class="button-container">
        <form action="hello" method="GET" class="hello-form">
            <input type="text" name="name" placeholder="Entrez votre nom..." required class="hello-input">
            <button type="submit" class="btn btn-primary">👋 Dire Bonjour</button>
        </form>


        <form action="annonce" method="GET">
            <button type="submit" class="btn btn-secondary">📋 Voir les Annonces</button>
        </form>

        <form action="annonceAdd.jsp" method="GET">
            <button type="submit" class="btn btn-success">➕ Ajouter une Annonce</button>
        </form>
    </div>
</div>
</body>
</html>
