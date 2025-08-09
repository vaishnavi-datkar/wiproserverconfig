package hiberDemo.hibernetDemo;

import org.hibernate.Session;
import hiberDemo.hibernetDemo.util.HibernateUtil1;

public class PanTest {
    public static void main(String[] args) {

        Session session = HibernateUtil1.getSessionFactory().openSession();

        Pan pan = new Pan();
        pan.setPanholderName("Vaishnavi");
        pan.setPanNumber("ABCD1234E");

        ((Object) session).beginTransaction();
        session.save(pan);
        ((Object) session).getTransaction().commit();

        session.close();
        HibernateUtil1.shutdown();

        System.out.println("PAN record saved successfully.");
    }
}
