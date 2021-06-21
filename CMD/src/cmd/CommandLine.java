package cmd;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author JV
 */
public class CommandLine {
    private String command;
    private File actualDir;
    
    public CommandLine(){
        actualDir = new File(System.getProperty("user.dir"));
    }
    
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    public String parseAndExecute(String command) throws IOException  {
        String[] parts = command.trim().split(" ");
        String result;
        switch(parts[0]){
            case "mkfile": result = mkfile(parts[1]); break; //mkfile a.txt
            case "dir": result = dir(parts); break;
            default:
                result = "Nevalidni prikaz";
        }
        return result;
    }
    
    private String dir(String[] parts){
        if(parts.length == 1){ //dir
            //String[] subFoldersFiles = actualDir.list();
            //return arrayToString(subFoldersFiles);
            File[] subFoldersFiles = actualDir.listFiles();
            return arrayToStringFolderFile(subFoldersFiles);
        } else {
            if(parts[1].equals("-e")){//dir -e .txt
                String[] subFoldersFiles = actualDir.list(new ExtensionFilter(parts[2]));
                return arrayToString(subFoldersFiles);
            }
        }
        return null;
    } 

    private String arrayToStringFolderFile(File[] a){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (File element : a) {
            if(element.isDirectory()){
                sb1.append(element.getName()).append("\n");
            }else{
                sb2.append(element.getName()).append("\n");
            } 
        }
        return sb1.append(sb2).toString();
    }
    
    private String arrayToString(String[] a){
        StringBuilder sb = new StringBuilder();
        for (String element : a) {
            sb.append(element).append("\n");
        }
        return sb.toString();
    }
    
    private String mkfile(String filename) throws IOException    {
        //File f = new File(actualDir.getAbsoluteFile() + File.separator + filename);
        File f = new File(actualDir, filename);
        //try{
            if(f.createNewFile()){
                return "Soubor vytvoren";
            } else{
                return "Soubor uz existuje";
            }
        //}catch(IOException e){
        //    throw new RuntimeException("Problem s IO");
        //}
    }
    
    public boolean isEnd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
