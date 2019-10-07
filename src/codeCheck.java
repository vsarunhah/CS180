import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class codeCheck {
    public static void main(String[] args){
        Book[] books = new Book[25];
        for (int i = 0; i < 25; i++){
            books[i] = new Book(Integer.toString(i), i*10, new double[]{1,2,3,4,5}, Character.toString((char) i+45));
        }
        Book book = new Book("Hello", 109417, new double[]{9.37, 20.0}, "James");
        Bookstore bk = new Bookstore(5,5,books);
        System.out.println(bk.lookUpName("7"));
    }
}
