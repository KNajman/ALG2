package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import logic.Bank;
import util.BankInterface;

/**
 *
 * @author JV
 */
public class Application {
    public static Scanner sc = new Scanner(System.in);
    private static BankInterface bank;
    
    public static void main(String[] args) throws IOException, ParseException{
        System.out.println("Vitajte v banke.");
        boolean isAppEnd = false;
        boolean isChoice1Valid = true;
        boolean isEnd = false;
        
        bank = new Bank();
        
        do{
            displayMenu1();
            isChoice1Valid = true;
            switch (readChoice()){
                case 1: createNewAccount(); 
                        break;
                case 2: if(!chooseExistingAccount()){
                            isChoice1Valid = false;
                        }
                        break;
                case 0: isAppEnd = true;
                        break;
                default : System.out.println("Bola zadana nespravna volba. Opakujte."); 
                          isChoice1Valid = false;  
            }
            if (isChoice1Valid && !isAppEnd){
                do{
                    displayMenu2();
                    isEnd = false;
                    switch (readChoice()){
                        case 1: deposit();
                                break;
                        case 2: withdraw();
                                break;
                        case 3: getStatement();
                                break;
                        case 4: getBalance();
                                break;
                        case 0: isEnd = true;
                                break;
                        default: System.out.println("Bola zadana nespravna volba. Opakuj.");
                    }
               }while (!isEnd);
            }
        }while(!isAppEnd);
    }
    
    private static void displayMenu1(){
        System.out.println();
        System.out.println("  1 - Vytvor novy ucet");
        System.out.println("  2 - Zadaj existujuci ucet");
        System.out.println("  0 - Koniec aplikacie");
    }
    
    private static void displayMenu2() {
        System.out.println();
        System.out.println("  1 - Vklad");
        System.out.println("  2 - Vyber");
        System.out.println("  3 - Vypis");
        System.out.println("  4 - Zostatok");
        System.out.println("  0 - Koniec prace s uctom");
    } 
    
    private static int readChoice() {
        int choice = 0;
        System.out.println();
        System.out.print("Zadej volbu: ");
        choice = sc.nextInt();
        return choice;
    }
       
    private static void createNewAccount() throws IOException {
        bank.createNewAccount();
        System.out.println("Bol Vam vytvoreny ucet s cislom: " + bank.getActiveAccountNumber());
    }
    
    private static boolean chooseExistingAccount() {
        System.out.println();
        System.out.println("Zadajte cislo uctu: ");
        int accountNumber = sc.nextInt();
        if(!bank.chooseExistingAccount(accountNumber)){
            System.out.println("Bolo zadane neexistujuce cislo uctu. Opakujte.");
            return false; //invalide account number;    
        }
        System.out.println("Pracujete s uctom cislo: "+ bank.getActiveAccountNumber());
        return true;
    }
        
    private static void deposit() throws FileNotFoundException, IOException, ParseException  {
        System.out.println();
        System.out.println("Vklad na ucet cislo: " + bank.getActiveAccountNumber());
        System.out.print("Zadajte sumu penazi, ktoru chcete vlozit: ");
        int sum = sc.nextInt();
        bank.deposit(sum);
        System.out.println(bank.getBalance());
    }
    
    private static void withdraw() throws FileNotFoundException, IOException, ParseException  {
        System.out.println();
        System.out.println("Vyber z uctu cislo: " + bank.getActiveAccountNumber());
        System.out.print("Zadajte sumu penazi, ktoru chcete vybrat: ");
        int sum = sc.nextInt();
        bank.withdraw(sum);
        System.out.println(bank.getBalance());
        }

    private static void getStatement() throws ParseException, FileNotFoundException, IOException {
        System.out.println();
        System.out.println("Zadajte datum od do: (format 21.04.2015)");
        Date from = BankInterface.sdf.parse(sc.next());
        Date to = BankInterface.sdf.parse(sc.next());
        System.out.format("Vypis z uctu: %d%n", bank.getActiveAccountNumber());
        System.out.println(bank.getStatement(from, to));
    }

    private static void getBalance() throws ParseException, FileNotFoundException, IOException {
        System.out.println();
        System.out.println("Zadajte datum od do: (format 21.04.2015)");
        Date from = BankInterface.sdf.parse(sc.next());
        Date to = BankInterface.sdf.parse(sc.next());
        System.out.format("Bilance uctu: %d%n", bank.getActiveAccountNumber());
        System.out.println(bank.getBalance(from, to));
    }
}