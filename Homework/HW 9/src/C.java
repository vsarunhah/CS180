/**
 * @author varun
 * @version 1.0
 */
public class C extends ProgrammingLanguage {
    public C(String compiler, String extension, String runConfig, String flags, String fileName) {
        super(compiler, extension, runConfig, flags, fileName);
    }

    public C(String filename) {
        super("gcc", ".c", "gcc " + "-o " + filename.substring(0, filename.indexOf(".c")) +
                " " + filename + " && ./" + filename.substring(0, filename.indexOf(".c")), "-o", filename);
    }

    @Override
    public boolean isObjectOriented() {
        return false;
    }

    @Override
    public void printStrengths() {
        System.out.println("C is a small language and provides programmers with low-level control.");
    }

    @Override
    public void printWeaknesses() {
        System.out.println("C allows programmers to perform potentially dangerous actions with few checks.");
    }

    @Override
    public String toString() {
        return "C uses the " + getCompiler() + " compiler, has file extensions with " + getExtension() +
                " and to run the file " + getFilename() + " you would need the following command: " + getRunConfig();
    }
}
