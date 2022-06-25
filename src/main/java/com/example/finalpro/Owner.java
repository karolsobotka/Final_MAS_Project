package com.example.finalpro;

import java.time.LocalDate;

public class Owner extends Person {
    private static final long serialVersionUID = 7526472295622776147L;  // unique id


    public Owner(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    public void hireEmployee(String firstName, String lastName, LocalDate birthDate, String address, int seniority){
        Employee e = new Employee(firstName, lastName, birthDate,address, seniority );

    }
    public void fireEmployee(Employee e){
        for (Employee emp: Employee.getEmployeesList()) {
            if(emp == e){
                Employee.getEmployeesList().remove(emp);
            }
        }
    }
    public void promoteEmployee(Employee e){
        e.setEmpType(EmployeeType.MANAGER);
    }

}
