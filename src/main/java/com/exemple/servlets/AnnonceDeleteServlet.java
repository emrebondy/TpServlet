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

@WebServlet("/deleteAnnonce")
public class AnnonceDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer l'ID de l'annonce à supprimer
            int id = Integer.parseInt(request.getParameter("id"));

            // Connexion à la base de données
            Connection conn = ConnectionDB.getInstance();
            Dao<Annonce> annonceDao = new AnnonceDao(conn);

            // Suppression de l'annonce
            boolean success = annonceDao.delete(id);

            if (success) {
                System.out.println("✅ Annonce supprimée avec succès !");
            } else {
                System.out.println("❌ Erreur lors de la suppression de l'annonce.");
            }

            // Redirige vers la liste des annonces après suppression
            response.sendRedirect("annonce");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("annonce"); // Redirige en cas d'erreur
        }
    }
}
