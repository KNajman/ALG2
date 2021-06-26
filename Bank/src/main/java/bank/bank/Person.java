package bank.bank;

/**
 *
 * @author najma
 */
public class Person extends Client {

    public Person(String name) {
        super(name);
    }

    @Override
    public String addressClient() {
        boolean ova = super.getName().endsWith("ova");
        return (ova) ? "Pani " : "Pan " + super.getName();
    }

}
