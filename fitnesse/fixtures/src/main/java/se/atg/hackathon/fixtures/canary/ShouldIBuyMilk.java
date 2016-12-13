package se.atg.hackathon.fixtures.canary;

@SuppressWarnings("unused")
public class ShouldIBuyMilk {
    private int dollars;
    private int pints;
    private boolean creditCard;

    public void setCashInWallet(int dollars) {
        this.dollars = dollars;
    }

    public void setPintsOfMilkRemaining(int pints) {
        this.pints = pints;
    }

    public void setCreditCard(String valid) {
        creditCard = "yes".equals(valid);
    }

    public String GoToStore() {
        return (pints == 0 && (dollars > 2 || creditCard)) ? "yes" : "no";
    }


} 