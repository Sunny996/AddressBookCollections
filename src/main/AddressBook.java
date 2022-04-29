package main;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static main.AddressBookMain.addressBookMain;

public class AddressBook {
    ArrayList<Person> contact;
    Scanner sc = new Scanner(System.in);

    public AddressBook() {
        contact = new ArrayList<>();
    }

    public void userOperations(AddressBook addBook) {
        System.out.println("Please select the operation to be performed");
        System.out.println("1.Add contact\n2.Edit contact\n3.Delete contact\n4.Print All Contacts\n5.Exit");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
            case 1:
                addBook.addNewContacts(addBook);
                break;
            case 2:
                addBook.editContactsFromAddressBook(addBook);
                break;
            case 3:
                addBook.deleteContactFromAddressBook(addBook);
                break;
            case 4:
                addBook.printAllContacts(addBook);
                break;
            case 5:
                break;
        }
    }

    public void addNewContacts(AddressBook addBook) {
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

        Person person = new Person(firstName, lastName, city, state, zip, phoneNumber, email, address);
        boolean bool = addBook.contact.stream().anyMatch(s -> s.equals(person));
        if (!bool) {
            contact.add(person);
            if (addressBookMain.cityPersonMap.get(person.getCity().toUpperCase()) != null)
                addressBookMain.cityPersonMap.get(person.getCity().toUpperCase()).add(person);
            else {
                addressBookMain.cityPersonMap.put(person.getCity().toUpperCase(), new ArrayList<Person>());
                addressBookMain.cityPersonMap.get(person.getCity().toUpperCase()).add(person);
            }
            if (addressBookMain.statePersonMap.get(person.getState().toUpperCase()) != null)
                addressBookMain.statePersonMap.get(person.getState().toUpperCase()).add(person);
            else {
                addressBookMain.statePersonMap.put(person.getState().toUpperCase(), new ArrayList<Person>());
                addressBookMain.statePersonMap.get(person.getState().toUpperCase()).add(person);
            }
            System.out.println("The contact " + firstName + " " + lastName + " has been added successfully");
        } else
            System.out.println("This is a duplicate contact, please enter new contact");
        userOperations(addBook);
    }

    public Person editContactsFromAddressBook(AddressBook addBook) {
        Person currentContact = null;
        System.out.println("Please enter the first name of contact to be edited");
        String firstName = sc.nextLine();
        System.out.println("Please enter the last name of contact to be edited");
        String lastName = sc.nextLine();
        for (Person person : contact) {
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName))
                currentContact = person;
        }
        editContacts(currentContact);
        userOperations(addBook);
        return currentContact;
    }

    public void editContacts(Person person) {

        System.out.println("Select Option:\n1. First Name\n2. Last Name\n 3. City\n4. State\n5. Zip\n6. Phone\n7. Email\n8.Address");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.println("Enter new first name:");
                person.setFirstName(sc.nextLine());
                System.out.println("The First Name has been edited to " + person.getFirstName());
                break;
            case 2:
                System.out.println("Enter new last name:");
                person.setLastName(sc.nextLine());
                System.out.println("The Last Name has been edited to " + person.getLastName());
                break;
            case 3:
                System.out.println("Enter new city");
                addressBookMain.cityPersonMap.get(person.getCity()).remove(person);
                person.setCity(sc.nextLine());
                if (addressBookMain.cityPersonMap.get(person.getCity().toUpperCase()) != null)
                    addressBookMain.cityPersonMap.get(person.getCity().toUpperCase()).add(person);
                else {
                    addressBookMain.cityPersonMap.put(person.getCity().toUpperCase(), new ArrayList<Person>());
                    addressBookMain.cityPersonMap.get(person.getCity().toUpperCase()).add(person);
                }
                System.out.println("The City has been edited to " + person.getCity());
                break;
            case 4:
                System.out.println("Enter new State");
                addressBookMain.statePersonMap.get(person.getState()).remove(person);
                person.setState(sc.nextLine());
                if (addressBookMain.cityPersonMap.get(person.getState().toUpperCase()) != null)
                    addressBookMain.cityPersonMap.get(person.getState().toUpperCase()).add(person);
                else {
                    addressBookMain.cityPersonMap.put(person.getState().toUpperCase(), new ArrayList<Person>());
                    addressBookMain.cityPersonMap.get(person.getState().toUpperCase()).add(person);
                }
                System.out.println("The state has been edited to " + person.getState());
                break;
            case 5:
                System.out.println("Enter new Zip");
                person.setZip(Integer.parseInt(sc.nextLine()));
                System.out.println("The zip has been edited to " + person.getZip());
                break;
            case 6:
                System.out.println("Enter new Phone");
                person.setPhoneNumber(Long.parseLong(sc.nextLine()));
                System.out.println("The phone number has been edited to " + person.getPhoneNumber());
                break;
            case 7:
                System.out.println("Enter new email");
                person.setEmail(sc.nextLine());
                System.out.println("The email has been edited to " + person.getEmail());
                break;
            case 8:
                System.out.println("Enter new Address");
                person.setAddress(sc.nextLine());
                System.out.println("The address has been edited to " + person.getAddress());
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    public void deleteContactFromAddressBook(AddressBook addBook) {
        System.out.println("Please enter the first name of contact to be deleted");
        String firstName = sc.nextLine();
        System.out.println("Please enter the last name of contact to be deleted");
        String lastName = sc.nextLine();
        for (int i = 0; i < addBook.contact.size(); i++) {
            if (addBook.contact.get(i).getFirstName().equalsIgnoreCase(firstName) && addBook.contact.get(i).getLastName().equalsIgnoreCase(lastName)) {
                addressBookMain.cityPersonMap.get(addBook.contact.get(i).getCity().toUpperCase()).remove(addBook.contact.get(i));
                addressBookMain.statePersonMap.get(addBook.contact.get(i).getState().toUpperCase()).remove(addBook.contact.get(i));
                addBook.contact.remove(i);
                System.out.println("The contact " + firstName + " " + lastName + " has been deleted successfully");
            } else
                System.out.println("No such contact exists");
        }
        userOperations(addBook);
    }

    public void printAllContacts(AddressBook addBook) {
        for (Person person : addBook.contact)
            System.out.println(person);
        userOperations(addBook);
    }

    public List<Person> sortAddressBookByName() {
        List<Person> sortedList = this.contact.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Person> sortAddressBookByCity() {
        List<Person> sortedList = this.contact.stream()
                .sorted(Comparator.comparing(Person::getCity))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Person> sortAddressBookByState() {
        List<Person> sortedList = this.contact.stream()
                .sorted(Comparator.comparing(Person::getState))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<Person> sortAddressBookByZip() {
        List<Person> sortedList = this.contact.stream()
                .sorted(Comparator.comparing(Person::getZip))
                .collect(Collectors.toList());
        return sortedList;
    }

    public void writeToFile(String fileName) {
        StringBuffer contactBuffer = new StringBuffer();
        contact.forEach(contact -> {
            String contactString = contact.toString().concat("\n");
            contactBuffer.append(contactString);
        });
        try {
            Files.write(Paths.get(fileName), contactBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromCSV(String fileName) {
        try (Reader reader = new BufferedReader(new FileReader(fileName))) {
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();
            contact = new ArrayList<Person>();
            for (String[] person : allData) {
                contact.add(new Person(person[0], person[1], person[2], person[3], Integer.parseInt(person[4]), Long.parseLong(person[5]), person[6], person[7]));
            }

        } catch (CsvException | IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToCSV(String fileName) {
        File file = new File(fileName);
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter csvWriter = new CSVWriter(outputFile);
            String[] header = {"FirstName", "LastName", "City", "State", "Zip", "PhoneNumber", "Email", "Address"};
            csvWriter.writeNext(header);
            for (Person p : contact) {
                String[] line = {p.getFirstName(), p.getLastName(), p.getCity(), p.getState(), String.valueOf(p.getZip())
                        , String.valueOf(p.getPhoneNumber()), p.getEmail(), p.getAddress()};
                csvWriter.writeNext(line);
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
