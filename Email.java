package emailapp;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
 private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail = "None";
    private String companySuffix = "hamzatahir.com";

    
    public Email(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;

        this.password = randomPassword(10);

       
        if (department.equals("None") || department.isEmpty()) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        } else {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "hamza786";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    
    public void setMailboxCapacity(int capacity) { this.mailboxCapacity = capacity; }
    public void setAlternateEmail(String altEmail) { this.alternateEmail = altEmail; }
    public void changePassword(String password) { this.password = password; }
}
