
package com.example.personnel.entity;


import java.util.UUID;

public class Person {

    private String personId;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String personnelCode;


    public Person(String firstName, String lastName, String nationalCode, String personnelCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.personnelCode = personnelCode;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + personnelCode;
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public String getPersonId() {
        return personId;
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

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        this.personnelCode = personnelCode;
    }


}
