import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

/**
 * @author varun
 * @version 1
 */
public class TextFile extends CommonFile {
    private long numberOfLines;

    public TextFile(java.io.File text) throws IOException, InvalidTextFileException {
        super(true, false, "TextEdit");
        FileReader fr = new FileReader(text);
        LineNumberReader lnr = new LineNumberReader(fr);
        int linenumber = 0;
        while (lnr.readLine() != null) {
            linenumber++;
        }
        if (linenumber <= 0) {
            throw new InvalidTextFileException();
        }
        this.numberOfLines = linenumber;
        super.setFile(text);
    }

    @Override
    public String getFileType() {
        return "Text";
    }

    public long getLines() {
        return numberOfLines;
    }

    public long getOccurrences(String charSequence) throws IOException {
        Scanner scanner = new Scanner(getFile());
        long found = 0;
        try (LineNumberReader r = new LineNumberReader(new FileReader(getFile().getName()))) {
            String line;
            while ((line = r.readLine()) != null) {
                for (String element : line.split(" ")) {
                    if (element.equalsIgnoreCase(charSequence)) {
                        found++;
                    }
                }
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return "TextFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName() + ", " +
                getLines() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TextFile) {
            TextFile t = (TextFile) o;
            return super.equals(t) && t.getFileSizeInBytes() == getFileSizeInBytes() && t.getLines() == getLines()
                    && t.getFile() == getFile();
        }
        return false;
    }

}
