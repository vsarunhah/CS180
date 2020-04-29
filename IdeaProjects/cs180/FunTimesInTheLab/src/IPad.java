public class IPad implements Computer{
    private final int scWidth;
    private final int scHeight;
    private final String operatingSystem;

    public IPad(int scWidth, int scHeight){
        this.scWidth = scWidth;
        this.scHeight = scHeight;
        operatingSystem = "iPadOS";

    }
    @Override
    public int screenWidth() {
        return scWidth;
    }

    @Override
    public int screenHeight() {
        return scHeight;
    }

    @Override
    public boolean hasTouchscreen() {
        return true;
    }

    @Override
    public boolean hasKeyboard() {
        return false;
    }

    @Override
    public String nameOfOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public String toString(){
        return "iPad["+ screenWidth() + ", " + screenHeight() + ", " + nameOfOperatingSystem()+"]";
    }
}
