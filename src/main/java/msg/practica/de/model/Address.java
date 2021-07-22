package msg.practica.de.model;

import javax.persistence.*;

@Entity(name="Address")
@Table(name="Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 60)
    private String street;

    @Column(nullable = false, length = 30)
    private Integer numar;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 30)
    private String town;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return numar;
    }

    public void setNumber(Integer number) {
        this.numar = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", numar=" + numar +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}
