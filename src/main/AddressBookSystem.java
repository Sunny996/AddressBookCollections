package main;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookSystem {
    ArrayList<Person> contact = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addNewContacts() {
        System.out.println("Enter the contact details:");
        System.out.println("Enter first name:");
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();
        System.out.println("Enter city");
        String city = sc.nextLine();
        System.out.println("Enter state");
        String state = sc.nextLine();
        System.out.println("Enter Zip");
        int zip = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Phone");
        long phoneNumber = Long.parseLong(sc.nextLine());
        System.out.println("Enter email");
        String email = sc.nextLine();
        System.out.println("Enter address");
        String address = sc.nextLine();

        contact.add(new Person(firstName, lastName, city, state, zip, phoneNumber, email, address));
        System.out.println("The contact " + firstName + " " + lastName + " has been added successfully");
    }
}
