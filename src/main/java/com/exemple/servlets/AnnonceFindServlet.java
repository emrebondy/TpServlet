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

@WebServlet("/editAnnonce")
public class AnnonceFindServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Récupérer l'ID de l'annonce depuis l'URL
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("Annonce find" + id);

            // Connexion à la base de données
            Connection conn = ConnectionDB.getInstance();
            Dao<Annonce> annonceDao = new AnnonceDao(conn);

            // Récupérer l'annonce existante
            Annonce annonce = annonceDao.find(id);
            System.out.println("voici find avec id" + annonce);
            // Vérifier si l'annonce existe
            if (annonce != null) {
                request.setAttribute("annonce", annonce);
                request.getRequestDispatcher("annonceEdit.jsp").forward(request, response);
            } else {
                response.sendRedirect("annonce"); // Redirige vers la liste si l'ID est invalide
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("annonce"); // Redirige en cas d'erreur
        }
    }
}
