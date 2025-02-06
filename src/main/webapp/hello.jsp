<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Résultat</title>
    <link rel="stylesheet" type="text/css" href="CSS/hello.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>👋 Hello, <span class="username"><%= request.getAttribute("username") %></span> !</h1>
    <p>Bienvenue sur mon site ! je suis ravis de te voir ici.</p>

    <div class="button-container">
        <a href="index.jsp" class="btn btn-menu">🏠 Retour au Menu</a>
    </div>
</div>
</body>
</html>
