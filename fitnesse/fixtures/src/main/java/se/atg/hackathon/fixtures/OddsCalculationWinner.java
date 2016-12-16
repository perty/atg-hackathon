package se.atg.hackathon.fixtures;

public class OddsCalculationWinner {

    private Integer lastHorse;

    public void setHorse(Integer horse) {
        lastHorse = horse;
    }

    public String Odds() {
        Double bettedAmount = CurrentPool.bets.get(lastHorse).doubleValue();
        Double totalBets = CurrentPool.getTotalBets().doubleValue() * (1 - 0.1425);
        return String.format("%3.2f", totalBets / bettedAmount);
    }
}
