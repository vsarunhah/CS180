public class Acer implements Computer{
    private final int scWidth;
    private final int scHeight;
    private final String operatingSystem;

    public Acer(int scWidth, int scHeight){
        this.scWidth = scWidth;
        this.scHeight = scHeight;
        operatingSystem = "Windows 10";

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
        return false;
    }

    @Override
    public boolean hasKeyboard() {
        return true;
    }

    @Override
    public String nameOfOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public String toString(){
        return "Acer["+screenWidth() + ", " + screenHeight() + ", " + nameOfOperatingSystem()+"]";}
}
