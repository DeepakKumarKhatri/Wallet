import java.io.Serializable;

public class ShoppingList implements Serializable {
    private String listName;
    private String product1;
    private double product1Price;
    private String product2;
    private double product2Price;
    private String product3;
    private double product3Price;
    private int listId;

    public ShoppingList(){}

    public ShoppingList(String listName, String product1, double product1Price, String product2, double product2Price, String product3, double product3Price, int listId) {
        this.listName = listName;
        this.product1 = product1;
        this.product1Price = product1Price;
        this.product2 = product2;
        this.product2Price = product2Price;
        this.product3 = product3;
        this.product3Price = product3Price;
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getProduct1() {
        return product1;
    }

    public void setProduct1(String product1) {
        this.product1 = product1;
    }

    public double getProduct1Price() {
        return product1Price;
    }

    public void setProduct1Price(double product1Price) {
        this.product1Price = product1Price;
    }

    public String getProduct2() {
        return product2;
    }

    public void setProduct2(String product2) {
        this.product2 = product2;
    }

    public double getProduct2Price() {
        return product2Price;
    }

    public void setProduct2Price(double product2Price) {
        this.product2Price = product2Price;
    }

    public String getProduct3() {
        return product3;
    }

    public void setProduct3(String product3) {
        this.product3 = product3;
    }

    public double getProduct3Price() {
        return product3Price;
    }

    public void setProduct3Price(double product3Price) {
        this.product3Price = product3Price;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    @Override
    public String toString() {
        return "------------- SHOPPING LIST -------------\n " +
                "List Id = '" + listId + '\'' +
                ",List Name = '" + listName + '\'' +
                ",Product 1 Name = '" + product1 + '\'' +
                ",Product 1 Price = " + product1Price +
                ",Product 2 Name = '" + product2 + '\'' +
                ",Product 2 Price = " + product2Price +
                ",Product 3 Name = '" + product3 + '\'' +
                ",Product 3 Price = " + product3Price+"\n\n";
    }
}
