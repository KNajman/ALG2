package bank.bank;

import java.util.Comparator;

/**
 *
 * @author najma
 */
public interface BalanceComparator{

    
    public static Comparator<Client> BalanceComparator = (Client c1, Client c2) -> {
        return Double.compare(c1.accountBalance(), c2.accountBalance());
    }
;

}
