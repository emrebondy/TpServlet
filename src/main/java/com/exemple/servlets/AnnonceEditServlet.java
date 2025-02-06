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

@WebServlet("/updateAnnonce")
public class AnnonceEditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String adress = request.getParameter("adress");
            String mail = request.getParameter("mail");

            Connection conn = ConnectionDB.getInstance();
            Dao<Annonce> annonceDao = new AnnonceDao(conn);

            // Mettre à jour l'annonce
            Annonce annonce = new Annonce(id, title, description, adress, mail, new Timestamp(System.currentTimeMillis()));
            boolean success = annonceDao.update(annonce);

            if (success) {
                System.out.println("✅ Annonce mise à jour avec succès !");
                response.sendRedirect("annonce");
            } else {
                request.setAttribute("error", "❌ Erreur lors de la mise à jour.");
                request.getRequestDispatcher("AnnonceEdit.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "❌ Une erreur est survenue : " + e.getMessage());
            request.getRequestDispatcher("AnnonceEdit.jsp").forward(request, response);
        }
    }
}
