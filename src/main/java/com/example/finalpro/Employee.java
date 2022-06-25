package com.example.finalpro;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person{
    private static final long serialVersionUID = 7526472295622776147L;  // unique id
    @Setter(AccessLevel.PRIVATE)
    @Getter
    @NonNull
    private String address;
    private static int hourlyRate = 20;
    @Setter(AccessLevel.PRIVATE)
    @Getter
    @NonNull
    private int seniority;
    @Getter
    @Setter
    @NonNull
    private EmployeeType empType;
    private static int weekendBonus = 25;
    @Getter
    private static List<Employee> employeesList = new ArrayList<Employee>();


    public Employee(String firstName, String lastName, LocalDate birthDate, String address, int seniority) {
        super(firstName, lastName, birthDate);
        setAddress(address);
        setSeniority(seniority);
        employeesList.add(this);
        setEmpType(EmployeeType.EMPLOYEE);
    }



    public int calculateSalary(int hoursNormal, int hoursWeekend){
        return hoursNormal*hourlyRate+hoursWeekend*weekendBonus;
    }
}
