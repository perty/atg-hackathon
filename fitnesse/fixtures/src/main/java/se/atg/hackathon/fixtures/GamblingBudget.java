package se.atg.hackathon.fixtures;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@SuppressWarnings("WeakerAccess")
public class GamblingBudget {
    private String user;
    private LocalDate dateActivated;
    private Integer months;
    private Integer amount;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDate changeDate;

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setDateActivated(LocalDate dateActivated) {
        this.dateActivated = dateActivated;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public void setAmount(Integer amount) {
        if(amount >= 100 && amount <= 16000) {
            this.amount = amount;
        }
    }

    public String getPeriodEnds() {
        if (isOk()) {
            LocalDate ends = getPeriodEndAsDate();
            return ends.format(formatter);
        }
        return "";
    }

    public boolean isOk() {
        return amount != null;
    }

    public void setNewAmount(LocalDate changeDate, Integer newAmount) {
        if (newAmount >= 100 && (newAmount < amount || changeDate.isAfter(getPeriodEndAsDate()))) {
            amount = newAmount;
            this.changeDate = changeDate;
        }
    }

    public Integer getAmount() {
        return amount;
    }

    public boolean isChanged() {
        return changeDate != null;
    }

    private LocalDate getPeriodEndAsDate() {
        return dateActivated.plus(months, ChronoUnit.MONTHS);
    }

}
