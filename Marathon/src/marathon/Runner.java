package marathon;

import java.time.LocalTime;

/**
 *
 * @author najma
 */
public class Runner {

    private final int number;
    private LocalTime startTime;
    private LocalTime finishTime;    
    
    private int HH;
    private int MM;
    private int SS;

    //construktor
    public Runner(int number, int HH, int MM, int SS) {
        this.number = number;
        this.HH = HH;
        this.MM = MM;
        this.SS = SS;
    }

    public int[] getRunner() {
        int[] runner = {number, HH, MM, SS};
        return runner;

    }

    public int getTimeInSeconds() {
        return 3600 * this.HH + 60 * this.MM + this.SS;
    }
    
    
    

    @Override
    public String toString() {
        return "Běžec číslo: " + number + " s cilovy casem = " + HH + ":" + MM + ":" + SS;
    }

//    public static void main(String[] args) {
//        Runner Pavel = new Runner(1001,11,16,39);
//        System.out.println(Pavel);
//    }
    public int getHH() {
        return HH;
    }

    public void setHH(int HH) {
        this.HH = HH;
    }

    public int getMM() {
        return MM;
    }

    public void setMM(int MM) {
        this.MM = MM;
    }

    public int getSS() {
        return SS;
    }

    public void setSS(int SS) {
        this.SS = SS;
    }

}
