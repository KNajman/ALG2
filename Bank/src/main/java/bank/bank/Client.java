package bank.bank;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author najma
 */
public abstract class Client {

    private String name;
    private List<Account> accounts;

    public Client(String name) {
        this.name = name;
        accounts = new ArrayList();
    }

    public void establishAccount(double amount) {
        this.accounts.add(new Account(amount));
    }

    public double celkovaSumaUctu() {
        double sum = 0;
        sum = accounts.stream().map(account -> account.balance()).reduce(sum, (accumulator, _item) -> accumulator + _item);
        return sum;
    }

    public String getName() {
        return name;
    }

    public abstract String addressClient();

    @Override
    public String toString() {
        return "Klient: " + name + accounts;
    }

}
