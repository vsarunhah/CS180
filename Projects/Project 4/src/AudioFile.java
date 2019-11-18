/**
 * @author varun
 * @version 1
 */
public class AudioFile extends CommonFile {
    private int songLength;

    public AudioFile(java.io.File audio, int songLengthInSeconds) throws InvalidAudioFileException {
        super(true, true, "iTunes");
        if (songLengthInSeconds < 0) {
            throw new InvalidAudioFileException();
        }
        this.songLength = songLengthInSeconds;
        super.setFile(audio);
    }

    @Override
    public String getFileType() {
        return "Audio";
    }

    public String getSongLength() {
        String s = "";
        int lengthInMinutes = songLength / 60;
        int seconds = songLength - lengthInMinutes * 60;
        s = lengthInMinutes + " minutes and " + seconds + " seconds";
        return s;
    }

    @Override
    public String toString() {
        return "AudioFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName() + ", " +
                getSongLength() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof AudioFile) {
            AudioFile af = (AudioFile) o;
            return this.getPlayable() == af.getPlayable() && this.getOpenable() == af.getOpenable() &&
                    this.getFileSizeInBytes() == af.getFileSizeInBytes() &&
                    this.getOpensWith().equals(af.getOpensWith()) && this.getFile().equals(af.getFile());
        }
        return false;
    }
}
