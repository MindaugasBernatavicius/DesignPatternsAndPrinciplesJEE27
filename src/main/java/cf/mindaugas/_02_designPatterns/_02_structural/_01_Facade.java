package cf.mindaugas._02_designPatterns._02_structural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class _01_Facade {
    public static void main(String[] args) throws IOException {
        // There are multiple examples in JAVA itself, that uses FACADES
        // ... URL hides a lot behind it, but we just interact with a nice facade ...
        URL url = new URL("https", "www.delfi.lt", 443, "/");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
    }
}

class Address {
    private String city;
    private String street;
}

class CustomerFacade {
    private AddressDAO addressDAO;
    // private CustomerDAO customerDAO;
    // private PhoneNumberDAO phoneNumberDAO;
    //
    // public Customer getCustomerWithAllData() {};
}

class AddressDAO { // Facade that hides complexity fo interacting with JDBC (this is not an ideal facade)
    public List<Address> getAll() {
        return new ArrayList<Address>();
    }

    public Address getById(Long id) {
        return new Address();
    }
}