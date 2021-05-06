/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.text.Collator;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author najmanK
 */
public class Runner implements Comparable<Runner> {

    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate dob;
    private String club;
    private String nationality;

    private int number;
    private LocalTime startTime;
    private LocalTime finishTime;

    public Runner(String firstName, String lastName, char gender, LocalDate dob, String club, String nationality, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.club = club;
        this.nationality = nationality;
        this.number = number;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    //getry
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getClub() {
        return club;
    }

    public String getNationality() {
        return nationality;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    //setry
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return String.format("%10s %10s %s %s %15s %s %d", firstName, lastName, gender, dob.format(DateTimeFormatter.ISO_LOCAL_DATE), club, nationality, number);
    }

    @Override
    public int compareTo(Runner o) {
        Collator col = Collator.getInstance(new Locale("cs", "CZ"));
        return col.compare(this.lastName, o.lastName);
    }

}
