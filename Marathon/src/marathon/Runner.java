package marathon;

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
    public Runner(int distance) {
        nRunners++;
        this.number = nRunners;
        this.distance=distance;
    }


    @Override
    public String toString() {
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("HH-mm-ss");
        return String.format("%4d %8.3f %10s %10s", number, distance, startTime.format(dtf), finishTime.format(dtf));
    }

//    public static void main(String[] args) {
//        Runner Pavel = new Runner(1001,11,16,39);
//        System.out.println(Pavel);
//    }
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

    public void setFinishTime(int HH, int MM, int SS) {
        this.finishTime = LocalTime.of(HH, MM, SS);
    }

    public void setFinishTime(String time, DateTimeFormatter dtf) { //HH:MM:SS
        this.finishTime = LocalTime.parse(time, dtf);
    }
    
    public static void main(String[] args) {
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("HH:mm:ss");
        Runner r = new Runner(42);
        r.setStartTime(2, 4, 0 );
        r.setFinishTime("03:05:10", dtf);
        System.out.println(r);
    }

}
