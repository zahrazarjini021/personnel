package com.example.personnel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.personnel.dao.impl.PermissionToLeaveRequestDAOImpl;
import com.example.personnel.entity.AcceptanceEnum;
import com.example.personnel.entity.PermissionToLeaveRequest;
import com.example.personnel.entity.Person;

public class DisplayOffPersonnel {

    private final PermissionToLeaveRequestDAOImpl requestDAO;

    public DisplayOffPersonnel(PermissionToLeaveRequestDAOImpl permissionToLeaveRequestDAO) {
        this.requestDAO = permissionToLeaveRequestDAO;
    }

    public List<Person> listOfPersonRequestsToLeave() {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        System.out.print("How many people want to request leave? ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter info for person #" + (i + 1));

            System.out.print("First name: ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Last name: ");
            String lastName = scanner.nextLine().trim();

            System.out.print("National code: ");
            String nationalCode = scanner.nextLine().trim();

            System.out.print("Personnel code: ");
            String personnelCode = scanner.nextLine().trim();

            System.out.print("Leave start date (yyyy-mm-dd): ");
            LocalDate fromDate = LocalDate.parse(scanner.nextLine().trim());

            System.out.print("Leave end date (yyyy-mm-dd): ");
            LocalDate toDate = LocalDate.parse(scanner.nextLine().trim());

            Person person = new Person(firstName, lastName, nationalCode, personnelCode);
            PermissionToLeaveRequest request = new PermissionToLeaveRequest(person, fromDate, toDate);

            people.add(person);
            requestDAO.save(request);
        }

        System.out.println("\nPeople who have submitted leave requests:");
        for (PermissionToLeaveRequest request : requestDAO.findAll()) {
            System.out.println(request);
        }

        return people;
    }

    public void acceptOrDenyPersonnelRequests(AcceptanceEnum action) {
        List<PermissionToLeaveRequest> requests = requestDAO.findAll();

        if (requests.isEmpty()) {
            System.out.println("No leave requests found.");
            return;
        }

        for (PermissionToLeaveRequest request : requests) {
            if (action == AcceptanceEnum.ACCEPT) {
                request.setAcceptedOrRejected(true);
                System.out.println("Accepted: " + request.getPerson().getFirstName());
            } else {
                request.setAcceptedOrRejected(false);
                System.out.println("Rejected: " + request.getPerson().getFirstName());
            }
        }
    }
}