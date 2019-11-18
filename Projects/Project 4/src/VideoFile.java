/**
 * @author varun
 * @version 1
 */
public class VideoFile extends CommonFile {
    private long videoLengthInSeconds;

    public VideoFile(java.io.File video, long videoLength) throws InvalidVideoFileException {
        super(true, true, "Quicktime Player");
        if (videoLength < 0) {
            throw new InvalidVideoFileException();
        }
        this.videoLengthInSeconds = videoLength;
        super.setFile(video);
    }

    @Override
    public String getFileType() {
        return "Video";
    }

    public String getVideoLength() {
        long minutes = videoLengthInSeconds / 60;
        long seconds = videoLengthInSeconds - minutes * 60;
        return minutes + " minutes and " + seconds + " seconds";
    }

    @Override
    public String toString() {
        return "VideoFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName()
                + ", " + getVideoLength() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof VideoFile) {
            VideoFile v = (VideoFile) o;
            return super.equals(v) && getVideoLength().equals(v.getVideoLength()) && v.getFile().equals(getFile())
                    && v.getFileSizeInBytes() == getFileSizeInBytes();
        }
        return false;
    }
}
