
/**
 *
 * @author najma
 */
public class Bus {

    private final int capacity;
    private int lineNumber = 0;
    private String company = "";
    private int nPassengers = 0;

//vytvořit autobus se zadaným počtem sedadel, číslem linky a názvem společnosti.
    public Bus(int pocetSedadel, int cisloLinky, String nazevSpolecnosti) {
        this.capacity = pocetSedadel;
        this.lineNumber = cisloLinky;
        this.company = nazevSpolecnosti;
    }

    /*vytvořit nový autobus, který ještě nemá číslo linky ani ho zatím 
    neprovozuje žádná společnost. Defaultní počet sedadel je 40.*/
    public Bus() {
        this.capacity = 40;
    }

    /*zjistit číslo linky, název společnosti, která autobus provozuje,
    počet sedadel a aktuální počet cestujících.*/
    public int getPocetSedadel() {
        return capacity;
    }

    public int getCisloLinky() {
        return lineNumber;
    }

    public String getNazevSpolecnosti() {
        return company;
    }

    /*změnit číslo linky a název společnosti. */
    public void setCisloLinky(int cisloLinky) {
        this.lineNumber = cisloLinky;
    }

    public void setNazevSpolecnosti(String nazevSpolecnosti) {
        this.company = nazevSpolecnosti;
    }

    /*vrátit info o autobusu ve formátu
    "Autobus číslo 3 společnosti Arriva s počtem sedadel 42 veze 10 cestujicich.”*/
    @Override
    public String toString() {
        return "Autobus číslo " + lineNumber + " společnosti " + company
                + " s počtem sedadel " + capacity + " veze " + nPassengers;
    }

    /*nechat vystoupit zadaný počet cestujících.*/
    public void outputCestujici(int vystupujici) {
        if (this.nPassengers > vystupujici) {
            this.nPassengers =this.nPassengers - vystupujici;
        } else {
            System.out.println("Vsichni vystoupili");
            this.nPassengers = 0;
        }
    }

    /*nechat nastoupit zadaný počet cestujících.*/
    public void inputCestujici(int nastupujici) {
        int volnaMista = this.capacity - this.nPassengers;
        if (volnaMista >= nastupujici) {
            this.nPassengers = this.nPassengers + nastupujici;
        } else {
            this.nPassengers = this.capacity;
            System.out.println("Je plno. Nastoupilo " + volnaMista + " z " + nastupujici);
        }
    }

    /*nechat vystoupit všechny cestující.*/
    public void outputCestujici() {
        System.out.println("Vsichni vystoupili");
        this.nPassengers = 0;
    }

}
