package nshape.version1;

import java.util.ArrayList;
import java.util.List;
import point.Point;
import java.util.Scanner;

/**
 * Dynamické pole objektů jako statická globální proměnná
 * Test 4 0 0 2 0 2 2 0 2
 * @author JV
 */
public class NShapeAppDynamicArray {

    public static Scanner sc = new Scanner(System.in);
    private static List<Point> shape = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("Zadej pocet bodu");
        int n = sc.nextInt();
        System.out.println("Zadej souradnice");
        double x, y;
        Point p;
        for (int i = 0; i < n; i++) {
            x = sc.nextDouble();
            y = sc.nextDouble();
            p = new Point(x, y);
            shape.add(p);
        }

        System.out.format("Obvod = %.2f%n", perim());
        System.out.format("Obsah = %.2f%n", area());
    }
    
    public static double perim(){
        double perim = 0;
        for (int i = 0; i < shape.size() - 1; i++) {
            perim = perim + shape.get(i).calculateDistaceFrom(shape.get(i+1));
        }
        perim = perim + shape.get(shape.size()-1).calculateDistaceFrom(shape.get(0));
        return perim;
    }
    
    public static double area(){
        double area = 0;
        for (int i = 0; i < shape.size() - 1; i++){
            area = area + shape.get(i).getX()*shape.get(i+1).getY() - shape.get(i+1).getX()*shape.get(i).getY();
        }
        area = area + shape.get(shape.size()-1).getX()*shape.get(0).getY() - shape.get(0).getX()*shape.get(shape.size()-1).getY();
        area = 0.5 * Math.abs(area);
        return area;
    }
}
