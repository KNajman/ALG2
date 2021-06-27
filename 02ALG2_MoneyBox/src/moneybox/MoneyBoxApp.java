package moneybox;

import java.util.Scanner;

/**
 *
 * @author najma
 */
public class MoneyBoxApp {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        MoneyBox alice = new MoneyBox("Alice", 3, 8);
        MoneyBox bob = new MoneyBox("Bob");
        bob.addCrownOne();
        bob.addCrownOne();
        bob.addCrownTwo(3);
        bob.addCrowns(5, 10);
        System.out.println("Alice ma " + alice.sum() + "Kc.");
        System.out.println("Bob ma " + bob.sum() + "Kc.");
        System.out.println(alice);
        System.out.println(bob);
        int hamburger = 32;
        System.out.println("Alice si "+ (alice.canBuy(hamburger)?"muze":"nemuze") + " koupit hamburger.");
        System.out.println("Bob si "+ (bob.canBuy(hamburger)?"muze":"nemuze") + " koupit hamburger.");
        if (alice.sum() > bob.sum()) {
            System.out.println("Alice ma vic penez.");
        } else if (alice.sum() < bob.sum()) {
            System.out.println("Bob ma vic penez.");
        } else {
            System.out.println("Alice i Bob maji stejne penez.");
        }
        alice.addCrowns(bob.getnOnes(), bob.getnTwos());
        bob.withdrawAll();
        System.out.println(alice);
        System.out.println(bob);
    }
    
}
