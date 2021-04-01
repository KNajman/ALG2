/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marathon;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author najma
 */
public class Marathon2 {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Runner> marathon;
    private static final double DISTANCE = 42.195;
    private static final String START_TIME = "09:15:00";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {
        System.out.println("Zadej pocet bezcu:");
        int n = sc.nextInt();
        marathon = new ArrayList<>();
        Runner r;
        //start
        for (int i = 0; i < n; i++) {
            r = new Runner(DISTANCE);
            r.setStartTime(START_TIME, dtf);
            marathon.add(r);
        }
        for (int i = 0; i < marathon.size(); i++) {
            System.out.println(marathon.get(i).getStartTime());
            
        }
        //v cili
        System.out.println("Zadej cisla a cislove casy:");
        int number, HH, mm, ss;
        for (int i = 0; i < n; i++) {
            number = sc.nextInt();
            HH = sc.nextInt();
            mm = sc.nextInt();
            ss = sc.nextInt();
            Runner r = findRunner(number);
        }

    }
}
