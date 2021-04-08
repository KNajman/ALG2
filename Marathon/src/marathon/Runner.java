package marathon;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author najma
 */
public class Runner {

    private static int nRunners = 999;
    private final int number;
    private double distance;
    private LocalTime startTime = null;
    private LocalTime finishTime = null;

    //construktor
    public Runner(double distance) {
        nRunners++;
        this.number = nRunners;
        this.distance = distance;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getStartTime() {
        //LocalTime je konstatní objekt, a tak není třeba defenzivní kopie
        return startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setStartTime(int HH, int MM, int SS) {
        this.startTime = LocalTime.of(HH, MM, SS);
    }

    public void setStartTime(String time, DateTimeFormatter dtf) { //HH:MM:SS
        this.startTime = LocalTime.parse(time, dtf);
    }

    public void setFinishTime(int HH, int mm, int ss) {
        this.finishTime = LocalTime.of(HH, mm, ss);
    }

    public void setFinishTime(String time, DateTimeFormatter dtf) { //HH:MM:SS
        this.finishTime = LocalTime.parse(time, dtf);
    }

    public LocalTime getRunningTime() {;
        return LocalTime.ofSecondOfDay(Duration.between(startTime, finishTime).getSeconds());
    }

    public double getAverageSpeed() {
        return distance / getRunningTime().toSecondOfDay() * 3600;
    }

    public LocalTime averageTime1K() {
        double time = Math.round(getRunningTime().toSecondOfDay()) / distance;
        return LocalTime.ofSecondOfDay((long) time);
    }


    public boolean underTime(int HH, int mm, int ss) {
        LocalTime time = LocalTime.of(HH, mm, ss); //;HH * 3600 + mm* 60 + ss
        return getRunningTime().toSecondOfDay() <= time.toSecondOfDay();
    }

    public boolean underTime(String time, DateTimeFormatter dtf) {
        return getRunningTime().isBefore(LocalTime.parse(time, dtf));
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("%4d %8.3f %10s %10s %10s", number, distance, startTime.format(dtf), finishTime.format(dtf), getRunningTime().format(dtf));
    }

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Runner r = new Runner(42);
        r.setStartTime(2, 4, 0);
        r.setFinishTime("03:05:10", dtf);
        System.out.println(r);
    }

}
