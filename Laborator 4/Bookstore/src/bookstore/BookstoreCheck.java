package bookstore;

public class BookstoreCheck {

    static boolean multipleBooks(Book[] books, Book book, int numBooks) {
        int count = 0;

        for(int i=0;i<numBooks;i++) {
            if(books[i].equals(book)) {
                count += 1;
                if(count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    static Book thicker(Book b1, Book b2) {
        if(b1.getPageCount() > b2.getPageCount()) {
            return b1;
        }
        return b2;
    }

}
