import java.io.File;

/**
 * @author varun
 * @version 1
 */
public abstract class CommonFile {
    private boolean canOpen;
    private boolean canPlay;
    private java.io.File file;
    private long fileSizeInBytes;
    private String programToOpenIn;

    public CommonFile() {
        this.canOpen = false;
        this.canPlay = false;
        this.programToOpenIn = null;
    }

    public CommonFile(boolean canOpen, boolean canPlay, String programToOpenIn) {
        this.canOpen = canOpen;
        this.canPlay = canPlay;
        this.programToOpenIn = programToOpenIn;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CommonFile) {
            CommonFile cf = (CommonFile) o;
            return cf.canPlay == this.canPlay && cf.canOpen == this.canOpen
                    && cf.programToOpenIn.equals(this.programToOpenIn);
        }
        return false;
    }

    public String getExtension() {
        File f = this.getFile();
        String s = f.getName();
        String substring = s.substring(s.indexOf("."));
        return substring;
    }

    public boolean getOpenable() {
        return canOpen;
    }

    public void setCanOpen(boolean canOpen) {
        this.canOpen = canOpen;
    }

    public boolean getPlayable() {
        return canPlay;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
        setFileSizeInBytes(file.length());
    }

    public long getFileSizeInBytes() {
        return fileSizeInBytes;
    }

    public void setFileSizeInBytes(long fileSizeInBytes) {
        this.fileSizeInBytes = fileSizeInBytes;
    }

    public String getOpensWith() {
        return programToOpenIn;
    }

    public void setProgramToOpenIn(String programToOpenIn) {
        this.programToOpenIn = programToOpenIn;
    }

    public abstract String getFileType();

    @Override
    public String toString() {
        return "CommonFile[" + getFileSizeInBytes() + ", " + getExtension() + "]";
    }
}
