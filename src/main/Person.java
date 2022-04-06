package main;

public class Person {
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;
    private String address;

    public Person(String firstName, String lastName, String city, String state, int zip, long phoneNumber, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString(){
        return "Contact Details\n"+
                "First Name : "+firstName+"\n"+
                "Last Name : "+lastName+"\n"+
                "City : "+city+"\n"+
                "State : "+state+"\n"+
                "Zip : "+zip+"\n"+
                "Phone Number : "+phoneNumber+"\n"+
                "Email : "+email+"\n"+
                "Address : "+address+"\n";
    }
}
