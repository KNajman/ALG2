import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
public class Main {
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
        System.out.print("File name with starting data: ");
        String start = scan.next();
        System.out.print("File name with finish data: " );
        String finish = scan.next();
        Competition zavod = new Competition(start,finish);
        File file= new File(start+".txt");
        Scanner sc = new Scanner(file);
        zavod.load();
        System.out.println(zavod.display());       
        zavod.sort();
        System.out.println(zavod.display());
        System.out.print("File name for saving results: ");
        String name = Main.scan.next();
        zavod.saveFinalFile(name);
    }
}
