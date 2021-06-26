package bank.bank;

import java.util.Comparator;

/**
 *
 * @author najma
 */
public class BalanceComparator implements Comparator<Client> {

    @Override
    public int compare(Client c1, Client c2) {
        return Double.compare(c1.celkovaSumaUctu(), c2.celkovaSumaUctu());
    }
;

}
