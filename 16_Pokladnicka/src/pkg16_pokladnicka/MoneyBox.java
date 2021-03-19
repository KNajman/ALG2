/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg16_pokladnicka;

/**
 *
 * @author najma
 */
public class MoneyBox {

    private String owner;
    private int oneCoin;
    private int twoCoin;

    //    vytvořit pojmenovanou (někomu patří) prázdnou pokladničku.
    public MoneyBox(String owner) {
        this.owner = owner;
    }

    //vytvořit pojmenovanou (někomu patří) pokladničku se zadanou vstupní sumou jako počet korun a dvoukorun.
    public MoneyBox(String owner, int oneCoin, int twoCoin) {
        this.owner = owner;
        this.oneCoin = oneCoin;
        this.twoCoin = twoCoin;

    }

    //změnit (nastavit) pojmenování (majitele) pokladničky
    public void setNewOwner(String owner) {
        this.owner = owner;
    }

//zjistit (vrátit) sumu mincí v pokladničce
    public int getSum() {
        return oneCoin + 2 * twoCoin;
    }

//vložit korunu do pokladničky
    public void plusOneCoin() {
        this.oneCoin++;
    }

//vložit dvoukorunu do pokladničky    
    public void plusTwoCoin() {
        this.twoCoin++;
    }

//vložit mince do pokladničky jako počet korun a dvoukorun
// 0 3 (nula korun, tři dvoukoruny)
    public void plusCoins(int oneCoins, int twoCoins) {
        this.oneCoin += oneCoins;
        this.twoCoin += twoCoins;
    }

    /**
     *
     * @param sum
     */
    public void plusCoins(int sum) {
        if (sum > 1) {
            while (sum > 1) {
                sum = sum / 2;
                this.twoCoin++;
            }
            this.oneCoin++;
        } else {
            throw new IllegalArgumentException("Neplatna castka");

        }
    }

//vrátit info o pokladničce ve tvaru “Janka má v pokladničce 13Kč - 3x1Kč, 5x2Kč.”
    @Override
    public String toString() {
        return this.owner + " má v pokladničce " + this.getSum() + "Kč - " + this.oneCoin + "x1Kč, " + this.twoCoin + "x2Kč.";
    }

//zjistit, jestli je v pokladničce dost peněz na nákup zadaného dárku.
    public boolean purchase(int presentPrice) {
        if (this.getSum() < presentPrice) {
            return false;
        }
        return true;
    }
}
