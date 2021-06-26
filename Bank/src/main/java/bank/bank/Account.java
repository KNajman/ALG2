
package bank.bank;

/**
 *
 * @author najma
 */
public class Account {

    private double account;
    private final String currency = "Kc";

    //prazdny ucet
    public Account() {
        this.account = 0;
    }

    //ucet s pocatecnim vkladem
    public Account(double amount) {
        this.account = amount;
    }

    public double balance() {
        return account;
    }

    public void deposit(double amount) {
        this.account += amount;
    }

    public void cashout(double amount) {
        if (amount <= this.account) {
            this.account -= amount;
        } else {
            this.account = 0;
        }
    }

    @Override
    public String toString() {
        return "Zustatek na uctu: " + account + currency;
    }

}
