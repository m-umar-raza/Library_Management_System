# Library Management System

## Overview

This Library Management System is a console-based application developed in Java. It is designed to help manage a library's needs, including managing books and users. The system allows you to add books and users, borrow and return books, and search for books by title or author.

## Classes

### Library

The `Library` class is the main class that runs the application. It contains an `ArrayList` of `Book` and `User` objects, representing the books in the library and the registered users, respectively. The class provides methods for loading and saving data, which are used to persist the state of the library between sessions.

### Book

The `Book` class represents a book in the library. Each book has an ID, title, author, genre, and availability status. The class provides methods for adding a book to the library, borrowing a book, returning a book, searching for a book by title or author, and displaying all books.

### User

The `User` class represents a user of the library. Each user has an ID, name, contact information, and a list of borrowed books. The class provides methods for adding a user, borrowing a book, returning a book, searching for books by user ID, and displaying all users.

## Features

1. **Add a User**: This feature allows you to add a new user to the library. You need to provide the user ID, name, and contact information.

2. **Add a Book**: This feature allows you to add a new book to the library. You need to provide the book ID, title, author, and genre.

3. **Borrow a Book**: This feature allows a user to borrow a book from the library. You need to provide the book title and the user ID.

4. **Return a Book**: This feature allows a user to return a borrowed book to the library. You need to provide the book title and the user ID.

5. **Search for Books by User ID**: This feature allows you to find all the books borrowed by a specific user. You need to provide the user ID.

6. **Display All Books**: This feature displays all the books in the library.

7. **Display All Users**: This feature displays all the users in the library.

8. **Search book by Title or Author**: This feature allows you to search for books by their title or author.

9. **File Handling**: This feature allows the data to be kept safe and not deleted when the program terminates. 

## How to Run

To run the application, simply run the `main` method in the `Library` class.

## Dependencies

This project requires Java SE 11 or later.

## Future Improvements

- Implement a GUI for a more user-friendly experience.
- Add more features, such as user ratings and reviews for books.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

MIT
