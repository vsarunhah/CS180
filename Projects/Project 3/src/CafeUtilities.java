import java.io.*;

/**
 * @author varun
 * @version 1.0
 */
public final class CafeUtilities {
    private CafeUtilities() {
    }

    public static Cafe readFromFile(File file) throws NullPointerException, IOException, ClassNotFoundException {
        Cafe cafe = new Cafe();
        if (file == null) {
            throw new NullPointerException();
        }
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            try {
                cafe = (Cafe) oi.readObject();
                oi.close();
                return cafe;
            } catch (Exception e) {
                throw new ClassNotFoundException();
            }
        } catch (Exception e) {
            throw new IOException();
        }

    }

    public static void saveToFile(Cafe cafe, File file) throws NullPointerException, IOException {
        if (cafe == null || file == null) {
            throw new NullPointerException();
        }
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(cafe);
        o.flush();
        o.close();
    }
}
