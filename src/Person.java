public class Person {
    private String firstName;
    private String lastName;
    private String emailAddress;


    public Person(String first, String last, String email) {
        firstName = first;
        lastName = last;
        emailAddress = email;
    }
    public Person(String first, String last) {
        firstName = first;
        lastName = last;
        emailAddress = "none";
    }

    public void introduce() {
        System.out.println("Hello, my name is " + getFirstName() + " " + getLastName());
    }


    public void changeEmail(String email) {
        emailAddress = email;
    }
    public String getEmailAddress() {
        return emailAddress;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }
}
