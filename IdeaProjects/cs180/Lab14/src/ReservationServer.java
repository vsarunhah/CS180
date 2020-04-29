import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Reservation Server - main server class
 *
 * @author Rahul Kolli
 * @author Varun Shah
 * @version 1.0
 */
public class ReservationServer {
    Delta delta;
    Alaska alaska;
    Southwest southwest;
    HashMap<String, String> passengerList = new HashMap<String, String>();
    /**
     * The server socket of this server.
     */
    private ServerSocket serverSocket;

    /**
     * Constructs a newly allocated {@code CensoringServer} object with the bad words in the specified file.
     *
     * @param file the file to be used in construction
     * @throws NullPointerException if the specified file is {@code null}
     * @throws IOException          if an I/O exception occurred
     */
    public ReservationServer(File file) throws NullPointerException, IOException {
        BufferedReader reader;
        String line;
        delta = new Delta();
        southwest = new Southwest();
        alaska = new Alaska();
        Objects.requireNonNull(file, "the specified file is null");

        this.serverSocket = new ServerSocket(0);
        //this.badWords = new HashSet<>();

        reader = new BufferedReader(new FileReader(file));

        //line = reader.readLine();
        String s = "";
        //passengerList = setPassengerList(file);
        readFile(file);
        reader.close();
    } //CensoringServer

    public static void main(String[] args) {
        ReservationServer server;

        try {
            //server = new CensoringServer(new File("Lab 12/badWords.txt"));
            //File f = new File("");
            //String abs = f.getAbsolutePath();
            URL path = ReservationServer.class.getResource("reservations.txt");
            File f = new File(path.getFile());
            server = new ReservationServer(f);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } //end try catch

        server.serveClients();
    } //main

    /**
     * Serves the clients that connect to this server.
     */
    public void serveClients() {
        Socket clientSocket;
        ServerRequestHandler handler;
        Thread handlerThread;
        int clientCount = 0;

        System.out.printf("<Now serving clients on port %d...>%n", this.serverSocket.getLocalPort());

        while (true) {
            try {
                clientSocket = this.serverSocket.accept();
                handler = new ServerRequestHandler(clientSocket);

                handler.setAlaska(getAlaska());
                handler.setSouthwest(getSouthwest());
                handler.setDelta(getDelta());
                handlerThread = new Thread(handler);
                handlerThread.start();
                System.out.printf("<Client %d connected...>%n", clientCount);

                clientCount++;
            } catch (IOException e) {
                e.printStackTrace();

                return;
            } //end try catch

//            handlerThread = new Thread(new CensoringRequestHandler(clientSocket, this.badWords));
//
//            handlerThread.start();
        } //end while
    } //serveClients

    @Override
    public String toString() {
        String format = "ReservationServer[%s, %s]";

        return format;
    } //toString

    public void readFile(File file) {
        //BufferedReader bfr = new BufferedReader(file);
        String line = "";
        try {
            Scanner s = new Scanner(file);
            while (s.hasNext() && !line.equals("EOF")) {
                line = s.nextLine();
                if (line.equals("ALASKA")) {
                    line = s.nextLine();
                    //System.out.println(line);
                    String[] maxPass = line.split("/");
                    //System.out.println(maxPass[1]);
                    s.nextLine();
                    alaska.setTotalPossible(Integer.parseInt(maxPass[1]));
                    //System.out.println(alaska.getTotalPossible());
                    while (!line.equals("") && !line.equals(null)) {
                        line = s.nextLine();
                        if (line.charAt(0) == '-') {
                            line = s.nextLine();
                        }

                        if (!line.equals("")) {
                            alaska.addPassenger(line);
                            passengerList.put("ALASKA", line);
                        }
                        //System.out.println(line);
                        //System.out.println(alaska.passList.get(0));
                    }
                    //line = s.nextLine();
                    //System.out.println(line);
                } else if (line.equals("DELTA")) {
                    line = s.nextLine();
                    //System.out.println(line);
                    String[] maxPass = line.split("/");
                    //System.out.println(maxPass[1]);
                    s.nextLine();
                    delta.setTotalPossible(Integer.parseInt(maxPass[1]));
                    //System.out.println(delta.getTotalPossible());
                    //System.out.println(alaska.getTotalPossible());
                    while (!line.equals("") && !line.equals(null)) {
                        line = s.nextLine();
                        if (line.charAt(0) == '-') {
                            line = s.nextLine();
                        }
                        if (!line.equals("")) {
                            delta.addPassenger(line);
                            passengerList.put("DELTA", line);
                        }
                        //System.out.println(delta.getTotalPassengers());
                        //System.out.println(line);
                    }
                } else if (line.equals("SOUTHWEST")) {
                    line = s.nextLine();
                    //System.out.println(line);
                    String[] maxPass = line.split("/");
                    //System.out.println(maxPass[1]);
                    s.nextLine();
                    southwest.setTotalPossible(Integer.parseInt(maxPass[1]));
                    //System.out.println(alaska.getTotalPossible());
                    while (!line.equals("") && !line.equals(null)) {
                        line = s.nextLine();
                        if (line.charAt(0) == '-') {
                            line = s.nextLine();
                        }
                        if (!line.equals("")) {
                            southwest.addPassenger(line);
                            passengerList.put("SOUTHWEST", line);
                            //System.out.println(line);
                        }
                        //System.out.println(line + " e");
                        //System.out.println(southwest.getTotalPassengers());
                        //System.out.println(line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Alaska getAlaska() {
        return alaska;
    }

    public Delta getDelta() {
        return delta;
    }

    public Southwest getSouthwest() {
        return southwest;
    }
}
