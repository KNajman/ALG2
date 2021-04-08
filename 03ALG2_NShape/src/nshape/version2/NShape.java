package nshape.version2;

import java.util.ArrayList;
import java.util.List;
import point.Point;

/**
 *
 * @author JV
 */
public class NShape {
    //data
    private List<Point> shape = new ArrayList<>();
    
    //constructors
    public NShape(double[][] points){
        double x, y;
        Point p;
        for (int i = 0; i < points.length; i++) {
            x = points[i][0];
            y = points[i][1];
            p = new Point(x, y);
            shape.add(p);
        }
    }
    
    public NShape(){
    }
    
    public void add(double x, double y){
        Point p = new Point(x, y);
        shape.add(p);
    }
    
    public double perim(){
        double perim = 0;
        for (int i = 0; i < shape.size() - 1; i++) {
            perim = perim + shape.get(i).calculateDistaceFrom(shape.get(i+1));
        }
        perim = perim + shape.get(shape.size()-1).calculateDistaceFrom(shape.get(0));
        return perim;
    }
    
    public double area(){
        double area = 0;
        for (int i = 0; i < shape.size() - 1; i++){
            area = area + shape.get(i).getX()*shape.get(i+1).getY() - shape.get(i+1).getX()*shape.get(i).getY();
        }
        area = area + shape.get(shape.size()-1).getX()*shape.get(0).getY() - shape.get(0).getX()*shape.get(shape.size()-1).getY();
        area = 0.5 * Math.abs(area);
        return area;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("NShape { ");
        for (Point point : shape) {
            out.append(point).append(" ");
        }
        out.deleteCharAt(out.length()-1).append(" }");

        return out.toString();
    }
}
