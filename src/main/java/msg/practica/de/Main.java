package msg.practica.de;

import msg.practica.de.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "my-app";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        String sql = "SELECT u FROM Users u";
        Query q = em.createQuery(sql);
        List<User> userList = q.getResultList();
        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println("Size: " + userList.size());

        // create new todo
        em.getTransaction().begin();

        User user = new User();
        user.setFirstName("radu");
        user.setLastName("muntean");
        user.setEmail("radu.muntean@msg.de");
        user.setPassword("topsecret");

        em.persist(user);
        em.getTransaction().commit();

        em.close();
    }
}
