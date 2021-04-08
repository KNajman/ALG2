package point;

/**
 *
 * @author JV
 */
public class PointApp {

    public static void main(String[] args) {
        System.out.println("Bod A");
        Point a = new Point();
        //System.out.println(a.x);
        System.out.println(a.getX());
        //System.out.println(a.getTextRepresentation());
        System.out.println(a); //System.out.println(a.toString());
        System.out.println();
        
        System.out.println("Bod B");
        Point b = new Point(2, 3);
        //System.out.println(b.x);
        System.out.println(b.getX());
        //System.out.println(b.getTextRepresentation());
        System.out.println(b); //println volá automaticky toString()

        //b.y = 4;
        //b.setY(7);
        //System.out.println(b);
        System.out.println("Bod B, vzdalenost od pocatku " +  b.getDistance());
        System.out.println();
        
        //vzdálenost mezi body A a B - vícero variant
        System.out.println("Vzdalenost mezi body");
        
        //pomocí instanční metody
        System.out.println(a.calculateDistaceFrom(b));
        System.out.println(b.calculateDistaceFrom(a));
        //System.out.println(a.calculateDistaceBetween(a, b)); //kdyby nebyla static
        
        //pomocí statické metody
        System.out.println(Point.calculateDistaceBetween(a, b));
        
        //z knihovní třídy
        System.out.println(PointTools.calculateDistaceBetween(a, b));
    }
    
}
