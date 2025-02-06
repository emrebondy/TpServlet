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

@WebServlet("/updateAnnonce")
public class AnnonceUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupérer les données du formulaire
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String adress = request.getParameter("adress");
            String mail = request.getParameter("mail");

            // Connexion à la base de données
            Connection conn = ConnectionDB.getInstance();
            Dao<Annonce> annonceDao = new AnnonceDao(conn);

            // Création de l'objet Annonce avec les nouvelles valeurs
            Annonce annonce = new Annonce(id, title, description, adress, mail, null);

            // Mise à jour dans la base de données
            boolean success = annonceDao.update(annonce);

            if (success) {
                System.out.println("✅ Annonce mise à jour avec succès !");
                response.sendRedirect("index.jsp"); // Redirige vers l'accueil
            } else {
                request.setAttribute("error", "❌ Erreur lors de la mise à jour.");
                request.getRequestDispatcher("annonceEdit.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "❌ Une erreur est survenue : " + e.getMessage());
            request.getRequestDispatcher("annonceEdit.jsp").forward(request, response);
        }
    }
}
