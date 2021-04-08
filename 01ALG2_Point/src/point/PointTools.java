package point;

/**
 * Library class - knihovní třída, sada statických metod
 * @author JV
 */
public final class PointTools {
    
    private PointTools(){ //není možné vytvořit objekt
        
    }
    
    public static double calculateDistaceBetween(Point a, Point b){
        return Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
    }
}
