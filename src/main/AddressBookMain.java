package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
    public static void main(String[] args) {
        HashMap<String, AddressBook> addressBooks = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook;
        String bookName = "";

        while (true) {
            System.out.println("Enter\n1.To Create New Address Book\n2.View/Edit Address Book\n3.Edit contact\n4.Delete contact" +
                    "\n5.Print All address books\n6.Search Person by City\n7.Search Person By state\n 8. Exit");
            int num = sc.nextInt();
            if (num == 1) {
                addressBook = new AddressBook();
                System.out.println("Enter New Address Book name");
                bookName = sc.next();
                addressBooks.put(bookName, addressBook);
                addressBooks.get(bookName).userOperations(addressBooks.get(bookName));
            } else if (num == 2) {
                System.out.println("Enter the name of address book to view or edit");
                bookName = sc.next();
                if (addressBooks.get(bookName) == null)
                    System.out.println("The selected address book does not exist");
                else {
                    addressBooks.get(bookName).userOperations(addressBooks.get(bookName));
                }
            } else if (num == 3) {
                boolean flag = false;
                System.out.println("Enter the first name of the contact you want to edit");
                String fName = sc.next();
                System.out.println("Enter the last name of the contact you want to edit");
                String lName = sc.next();
                for (String book : addressBooks.keySet()) {
                    for (Person person : addressBooks.get(book).contact) {
                        if (person.getFirstName().equalsIgnoreCase(fName) && person.getLastName().equalsIgnoreCase(lName)) {
                            addressBooks.get(book).editContacts(person);
                            flag = true;
                        }
                    }
                }
                if (!flag)
                    System.out.println("The contact " + fName + " " + lName + " does not exist");
            } else if (num == 4) {
                boolean flag = false;
                System.out.println("Enter the first name of the contact you want to edit");
                String fName = sc.next();
                System.out.println("Enter the last name of the contact you want to edit");
                String lName = sc.next();
                for (String book : addressBooks.keySet()) {
                    for (int i = 0; i < addressBooks.get(book).contact.size(); i++) {
                        if (addressBooks.get(book).contact.get(i).getFirstName().equalsIgnoreCase(fName) && addressBooks.get(book).contact.get(i).getLastName().equalsIgnoreCase(lName)) {
                            addressBooks.get(book).contact.remove(i);
                            flag = true;
                        }
                    }
                }
                if (flag)
                    System.out.println("The contact " + fName + " " + lName + " has been deleted");
                else
                    System.out.println("The contact " + fName + " " + lName + " does not exist");
            } else if (num == 5) {
                for (String book : addressBooks.keySet()) {
                    for (int i = 0; i < addressBooks.get(book).contact.size(); i++) {
                        System.out.println(addressBooks.get(book).contact.get(i));
                    }
                }
            } else if (num == 6) {
                System.out.println("Enter city of Person to search");
                String city = sc.next();
                addressBooks.values().stream().forEach(s -> s.contact.stream().filter(a -> a.getCity().equalsIgnoreCase(city)).forEach(p-> System.out.println(p)));
            } else if (num == 7) {
                System.out.println("Enter State of Person to search");
                String state = sc.next();
                addressBooks.values().stream().forEach(s -> s.contact.stream().filter(a -> a.getState().equalsIgnoreCase(state)).forEach(p-> System.out.println(p)));
            } else if (num == 8) {
                System.out.println("Thank you for using address book");
                break;
            }
        }
    }
}
