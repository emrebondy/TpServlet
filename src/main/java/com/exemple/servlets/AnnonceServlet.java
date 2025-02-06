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
import java.util.ArrayList;

@WebServlet("/annonce")
public class AnnonceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Récupérer la connexion via ConnectionDB
            Connection conn = ConnectionDB.getInstance();
            System.out.println("✅ Connexion réussie !");

            if (conn == null) {
                throw new RuntimeException("❌ La connexion est fermée !");
            }

            // Initialiser le DAO
            Dao<Annonce> annonceDao = new AnnonceDao(conn);
            if (annonceDao == null) {
                throw new RuntimeException("❌ Erreur lors de l'initialisation du DAO !");
            }

            // Récupération des annonces
            ArrayList<Annonce> annonceList = annonceDao.list();

            if (annonceList == null) {
                throw new RuntimeException("❌ La liste des annonces est NULL !");
            } else if (annonceList.isEmpty()) {
                System.out.println("⚠️ La liste des annonces est vide.");
            } else {
                System.out.println("📋 Liste des annonces : " + annonceList);
            }

            try {
                // Envoyer les annonces à la JSP
                request.setAttribute("annonceList", annonceList);

                // Redirection vers la JSP
                request.getServletContext().getRequestDispatcher("/annonceList.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
                throw new ServletException("❌ Erreur lors de l'affichage de la JSP : " + e.getMessage());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
