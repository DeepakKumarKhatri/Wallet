import java.io.Serializable;

public class Budget implements Serializable {
    private String budgetName;
    private String period;
    private double amount;
    private String currency;
    private int priority;
    private int budgetId;

    public Budget() {
    }

    public Budget(String budgetName, String period, double amount, String currency, int priority, int budgetId) {
        this.budgetName = budgetName;
        this.period = period;
        this.amount = amount;
        this.currency = currency;
        this.priority = priority;
        this.budgetId = budgetId;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    @Override
    public String toString() {
        return "------------- BUDGET -------------\n " +
                "Budget ID = '" + budgetId + '\'' +
                ",Budget Name = '" + budgetName + '\'' +
                ",Period = '" + period + '\'' +
                ",Amount = " + amount +
                ",Currency = '" + currency + '\'' +
                ",Priority = " + priority+"\n";
    }
}
