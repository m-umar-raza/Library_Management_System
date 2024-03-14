package Library_Management;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Library implements Serializable {
    // ArrayLists to store books and users
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
                loadData(); // Load data when authentication is successful
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
                case 1:
                    User.addUser(); // Add a user
                    saveData(); // Save data after adding user
                    break;
                case 2:
                    Book.addBook(); // Add a book
                    saveData(); // Save data after adding book
                    break;
                case 3:
                    Book.displayTitles(); // Display book titles
                    Book.borrowBook(); // Borrow a book
                    saveData(); // Save data after borrowing book
                    break;
                case 4:
                    Book.returnBook(); // Return a book
                    saveData(); // Save data after returning book
                    break;
                case 5:
                    User.searchBooksByUserID(); // Search for books by user ID
                    break;
                case 6:
                    Book.displayBook(); // Display all books
                    break;
                case 7:
                    User.displayUsers(); // Display all users
                    break;
                case 8:
                    Book.searchBookByTitleOrAuthor(); // Search book by title or author
                    break;
                default:
                    System.out.println("Invalid option! Please enter a valid option.");
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0); // Exit the program
                    break;
            }
            System.out.println("Do you want to continue(y/n)? ");
            again = in.nextLine();
        }
    }

    // Method to load data from file
    public static void loadData() {
        try {
            FileInputStream fis = new FileInputStream("libraryData.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            books = (ArrayList<Book>) ois.readObject();
            users = (ArrayList<User>) ois.readObject();

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            // File does not exist, initialize books and users as empty lists
            books = new ArrayList<>();
            users = new ArrayList<>();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    // Method to save data to file
    public static void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream("libraryData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(books);
            oos.writeObject(users);

            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
