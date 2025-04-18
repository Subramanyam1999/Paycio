package UtilityMethods;

public class ReceiveDetails {
    private String currencyName;
    private String address;
    private String screenshotPath;

    public ReceiveDetails(String currencyName, String address, String screenshotPath) {
        this.currencyName = currencyName;
        this.address = address;
        this.screenshotPath = screenshotPath;
    }

    @Override
    public String toString() {
        return "🔹 <b>Currency:</b> " + currencyName +
                " | <b>Address:</b> " + address +
                " | 📸 <b>Screenshot:</b> <a href='file:///" + screenshotPath + "' target='_blank'>View</a>";
    }
}
