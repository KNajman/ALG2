package cmd;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author najma
 */
public class CommandLine {

    private String command;
    private File actualDir;

    public CommandLine() {
        actualDir = new File(System.getProperty("user.dir"));
    }

    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    public String parseAndExecute(String command) throws IOException {
        String[] parts = command.trim().split(" ");
        String result;
        switch (parts[0]) {
            case "help":
                result = help();
                break;
            case "dir":
                result = dir(parts);
                break;
            case "mkfile":
                result = mkfile(parts[1]);
                break; //mkfile a.txt                       
            case "mkdir":
                result = mkdir(parts[1]);
                break;
            case "mkdirs":
                result = mkdirs(parts[1]);
                break;
            case "rename":
                result = rename(parts[1], parts[2]);
                break;
            case "cd":
                if (parts.length == 1) {
                    result = cdOut();
                    break;
                } else if (parts.length == 2) {
                    result = cdIn(parts[1]);
                    break;
                } else {
                    result = "Nevalidni jmeno slozky";
                    break;
                }
            default:
                result = "Nevalidni prikaz";
        }
        return result;
    }

    /**
     * *
     * dir
     *
     * @param parts
     * @return
     */
    private String dir(String[] parts) {
        if (parts.length == 1) { //dir
            //String[] subFoldersFiles = actualDir.list();
            //return arrayToString(subFoldersFiles);
            File[] subFoldersFiles = actualDir.listFiles();
            return arrayToStringFolderFile(subFoldersFiles);
        } else {
            if (parts[1].equals("-e")) {//dir -e .txt
                String[] subFoldersFiles = actualDir.list(new ExtensionFilter(parts[2]));
                return arrayToString(subFoldersFiles);
            }
        }
        return null;
    }

    private String arrayToStringFolderFile(File[] a) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (File element : a) {
            if (element.isDirectory()) {
                sb1.append(element.getName()).append("\n");
            } else {
                sb2.append(element.getName()).append("\n");
            }
        }
        return sb1.append(sb2).toString();
    }

    private String arrayToString(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (String element : a) {
            sb.append(element).append("\n");
        }
        return sb.toString();
    }

    /**
     * *
     * mkfile
     *
     * @param filename
     * @return
     * @throws IOException
     */
    private String mkfile(String filename) throws IOException {
        //File f = new File(actualDir.getAbsoluteFile() + File.separator + filename);
        File f = new File(actualDir, filename);
        //try{
        if (f.createNewFile()) {
            return "Soubor vytvoren";
        } else {
            return "Soubor uz existuje";
        }
        //}catch(IOException e){
        //    throw new RuntimeException("Problem s IO");
        //}
    }

    public boolean isEnd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String help() {
        StringBuilder str = new StringBuilder("");
        str.append("help – vrátí víceřádkový textový řetězec s „nápovědou" + "\n");
        str.append("dir – vrátí víceřádkový textový řetězec s formátovaným výpisem aktuálního adresáře" + "\n");
        str.append("dir <adresář> – vrátí víceřádkový textový řetězec s formátovaným výpisem adresáře\n"
                + "předaného v parametru, nemění aktuální adresář" + "\n");
        str.append("cd <adresář> – změna aktuálního adresáře dle para" + "\n");
        str.append("mkfile <soubor> – vytvoří nový soubor, jehož jméno bylo zadáno v parametru" + "\n");
        str.append("mkdir <adresář> - vytvoří zadaný adresář" + "\n");
        str.append("mkdirs <cesta> – vytvoří adresáře odpovídající cestě zadané v parametru" + "\n");
        str.append("rename <jm1> <jm2> – přejmenuje soubor nebo adresář" + "\n");
        str.append("exit - ukončí program" + "\n");
        return str.toString();
    }

    private String mkdir(String part) throws IOException {
        File f = new File(actualDir, part);
        if (f.createNewFile()) {
            return "Soubor vytvořen";
        }
        return "Soubor již existuje";
    }

    private String mkdirs(String part) {
        int lastIndex = part.lastIndexOf(File.separator);
        String tocheck = part.substring(0, lastIndex);
        File d = new File(tocheck);
        if (d.isDirectory()) {
            File n = new File(part);
            if (n.mkdir()) {
                return "Složka úspěšně vytvořena.";
            } else {
                return "Složka již existuje.";
            }
        }
        return "Nevalidní cesta.";
    }

    private String rename(String jm1, String jm2) {
        File name1 = new File(jm1);
        File name2 = new File(jm2);
        if (name1.exists()) {
            if (!name2.isFile()) {
                name1.renameTo(name2);
                return "Přjmenováno.";
            } else {
                return "Soubor již existuje.";
            }
        } else {
            return "Soubor nenalezen.";
        }
    }

    private String cdIn(String dirname) {
        File d = new File(actualDir.getAbsolutePath(), dirname);
        if (d.isDirectory()) {
            actualDir = d;
            return "";
        } else {
            return "Taková složka neexistuje.";
        }
    }

    private String cdOut() {
        int chop = actualDir.getName().length() + 1;
        String actdirpath = actualDir.getAbsolutePath();
        String path = actdirpath.substring(0, actdirpath.length() - chop);
        actualDir = new File(path);
        return "";
    }

}
