import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By default, books are available
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkOut() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Status: " +
               (isAvailable ? "Available" : "Checked Out");
    }
}

// LibraryCatalog class
class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void searchByTitle(String title) {
        System.out.println("Searching for books with title: " + title);
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the title: " + title);
        }
    }

    public void searchByAuthor(String author) {
        System.out.println("Searching for books by author: " + author);
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by the author: " + author);
        }
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.checkOut();
                    System.out.println("You have successfully checked out: " + title);
                } else {
                    System.out.println("The book is already checked out: " + title);
                }
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.returnBook();
                    System.out.println("You have successfully returned: " + title);
                } else {
                    System.out.println("The book is already available: " + title);
                }
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. Check Out Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    catalog.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    catalog.searchByTitle(searchTitle);
                    break;

                case 3:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    catalog.searchByAuthor(searchAuthor);
                    break;

                case 4:
                    System.out.print("Enter title to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    catalog.checkOutBook(checkOutTitle);
                    break;

                case 5:
                    System.out.print("Enter title to return: ");
                    String returnTitle = scanner.nextLine();
                    catalog.returnBook(returnTitle);
                    break;

                case 6:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
