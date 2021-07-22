package msg.practica.de;

import msg.practica.de.model.Product;
import msg.practica.de.model.User2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class ManyToMany {
    private static final String PERSISTENCE_UNIT_NAME = "my-app";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // create new todo
        em.getTransaction().begin();

        // create product1 Entity
        Product product1 = new Product();
        product1.setNume("tricou");
        product1.setPret(80);
        product1.setDescriere("de bumbac");

        // create product2 Entity
        Product product2 = new Product();
        product2.setNume("pantaloni");
        product2.setPret(200);
        product2.setDescriere("de piele");

        // create product3 Entity
        Product product3 = new Product();
        product3.setNume("bustiera");
        product3.setPret(200);
        product3.setDescriere("roz");

        // store product1 and product2
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);

        // create Product Set1
        Set<Product> prodSet1 = new HashSet<Product>();
        prodSet1.add(product1);
        prodSet1.add(product2);
        prodSet1.add(product3);

        // create Product Set2
        Set<Product> prodSet2 = new HashSet<Product>();
        prodSet2.add(product3);
        prodSet2.add(product1);
        prodSet2.add(product2);

        // create Product Set3
        Set<Product> prodSet3 = new HashSet<Product>();
        prodSet3.add(product2);
        prodSet3.add(product3);
        prodSet3.add(product1);

        // create user1 Entity
        User2 user1 = new User2();
        user1.setFirstName("Maria");
        user1.setLastName("Papuc");
        user1.setEmail("maria_minodora07@yahoo.com");
        user1.setPassword("mra");
        user1.setProductSet(prodSet1);

        // create user2 Entity
        User2 user2 = new User2();
        user2.setFirstName("Mihai");
        user2.setLastName("Oancea");
        user2.setEmail("mihai.oancea@gmail.com");
        user2.setPassword("InSoMnIaC");
        user2.setProductSet(prodSet2);

        // create user3 Entity
        User2 user3 = new User2();
        user3.setFirstName("Radu");
        user3.setLastName("Muntean");
        user3.setEmail("radu.muntean@msg.de");
        user3.setPassword("topsecret");
        user3.setProductSet(prodSet3);

        // store users
        em.persist(user1);
        em.persist(user2);
        em.persist(user3);

        em.getTransaction().commit();

        System.out.println("Tran Committed");

        em.close();
        factory.close();
    }
}
