import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Request Handler
 *
 * @author Varun Shah
 * @author Rahul Kolli
 * @version 1.0
 */
public final class ServerRequestHandler implements Runnable {
    Alaska alaska;
    Delta delta;
    Southwest southwest;
    private Socket clientSocket;
    HashMap<String, String> passengerList = new HashMap<String, String>();

    public ServerRequestHandler(Socket clientSocket) throws NullPointerException {
        Objects.requireNonNull(clientSocket, "the specified client socket is null");

        this.clientSocket = clientSocket;
    } //CountdownRequestHandler

    @Override
    public void run() {
        BufferedReader reader = null;
        //while (true) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream objectWriter = new ObjectInputStream(clientSocket.getInputStream());
            while (true) {
                System.out.println("came here");
                char request = objectWriter.readChar();
                System.out.println(request + " waiting for more");
                while (request == 'a') {
                    //System.out.println("requested");
                    writeObject(oos, alaska);
                    //System.out.println("southwest?" + southwest.getTotalPassengers());
                    writeObject(oos, southwest);
                    //System.out.println("southwest " + southwest.getTotalPassengers());
                    writeObject(oos, delta);
                    oos.flush();
                    System.out.println("gave it");
                    request = objectWriter.readChar();
                }
                Object readThing = objectWriter.readObject();
                if (readThing instanceof Alaska) {
                    System.out.println("Got alaska");
                    alaska = (Alaska) readThing;
                } else if (readThing instanceof Southwest) {
                    System.out.println("Got Southwest");
                    southwest = (Southwest) readThing;
                } else if (readThing instanceof Delta) {
                    System.out.println("Got Delta");
                    delta = (Delta) readThing;
                }
                //System.out.println("outside if, before loops again");
                addPassengerToFile(alaska, delta, southwest);
                //System.out.println("wrote");

                char obj = objectWriter.readChar();
                System.out.println(request + " noice");
                while (obj == 'a') {
                    File f = new File("");
                    String abs = f.getAbsolutePath();
                    File writingTo = new File(abs + "/src/reservations.txt");
                    readFile(writingTo);
                    //System.out.println("requested");
                    writeObject(oos, alaska);
                    System.out.println("wrote");
                    //System.out.println("southwest?" + southwest.getTotalPassengers());
                    writeObject(oos, southwest);
                    System.out.println("wrote2");
                    //System.out.println("southwest " + southwest.getTotalPassengers());
                    writeObject(oos, delta);
                    System.out.println("wrote3");
                    oos.flush();
                    System.out.println("gave it");
                    request = objectWriter.readChar();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
        }
    }
    //}

    public Alaska getAlaska() {
        //System.out.println(alaska.getTotalPassengers());
        return alaska;
    }

    public void setAlaska(Alaska alaska) {
        this.alaska = alaska;
    }

    public Delta getDelta() {
        return delta;
    }

    public void setDelta(Delta delta) {
        this.delta = delta;
    }

    public Southwest getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

    public void writeObject(ObjectOutputStream os, Object o) {
        try {
            os.writeObject(o);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addPassengerToFile(Alaska a, Delta d, Southwest s) {
        String fileString = "ALASKA\n" + alaska.getTotalPassengers() + "/" + alaska.getTotalPossible();
        fileString += "\nAlaska passenger list\n";
        for (int i = 0; i < alaska.passList.size(); i++) {
            fileString += alaska.passList.get(i) + "\n---------------------ALASKA\n";
        }
        fileString += "\nDELTA\n" + delta.getTotalPassengers() + "/" + delta.getTotalPossible();
        fileString += "\nDelta passenger list\n";
        for (int i = 0; i < delta.passList.size(); i++) {
            fileString += delta.passList.get(i) + "\n---------------------Delta\n";
        }
        fileString += "\nSOUTHWEST\n" + southwest.getTotalPassengers() + "/" + southwest.getTotalPossible();
        fileString += "\nSouthwest passenger list\n";
        for (int i = 0; i < southwest.passList.size(); i++) {
            fileString += southwest.passList.get(i) + "\n---------------------Southwest\n";
        }
        fileString += "\nEOF\n";


        File f = new File("");
        String abs = f.getAbsolutePath();
        File writingTo = new File(abs + "/src/reservations.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(writingTo.getAbsolutePath()));
            writer.write(fileString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(File file) {
        alaska = new Alaska();
        southwest = new Southwest();
        delta = new Delta();
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
}
