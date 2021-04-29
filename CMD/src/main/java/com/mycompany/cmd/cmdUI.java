/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cmd;

import java.util.Scanner;

/**
 *
 * @author najma
 */
public class cmdUI {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine();
        do {
            System.out.println(cmd.getActualDir() + "  >");
            String command = sc.nextLine();
            System.out.println(cmd.parseAndExecute(command));
        } while (cmd.isRunning());
    }

}
