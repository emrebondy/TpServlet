package ConnectionDB;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Bean.Annonce;

public class HibernateTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Session session = null;

        try {
            // Récupérer la SessionFactory depuis HibernateUtil
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            // Récupérer toutes les annonces avec Criteria API
            List<Annonce> annonces = session.createCriteria(Annonce.class).list();
            System.out.println("📌 Avec Criteria API : Nombre d'annonces : " + annonces.size());

            // Récupérer toutes les annonces avec HQL (Hibernate Query Language)
            List<Annonce> annoncesHQL = session.createQuery("FROM Annonce").list();
            System.out.println("📌 Avec HQL : Nombre d'annonces : " + annoncesHQL.size());

            // Récupérer toutes les annonces avec SQL natif
            List<Object[]> annoncesSQL = session.createSQLQuery("SELECT * FROM annonce").list();
            System.out.println("📌 Avec SQL : Nombre d'annonces : " + annoncesSQL.size());

            tx.commit();
            System.out.println("✅ Test terminé avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
}
