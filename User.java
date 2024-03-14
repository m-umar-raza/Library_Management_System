package Library_Management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {
    // Properties of the User class
    public int userID;
    public String name;
    public String contactInfo;
    public ArrayList<String> borrowedBooks = new ArrayList<>();

    // Constructor for the User class
    User(int userID, String name, String contactInfo) {
        this.setUserID(userID);
        this.setName(name);
        this.setContactInfo(contactInfo);
    }

    // Scanner object for user input
    static Scanner in = new Scanner(System.in);

    // Setter methods for the properties of the User class
    public void setUserID(int id) {
        this.userID = id;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setContactInfo(String cInfo) {
        this.contactInfo = cInfo;
    }

    // Getter methods for the properties of the User class
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

    // Method to add a book to the list of borrowed books
    public void borrowBooks(String title) {
        borrowedBooks.add(title);
        System.out.println("Book borrowed Successfully\n");
    }

    // Method to return a book from the list of borrowed books
    public void returnBooks(String title) {
        if (!this.borrowedBooks.contains(title)) {
            System.out.println("You did not borrow this book, so you cannot return it.");
            return;
        }
        borrowedBooks.remove(title);
        System.out.println("Book returned Successfully\n");
    }

    // Method to add a new user
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
        System.out.println("User added Successfully\n");
    }

    // Method to search for books borrowed by a user
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

    // Method to display all users
    public static void displayUsers() {
        System.out.println("List of Users:");
        System.out.println("---------------");
        for (User user : Library.users) {
            System.out.println("User ID: " + user.getUserID());
            System.out.println("Name: " + user.getName());
            System.out.println("Contact Information: " + user.getContactInfo());
            System.out.println("Borrowed Books: " + user.getBorrowedBooks());
            System.out.println("---------------");
        }
    }

    // Overriding toString() method to get desired results
    public String toString() {
        return "Name : " + name + "\nUser ID: " + userID + "\nContact Information: " + contactInfo;
    }
}
