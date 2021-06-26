package app;

import bank.bank.Client;
import bank.bank.Company;
import bank.bank.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import bank.bank.BalanceComparator;
import bank.bank.NameComparator;

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
        Client Svecova = new Person("Svecova");
        Client Skoda = new Company("Skoda");

        Pekar.establishAccount(1000);
        Pekar.establishAccount(500);
        Svecova.establishAccount(1200);
        Skoda.establishAccount(120);

        //System.out.println(Pekar);
        System.out.println(Pekar.addressClient());
        System.out.println(Pekar.celkovaSumaUctu());
        System.out.println("");
        //System.out.println(Svecova);
        System.out.println(Svecova.addressClient());
        System.out.println(Svecova.celkovaSumaUctu());
        System.out.println("");
        //System.out.println(Skoda);
        System.out.println(Skoda.addressClient());
        System.out.println(Skoda.celkovaSumaUctu());
        System.out.println("");

        List<Client> clients = new ArrayList(Arrays.asList(Pekar, Svecova, Skoda));
        printList(clients);
        
        System.out.println("___________________________________");
        System.out.println("Name-sorted (using Namecomparator):");
        
        printList(clients);
        
        Arrays.sort(clients);
        //printList(clients);
        
        

    }

    public static void printList(List<Client> clients) {
        clients.forEach(c -> {
            System.out.format("%s: %.2f KC %n", c.addressClient(), c.celkovaSumaUctu());
        });
    }
}
