
package com.example.personnel;

import com.example.personnel.dao.impl.PermissionToLeaveRequestDAOImpl;
import com.example.personnel.entity.AcceptanceEnum;
import com.example.personnel.service.DisplayOffPersonnel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DisplayOffPersonnel service = new DisplayOffPersonnel(new PermissionToLeaveRequestDAOImpl());

        while (true) {
            System.out.println("\n*=*=*=*=*=* MAIN *=*=*=*=*=*");
            System.out.println("SHOW PERSON WHO SEND REQUESTS TO LEAVE");
            System.out.println("ACCEPT OR REJECT THE REQUESTS");
            System.out.println("EXIT");
            System.out.print("CHOOSE YOUR OPTION: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    service.listOfPersonRequestsToLeave();
                    break;

                case "2":
                    String input = scanner.nextLine().trim();

                    AcceptanceEnum action = null;

                    if (input.equals("1")) {
                        action = AcceptanceEnum.ACCEPT;
                    }
                    else if (input.equals("2")) {
                        action = AcceptanceEnum.REJECT;
                    }
                    else {
                        System.out.println("not valid!!!!!");
                        break;
                    }

                    service.acceptOrDenyPersonnelRequests(action);
                    break;
                case "3":
                    System.out.println("EXIT\nSEE YOU SOON");
                    scanner.close();
                    return;

                default:
                    System.out.println("ENTER A VALID CHOICE");
            }
        }
    }
}