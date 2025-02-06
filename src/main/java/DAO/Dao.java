package DAO;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class Dao<T> {

    protected Connection connect = null;

    /**
     * Constructeur
     * @param conn
     */
    public Dao(Connection conn) {
        this.connect = conn;
    }

    /**
     * Methode de creation d'item
     * @param obj
     * @return
     */
    public abstract boolean create(T obj);

    /**
     * Methode pour effacer un item
     * @param id
     * @return
     */
    public abstract boolean delete(int id);

    /**
     * Methode de mise à jour
     * @param obj
     * @return
     */
    public abstract boolean update(T obj);

    /**
     * Methode de recherche d'un item
     * @param id
     * @return
     */
    public abstract T find(int id);

    /**
     * Methode de recherche de tous les items
     * @return ArrayList
     */
    public abstract ArrayList<T> list();
}
