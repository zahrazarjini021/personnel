package com.example.personnel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.personnel.dao.impl.PermissionToLeaveRequestDAOImpl;
import com.example.personnel.entity.AcceptanceEnum;
import com.example.personnel.entity.PermissionToLeaveRequest;
import com.example.personnel.entity.Person;

public class DisplayOffPersonnel {


    private final PermissionToLeaveRequestDAOImpl requestDAO = new PermissionToLeaveRequestDAOImpl();

    public DisplayOffPersonnel(PermissionToLeaveRequestDAOImpl permissionToLeaveRequestDAO) {
    }

    public List<Person> listOfPersonRequestsToLeave() {
        List<Person> people = new ArrayList<>();

        Person person1 = new Person("zahra", "zarjini", "1234567890", "11111");
        Person person2 = new Person("mobina", "zahdi", "0987654321", "121212");

        people.add(person1);
        people.add(person2);

        PermissionToLeaveRequest request1 = new PermissionToLeaveRequest(person1,
                LocalDate.of(2025, 5, 1),
                LocalDate.of(2025, 5, 3));

        PermissionToLeaveRequest request2 = new PermissionToLeaveRequest(person2,
                LocalDate.of(2025, 5, 1),
                LocalDate.of(2025, 5, 3));

        requestDAO.save(request1);
        requestDAO.save(request2);

        System.out.println("all personnel:");
        for (Person p : people) {
            System.out.println(p);
        }

        System.out.println("\npersonnel who request to leave:");
        for (PermissionToLeaveRequest leaveRequest : requestDAO.findAll()) {
            System.out.println(leaveRequest);
        }

        return people;
    }

    /*
    update
     */

    public void acceptOrDenyPersonnelRequests(AcceptanceEnum action) {
        System.out.println("\nPROCESSING REQUESTS...");

        for (PermissionToLeaveRequest request : requestDAO.findAll()) {

            if (action == AcceptanceEnum.ACCEPT) {
                request.setAcceptedOrRejected(true);
                System.out.println("LEAVING REQUEST ACCEPTED");
            }
            else if (action == AcceptanceEnum.REJECT) {
                request.setAcceptedOrRejected(false);
                System.out.println("LEAVING REQUEST REJECTED");
            }
        }
    }

}
