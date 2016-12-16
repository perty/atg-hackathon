package se.atg.hackathon.fixtures;

import java.util.HashMap;
import java.util.Map;

public class CurrentPool {

    static Map<Integer, Long> bets = new HashMap<>();
    private Integer lastHorse;

    public void setHorse(Integer horse) {
        bets.put(horse, 0L);
        lastHorse = horse;
    }

    public void setCurrentBetting(Long amount) {
        bets.put(lastHorse, amount);
    }

    public static Long getTotalBets() {
        return bets.entrySet().stream().mapToLong(Map.Entry::getValue).sum();
    }
}
