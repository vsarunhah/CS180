/**
 * @author varun
 * @version 1.0
 */
public class AccessoryMethods {
    public static boolean isPlatformIndependent(ProgrammingLanguage pl) {
        if (pl.getExtension().equals(".py") || pl.getExtension().equals(".java")) {
            return true;
        } else if (pl.getExtension().equals(".cpp") || pl.getExtension().equals(".c")) {
            return false;
        }
        System.out.println("Error, invalid language!");
        return false;
    }

    public static String compilerAge(ProgrammingLanguage pl) {
        if (pl.getExtension().equals(".py") || pl.getExtension().equals(".java")) {
            return "2019";
        } else if (pl.getExtension().equals(".cpp")) {
            return "2017";
        } else if (pl.getExtension().equals(".c")) {
            return "2018";
        }

        return "Invalid";
    }

    public static String identifyLanguage(String filename) {
        if (filename.contains(".java")) {
            return "Java";
        } else if (filename.contains(".cpp")) {
            return "C++";
        } else if (filename.contains(".c")) {
            return "C";
        } else if (filename.contains(".py")) {
            return "Python";
        }
        return "Unknown language";
    }
}
