import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author varun
 * @version 1
 */
public class ImageFile extends CommonFile {
    private int imageHeight;
    private int imageWidth;
    private boolean isAnimated;

    public ImageFile(java.io.File image) throws InvalidImageFileException, IOException {
        super(true, false, "Preview");
        BufferedImage bimg = ImageIO.read(image);
        if (bimg.getHeight() < 0 || bimg.getWidth() < 0) {
            throw new InvalidImageFileException();
        }
        imageHeight = bimg.getHeight();
        imageWidth = bimg.getWidth();
        super.setFile(image);
        if (getExtension().equals("gif")) {
            isAnimated = true;
        }
    }

    @Override
    public String getFileType() {
        return "Image";
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public boolean animated() {
        return isAnimated;
    }

    @Override
    public String toString() {
        return "ImageFile[" + getFileType() + ", " + getFileSizeInBytes() + ", " + getFile().getName() + ", " +
                getImageHeight() + "x" + getImageWidth() + ", " + animated() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ImageFile) {
            ImageFile f = (ImageFile) o;
            return super.equals(f) && this.animated() == f.animated() && getImageWidth() == f.getImageWidth() &&
                    getImageHeight() == f.getImageHeight() && getFile().equals(f.getFile());
        }
        return false;
    }
}
