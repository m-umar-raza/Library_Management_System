package Library_Management;

import java.util.Scanner;

public class Book {
    // Attributes of a book
    public int bookID;
    public String title;
    public String author;
    public String genre;
    public Boolean availabilityStatus;

    // Constructor to initialize book attributes
    Book(int bookID, String title, String author, String genre, Boolean availabilityStatus) {
        this.setBookID(bookID);
        this.setTitle(title);
        this.setAuthor(author);
        this.setGenre(genre);
        this.setAvailabilityStatus(availabilityStatus);
    }

    // Scanner object for user input
    static Scanner in = new Scanner(System.in);

    // Setter methods for book attributes
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

    // Getter methods for book attributes
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
        return (availabilityStatus ? "Available" : "Not Available");
    }

    // Method to add a new book
    public static void addBook() {
        System.out.println("Enter Book ID:");
        int bookID;
        try {
            bookID = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the book ID.");
            return;
        }
        for (Book book : Library.books) {
            if (book.getBookID() == bookID) {
                System.out.println("Book is already present");
                return;
            }
        }
        System.out.println("Enter Title:");
        String title = in.nextLine();
        System.out.println("Enter Author:");
        String author = in.nextLine();
        System.out.println("Enter Genre:");
        String genre = in.nextLine();
        Library.books.add(new Book(bookID, title, author, genre, true));
        System.out.println("*Book added Successfully*\n");
    }

    // Method to borrow a book
    public static void borrowBook() {
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
        boolean userExists = false;
        for (User user : Library.users) {
            if (user.getUserID() == uID) {
                userExists = true;
                for (Book book : Library.books) {
                    if (book.getTitle().equals(bBook)) {
                        if (book.availabilityStatus) {
                            user.borrowBooks(bBook);
                            book.availabilityStatus = false; // Update availability status
                            System.out.println("The book has been borrowed.");
                        } else {
                            System.out.println("The book is not available.");
                        }
                        break;
                    }
                }
                System.out.println("The book is not available.");
                break;
            }
        }
        if (!userExists) {
            System.out.println("User ID does not exist.");
        }
    }

    // Method to return a borrowed book
    public static void returnBook() {
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
        boolean userExists = false;
        for (User user : Library.users) {
            if (user.getUserID() == uID) {
                userExists = true;
                for (Book book : Library.books) {
                    if (book.getTitle().equals(rBook)) {
                        user.returnBooks(rBook);
                        book.availabilityStatus = true; // Update availability status
                        System.out.println("The book has been returned.");
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

    // Method to search for a book by title or author
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

    // Method to display all books in the library
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

    // Method to display titles of all books in the library
    public static void displayTitles() {
        System.out.println("List of Titles:");
        System.out.println("---------------");
        int c = 1;
        for (Book book : Library.books) {
            System.out.println(c + ". " + book.getTitle());
            c++;
        }
        System.out.println("---------------");
    }

    // Overriding toString method to display book information
    public String toString() {
        return "Book ID: " + bookID + "\nTitle: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nAvailability: " + (availabilityStatus ? "Available" : "Not Available");
    }
}

