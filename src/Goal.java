import java.io.Serializable;

public class Goal implements Serializable {
    private String goalName;
    private String goalDescription;
    private double targetAmount;
    private double savedAlready;
    private Date desiredDate;
    private int goalId;

    public Goal(String goalName, String goalDescription, double targetAmount, double savedAlready, Date desiredDate, int goalId) {
        this.goalName = goalName;
        this.goalDescription = goalDescription;
        this.targetAmount = targetAmount;
        this.savedAlready = savedAlready;
        this.desiredDate = desiredDate;
        this.goalId = goalId;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public double getSavedAlready() {
        return savedAlready;
    }

    public void setSavedAlready(double savedAlready) {
        this.savedAlready = savedAlready;
    }

    public Date getDesiredDate() {
        return desiredDate;
    }

    public void setDesiredDate(Date desiredDate) {
        this.desiredDate = desiredDate;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    @Override
    public String toString() {
        return "------------- GOAL ------------- \n" +
                "Goal Id = '" + goalId + '\'' +
                ",Goal Name = '" + goalName + '\'' +
                ",Goal Description = '" + goalDescription + '\'' +
                ",Target Amount = " + targetAmount +
                ",Saved Already = " + savedAlready +
                ",Desired Date = " + desiredDate+"\n";
    }
}
