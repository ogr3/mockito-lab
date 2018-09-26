package se.cag.labs;

public class Customer {

    private String name;
    private String customerId;

    public Customer(String name, String phone) {
        this.name = name;
        this.customerId = phone;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }
}
