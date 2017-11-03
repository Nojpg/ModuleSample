package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    private User user;
    private List<Account> accounts = new ArrayList<>();

    @Before
    public void initUser(){
        user = new User();


    }

    @Test
    public void idTest() {
        user.setId(2);
        assertEquals(2, user.getId());
    }

    @Test
    public void nameTest() {
        user.setName("test");
        assertEquals("test", user.getName());
    }

    @Test
    public void AccountsTest() {
        CreditAccount account1 = new CreditAccount();
        DebitAccount account2 = new DebitAccount();
        account1.setCreditLimit(1);
        account2.setOverdraftFee(3);
        accounts.add(account1);
        accounts.add(account2);
        user.setAccounts(accounts);
        assertEquals(accounts.get(0), account1);
    }

    @Test
    public void homeAddressTest() {
        Address address = new Address();
        address.setHouse("123");
        address.setStreet("new");
        user.setHomeAddress(address);
        assertEquals("123", user.getHomeAddress().getHouse());
    }

    @Test
    public void workAddressTest() {
    }
}