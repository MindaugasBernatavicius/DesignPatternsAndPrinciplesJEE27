package cf.mindaugas._01_solid;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class _01_SRP {
    public static void main(String[] args) {

    }
}

class Employee {
    private String id;
    private String name;
    private String address;
    private Date startTime;

    //Getters & Setters
    public Date getStartTime() {
        return startTime;
    }

    // ... can an employee know about his promotion eligibility?
    // ... some would say, that promotion logic should be separate
    // ... from Employee class b/c it is not a property of Employee
    // ... so in the next example, lets move this to another class:
    // ... PromotionCalculator class
    public boolean isPromotionDueThisYear() {
        var currentDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        var startDate = startTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return startDate.getYear() > currentDate.getYear();
    }
}

class ContractEmployee extends Employee {}

class PromotionCalculator {
    public boolean isPromotionDueThisYear(Employee e) {
        LocalDate currentDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startDate = e.getStartTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return startDate.getYear() + 1 > currentDate.getYear();
    }
}
