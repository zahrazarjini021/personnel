
package com.example.personnel;

import com.example.personnel.dao.impl.PermissionToLeaveRequestDAOImpl;
import com.example.personnel.entity.AcceptanceEnum;
import com.example.personnel.service.DisplayOffPersonnel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        DisplayOffPersonnel service = new DisplayOffPersonnel(new PermissionToLeaveRequestDAOImpl());

        boolean running = true;

        while (running) {
            System.out.println("\n*=*=*=*=*=* MAIN MENU *=*=*=*=*=*");
            System.out.println("1. Submit Leave Requests");
            System.out.println("2. Accept or Reject Leave Requests");
            System.out.println("3. Exit");
            System.out.print("CHOOSE YOUR OPTION: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    service.listOfPersonRequestsToLeave();
                    break;

                case "2":
                    System.out.println("Do you want to accept or reject the requests?");
                    System.out.println("Enter 1 for ACCEPT, 2 for REJECT:");
                    String input = scanner.nextLine().trim();

                    AcceptanceEnum action = null;

                    if (input.equals("1")) {
                        action = AcceptanceEnum.ACCEPT;
                    } else if (input.equals("2")) {
                        action = AcceptanceEnum.REJECT;
                    } else {
                        System.out.println("Invalid input! Try again.");
                        break;
                    }

                    service.acceptOrDenyPersonnelRequests(action);
                    break;

                case "3":
                    System.out.println("Exiting... See you soon!");
                    running = false;
                    break;

                default:
                    System.out.println("Please enter a valid choice (1, 2, or 3).");
            }
        }
    }
}