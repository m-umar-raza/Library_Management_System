package Library_Management;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    // ArrayList to store books and users
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Library Management System!");
        System.out.println("Enter Username: ");
        String userName = in.nextLine();
        System.out.println("Enter Password");
        int userPass;
        try {
            userPass = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the password.");
            return;
        }
        int myPass = 123;
        String myUser = "Umar";

        // Authentication loop
        while (true) {
            if (userName.equals(myUser) && userPass == myPass) {
                System.out.println("Authentication successful!");
                break;
            } else {
                System.out.println("Wrong Username or Password");
                System.out.println("Enter Username: ");
                userName = in.nextLine();
                System.out.println("Enter Password");
                try {
                    userPass = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number for the password.");
                    return;
                }
            }
        }

        // Menu loop
        int opt;
        String again = "y";
        while (again.equalsIgnoreCase("y")) {
            System.out.println("""
                    Please select an option:\s
                    1. Add a User
                    2. Add a Book
                    3. Borrow a Book
                    4. Return a Book
                    5. Search for Books by User ID
                    6. Display All Books
                    7. Display All Users
                    8. Search book by Title or Author
                    9. Exit

                    Enter your choice:\s""");
            try {
                opt = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for the option.");
                continue;
            }
            switch (opt) {
                // Add a User
                case 1:
                    User.addUser();
                    break;
                // Add a Book
                case 2:
                    Book.addBook();
                    break;
                // Borrow a Book
                case 3:
                    Book.displayTitles();
                    Book.borrowBook();
                    break;
                // Return a Book
                case 4:
                    Book.returnBook();
                    break;
                // Search for Books by User ID
                case 5:
                    User.searchBooksByUserID();
                    break;
                // Display All Books
                case 6:
                    Book.displayBook();
                    break;
                // Display All Users
                case 7:
                    User.displayUsers();
                    break;
                // Search book by Title or Author
                case 8:
                    Book.searchBookByTitleOrAuthor();
                    break;
                // Exit
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option! Please enter a valid option.");
                    break;
            }
            System.out.println("Do you want to continue(y/n)? ");
            again = in.nextLine();
        }
    }
}

