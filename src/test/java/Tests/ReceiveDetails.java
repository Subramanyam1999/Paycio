package Tests;

public class ReceiveDetails {
    public String currencyName;
    public String generatedAddress;

    public ReceiveDetails(String currencyName, String generatedAddress) {
        this.currencyName = currencyName;
        this.generatedAddress = generatedAddress;
    }

    @Override
    public String toString() {
        return "Currency: " + currencyName + " | Address: " + generatedAddress;
    }
}
