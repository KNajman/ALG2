package logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Account {

    private int number;
    private File file;
    private ArrayList<Transaction> transakce = new ArrayList<>();
    private double zustatek = 0;

    public Account(int number) throws IOException {
        file = new File(String.format("Account%d.dat", number));
        if (!file.exists()) {
            file.createNewFile();
        } else {
            try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
                Transaction t;
                while ((t = Transaction.readTransaction(in)) != null) {
                    transakce.add(t);
                }
            }
            
            zustatek = vypoctiZustatek();

        }
        this.number = number;
    }

    public boolean existAccount(int number) {
        file = new File(String.format("Account%d.dat", number));
        if (!file.exists()) {
            return false;
        } else {
            return true;
        }

    }

    void makeTransaction(int sum) throws FileNotFoundException, IOException {
        Transaction t = new Transaction(sum);
        zustatek = zustatek + sum;
        transakce.add(t);
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file, true))) { // true = zapisuj na konec
            out.writeLong(t.getDate().getTime()); //zapisu pocet milisekund 
            out.writeDouble(sum);

        }

    }

    public double getZustatek() {
        return zustatek;
    }

    public static void main(String[] agrs) throws IOException {
        Account a = new Account(11);
        a.makeTransaction(1000);
    }

    public ArrayList<Transaction> getTransakce() {
        return transakce;
    }

    public int getNumber() {
        return number;
    }

    private double vypoctiZustatek() {
        double sum = 0;
        for (Transaction t : transakce) {
            sum = sum + t.getSum();
        }
        return sum;
    }
}
