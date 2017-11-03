package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "account", schema = "public")
//@Embeddable
@ManyToOne(targetEntity = user)
@MappedSuperclass
public class Account implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "owner")
    @JsonProperty("owner")
    private String owner;

    @Column(name = "balance")
    @JsonProperty("balance")
    private int balance;

    public Account() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
