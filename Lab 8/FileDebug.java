import java.io.*;
import java.util.Scanner;

public class FileDebug {

    public static void main(String [] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("What is the name of the file?");
        String f = s.nextLine();
        File file = new File(f);
        write(file);
        read(file);
    }

    public static void write(File f) throws IOException {
        FileWriter fw = new FileWriter(f, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("Here's the first Line!");
        pw.println("Here's the second Line!");
        pw.println("Here's the third Line!");
        pw.close();
        fw.close();

    }

    public static void read(File f) throws IOException {
       
        BufferedReader bfr = new BufferedReader(new FileReader(f));
        String line;
        while((line = bfr.readLine()) != null) {
            System.out.println(line);
        }

        bfr.close(); 
    }
}
