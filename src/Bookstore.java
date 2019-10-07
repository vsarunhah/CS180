import java.util.Arrays;

/**
 * A simple Bookstore class
 * @author Varun Shah, CS180 instructors
 * @version 1.0
 */
public class Bookstore {

    private int row;
    private int col;
    private Book[][][] bookshelf;

    /**
     * Construct a newly allocated {@code Bookstore} object with given parameters
     *
     * @param row   Number of rows in each shelf
     * @param col   Number of columns in each shelf
     * @param books Array of books to be placed in the bookshelf
     */
    public Bookstore(int row, int col, Book[] books) {
        this.row = row;
        this.col = col;
        bookshelf = new Book[10][row][col];
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (counter < books.length) {
                        bookshelf[i][r][c] = books[counter];
                        counter += 1;
                    }
                }

            }
        }

    }

    /**
     * Book look up in bookshelf using the name of the book
     *
     * @param name Name of the book
     * @return String with the format    Book: [name] [bookISBN] [author] [lowest price]
     */
    public String lookUpName(String name) {
        System.out.println(Arrays.deepToString(bookshelf));
        for (int i = 0; i < bookshelf.length; i++) {
            for (int y = 0; y < bookshelf[i].length; y++) {
                for (int x = 0; x < bookshelf[i][y].length; x++) {
                    System.out.println(i + " " + y + " " + x);
                    if (bookshelf[i][y][x].getName().equals(name)) {
                        return bookshelf[i][y][x].toString();
                    }
                }
            }
        }
        return "Not found";
    }

    /**
     * Book look up in bookshelf using the ISBN of the book
     *
     * @param bookISBN bookISBN of the book
     * @return String with the format    Book: [name] [bookISBN] [author] [lowest price]
     */
    public String lookUpBookISBN(int bookISBN) {
        for (int i = 0; i < bookshelf.length; i++) {
            for (int y = 0; y < bookshelf[i].length; y++) {
                for (int x = 0; x < bookshelf[i][y].length; x++) {
                    if (bookshelf[i][y][x].getBookISBN() == bookISBN) {
                        return bookshelf[i][y][x].toString();
                    }
                }
            }
        }
        return "Not found";
    }

    public Book[][][] getBookshelf() {
        return bookshelf;
    }
}


