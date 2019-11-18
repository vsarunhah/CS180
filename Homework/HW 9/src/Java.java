/**
 * @author Varun Shah
 * @version 1.0
 */
public class Java extends ProgrammingLanguage {
    public Java(String compiler, String extension, String runConfig, String flags, String fileName) {
        super(compiler, extension, runConfig, flags, fileName);
    }

    public Java(String filename) {
        super("Java Virtual Machine (JVM)", ".java", "javac " + filename + " && java "
                + filename.substring(0, filename.indexOf(".java")), "", filename);
    }

    @Override
    public boolean isObjectOriented() {
        return true;
    }

    @Override
    public void printStrengths() {
        System.out.println("Java is a general purpose object-oriented language, making it well suited for " +
                "most general development.");
    }

    @Override
    public void printWeaknesses() {
        System.out.println("Because Java is run on a virtual machine, it can be slower than other languages.");
    }

    @Override
    public String toString() {
        String s = "Java uses the Java Virtual Machine (JVM) compiler, and has file extensions with .java.\n" +
                "To run the file " + getFilename() + " you would need the following command:\n" + getRunConfig();
        return s;
    }
}
