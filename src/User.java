import java.io.Serializable;
import java.util.ArrayList;

public class User extends Person implements Serializable {
    private double cashBalance;
    private String email;
    private String password;
    private  ArrayList<Budget> budget;
    private  ArrayList<Goal> goal;
    private ArrayList<ShoppingList> shoppingList;
    private ArrayList<Debt> debt;

    public User(){
        super();
        this.budget =new ArrayList<>();
        this.goal = new ArrayList<>();
        this.shoppingList = new ArrayList<>();
        this.debt = new ArrayList<>();
    }

    public User(String firstName, String lastName, String phone, String CNIC, double cashBalance, String email, String password) {
        super(firstName, lastName, phone, CNIC);
        if (cashBalance>=0){this.cashBalance = cashBalance;}
        if (email.contains("@gmail.com") || getEmail().contains("@yahoo.com") || getEmail().contains("@outlook.com")){this.email = email;}
        if (password.length()>=6){this.password = password;}
        this.budget = new ArrayList<>();
        this.goal = new ArrayList<>();
        this.shoppingList = new ArrayList<>();
        this.debt = new ArrayList<>();
    }


    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  ArrayList<Budget> getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget.add(budget);
    }

    public  ArrayList<Goal> getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal.add(goal);
    }

    public  ArrayList<ShoppingList> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList.add(shoppingList);
    }

    public ArrayList<Debt> getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt.add(debt);
    }

    @Override
    public String toString() {
        return "------------- USER ------------- \n" +
                super.toString()+
                ",CashBalance = " + cashBalance +
                ",Email = '" + email + '\'' +
                ",Password = '" + password+"\n";
    }
}
