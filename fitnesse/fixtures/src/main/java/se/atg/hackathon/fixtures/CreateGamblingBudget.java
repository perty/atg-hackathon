package se.atg.hackathon.fixtures;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class CreateGamblingBudget {

    private Map<String, GamblingBudget> budgets = new HashMap<>();
    private String currentUser;

    public void setUser(String user) {
        budgets.putIfAbsent(user, new GamblingBudget());
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

    public void setComment(String comment) {
        // Method is empty since it is only a comment.
    }
}
