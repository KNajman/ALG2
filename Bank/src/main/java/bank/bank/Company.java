
package bank.bank;

/**
 *
 * @author najma
 */
public class Company extends Client {

    public Company(String name) {
        super(name);
    }

    @Override
    public String addressClient() {
        return "Firma: "+ super.getName();
    }

}
