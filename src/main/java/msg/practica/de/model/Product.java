package msg.practica.de.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name="Product")
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nume;

    @Column(nullable = false, length = 30)
    private Integer pret;

    @Column(nullable = false, length = 100)
    private String descriere;

    @ManyToMany(targetEntity = User2.class)
    private Set user2Set;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Set getUser2Set() {
        return user2Set;
    }

    public void setUser2Set(Set user2Set) {
        this.user2Set = user2Set;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pret=" + pret +
                ", descriere='" + descriere + '\'' +
                ", user2Set=" + user2Set +
                '}';
    }
}
