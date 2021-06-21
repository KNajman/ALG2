package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JV
 */
public interface BankInterface {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public void createNewAccount();

    public boolean chooseExistingAccount(int accountNumber);

    public int getActiveAccountNumber();

    public void deposit(int sum);

    public void withdraw(int sum);

    public String getStatement(Date from, Date to);

    public String getBalance(Date from, Date to);
    
    public String getStatement();

    public String getBalance();
}