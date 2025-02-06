package DAO;

import Bean.Annonce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnnonceDao extends Dao<Annonce> {

    public AnnonceDao(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Annonce obj) {
        String query = "INSERT INTO annonce (title, description, adress, mail, date) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = this.connect.prepareStatement(query)) {
            stmt.setString(1, obj.getTitle());
            stmt.setString(2, obj.getDescription());
            stmt.setString(3, obj.getAdress());
            stmt.setString(4, obj.getMail());
            stmt.setTimestamp(5, obj.getDate());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM annonce WHERE id = ?";

        try (PreparedStatement stmt = this.connect.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Annonce find(int id) {
        String query = "SELECT * FROM annonce WHERE id = ?";
        Annonce annonce = null;

        try (PreparedStatement stmt = this.connect.prepareStatement(query,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if (result.first()) { // ✅ Maintenant possible grâce à SCROLL_INSENSITIVE
                annonce = new Annonce(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("adress"),
                        result.getString("mail"),
                        result.getTimestamp("date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonce;
    }


    @Override
    public ArrayList<Annonce> list() {
        ArrayList<Annonce> annonceList = new ArrayList<>();
        String query = "SELECT * FROM annonce"; // Vérifie le nom de la table !

        try (PreparedStatement stmt = this.connect.prepareStatement(query);
             ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                Annonce annonce = new Annonce(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("adress"),  // Vérifie l'orthographe ici
                        result.getString("mail"),
                        result.getTimestamp("date")
                );
                annonceList.add(annonce);
            }

            System.out.println("✅ Nombre d'annonces récupérées : " + annonceList.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonceList;
    }


    @Override
    public boolean update(Annonce obj) {
        String query = "UPDATE annonce SET title = ?, description = ?, adress = ?, mail = ?, date = ? WHERE id = ?";

        try (PreparedStatement stmt = this.connect.prepareStatement(query)) {
            stmt.setString(1, obj.getTitle());
            stmt.setString(2, obj.getDescription());
            stmt.setString(3, obj.getAdress());
            stmt.setString(4, obj.getMail());
            stmt.setTimestamp(5, obj.getDate());
            stmt.setInt(6, obj.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
