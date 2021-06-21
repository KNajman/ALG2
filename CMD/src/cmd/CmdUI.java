package cmd;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author JV
 */
public class CmdUI {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)   {
        CommandLine cmd = new CommandLine();
        String command;
        boolean end = false;
            do{
                System.out.print(cmd.getActualDir() + ">");
                command = sc.nextLine();
                try{
                    System.out.println(cmd.parseAndExecute(command));
                
                    end = cmd.isEnd();
                }catch(UnsupportedOperationException e){
                    System.out.println(e.getMessage());
                }catch(IOException e){
                    System.out.println("Problem se souborem");
                }   
            } while (!end);
    }
}
