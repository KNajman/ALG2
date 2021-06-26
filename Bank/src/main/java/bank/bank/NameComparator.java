package bank.bank;

import java.util.Comparator;

/**
 *
 * @author najma
 */
public class NameComparator {

    public static Comparator<Client> NameComparator = (Client c1, Client c2) -> {
        String Name1 = c1.getName().toUpperCase();
        String Name2 = c2.getName().toUpperCase();

        //ascending order
        return Name1.compareTo(Name2);

        //descending order
        //return Name2.compareTo(Name1);
    };
}
