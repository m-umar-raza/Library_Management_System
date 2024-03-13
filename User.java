// package declaration
package Library_Management;

// import statements
import java.util.ArrayList;
import java.util.Scanner;

// User class
public class User {
    // instance variables
    public int userID;
    public String name;
    public String contactInfo;
    public ArrayList<String> borrowedBooks = new ArrayList<>(); // Removed static

    // constructor
    User(int userID, String name, String contactInfo) {
        this.setUserID(userID);
        this.setName(name);
        this.setContactInfo(contactInfo);
    }

    // Scanner object
    static Scanner in = new Scanner(System.in);

    // setters
    public void setUserID(int id) {
        this.userID = id;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setContactInfo(String cInfo) {
        this.contactInfo = cInfo;
    }

    // getters
    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    // method to borrow books
    public void borrowBooks(String title) { // Removed static
        borrowedBooks.add(title);
        System.out.println("*Book borrowed Successfully*\n");
    }

    // method to return books
    public void returnBooks(String title) { // Removed static
        if (!this.borrowedBooks.contains(title)) {
            System.out.println("You did not borrow this book, so you cannot return it.");
            return;
        }
        borrowedBooks.remove(title);
        System.out.println("*Book returned Successfully*\n");
    }

    // method to add user
    public static void addUser() {
        System.out.println("Enter User ID:");
        int UserID;
        try {
            UserID = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the User ID.");
            return;
        }
        for (User user : Library.users) {
            if (user.getUserID() == UserID) {
                System.out.println("User is already present");
                return; // Exit the method if user already exists
            }
        }
        System.out.println("Enter Name:");
        String name = in.nextLine();
        System.out.println("Enter Contact Information:");
        String contactInfo = in.nextLine();
        Library.users.add(new User(UserID, name, contactInfo));
        System.out.println("*User added Successfully*\n");
    }

    // method to search books by user ID
    public static void searchBooksByUserID() {
        System.out.println("Enter User ID to search for books: ");
        int uID;
        try {
            uID = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the User ID.");
            return;
        }
        boolean userFound = false;
        for (User user : Library.users) {
            if (user.getUserID() == uID) {
                userFound = true;
                System.out.println("Books borrowed by user with ID " + uID + ":");
                for (String bookTitle : user.getBorrowedBooks()) {
                    System.out.println("  " + bookTitle);
                }
                System.out.println("---------------");
                break;
            }
        }
        if (!userFound) {
            System.out.println("User ID does not exist.");
        }
    }

    // method to display users
    public static void displayUsers() { // Removed static
        System.out.println("List of Users:"); //
        System.out.println("---------------");
        for (User user : Library.users) {
            System.out.println("User ID: " + user.getUserID());
            System.out.println("Name: " + user.getName());
            System.out.println("Contact Information: " + user.getContactInfo());
            System.out.println("Borrowed Books: " + user.getBorrowedBooks());
            System.out.println("---------------");
        }
    }

    // toString method
    public String toString() {
        return "Name : " + name + "\nUser ID: " + userID + "\nContact Information: " + contactInfo;
    }
}
