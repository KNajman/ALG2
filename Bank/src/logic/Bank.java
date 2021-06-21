package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.BankInterface;

public class Bank implements BankInterface {

    private Account activeAccount = null;
    private static ArrayList<Transaction> transakceUctu = new ArrayList<>();
    private BufferedWriter writer;
    private BufferedReader reader;

    @Override
    public void createNewAccount() {

        try {
            reader = new BufferedReader(new FileReader(new File("Number")));
            int number = Integer.parseInt(reader.readLine());
            activeAccount = new Account(number);
            number++;
            writer = new BufferedWriter(new FileWriter(new File("Number")));
            writer.write(String.valueOf(number));
            writer.flush();
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean chooseExistingAccount(int accountNumber) {
        try {
            reader = new BufferedReader(new FileReader(new File("Number")));
            int number = Integer.parseInt(reader.readLine());
            if (number > accountNumber) {
                activeAccount = new Account(accountNumber);
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public int getActiveAccountNumber() {
        return activeAccount.getNumber();
    }

    @Override
    public void deposit(int sum) {
        try {
            activeAccount.makeTransaction(sum);
        } catch (IOException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void withdraw(int sum) {
        if (sum <= activeAccount.getZustatek()) {
            try {
                activeAccount.makeTransaction(-sum);
            } catch (IOException ex) {
                Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Nemate dostatek penez na uctu.");
        }
    }

    @Override
    public String getStatement(Date from, Date to) {
        transakceUctu = activeAccount.getTransakce();
        long odD = from.getTime();
        long doD = to.getTime();
        StringBuilder s = new StringBuilder();

        for (Transaction t : transakceUctu) {
            long tran = t.getDate().getTime();
            if (tran > odD && tran < doD) {
                s.append(t.getDate());
                s.append(" ");
                s.append(t.getSum());
                s.append("\n");
            }
        }
        return s.toString();
    }

    @Override
    public String getBalance(Date from, Date to) {
        transakceUctu = activeAccount.getTransakce();
        long odD = from.getTime();
        long doD = to.getTime();
        double prijmy = 0;
        double vydaje = 0;
        StringBuilder s = new StringBuilder();

        s.append("zustatek: ");
        s.append(activeAccount.getZustatek());
        s.append(" prijmy: ");

        for (Transaction t : transakceUctu) {
            long tran = t.getDate().getTime();
            if (tran > odD && tran < doD) {
                if (t.getSum() > 0) {
                    prijmy = prijmy + t.getSum();
                } else {
                    vydaje = vydaje + t.getSum();
                }
            }
        }
        s.append(prijmy);
        s.append(" vydaje: ");
        s.append(vydaje);
        return s.toString();
    }

    @Override
    public String getStatement() {
        transakceUctu = activeAccount.getTransakce();
        StringBuilder s = new StringBuilder();

        for (Transaction t : transakceUctu) {
            s.append(t.getDate());
            s.append(" ");
            s.append(t.getSum());
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String getBalance() {
        transakceUctu = activeAccount.getTransakce();

        double prijmy = 0;
        double vydaje = 0;
        StringBuilder s = new StringBuilder();

        s.append("zustatek: ");
        s.append(activeAccount.getZustatek());
        s.append(" prijmy: ");

        for (Transaction t : transakceUctu) {
            if (t.getSum() > 0) {
                prijmy = prijmy + t.getSum();
            } else {
                vydaje = vydaje + t.getSum();
            }

        }
        s.append(prijmy);
        s.append(" vydaje: ");
        s.append(-vydaje);
        return s.toString();
    }
}