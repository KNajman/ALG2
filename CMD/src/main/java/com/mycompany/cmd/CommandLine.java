/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cmd;

import java.io.File;

/**
 *
 * @author najma
 */
public class CommandLine {

    private boolean isRunning = true;
    private File actualDir;

    public CommandLine() {
        this.actualDir = new File(System.getProperty("user.dir"));
    }

    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    public String parseAndExecute(String command) {
        String[] temp = command.trim().split(" ");
        String rs = null;
        switch (temp[0]) {
            case "dir":
                rs = dir(temp);
                break;
            case "help":
                rs= help();
                break;
            case "mkdir":
                rs = mkdir(temp);
                break;
            case "mkfile":
                break;
            case "mkdirs":
                break;
            case "rename":
                break;
            case "cd":
                break;
            case "exit":
                this.isRunning = false;
                break;
            default:
                return "Nevalidni vstup";
        }
        return rs;
    }

    public boolean isRunning() {
        return isRunning;
    }

//- dir – vrátí víceřádkový textový řetězec s formátovaným výpisem aktuálního adresáře 
    private String dir(String[] commandParts) {
        String[] listcmd = null;
        if (commandParts.length == 1) {
            listcmd = this.actualDir.list();
            return ListToString(listcmd);
        }

        if (commandParts.length == 2) {
//            listcmd = this.actualDir.list(FilenameFilter) + "" + commandParts[1];
            File fAdr = new File(this.actualDir + File.pathSeparator + commandParts[1]);
            listcmd = fAdr.list();
            return ListToString(listcmd);
        }
        return null;
    }

    private String ListToString(String[] listcmd) {
        StringBuilder str = new StringBuilder("");
        for (String listcmd1 : listcmd) {
            str.append(listcmd1 + "\n");
        }
        return str.toString();
    }

    private String help() {
        StringBuilder str = new StringBuilder("");
        str.append("help – vrátí víceřádkový textový řetězec s „nápovědou"+"\n");
        str.append("dir – vrátí víceřádkový textový řetězec s formátovaným výpisem aktuálního adresáře"+"\n");
        str.append("dir <adresář> – vrátí víceřádkový textový řetězec s formátovaným výpisem adresáře\n"
                + "předaného v parametru, nemění aktuální adresář"+"\n");
        str.append("cd <adresář> – změna aktuálního adresáře dle para"+"\n");
        str.append("mkfile <soubor> – vytvoří nový soubor, jehož jméno bylo zadáno v parametru"+"\n");
        str.append("mkdir <adresář> - vytvoří zadaný adresář"+"\n");
        str.append("mkdirs <cesta> – vytvoří adresáře odpovídající cestě zadané v parametru"+"\n");
        str.append("rename <jm1> <jm2> – přejmenuje soubor nebo adresář"+"\n");
        str.append("exit - ukončí program"+"\n");

        return str.toString();
    }

    private String mkdir(String[] commandParts) {
        File f = new File(actualDir, commandParts[1]);
        f.createNewFile();
        if () {
            
        }
    }
}
