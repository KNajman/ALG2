package interfacevariant;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janvit
 */
public class Main {

    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceD(8);
        Rectangle r1 = new Rectangle(2, 3);
        Circle c2 = Circle.getInstanceR(2.6);
        
        System.out.println("3. varianta");
        List<ShapeInterface> shapes3 = new ArrayList<>(); //dynamicke pole objektů, ktere implementuji ShapeInterface
        //muze obsahovat cokoli, co je typove kompatibilni s ShapeInterface (Circle, Rectangle)
        //ShapeInterface s = new Rectangle(5, 6);
        //Rectangle r = new ShapeInterface(); //nejde ani priradit, ani vytvorit objekt
        shapes3.add(c1);
        shapes3.add(r1);
        shapes3.add(Circle.getInstanceR(2.6));
        
        double allArea3 = 0;
        for (ShapeInterface shape : shapes3) { //foreach
            allArea3 += shape.computeArea(); //polymorfism
        }
        System.out.println(allArea3);
    }
    
}
