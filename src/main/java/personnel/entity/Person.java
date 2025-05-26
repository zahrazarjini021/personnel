
package personnel.entity;


import java.util.UUID;

public class Person {

    private Integer personId;
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

    public Person() {
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + personnelCode;
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public Integer getPersonId() {
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
