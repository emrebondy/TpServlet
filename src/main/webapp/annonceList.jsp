<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Annonces</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="annonce-container">
    <h2>📢 Liste des Annonces</h2>

    <c:choose>
        <c:when test="${empty annonceList}">
            <p>⚠️ Aucune annonce trouvée.</p>
        </c:when>
        <c:otherwise>
            <ul class="annonce-list">
                <c:forEach var="annonce" items="${annonceList}">
                    <li class="annonce-item">
                        <span class="annonce-title">${annonce.title}</span>
                        <p class="annonce-description">${annonce.description}</p>
                        <p class="annonce-details">
                            📍 Adresse: ${annonce.adress} | 📧 Email: ${annonce.mail} | 🕒 Date: ${annonce.date}
                        </p>

                        <!-- Bouton Modifier -->
                        <form action="AnnonceEdit.jsp" method="GET">
                            <input type="hidden" name="id" value="${annonce.id}">
                            <button type="submit">✏️ Modifier</button>
                        </form>
                    </li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>

    <!-- Bouton Retour Accueil -->
    <form action="index.jsp">
        <button type="submit" class="back-button">🏠 Retour</button>
    </form>
</div>
</body>
</html>
