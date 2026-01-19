package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

  
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

      
        this.department = setDepartment();

       
        this.password = randomPassword(defaultPasswordLength);        
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + 
                (department.isEmpty() ? "" : department + ".") + companySuffix;
    }
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return ""; }
    }private String randomPassword(int length) {
        String passwordSet = "mhamza";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

 public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    } 
   public void changePassword(String password) {
        this.password = password;
    }
    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
               "\nCOMPANY EMAIL: " + email +
               "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
