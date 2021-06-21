package logic;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    public static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    private Date date;
    private double sum;
       
    public Transaction(double sum){
        this(sum, new Date());
    }
    
    public Transaction(double sum, Date date){
        this.sum = sum;
        this.date = date;
    }
    
    public double getSum(){
        return sum;
    }
    
    public Date getDate(){
        return date;
    }
    
    public static Transaction readTransaction(DataInputStream in) throws IOException{
        try{
        long l = in.readLong();
        double d = in.readDouble();
        return new Transaction(d, new Date(l));
        }catch(EOFException eof){
            return null;
        }
    }
    
    @Override
    public String toString() {
        String dateString = dateFormat.format(date);
        String sumString = String.format("%.2f", sum);
        return dateString+" "+sumString+" CZK";
    }
    
    public static void main(String[] args) {
        Transaction transactionA = new Transaction(1000);
        System.out.println(transactionA);
    }
}