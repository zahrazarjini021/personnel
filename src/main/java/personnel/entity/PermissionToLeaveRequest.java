
package personnel.entity;

import java.time.LocalDate;

public class PermissionToLeaveRequest {
    private Person person;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Boolean acceptedOrRejected;


    public PermissionToLeaveRequest(Person person, LocalDate fromDate, LocalDate toDate) {
        this.person = person;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.acceptedOrRejected = false;
    }

    public PermissionToLeaveRequest() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Boolean getAcceptedOrRejected() {
        return acceptedOrRejected;
    }

    public void setAcceptedOrRejected(Boolean acceptedOrRejected) {
        this.acceptedOrRejected = acceptedOrRejected;
    }

    @Override
    public String toString() {
        return person.toString() + " From " + fromDate + " To " + toDate;
    }
}
