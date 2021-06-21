import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Competition {
    private ArrayList<Runner> runners;
    private String startFile;
    private String finishFile;
    
    public Competition(String sf, String ff){
        this.startFile=sf+".txt";
        this.finishFile=ff+".txt";
        runners=new ArrayList<Runner>();
    }
    
    public ArrayList<Runner> getRunners(){
        return this.runners;
    }
    
    public void load() throws FileNotFoundException, ParseException, IOException{
        loadFromStartFile();
        loadFromFinishFile();               
    }
        
    private void loadFromStartFile() throws FileNotFoundException, ParseException {
        File file= new File(startFile);
        Scanner scan = new Scanner(file);
        while(scan.hasNext()){          
            runners.add(Runner.readRunnerFromStartFile(scan));
        }
        scan.close(); 
    }

    private void loadFromFinishFile() throws FileNotFoundException, ParseException, IOException {
        BufferedReader inFile = null;
        try {
            inFile = new BufferedReader(new FileReader(finishFile));
            Runner r;
            int id;
            String finTime;
            String row;            
            while((row = inFile.readLine())!=null){
                String[] rowElements = row.trim().split("[ ]+");
                id=Integer.parseInt(rowElements[0]);
                finTime = rowElements[1];
                for(Runner runner:runners){
                    if((runner.getNumber())==id){
                        runner.setFinishTime(finTime);
                    }
                }
            }            
        } finally {
            if (inFile != null) {
                inFile.close();
            }
        }  
    }
    
    public void sort(){
        boolean sort = false;
        Runner r;
        System.out.println("Sorted list of runners");
        while(!sort){
            sort = true;  
            for(int i=0;i<runners.size()-1;i++){
                if((runners.get(i).runningTime().getTime())>(runners.get(i+1).runningTime().getTime())){
                    r=runners.get(i);
                    runners.set(i, runners.get(i+1));
                    runners.set(i+1,r);
                    sort=false;
                }
            }                    
        }       
    }
    
    public String display(){
        String s="";
        for(Runner runner : runners){            
            s+=runner.toString()+"\n";
        }
        return s;
    }
    
    public void saveFinalFile(String name){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name+".txt"))){
            int num = 1;
            for(Runner runner : runners){            
                bw.write(num+"."+runner.toString()+"\n");
                bw.newLine();    
                num++;
            }
        }
       catch (Exception e){
            System.out.println("File write failed.");
        }
   } 
}
