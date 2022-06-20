import java.io.Serializable;

public class Complete_user_Information implements Serializable {
    User user;
    Budget budget;
    Debt debt;
    Goal goal;
    ShoppingList shoppingList;

    public Complete_user_Information(User user, Budget budget, Debt debt, Goal goal, ShoppingList shoppingList) {
        this.user = user;
        this.budget = budget;
        this.debt = debt;
        this.goal = goal;
        this.shoppingList = shoppingList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    @Override
    public String toString() {
        return "Complete_user_Information{" +
                "user=" + user +
                ", budget=" + budget +
                ", debt=" + debt +
                ", goal=" + goal +
                ", shoppingList=" + shoppingList +
                '}';
    }
}
