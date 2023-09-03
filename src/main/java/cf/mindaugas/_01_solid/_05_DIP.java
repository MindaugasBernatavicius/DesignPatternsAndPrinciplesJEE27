package cf.mindaugas._01_solid;

// Prerequisite: what is a "dependency".
// ... when a class needs another class to be instantiated and work correctly

public class _05_DIP {
    public static void main(String[] args) {
        var c1 =  new Customer(
                new FullName(),
                new ShippingAddress("USA", "Los angeles", "Venice Beatch", 15)
        );
        var c2 =  new Customer(
                new FullName(),
                new Address("USA", "Los angeles", "Venice Beatch")
        );
        var c3 =  new Customer(
                new FullName(),
                new BillingAddress("USA", "Los angeles", "Venice Beatch")
        );
    }
}

// 0.
// Customer depends on ShippingAddress.
// ... dependency for the Customer class is the ShippingAddress class.
// ... b/c ShippingAddress is a concrete class we depend on a concretion
// ... so we violate Dep. Inv. Princip. Which might lead to situations
// ... where a customer does not have a shipping address and this field will be null
// class Customer {
//     private FullName fullName; // dependency
//     private ShippingAddress shippingAddress; // dependency
// }

// 1.
// ... let's make it a bit better
// ... but we still don't get the full flexibility
class Customer {
    private FullName fullName; // dependency
    private Address address; // dependency

    public Customer(FullName fullName, Address address) {
        this.fullName = fullName;
        this.address = address;
    }
}

class FullName {
    private String name;
    private String middleName;
    private String surname;
}


class Address {
    private String country;
    private String city;
    private String streetAddress;

    public Address(String country, String city, String streetAddress) {
        this.country = country;
        this.city = city;
        this.streetAddress = streetAddress;
    }
}

class ShippingAddress extends Address {
    private int flatNumber;

    public ShippingAddress(String country,
                           String city,
                           String streetAddress,
                           int flatNumber) {
        super(country, city, streetAddress);
        this.flatNumber = flatNumber;
    }
}

class BillingAddress extends Address {
    public BillingAddress(String country, String city, String streetAddress) {
        super(country, city, streetAddress);
    }
}