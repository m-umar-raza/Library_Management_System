# Library Management System

## Overview

The Library Management System is a Java-based console application designed to facilitate the management of a library's operations. It provides functionalities to manage books, users, and borrowing/returning books. This system aims to streamline library tasks, making it easier for librarians to organize and track library resources efficiently.

## Classes

### Library

The `Library` class serves as the core of the application, orchestrating interactions between users, books, and the data storage system. It manages the collections of books and users, provides methods for data loading and saving, and controls the main flow of the program.

### Book

The `Book` class represents individual books within the library. It encapsulates properties such as ID, title, author, genre, and availability status. Additionally, it offers functionalities for adding, borrowing, returning, searching, and displaying books.

### User

The `User` class models library patrons, storing information such as ID, name, contact details, and a list of borrowed books. It facilitates user-related operations such as registration, borrowing, returning, searching, and displaying user information.

## Features

1. **Add a User**: Register new users with unique IDs, names, and contact information.
2. **Add a Book**: Add new books to the library inventory, including details like title, author, and genre.
3. **Borrow a Book**: Allow users to borrow books by specifying the book title and their user ID.
4. **Return a Book**: Enable users to return borrowed books, updating availability status accordingly.
5. **Search for Books by User ID**: Retrieve a list of books borrowed by a specific user identified by their ID.
6. **Display All Books**: View a comprehensive list of all available books in the library.
7. **Display All Users**: Access a directory of registered library users, including their details and borrowed books.
8. **Search for Books by Title or Author**: Locate books within the library's collection based on title or author name.
9. **File Handling**: Implement data persistence mechanisms to store library data between program sessions, ensuring data integrity and continuity.

## How to Run

To execute the application, simply run the `main` method within the `Library` class. Ensure that the necessary dependencies, such as Java SE 11 or later, are installed on your system.

## Dependencies

This project relies on Java SE 11 or later for execution. No additional external dependencies are required.

## Future Improvements

- **Graphical User Interface (GUI)**: Enhance the user experience by developing a GUI version of the application for intuitive interaction.
- **Advanced Search Options**: Implement advanced search functionalities, such as filtering books by publication year, ISBN, or availability.
- **Fine Management System**: Integrate features for managing fines, due dates, and notifications for overdue books.
- **Recommendation Engine**: Incorporate a recommendation system based on user preferences, borrowing history, and popular titles.
- **Multi-User Support**: Extend support for multiple concurrent users, allowing simultaneous operations without data conflicts.

## Contributing

Contributions to the project are welcome via pull requests. Please ensure to follow the established coding conventions and guidelines. For major changes, kindly discuss them in an issue before proceeding with implementation.

## License

This project is licensed under the MIT License. For details, please refer to the [LICENSE](LICENSE) file.
