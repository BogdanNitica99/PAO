package bookstore;

import java.util.Scanner;

public class BookstoreTest {

    public static void main(String[] args){

        Book[] books;
        int index=0;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of books");
        int numBooks = input.nextInt();

        if(numBooks <= 0) {
            throw new RuntimeException("The number of books must be a positive integer!");
        }

        books = new Book[numBooks];

        String title, author, publisher;
        int pageCount;

        for(int i=0;i<numBooks;i++) {
            title = input.next();
            author = input.next();
            publisher = input.next();
            pageCount = input.nextInt();

            Book book = new Book(title, author, publisher, pageCount);

            books[index] = book;

            index += 1;
        }

        input.close();

        System.out.print(BookstoreCheck.multipleBooks(books, books[0], numBooks) + "\n");

        System.out.print(BookstoreCheck.thicker(books[0], books[1]));
    }
}
