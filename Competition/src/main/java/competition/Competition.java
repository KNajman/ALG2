/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author najma
 */
public class Competition {

    static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");

    private List<Runner> runners;

    public Competition() {
        runners = new ArrayList<>();
    }

    public void loadRegistration(String filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {;
            String line;
            String[] parts;
            String firstName, lastName, club, nationality;
            int number;
            char gender;
            LocalDate dob;
            Runner r;

            while ((line = br.readLine()) != null) {
                parts = line.split(",");
                String[] firstLast = parts[1].split(" ");
                firstName = firstLast[1];
                lastName = firstLast[0];
                club = parts[4];
                nationality = parts[5];
                number = Integer.parseInt(parts[0]);
                dob = LocalDate.parse(parts[3], dtf);
                gender = parts[2].charAt(0);
                r = new Runner(firstName, lastName, gender, dob, club, nationality, number);
                runners.add(r);
            }
        }
    }

    public String getResults() {
        Collections.sort(runners);
        StringBuilder sb = new StringBuilder();
        runners.forEach(r -> {
            sb.append(r).append("\n");
        });
        return sb.toString();
    }

    public void saveResults(String filename) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename))))){
            runners.forEach(runner -> {
                pw.println(runner.toString());
            });
        }

    }

}
