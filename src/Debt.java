import java.io.Serializable;

public class Debt implements Serializable {
    private int debtId;
    private String debtType;
    private String name;
    private String description;
    private double amount;
    private Date startDate;
    private Date dueDate;

    public Debt(){}

    public Debt(int debtId, String debtType, String name, String description, double amount, Date startDate, Date dueDate) {
        this.debtId = debtId;
        this.debtType = debtType;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public int getDebtId() {
        return debtId;
    }

    public void setDebtId(int debtId) {
        this.debtId = debtId;
    }

    public String getDebtType() {
        return debtType;
    }

    public void setDebtType(String debtType) {
        this.debtType = debtType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "------------- DEBT ------------- \n" +
                "Debt Id = '" + debtId + '\'' +
                ",Debt Type = '" + debtType + '\'' +
                ",Name = '" + name + '\'' +
                ",Description = '" + description + '\'' +
                ",Amount = " + amount +
                ",Start Date => " + startDate +
                ",Due Date => " + dueDate+"\n";
    }
}
