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

    public void editContacts() {
        Person currentContact = null;
        System.out.println("Please enter the first name of contact to be edited");
        String firstName = sc.nextLine();
        System.out.println("Please enter the last name of contact to be edited");
        String lastName = sc.nextLine();
        if (contact.get(0).getFirstName().equalsIgnoreCase(firstName) && contact.get(0).getLastName().equalsIgnoreCase(lastName)) {
            currentContact = contact.get(0);
        }

        System.out.println("Select Option:\n1. First Name\n2. Last Name\n 3. City\n4. State\n5. Zip\n6. Phone\n7. Email\n8.Address");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.println("Enter new first name:");
                String newName = sc.nextLine();
                currentContact.setFirstName(newName);
                break;
            case 2:
                System.out.println("Enter new last name:");
                currentContact.setLastName(sc.nextLine());
                break;
            case 3:
                System.out.println("Enter new city");
                currentContact.setCity(sc.nextLine());
                break;
            case 4:
                System.out.println("Enter new State");
                currentContact.setState(sc.nextLine());
                break;
            case 5:
                System.out.println("Enter new Zip");
                currentContact.setZip(Integer.parseInt(sc.nextLine()));
                break;
            case 6:
                System.out.println("Enter new Phone");
                currentContact.setPhoneNumber(Long.parseLong(sc.nextLine()));
                break;
            case 7:
                System.out.println("Enter new email");
                currentContact.setEmail(sc.nextLine());
                break;
            case 8:
                System.out.println("Enter new Address");
                currentContact.setAddress(sc.nextLine());
                break;
            default:
                System.out.println("Invalid Option");
        }
    }
    public void deleteContact(){
        System.out.println("Please enter the first name of contact to be deleted");
        String firstName = sc.nextLine();
        System.out.println("Please enter the last name of contact to be deleted");
        String lastName = sc.nextLine();
        if (contact.get(0).getFirstName().equalsIgnoreCase(firstName) && contact.get(0).getLastName().equalsIgnoreCase(lastName)) {
            contact.remove(contact.get(0));
        }
        System.out.println("The contact " + firstName + " " + lastName + " has been deleted successfully");
    }

}
