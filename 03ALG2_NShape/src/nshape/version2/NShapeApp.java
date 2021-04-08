package nshape.version2;

import java.util.Scanner;

/**
 * 
 * Test 4 0 0 2 0 2 2 0 2
 * @author JV
 */
public class NShapeApp {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        NShape shape = new NShape();
        System.out.println("Zadej pocet bodu");
        int n = sc.nextInt();
        double x, y;
        System.out.println("Zadej souradnice");
        for (int i = 0; i < n; i++) {
            x = sc.nextDouble();
            y = sc.nextDouble();
            shape.add(x, y);
        }
        
        System.out.println(shape);
        System.out.format("Obvod = %.2f%n",shape.perim());
        System.out.format("Obsah = %.2f%n",shape.area());
    }
    
}
