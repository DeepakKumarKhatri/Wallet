import java.io.Serializable;

public abstract class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private String CNIC;

    public Person(){}
    public Person(String firstName, String lastName, String phone, String CNIC) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.CNIC = CNIC;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    @Override
    public String toString() {
        return "First Name = '" + firstName + '\'' +
                ",LastName = '" + lastName + '\'' +
                ",Phone = '" + phone + '\'' +
                ",CNIC = '" + CNIC + '\'' ;
    }
}
