package nshape.version1;

import point.Point;
import java.util.Scanner;

/**
 * Statické pole objektů jako statická globální proměnná
 * Test 4 0 0 2 0 2 2 0 2
 * @author JV
 */
public class NShapeAppStaticArray {

    public static Scanner sc = new Scanner(System.in);
    private static Point[] shape;
    
    public static void main(String[] args) {
        System.out.println("Zadej pocet bodu");
        int n = sc.nextInt();
        shape = new Point[n];
        System.out.println("Zadej souradnice");
        double x, y;
        Point p;
        for (int i = 0; i < n; i++) {
            x = sc.nextDouble();
            y = sc.nextDouble();
            p = new Point(x, y);
            shape[i] = p;
        }

        System.out.format("Obvod = %.2f%n", perim());
        System.out.format("Obsah = %.2f%n", area());
    }
    
    public static double perim(){
        double perim = 0;
        for (int i = 0; i < shape.length - 1; i++) {
            perim = perim + shape[i].calculateDistaceFrom(shape[i+1]);
        }
        perim = perim + shape[shape.length-1].calculateDistaceFrom(shape[0]);
        return perim;
    }
    
    public static double area(){
        double area = 0;
        for (int i = 0; i < shape.length - 1; i++){
            area = area + shape[i].getX()*shape[i+1].getY() - shape[i+1].getX()*shape[i].getY();
        }
        area = area + shape[shape.length-1].getX()*shape[0].getY() - shape[0].getX()*shape[shape.length-1].getY();
        area = 0.5 * Math.abs(area);
        return area;
    }
}
