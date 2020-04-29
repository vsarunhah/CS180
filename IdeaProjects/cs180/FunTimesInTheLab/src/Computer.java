@SuppressWarnings("WeakerAccess")
public interface Computer {

	/**
	 * Defines the screen width of the computer
	 * @return the screen width of the computer
	 */
	int screenWidth();

	/**
	 * Defines the screen height of the computer
	 * @return the screen height of the computer
	 */
	int screenHeight();

	/**
	 * Defines the touchscreen capability of the computer
	 * @return the touchscreen capability of the computer
	 */
	boolean hasTouchscreen();

	/**
	 * Defines if the keyboard has a physical keyboard or not.
	 * @return if the keyboard has a physical keyboard or not.
	 */
	boolean hasKeyboard();

	/**
	 * Returns the name of the operating system that this computer runs on.
	 * @return the name of the operating system that this computer runs on.
	 */
	String nameOfOperatingSystem();
}
