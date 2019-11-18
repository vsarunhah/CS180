/**
 * @author varun
 * @version 1.0
 */
public abstract class ProgrammingLanguage {
    private String compiler;
    private String extension;
    private String runConfig;
    private String flags;
    private String filename;

    public ProgrammingLanguage(String compiler, String extension, String runConfig, String flags, String filename) {
        this.compiler = compiler;
        this.extension = extension;
        this.runConfig = runConfig;
        this.flags = flags;
        this.filename = filename;
    }

    public String getCompiler() {
        return compiler;
    }

    public void setCompiler(String compiler) {
        this.compiler = compiler;
    }

    public abstract boolean isObjectOriented();

    public String getExtension() {
        return extension;
    }

    public void setExtension(String ext) {
        this.extension = ext;
    }

    public String getFlags() {
        return flags;
    }

    public String getRunConfig() {
        return runConfig;
    }

    public void setRunConfig(String runConfig) {
        this.runConfig = runConfig;
    }

    public void addFlag(String flag) {
        this.flags = this.flags + " " + flag;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ProgrammingLanguage) {
            ProgrammingLanguage pl = (ProgrammingLanguage) o;
            return pl.getCompiler().equals(getCompiler()) && pl.getFlags().equals(getFlags()) &&
                    pl.getRunConfig().equals(getRunConfig()) && isObjectOriented();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Unknown Programming Language";
    }

    public abstract void printStrengths();

    public abstract void printWeaknesses();
}