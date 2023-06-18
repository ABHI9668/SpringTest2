import org.springframework.beans.factory.annotation.Autowired;

public class Person {

    private String name;
    private Address address; // Dependency on Address

    // Constructor
    @Autowired
    public Person(Address address) {
        this.name = "John Doe";
        this.address = address;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
