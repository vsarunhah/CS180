import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A simple Book class
 * @author Varun Shah, CS180 instructors
 * @version 1.0
 */
public class Book {

    private String name;
    private int bookISBN;
    private double[] prices;
    private String author;

    /**
    Construct a newly allocated {@code Book} object with given parameters

     @param name Name of the book
     @param bookISBN bookISBN of the book
     @param prices Available prices of the book
     @param author Author of the book
     */
    public Book(String name, int bookISBN, double[] prices, String author) {
        this.name = name;
        this.bookISBN = bookISBN;
        this.prices = prices;
        this.author = author;
        
    }

    /**
     * Returns Name of the book
     * @return Name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Returns author of the book
     * @return Author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns bookISBN of the book
     * @return bookISBN of the book
     */
    public int getBookISBN() {
        return bookISBN;
    }

    /**
     * Returns lowest price out of price options
     * @return Lowest price out of price options
     */
    public double getLowestPrice() {
        double[] priceSort = prices;
        Arrays.sort(priceSort);
        return priceSort[0];
    }
    
    /**
     * Returns String representation of a Book
     * @return String representation of a Book
     */
    @Override
    public String toString() {
        return "Book: " + getName() + " " + getBookISBN() + " " + getAuthor() + " " + getLowestPrice();
    }
    
}