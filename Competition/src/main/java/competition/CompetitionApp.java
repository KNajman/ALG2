/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author najma
 */
public class CompetitionApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Competition comp = new Competition();
        try {
            try {
                System.out.println("Zadej soubor");
                comp.loadRegistration(sc.next());
                System.out.println(comp.getResults());
            } catch (FileNotFoundException e) {
                System.out.println("Zadan neplatny soubour");
            }
        } catch (IOException e) {
            System.out.println("Nastal problem" + e.getMessage());
        }
    }
}
