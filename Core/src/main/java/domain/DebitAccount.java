package domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity(name = "DebitAccount")
@Table(name = "debit_account", schema = "public")
public class DebitAccount extends Account {

    private int overdraftFee;

    public int getOverdraftFee() {
        return overdraftFee;
    }

    public void setOverdraftFee(int overdraftFee) {
        this.overdraftFee = overdraftFee;
    }

    public DebitAccount() {
    }
}
