import java.io.Serializable;

/**
 * @author varun
 * @version 1
 */
public class InvalidFileException extends Exception implements Serializable {
    public InvalidFileException() {
        super();
        System.out.println(getMessage());
        System.out.println(getStackTrace());
    }

    public InvalidFileException(String message) {
        super();
        System.out.println(message);
        System.out.println(getStackTrace());
    }
}
