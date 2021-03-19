/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg16_pokladnicka;

/**
 *
 * @author najma
 */
public class MoneyBoxApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MoneyBox Alice = new MoneyBox("Alice", 3, 15);
        MoneyBox Bob = new MoneyBox("Bob");
        for (int i = 0; i < 2; i++) {
            Bob.plusOneCoin();
        }
        for (int i = 0; i < 3; i++) {
            Bob.plusTwoCoin();
        }
        Bob.plusCoins(5, 10);

        System.out.println("Alice má: " + Alice.getSum() + "Kč.");
        System.out.println("Bob má: " + Bob.getSum() + "Kč.");

        System.out.println(Alice);
        System.out.println(Bob);

        System.out.println("Muze si Alice koupit hamburger? " + Alice.purchase(39));
        System.out.println("Muze si Bob koupit hamburger? " + Bob.purchase(39));

        if (Alice.getSum() > Bob.getSum()) {
            System.out.println("Vic penez má Alice");
        } else if (Alice.getSum() == Bob.getSum()) {
            System.out.println("Mají stejně");
        } else {
            System.out.println("Vic penez má Bob");
        };

        Bob.setNewOwner("Alice");
        System.out.println(Bob);

    }

}
