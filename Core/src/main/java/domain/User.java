package domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "users", schema = "public") //TODO name
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @ElementCollection
    @Column(name = "accounts")
    @CollectionTable(schema = "public", name = "accounts")
    @OrderColumn
    @OneToMany(mappedBy = "owner")
    @JsonProperty("accounts")
    private List<Account> accounts = new LinkedList<>();

    @Embedded
    @JoinColumn(name = "home_address", referencedColumnName = "address_street")
    @OneToOne(mappedBy = "user")
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "house", column = @Column(name = "home_house"))})
    @JsonProperty("homeAddress")
    private Address homeAddress;

    @Embedded
    @JoinColumn(name = "work_address", referencedColumnName = "address_street")
    @OneToOne(mappedBy = "user")
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "work_street")),
            @AttributeOverride(name = "house", column = @Column(name = "work_house"))})
    @JsonProperty("workAddress")
    private Address workAddress;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getAccounts(), user.getAccounts()) &&
                Objects.equals(getHomeAddress(), user.getHomeAddress()) &&
                Objects.equals(getWorkAddress(), user.getWorkAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getAccounts(), getHomeAddress(), getWorkAddress());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                '}';
    }
}
