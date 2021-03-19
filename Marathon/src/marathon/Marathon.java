/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marathon;

import java.util.Scanner;

/**
 *
 * @author najma
 */
public class Marathon {

    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Berlinský maraton 2034");
        System.out.println("Zadejte počet běžců");
        int n = sc.nextInt();
        Runner bezci[] = new Runner[n];
        for (int i = 0; i < n; i++) {
            bezci[i] = Runner(sc.nextInt()
            ,sc.nextInt()
            ,sc.nextInt()
            ,sc.nextInt());            
        }
    }

}
