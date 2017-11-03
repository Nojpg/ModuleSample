package domain;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity(name = "CreditAccount")
@Table(name = "credit_account", schema = "public")
public class CreditAccount extends Account {

    private int creditLimit;

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public CreditAccount() {
    }

}
