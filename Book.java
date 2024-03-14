package Library_Management;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    // Properties of the Book class
    public int bookID;
    public String title;
    public String author;
    public String genre;
    public Boolean availabilityStatus;

    // Constructor for the Book class
    Book(int bookID, String title, String author, String genre, Boolean availabilityStatus) {
        this.setBookID(bookID);
        this.setTitle(title);
        this.setAuthor(author);
        this.setGenre(genre);
        this.setAvailabilityStatus(availabilityStatus);
    }

    // Scanner object for user input
    static Scanner in = new Scanner(System.in);

    // Setter methods for the properties of the Book class
    public void setBookID(int x) {
        this.bookID = x;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public void setAuthor(String a) {
        this.author = a;
    }

    public void setGenre(String g) {
        this.genre = g;
    }

    public void setAvailabilityStatus(Boolean as) {
        this.availabilityStatus = as;
    }

    // Getter methods for the properties of the Book class
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getAvailabilityStatus() {
        return (availabilityStatus? "Available" : "Not Available");
    }
    
    // Method to add a new book
    public static void addBook(){
        System.out.println("Enter Book ID:");
        int bookID;
        try {
            bookID = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the book ID.");
            return;
        }

        // Check if the book already exists
        for (Book book : Library.books) {
            if (book.getBookID() == bookID) {
                System.out.println("Book is already present");
                return;
            }
        }

        // Input details for the new book
        System.out.println("Enter Title:");
        String title = in.nextLine();
        System.out.println("Enter Author:");
        String author = in.nextLine();
        System.out.println("Enter Genre:");
        String genre = in.nextLine();

        // Add the new book to the list of books
        Library.books.add(new Book(bookID,title,author,genre,true));
        System.out.println("Book added Successfully\n");
    }

    // Method to borrow a book
    public static void borrowBook() {
        // Input the book to be borrowed and user ID
        System.out.println("Enter the book to be borrowed");
        String bBook = in.nextLine();
        System.out.println("Enter your User ID");
        int uID;
        try {
            uID = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the User ID.");
            return;
        }

        // Check if the user exists
        boolean userExists = false;
        for (User user : Library.users) {
            if (user.getUserID() == uID) {
                userExists = true;
                // Iterate through the books to find the requested book
                for (Book book : Library.books) {
                    if (book.getTitle().equals(bBook)) {
                        // Check availability and update if available
                        if (book.availabilityStatus) {
                            user.borrowBooks(bBook);
                            book.availabilityStatus = false; // Update availability status
                        } else {
                            System.out.println("The book is not available.");
                        }
                        break;
                    }
                }
                break;
            }
        }
        if (!userExists) {
            System.out.println("User ID does not exist.");
        }
    }

    // Method to return a borrowed book
    public static void returnBook() {
        // Input the book to be returned and user ID
        System.out.println("Enter the book to be Returned");
        String rBook = in.nextLine();
        System.out.println("Enter your User ID");
        int uID;
        try {
            uID = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the User ID.");
            return;
        }

        // Check if the user exists
        boolean userExists = false;
        for (User user : Library.users) {
            if (user.getUserID() == uID) {
                userExists = true;
                // Iterate through the books to find the requested book
                for (Book book : Library.books) {
                    if (book.getTitle().equals(rBook)) {
                        // Update user's borrowed books and book's availability status
                        user.returnBooks(rBook);
                        book.availabilityStatus = true; // Update availability status
                        break;
                    }
                }
                break;
            }
        }
        if (!userExists) {
            System.out.println("User ID does not exist.");
        }
    }

    // Method to search for books by title or author
    public static void searchBookByTitleOrAuthor() {
        System.out.println("Enter a title or author to search for books: ");
        String query = in.nextLine();
        boolean bookFound = false;
        for (Book book : Library.books) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                bookFound = true;
                System.out.println(book);
            }
        }
        if (!bookFound) {
            System.out.println("No books found with the given title or author.");
        }
    }

    // Method to display all books
    public static void displayBook() {
        System.out.println("List of Books:");
        System.out.println("---------------");
        for (Book book : Library.books) {
            System.out.println("Book ID: " + book.getBookID());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Availability: " + (book.getAvailabilityStatus()));
            System.out.println("---------------");
        }
    }

    // Method to display only book titles
    public static void displayTitles(){
        System.out.println("List of Titles:");
        System.out.println("---------------");
        int c=1;
        for (Book book : Library.books) {
            System.out.println(c +". "+ book.getTitle());
            c++;
        }
        System.out.println("---------------");
    }

    // Method to override the toString() method for Book class
    public String toString() {
        return "Book ID: " + bookID + "\nTitle: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nAvailability: " + (availabilityStatus? "Available" : "Not Available");
    }
}
