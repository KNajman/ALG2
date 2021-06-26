package app;

import bank.bank.Client;
import bank.bank.Account;
import bank.bank.Company;
import bank.bank.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author najma
 */
public class BankApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client Pekar = new Person("Pekar");
        Client Svecova= new Person("Svecova");
        Client Skoda= new Company("Skoda");
        
        Pekar.establishAccount(1000);
        Pekar.establishAccount(500);
        Svecova.establishAccount(1200);
        Skoda.establishAccount(120);
        
        System.out.println(Pekar);
        System.out.println(Pekar.addressClient());
        System.out.println(Pekar.celkovaSumaUctu());
        System.out.println("");
        System.out.println(Svecova);
        System.out.println(Svecova.addressClient());
        System.out.println(Svecova.celkovaSumaUctu());
        System.out.println("");
        System.out.println(Skoda);
        System.out.println(Skoda.addressClient());
        System.out.println(Skoda.celkovaSumaUctu());
    }

}
