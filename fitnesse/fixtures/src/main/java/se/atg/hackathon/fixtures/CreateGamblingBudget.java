package se.atg.hackathon.fixtures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateGamblingBudget {

    private Map<String, GamblingBudget> budgets = new HashMap<>();
    private String currentUser;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void setUser(String user) {
        if (budgets.get(user) == null) {
            budgets.put(user, new GamblingBudget());
        }
        budgets.get(user).setUser(user);
        currentUser = user;
    }

    public void setDateActivated(String dateAsString) throws ParseException {
        LocalDate date = LocalDate.parse(dateAsString);
        budgets.get(currentUser).setDateActivated(date);
    }

    public void setMonths(Integer months) {
        budgets.get(currentUser).setMonths(months);
    }

    public void setAmount(Integer amount) {
        budgets.get(currentUser).setAmount(amount);
    }

    public String PeriodEnds() {
        return budgets.get(currentUser).getPeriodEnds();
    }

    public String Result() {
        return budgets.get(currentUser).isOk() ? "Created" : "Not created";
    }

    public void setKommentar(String kommentar) {

    }
}
