/**
 * A class that represents an exception that is thrown if the side length of three dimensional objects is below the
 * allowed amount for that shape.
 * @author Purdue CS180
 * @version 1.0
 */
public class UnexpectedSideLengthException extends Exception {
	/**
	 * Constructs a new exception with {@code null} as its detail message.
	 * The cause is not initialized, and may subsequently be initialized by a
	 * call to {@link #initCause}.
	 */
	public UnexpectedSideLengthException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.  The
	 * cause is not initialized, and may subsequently be initialized by
	 * a call to {@link #initCause}.
	 *
	 * @param message the detail message. The detail message is saved for
	 *                later retrieval by the {@link #getMessage()} method.
	 */
	@SuppressWarnings("WeakerAccess")
	public UnexpectedSideLengthException(String message) {
		super(message);
	}
}
