package se.atg.hackathon.fixtures;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ChangeGamblingBudget {

    private Map<String, GamblingBudget> budgets = new HashMap<>();
    private String currentUser;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDate changeDate;

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

    public void setChangeDate(String dateAsString) throws ParseException {
        changeDate = LocalDate.parse(dateAsString);
    }

    public void setNewAmount(Integer newAmount) {
        budgets.get(currentUser).setNewAmount(changeDate, newAmount);
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

    public String BudgetChanged() {
        return budgets.get(currentUser).isChanged() ? "Changed" : "Not changed";
    }

    public void setKommentar(String kommentar) {

    }
}
