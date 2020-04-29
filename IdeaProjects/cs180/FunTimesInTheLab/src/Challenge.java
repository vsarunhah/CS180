import java.util.*;

public class Challenge {
	public static void main(String[] args) {
		String myString = "Close the door John, it is cold outside. Purdue shut the door";
		System.out.println(myString);

		String[] ab = myString.split("\\. ");
		String[] cd = ab[0].split("\\, ");

		String c = cd[0];
		c = c.replace(c.charAt(0), ab[1].charAt(0));

		String d = cd[1].replaceFirst(String.valueOf(cd[1].charAt(0)), String.valueOf(cd[0].charAt(0)));

		String b = ab[1].replaceFirst(String.valueOf(ab[1].charAt(0)), String.valueOf(cd[1].charAt(0)).toUpperCase());
		b = b + " ";
		d = d + ". ";
		c = c + ",";

		System.out.println(b+d+c);

	}
}