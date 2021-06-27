package moneybox;

/**
 *
 * @author najma
 */

//new datatype mutable
public class MoneyBox {
    //data
    private String owner;
    private int nOnes;
    private int nTwos;
    
    public static final int ONE = 1;
    public static final int TWO = 2;

    //constructor
    public MoneyBox(String owner) {
        this.owner = owner;
        this.nOnes = 0;
        this.nTwos = 0;
    }
    
    //overloaded constructor
    public MoneyBox(String owner, int nOnes, int nTwos) {
        this.owner = owner;
        this.nOnes = nOnes;
        this.nTwos = nTwos;
    }
    
    public void addCrowns(int nOnes, int nTwos) {
        this.nOnes += nOnes;
        addCrownTwo(nTwos); //reuse another method
    }
    
    public void addCrownOne() {
        nOnes++;
    }
    
    public void addCrownTwo(int count) {
        nTwos += count;
    }
    
    public int sum(){
        int sum = nOnes * ONE + nTwos * TWO;
        return sum;
    }
    
    public boolean canBuy(int price){
        int sum = sum();
        return sum >= price;
    }
    
    //setter
    public void setOwner(String owner){
        this.owner = owner;
    }
    
    //getter
    public String getOwner() {
        return owner;
    }

    public int getnOnes() {
        return nOnes;
    }

    public int getnTwos() {
        return nTwos;
    }
    
    @Override
    public String toString() {
        String s = owner + " ma " + sum() + "Kc - ";
        s = s + nOnes + "x1Kc "+ nTwos + "x2Kc ";
        return s;
    }
    
    public int withdrawAll(){
        int sum = sum();
        nOnes = 0;
        nTwos = 0;
        return sum();
    }
}
