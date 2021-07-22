package msg.practica.de;

import msg.practica.de.model.Address;
import msg.practica.de.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ManyToOne {

    private static final String PERSISTENCE_UNIT_NAME = "my-app";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // create new todo
        em.getTransaction().begin();

        // create address1 Entity
        Address address1 = new Address();
        address1.setStreet("Gheorghe Dima");
        address1.setNumber(39);
        address1.setCity("Cluj Napoca");
        address1.setTown("Romania");

        // create address2 Entity
        Address address2 = new Address();
        address2.setStreet("Octavian Goga");
        address2.setNumber(11);
        address2.setCity("Sibiu");
        address2.setTown("Romania");

        // store address1 and address2
        em.persist(address1);
        em.persist(address2);

        // create user1 Entity
        User user1 = new User();
        user1.setFirstName("Maria");
        user1.setLastName("Papuc");
        user1.setEmail("maria_minodora07@yahoo.com");
        user1.setPassword("mra");
        user1.setAddress(address2);

        // create user2 Entity
        User user2 = new User();
        user2.setFirstName("Mihai");
        user2.setLastName("Oancea");
        user2.setEmail("mihai.oancea@gmail.com");
        user2.setPassword("InSoMnIaC");
        user2.setAddress(address2);

        // create user3 Entity
        User user3 = new User();
        user3.setFirstName("Radu");
        user3.setLastName("Muntean");
        user3.setEmail("radu.muntean@msg.de");
        user3.setPassword("topsecret");
        user3.setAddress(address1);

        // store users
        em.persist(user1);
        em.persist(user2);
        em.persist(user3);

        em.getTransaction().commit();

        System.out.println("Address Table Data");
        List<Address> addressList = em.createQuery("SELECT a FROM Address a").getResultList();
        for (Address adr : addressList) {
            System.out.println(adr.toString());
        }
        System.out.println("Size: " + addressList.size() + "\n");

        System.out.println("Users Table Data");
        List<User> userList = em.createQuery("SELECT u FROM Users u").getResultList();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        System.out.println("Size: " + userList.size() + "\n");

        System.out.println("Tran Committed");

        em.close();
        factory.close();

//        String sql = "SELECT u FROM Users u";
//        Query q = em.createQuery(sql);
//        List<User> userList = q.getResultList();
//        for (User user : userList) {
//            System.out.println(user);
//        }
//        System.out.println("Size: " + userList.size());
//
//        // create new todo
//        em.getTransaction().begin();
//
//        User user = new User();
//        user.setFirstName("radu");
//        user.setLastName("muntean");
//        user.setEmail("radu.muntean@msg.de");
//        user.setPassword("topsecret");
//
//        em.persist(user);
//        em.getTransaction().commit();
//
//        em.close();
    }
}
