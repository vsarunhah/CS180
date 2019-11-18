/**
 * @author varun
 * @version 1.0
 */
public class CPlusPlus extends ProgrammingLanguage {
    public CPlusPlus(String compiler, String extension, String runConfig, String flags, String fileName) {
        super(compiler, extension, runConfig, flags, fileName);
    }

    public CPlusPlus(String filename) {
        super("g++", ".cpp", "g++ " + "-o " + filename.substring(0, filename.indexOf(".cpp"))
                + " " + filename + " && ./" + filename.substring(0, filename.indexOf(".cpp")), "-o", filename);
    }

    @Override
    public boolean isObjectOriented() {
        return true;
    }

    @Override
    public void printStrengths() {
        System.out.println("C++ brings together low-level management with high-level object-oriented features.");
    }

    @Override
    public void printWeaknesses() {
        System.out.println("C++ is a large, complex language and requires manual memory management.");
    }

    @Override
    public String toString() {
        String s = "One of the compilers C++ uses is the " + getCompiler() + " compiler. " + "It has file " +
                "extensions with " + getExtension() + ". To run the file " + getFilename() + " you would need the " +
                "following command: " + getRunConfig();
        return s;
    }
}
