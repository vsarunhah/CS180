import java.util.Scanner;
/**
 * @author varun
 * @version 1.0
 */
public class Driver {
    public static void main(String[] args) {
        ProgrammingLanguage pl = null;
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome! Input the file you would like to process:");
        String filename = s.nextLine();
        System.out.println("Here is your selected file's language information:");
        System.out.println("-----");
        AccessoryMethods am = new AccessoryMethods();
        String lang = AccessoryMethods.identifyLanguage(filename);
        if (lang.equals("Java")) {
            pl = new Java(filename);
        } else if (lang.equals("C++")) {
            pl = new CPlusPlus(filename);
        } else if (lang.equals("C")) {
            pl = new C(filename);
        } else if (lang.equals("Python")) {
            pl = new Python(filename);
        }
        if (pl != null) {
            System.out.println(pl.toString());
            if (AccessoryMethods.isPlatformIndependent(pl)) {
                System.out.println("It is platform independent.");
            } else {
                System.out.println("It is not platform independent.");
            }
            System.out.println("The compiler was last updated in " + AccessoryMethods.compilerAge(pl) + ".");
            pl.printStrengths();
            pl.printWeaknesses();
            System.out.println("-----");
        }
    }
}
