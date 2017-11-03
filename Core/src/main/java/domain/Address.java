package domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "address", schema = "public")
//@Embeddable ??
public class Address implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "address_street")
    @JsonProperty("street")
    private String street;
    @Column(name = "address_house")
    @JsonProperty("house")
    private String house;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
