import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Runner {
    private static SimpleDateFormat sdfStart = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat sdfFinish = new SimpleDateFormat("HH:mm:ss:SSS");
    private String name;
    private String surname;
    private int number;
    private Date startTime;
    private Date finishTime;
    
    public Runner(String name, String surname, int number){
        this.name = name;
        this.surname = surname;
        this.number = number;
    }
    
        public static Runner readRunnerFromStartFile(Scanner startFile) throws ParseException{
        Runner r;
        if(startFile.hasNext()){
            r=new Runner(startFile.next(), startFile.next(), startFile.nextInt());
            r.setStartTime(startFile.next());            
            return r;
        }
        return null;
    }  
         
    public static Runner readRunnerFromFinishFile(BufferedReader finishFile) throws ParseException, IOException{
        String row;
        Runner r;
        if((row = finishFile.readLine()) != null){
            String [] rowElements = row.trim().split("[ ]+");
            r = new Runner (" ", " ", Integer.parseInt(rowElements[0]));
            r.setFinishTime(rowElements[1]);
            return r;
        }
        return null;
    }
    
    private Runner(String name, String surname, int number, String startTime,String finishTime) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.startTime=sdfStart.parse(startTime);
        this.finishTime=sdfFinish.parse(finishTime);
    }
    
    public Date runningTime(){
        long runningTimeMS;
        Date runningTime=new Date();
        runningTimeMS=finishTime.getTime()-startTime.getTime()-3600000;
        runningTime.setTime(runningTimeMS);
        return runningTime;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getNumber() {
        return number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public static SimpleDateFormat getSdfStart() {
        return sdfStart;
    }

    public static SimpleDateFormat getSdfFinish() {
        return sdfFinish;
    }

    public static void setSdfStart(SimpleDateFormat sdfStart) {
        Runner.sdfStart = sdfStart;
    }

    public static void setSdfFinish(SimpleDateFormat sdfFinish) {
        Runner.sdfFinish = sdfFinish;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStartTime(String startTime) throws ParseException {
        this.startTime = sdfStart.parse(startTime);
    }

    public void setFinishTime(String finishTime) throws ParseException {
        this.finishTime = sdfStart.parse(finishTime);
    }
        
    @Override
    public String toString(){
        return "Runner number: " + number + " " + surname + " " + name + ", start: " + sdfStart.format(startTime) + ", finish: " + sdfFinish.format(finishTime) + ", time: " + sdfFinish.format(this.runningTime());
    }
}