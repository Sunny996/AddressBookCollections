package main;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Person> contact ;
    Scanner sc = new Scanner(System.in);

    public AddressBook(){
        contact= new ArrayList<>();
    }
    public void userOperations(AddressBook addBook) {
        System.out.println("Please select the operation to be performed");
        System.out.println("1.Add contact\n2.Edit contact\n3.Delete contact\n4.Print All Contacts\n5.Exit");
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
            case 1:
                addBook.addNewContacts();
                break;
            case 2:
                addBook.editContacts();
                break;
            case 3:
                addBook.deleteContact();
                break;
            case 4:
                addBook.printAllContacts();
                break;
            case 5:
                break;
        }
    }
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
        for (Person person : contact) {
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName))
                currentContact = person;
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

    public void deleteContact() {
        System.out.println("Please enter the first name of contact to be deleted");
        String firstName = sc.nextLine();
        System.out.println("Please enter the last name of contact to be deleted");
        String lastName = sc.nextLine();
        for (Person person : contact) {
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)){
                contact.remove(person);
                System.out.println("The contact " + firstName + " " + lastName + " has been deleted successfully");
            }
            else
                System.out.println("No such contact exists");

        }
    }
    public void printAllContacts(){
        for(Person person: contact)
            System.out.println(person);
    }
}
