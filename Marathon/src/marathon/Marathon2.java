/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marathon;

import java.time.LocalTime;
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
            r = findRunner(number);
            r.setFinishTime(HH, mm, ss);
        }

        marathon.forEach(runner -> {
            System.out.println(runner);
        });

        System.out.println(countUnderLimit("00:16:00", dtf));

    }

    private static Runner findRunner(int number) {
        for (int i = 0; i < marathon.size(); i++) {
            if (marathon.get(i).getNumber() == number) {
                return marathon.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    private static int countUnderLimit(String time, DateTimeFormatter dtf) {
        int count = 0;
        for (Runner runner : marathon) {
            if (runner.underTime(time, dtf)) {
                count++;
            }
        }
        return count;
    }

    private static Runner fastest() {
        LocalTime fastestTime = marathon.get(0).getRunningTime();
        Runner fastestRunner = null;
        for (Runner runner : marathon) {
            if (runner.getRunningTime().isBefore(fastestTime)) {
                fastestTime = runner.getRunningTime();
                fastestRunner = runner;
            }
        }
        return fastestRunner;
    }

}
