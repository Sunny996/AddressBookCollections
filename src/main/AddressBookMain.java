package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        HashMap<String, AddressBook> addressBooks = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook;
        String bookName="";

        while (true) {
            System.out.println("Enter 1.To Create New Address Book\n 2.View/Edit Address Book\n 3. Exit");
            int num = sc.nextInt();
            if (num == 1) {
                addressBook = new AddressBook();
                System.out.println("Enter New Address Book name");
                bookName = sc.next();
                addressBooks.put(bookName, addressBook);
            }
            else if(num==2){
                System.out.println("Enter the name of address book to view or edit");
                bookName=sc.next();
                if(addressBooks.get(bookName)==null)
                    System.out.println("The selected address book does not exist");
                else{
                    addressBooks.get(bookName).userOperations(addressBooks.get(bookName));
                }
            }
            else if(num==3){
                System.out.println("Thank you for using address book");
                break;
            }
        }
    }
}
