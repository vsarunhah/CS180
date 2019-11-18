/**
 * @author varun
 * @version 1.0
 */
public class Python extends ProgrammingLanguage {

    public Python(String compiler, String extension, String runConfig, String flags, String fileName) {
        super(compiler, extension, runConfig, flags, fileName);
    }

    public Python(String filename) {
        super("Python Virtual Machine (PVM)", ".py", "python " + filename, "",
                filename);
    }

    @Override
    public boolean isObjectOriented() {
        return true;
    }

    @Override
    public void printStrengths() {
        System.out.println("Python has simple syntax and is easily extensible.");
    }

    @Override
    public void printWeaknesses() {
        System.out.println("Python is slower than other languages and not suited for mobile development.");
    }

    @Override
    public String toString() {
        String s = "The standard version of Python uses the " + getCompiler() + " compiler. All versions of Python " +
                "have file extensions with " + getExtension() + ". To run the file " + getFilename() + " you would " +
                "need the following command: " + getRunConfig();
        return s;
    }
}
