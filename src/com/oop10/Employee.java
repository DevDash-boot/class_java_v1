package com.oop10;

public class Employee {

    int employeeNumber;
    private String name;
    private String department;

    // 문제 상황 - 직원 객체를 생성할 때마다 자동으로 company의 시리얼 번호를 활용해서 1001
    // 직원이 생성되면 1002... 처럼 자동으로 할당할 수 있도록 코드를 완성해주세요.
    public Employee(String name, String department){
        this.name = name;
        this.department = department;
        // MainTest1.java에서 출력할 때 1001, 1002, 1003으로 값을 주는 코드
        employeeNumber = Company.empSerialNumber++;
    }
}
