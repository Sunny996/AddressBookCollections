package main;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Ability to create contacts in Address Book");
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        addressBookSystem.addNewContacts();
        addressBookSystem.editContacts();
        addressBookSystem.deleteContact();
    }
}
