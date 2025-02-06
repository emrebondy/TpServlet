package com.exemple.servlets;

import Bean.Annonce;
import ConnectionDB.ConnectionDB;
import DAO.AnnonceDao;
import DAO.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;

@WebServlet("/addAnnonce") // URL du servlet
public class AnnonceAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer les valeurs du formulaire
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String adress = request.getParameter("adress");
            String mail = request.getParameter("mail");

            // Vérification des champs (éviter l'injection SQL et les erreurs)
            if (title == null || title.isEmpty() || description == null || description.isEmpty()
                    || adress == null || adress.isEmpty() || mail == null || mail.isEmpty()) {
                request.setAttribute("error", "Tous les champs sont obligatoires !");
                request.getRequestDispatcher("annonceAdd.jsp").forward(request, response);
                return;
            }

            // Créer une connexion à la base de données
            Connection conn = ConnectionDB.getInstance();

            // Création d'une nouvelle annonce
            Annonce annonce = new Annonce(0, title, description, adress, mail, new Timestamp(System.currentTimeMillis()));

            // Insérer dans la base via DAO
            Dao<Annonce> annonceDao = new AnnonceDao(conn);
            boolean success = annonceDao.create(annonce);

            if (success) {
                System.out.println("✅ Annonce ajoutée avec succès !");
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("error", "❌ Erreur lors de l'ajout de l'annonce.");
                request.getRequestDispatcher("annonceAdd.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "❌ Une erreur est survenue : " + e.getMessage());
            request.getRequestDispatcher("annonceAdd.jsp").forward(request, response);
        }
    }
}
