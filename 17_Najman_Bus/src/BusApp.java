
import java.util.Scanner;

/**
 *
 * @author najma
 */
public class BusApp {

    public static void main(String[] args) {
        /*
        Vytvořte třídu BusApp.java, která bude simulovat jízdu.
        Vytvořte univerzitní autobus číslo 15, kterí patří společnosti DPMLJ a má 41 sedadel.
        Nasimulujete jeho jízdu přes 5 zastávek. Na každé zastávce:
        vypište číslo zastávky a informace o autobuse.
        zeptejte se, kolik cestujících chce vystoupit a kolik chce nastoupit.
        pokud chce vystoupit víc cestujících, než je v autobuse, nechte vystoupit všechny a vypište skutečný počet cestujících, kteří vystoupili.
        pokud chce nastoupit víc cestujících, než je volných sedadel, nechte nastoupit tolik, kolik je volných sedadel a vypište skutečný počet lidí, kteří nastoupili.
        na poslední zastávce ať vystoupí všichni.
         */
        Scanner sc = new Scanner(System.in);

        Bus mujAutobus = new Bus(41, 42, "BusLine");
        final int pocetZastavek = 5;
        for (int i = 0; i < pocetZastavek; i++) {
            System.out.println("Stanice: " + (i + 1));
            System.out.println(mujAutobus.toString());
            
            if (i == pocetZastavek - 1) {
                mujAutobus.outputCestujici();
                System.out.println("Konečná stanice.");
                System.out.println(mujAutobus.toString());
            } else {
                System.out.println("Výstup pasažérů:");
                mujAutobus.outputCestujici(sc.nextInt());
                System.out.println("Nástup pasažérů:");
                mujAutobus.inputCestujici(sc.nextInt());
                System.out.println(mujAutobus.toString());
                System.out.println("");

            }
        }
    }
}
