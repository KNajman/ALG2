package marathon;

/**
 *
 * @author najma
 */
public class Runner {

    private final int number;
    private int HH;
    private int MM;
    private int SS;

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

    @Override
    public String toString() {
        return "Běžec číslo: " + number + " s cilovy casem = " + HH + ":" + MM + ":" + SS;
    }
    
    
//    public static void main(String[] args) {
//        Runner Pavel = new Runner(1001,11,16,39);
//        System.out.println(Pavel);
//    }

}
