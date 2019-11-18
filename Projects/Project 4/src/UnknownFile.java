/**
 * @author varun
 * @version 1
 */
public class UnknownFile extends CommonFile {
    public UnknownFile(java.io.File unknownFile) throws InvalidFileException {
        super(false, false, "Unknown Program");
        String fileName = unknownFile.getName();
        if (fileName.lastIndexOf(".") != fileName.indexOf(".")) {
            throw new InvalidFileException();
        }
        super.setFile(unknownFile);
    }

    @Override
    public String getFileType() {
        return "Unknown";
    }

    @Override
    public String toString() {
        return "UnknownFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof UnknownFile) {
            UnknownFile u = (UnknownFile) o;
            return u.getPlayable() == getPlayable() && u.getOpenable() == getOpenable() &&
                    u.getFileSizeInBytes() == getFileSizeInBytes() && u.getOpensWith().equals(getOpensWith()) &&
                    u.getFile().equals(getFile());
        }
        return false;
    }
}
