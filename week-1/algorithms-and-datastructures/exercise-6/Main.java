public class Main {
    public static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }

    public static class LibraryManagementSystem {
        public Book linearSearch(Book[] books, String targetTitle) {
            for (Book book : books) {
                if (book.getTitle().equals(targetTitle)) {
                    return book;
                }
            }
            return null;
        }

        public Book binarySearch(Book[] books, String targetTitle) {
            int left = 0;
            int right = books.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (books[mid].getTitle().equals(targetTitle)) {
                    return books[mid];
                } else if (books[mid].getTitle().compareTo(targetTitle) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();

        Book[] books = new Book[] {
                new Book(1, "Book 1", "Author 1"),
                new Book(2, "Book 2", "Author 2"),
                new Book(3, "Book 3", "Author 3")
        };

        Book foundBookLinear = lms.linearSearch(books, "Book 2");
        System.out.println("Found Book (Linear Search): " + foundBookLinear.getTitle());

        // Sort books for binary search
        java.util.Arrays.sort(books, (a, b) -> a.getTitle().compareTo(b.getTitle()));

        Book foundBookBinary = lms.binarySearch(books, "Book 2");
        System.out.println("Found Book (Binary Search): " + foundBookBinary.getTitle());
    }
}
