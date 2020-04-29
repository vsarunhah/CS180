import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reservation Client - main client class
 *
 * @author Rahul Kolli
 * @author Varun Shah
 * @version 1.0
 */
public class ReservationClient {
    final static String PUARMS = "Purdue University Airline Reservation Management System";
    static String hostname;
    static String portString;
    static int port;
    static Socket socket;
    static BufferedWriter socketWriter = null;
    static BufferedReader socketReader = null;
    static ObjectInputStream socketObjectReader = null;
    static ObjectOutputStream socketObjectWriter = null;
    static Alaska al;
    static Southwest sw;
    static Delta de;
    static String airlineSelected = "";
    static KeyListener slashKeyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
                JFrame list = new JFrame();
                list.setLayout(new BorderLayout());
                JPanel north = new JPanel();
                JLabel airline = new JLabel(airlineSelected + " Airlines");
                north.add(airline);
                JLabel remaining = new JLabel();
                String rem = "";
                JPanel center = new JPanel();
                JScrollPane passengerList;
                JTextArea listOfPass = new JTextArea("", 10, 50);
                listOfPass.setEditable(false);
                String passList = "";
                if (airlineSelected.equals("Alaska")) {
                    //System.out.println(al.passList);
                    rem += al.getTotalPassengers() + " : " + al.getTotalPossible();
                    for (int i = 0; i < al.getTotalPassengers(); i++) {
                        passList += al.passList.get(i) + "\n";
                    }
                } else if (airlineSelected.equals("Delta")) {
                    rem += de.getTotalPassengers() + " : " + de.getTotalPossible();
                    for (int i = 0; i < de.getTotalPassengers(); i++) {
                        passList += de.passList.get(i) + "\n";
                    }
                } else if (airlineSelected.equals("Southwest")) {
                    rem += sw.getTotalPassengers() + " : " + sw.getTotalPossible();
                    for (int i = 0; i < sw.getTotalPassengers(); i++) {
                        passList += sw.passList.get(i) + "\n";
                    }
                }
                passList = passList.substring(0, passList.length() - 1);
                listOfPass.setLineWrap(true);
                listOfPass.setText(passList);
                //listOfPass.setEditable(false);
                listOfPass.setAlignmentX(10);
                passengerList = new JScrollPane(listOfPass);
                passengerList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                //passengerList.
                center.add(passengerList);
                remaining.setText(rem);
                north.add(remaining);

                JPanel south = new JPanel();
                JButton exit = new JButton("Exit");
                exit.setSize(40, 40);
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        list.dispose();
                    }
                });
                listOfPass.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
                            list.dispose();
                        }
                    }
                });
                list.setSize(600, 334);
                south.add(exit);
                list.add(north, BorderLayout.NORTH);
                list.add(center, BorderLayout.CENTER);
                list.add(south, BorderLayout.SOUTH);
                exit.requestFocus();
                list.setVisible(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
    String request;
    String response;

    private static boolean isParsable(String string) {
        return string.chars()
                .mapToObj(Character::isDigit)
                .reduce(Boolean::logicalAnd)
                .orElse(Boolean.FALSE);
    } //isParsable

    public static void main(String[] args) {
        boolean connection = connectToServer();
        if (connection) {
            stage2();
        }

    }

    //gui method with connection to ReservationServer
    public static boolean connectToServer() {
        try {
            //System.out.print("Enter the sever's hostname: ");
            hostname = JOptionPane.showInputDialog(null, "What is the hostname you'd like to " +
                    "connect to?", "Hostname?", JOptionPane.PLAIN_MESSAGE);
            System.out.println(hostname);
            if (hostname == null) {
                JOptionPane.showMessageDialog(null,
                        "Thank you for using Purdue University's Airline Reservation Management System",
                        "Bye", JOptionPane.PLAIN_MESSAGE);
                return false;
            }
            while (hostname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a hostname");
                hostname = JOptionPane.showInputDialog(null, "What is the hostname you'd like "
                        + "to connect to?", "Hostname?", JOptionPane.PLAIN_MESSAGE);
            }
            //System.out.print("Enter the sever's port: ");

            portString = JOptionPane.showInputDialog(null, "What is the port you'd like " +
                    "to connect to?", "Port?", JOptionPane.PLAIN_MESSAGE);
            if (portString == null) {
                JOptionPane.showMessageDialog(null,
                        "Thank you for using Purdue University's Airline Reservation Management System",
                        "Bye", JOptionPane.PLAIN_MESSAGE);
                return false;
            }
            while (portString == null || !isParsable(portString)) {
                JOptionPane.showMessageDialog(null, "Please enter a port number");
                portString = JOptionPane.showInputDialog(null,
                        "What is the port you'd like to connect to?", "Port?", JOptionPane.ERROR_MESSAGE);
            }
            port = Integer.parseInt(portString);
            socket = new Socket(hostname, port);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to host, please try again " +
                    "later.", "Error Connecting", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to host, please try again " +
                    "later.", "Error Connecting", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please contact technical support",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketObjectWriter = new ObjectOutputStream(socket.getOutputStream());
            socketObjectReader = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    //stage 2
    public static void stage2() {
        //set up jframe
        JFrame frame = new JFrame(PUARMS);
        frame.setLayout(new BorderLayout());
        frame.setSize(900, 450);
        frame.setLocationRelativeTo(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        //set up welcome
        JLabel welcome = new JLabel("Welcome to the " + PUARMS + "!");
        frame.add(welcome, BorderLayout.NORTH);

        //set up picture
        //File f = new File("");
        //String abs = f.getAbsolutePath();
        //ImageIcon icon = new ImageIcon(abs + "/src/purdue_.png");
        URL path = ReservationServer.class.getResource("purdue_.png");
        File f = new File(path.getFile());
        ImageIcon icon = new ImageIcon(f.getAbsolutePath());
        frame.add(new JLabel(icon), BorderLayout.CENTER);

        //add buttons to bottom
        JButton exit = new JButton("Exit");
        JButton book = new JButton("Book a flight");
        exit.addActionListener(e -> {
            frame.setVisible(false);
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Thank you for using the Purdue " +
                    "University Airline Reservation Management", "Quit", JOptionPane.PLAIN_MESSAGE);
        });
        book.addActionListener(e -> {
            frame.dispose();
            stage3();
        });
        JPanel southButtons = new JPanel();
        southButtons.add(exit);
        southButtons.add(book);
        frame.add(southButtons, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void stage3() {
        //System.out.println(PUARMS);
        JFrame frame = new JFrame(PUARMS);
        frame.setLocationRelativeTo(null);
        frame.setSize(900, 450);
        frame.setLayout(new BorderLayout());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        //north label
        JLabel northLabel = new JLabel("<html><font size=\"10\"><div style='text-align: center;'><b>Do you want to " +
                "book a flight today?</b></div></font></html>");
        frame.add(northLabel, BorderLayout.NORTH);

        //south buttons
        JPanel southButtons = new JPanel();
        JButton exit = new JButton("Exit");
        JButton yes = new JButton("Yes, I want to book a flight.");
        exit.addActionListener(e -> {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Thank you for using the Purdue " +
                    "University Airline Reservation Management", "Quit", JOptionPane.PLAIN_MESSAGE);
        });
        yes.addActionListener(e -> {
            //System.out.println("it's working till stage 3");
            stage4();
            frame.dispose();
        });
        southButtons.add(exit);
        southButtons.add(yes);
        frame.add(southButtons, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void stage4() {
        JFrame frame = new JFrame(PUARMS);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Delta.numPassengers = new AtomicInteger(Delta.numPassengers.addAndGet(100));
        //System.out.println(Delta.numPassengers);
        frame.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        JLabel choose = new JLabel("Choose a flight from the drop down menu");
        northPanel.add(choose);
        ArrayList<String> airlines = new ArrayList<String>();
        try {
            //ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            socketWriter.flush();
            //socketObjectWriter.flush();
            System.out.println("trying to write");
            socketObjectWriter.writeChar('a');
            System.out.println("wrote to handler");
            socketObjectWriter.flush();
            al = (Alaska) socketObjectReader.readObject();

            sw = (Southwest) socketObjectReader.readObject();

            de = (Delta) socketObjectReader.readObject();

            if (al.canAddPassengers()) {
                airlines.add("Alaska");
            }
            if (de.canAddPassengers()) {
                airlines.add("Delta");
            }
            if (sw.canAddPassengers()) {
                airlines.add("Southwest");
            }
            JComboBox<Object> possibleAirlines = new JComboBox<>(airlines.toArray());
            northPanel.add(possibleAirlines);

            JTextArea airlineInfo = new JTextArea(10, 5);
            airlineInfo.setWrapStyleWord(true);
            airlineInfo.setLineWrap(true);
            airlineInfo.setOpaque(false);
            airlineInfo.setEditable(false);
            airlineInfo.setFocusable(false);

            if (airlines.get(0).equals("Alaska")) {
                airlineInfo.setText(new Alaska().toString());
                airlineSelected = "Alaska";
            } else if (airlines.get(0).equals("Delta")) {
                airlineInfo.setText(new Delta().toString());
                airlineSelected = "Delta";
            } else if (airlines.get(0).equals("Southwest")) {
                airlineInfo.setText(new Southwest().toString());
                airlineSelected = "Southwest";
            }

            possibleAirlines.addActionListener(e -> {
                if (possibleAirlines.getSelectedItem().equals("Alaska")) {
                    Alaska a = new Alaska();
                    airlineInfo.setText(a.toString());
                    airlineSelected = "Alaska";
                } else if (possibleAirlines.getSelectedItem().equals("Delta")) {
                    Delta d = new Delta();
                    airlineInfo.setText(d.toString());
                    airlineSelected = "Delta";
                } else if (possibleAirlines.getSelectedItem().equals("Southwest")) {
                    Southwest southNo = new Southwest();
                    airlineInfo.setText(southNo.toString());
                    airlineSelected = "Southwest";
                }
            });

            frame.add(new JLabel(), BorderLayout.EAST);
            frame.add(new JLabel(), BorderLayout.WEST);
            frame.add(northPanel, BorderLayout.NORTH);
            frame.add(airlineInfo, BorderLayout.CENTER);
            possibleAirlines.addKeyListener(slashKeyListener);

            JButton chooseFlight = new JButton("Choose This Flight.");
            chooseFlight.setSize(40, 50);
            JPanel south = new JPanel();
            chooseFlight.addActionListener(e -> {
                stage5();
                frame.dispose();
            });

            JButton exit = new JButton("Exit");
            exit.setSize(40, 50);
            exit.addActionListener(e -> {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Thank you for using the " + PUARMS,
                        "Quit", JOptionPane.PLAIN_MESSAGE);
            });
            south.add(exit);
            south.add(chooseFlight);
            frame.add(south, BorderLayout.SOUTH);
            frame.setLocationRelativeTo(null);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height
                    / 2);
            frame.setVisible(true);
            //Alaska alaska = (Alaska) in.readObject();

            //System.out.println(alaska);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(Delta.numPassengers);
    }

    public static void stage5() {
        JFrame frame = new JFrame(PUARMS);
        frame.setLayout(new BorderLayout());
        JPanel north = new JPanel();
        frame.setSize(600, 300);
        JLabel confirmation = new JLabel("Are you sure you want to book a flight on " + airlineSelected + " Airlines");
        north.add(confirmation);
        confirmation.addKeyListener(slashKeyListener);
        frame.add(north, BorderLayout.NORTH);
        JPanel south = new JPanel();
        south.addKeyListener(slashKeyListener);

        JButton yes = new JButton("Yes, I want this flight.");
        yes.addKeyListener(slashKeyListener);
        yes.setSize(40, 50);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterInfo();
                frame.dispose();
            }
        });
        south.add(yes);

        JButton no = new JButton("No, I want a different flight.");
        no.setSize(40, 50);
        no.addKeyListener(slashKeyListener);
        no.addActionListener(e -> {
            stage4();
            frame.dispose();
        });
        south.add(no);

        JButton exit = new JButton("Exit");
        exit.setSize(40, 50);
        exit.addKeyListener(slashKeyListener);
        exit.addActionListener(e -> {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Thank you for using the " + PUARMS,
                    "Quit", JOptionPane.PLAIN_MESSAGE);
        });
        south.add(exit);

        frame.add(south, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    public static void enterInfo() {
        JFrame frame = new JFrame(PUARMS);
        frame.setSize(new Dimension(900, 450));
        frame.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        JPanel n = new JPanel();
        JLabel label = new JLabel("<html><header><font size=\"8\">Please input your information below.\n" +
                "</font></header></html>");
        n.add(label);

        frame.add(n, BorderLayout.NORTH);

        JLabel name = new JLabel("What is your first name");
        north.add(name);

        JTextField field = new JTextField(100);
        north.add(field, BorderLayout.SOUTH);

        JLabel lName = new JLabel("What is your last name");
        north.add(lName);


        JTextField lastField = new JTextField(100);
        north.add(lastField, BorderLayout.SOUTH);
        String lastName = lastField.getText();

        JLabel age = new JLabel("What is your age?");
        north.add(age);

        JTextField ageField = new JTextField(100);
        north.add(ageField, BorderLayout.SOUTH);
        //Double ageDouble = Double.parseDouble(ageField.getText());
        frame.add(north, BorderLayout.CENTER);
        //frame.setVisible(true);


        JPanel south = new JPanel();

        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null, "Are the details you entered correct?",
                        PUARMS, JOptionPane.PLAIN_MESSAGE);
            }

        });
        south.add(exit);

        //JPanel south = new JPanel();
        JButton next = new JButton("Next");
        next.addActionListener(actionEvent -> {
            String firstName = field.getText();
            String lastName1 = lastField.getText();
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher fName = p.matcher(firstName);
            boolean first = fName.find();
            Matcher lName1 = p.matcher(lastName1);
            boolean last = lName1.find();
            if (first || last) {
                JOptionPane.showMessageDialog(null, "Names cannot contain special " +
                        "characters.", PUARMS, JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int ageDouble = Integer.parseInt(ageField.getText());
                    frame.setVisible(false);
                    int hello = JOptionPane.showConfirmDialog(null, "Are all the details " +
                                    "entered you " + "correct.\nThe passengers name is " + firstName + " " + lastName1 +
                                    " and their age " + "is " + ageDouble + ".\nIf all the information shown is " +
                                    "correct, select the " + "Yes button below, otherwise, select the No button.",
                            PUARMS, JOptionPane.YES_NO_OPTION);
                    if (hello == JOptionPane.NO_OPTION) {
                        enterInfo();
                        frame.dispose();
                    } else {
                        socketObjectWriter.writeChar('e');
                        Passenger pass = new Passenger(firstName, lastName1, ageDouble);
                        if (airlineSelected.equals("Alaska")) {
                            al.addPassenger(pass.toString());
                            socketObjectWriter.writeObject(al);
                        } else if (airlineSelected.equals("Southwest")) {
                            sw.addPassenger(pass.toString());
                            socketObjectWriter.writeObject(sw);
                        } else if (airlineSelected.equals("Delta")) {
                            de.addPassenger(pass.toString());
                            socketObjectWriter.writeObject(de);
                        }
                        stage8(pass);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid age",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    frame.setVisible(false);
                    enterInfo();
                    frame.dispose();

                }
            }
        });
        south.add(next);
        field.addKeyListener(slashKeyListener);
        lastField.addKeyListener(slashKeyListener);
        ageField.addKeyListener(slashKeyListener);
        age.addKeyListener(slashKeyListener);
        name.addKeyListener(slashKeyListener);
        lName.addKeyListener(slashKeyListener);
        exit.addKeyListener(slashKeyListener);
        next.addKeyListener(slashKeyListener);
        north.addKeyListener(slashKeyListener);
        n.addKeyListener(slashKeyListener);
        south.addKeyListener(slashKeyListener);
        frame.add(south, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);

    }

    public static void stage8(Passenger p) {
        JFrame frame = new JFrame(PUARMS);
        frame.setSize(900, 450);
        frame.setLocationRelativeTo(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setLayout(new BorderLayout());

        //north
        JPanel north = new JPanel();
        BoardingPass bp = new BoardingPass(p, airlineSelected);

        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        JLabel top = new JLabel("<html><strong>Flight data displaying for " + airlineSelected +
                " airlines.\n</strong></html>");
        north.add(top);

        JLabel middle = new JLabel("<html><strong>Enjoy your flight!</strong></html>");
        north.add(middle);

        JLabel bottom = new JLabel("<html><strong>Flight is now boarding at gate " + bp.getTerminal() +
                bp.getGate() + "</strong></html>");
        north.add(bottom);
        //north.add(flightStuff);

        frame.add(north, BorderLayout.NORTH);

        //center
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        JScrollPane passengerList;
        JTextArea listOfPass = new JTextArea(20, 30);
        listOfPass.setEditable(false);
        String passList = "";
        if (airlineSelected.equals("Alaska")) {
            passList = al.getTotalPassengers() + " : " + al.getTotalPossible() + "\n\n";
            for (int i = 0; i < al.getTotalPassengers(); i++) {
                passList += al.passList.get(i) + "\n";
            }
        } else if (airlineSelected.equals("Delta")) {
            passList = de.getTotalPassengers() + " : " + de.getTotalPossible() + "\n\n";
            for (int i = 0; i < de.getTotalPassengers(); i++) {
                passList += de.passList.get(i) + "\n";
            }
        } else if (airlineSelected.equals("Southwest")) {
            passList = sw.getTotalPassengers() + " : " + sw.getTotalPossible() + "\n\n";
            for (int i = 0; i < sw.getTotalPassengers(); i++) {
                passList += sw.passList.get(i) + "\n";
            }
        }
        passList = passList.substring(0, passList.length() - 1);
        listOfPass.setText(passList);
        listOfPass.setEditable(false);
        listOfPass.setAlignmentX(10);
        passengerList = new JScrollPane(listOfPass);
        passengerList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        passengerList
                .getViewport().setViewPosition(new Point(0, 0));
        center.add(passengerList);

        JTextArea boardingPass = new JTextArea();
        boardingPass.setEditable(false);
        boardingPass.setLineWrap(true);
        boardingPass.setWrapStyleWord(true);
        boardingPass.setFocusable(false);
        boardingPass.setText(bp.toString());
        center.add(boardingPass);

        frame.add(center, BorderLayout.CENTER);

        JPanel south = new JPanel();
        JButton exit = new JButton("Exit");
        exit.setSize(40, 50);
        exit.addActionListener(e -> {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Thank you for using the " + PUARMS,
                    "Quit", JOptionPane.PLAIN_MESSAGE);
        });
        south.add(exit);

        JButton refresh = new JButton("Refresh Flight Status");
        refresh.addActionListener(e -> {
            try {
                //socketObjectWriter.flush();
                socketObjectWriter.writeChar('a');
                socketObjectWriter.flush();
                System.out.println("og write to server");
                Alaska a = (Alaska) socketObjectReader.readObject();
                System.out.println("got al");
                Southwest s = (Southwest) socketObjectReader.readObject();
                System.out.println("got sw");
                Delta d = (Delta) socketObjectReader.readObject();
                System.out.println("got del");
                //socketObjectWriter.writeChar('e');
                System.out.println("wrote to server");
                String p1 = "";
                if (airlineSelected.equals("Alaska")) {
                    p1 = a.getTotalPassengers() + " : " + a.getTotalPossible() + "\n\n";
                    for (int i = 0; i < a.passList.size(); i++) {
                        p1 += a.passList.get(i) + "\n";
                    }
                } else if (airlineSelected.equals("Delta")) {
                    p1 = d.getTotalPassengers() + " : " + d.getTotalPossible() + "\n\n";
                    for (int i = 0; i < d.passList.size(); i++) {
                        p1 += d.passList.get(i) + "\n";
                    }
                } else if (airlineSelected.equals("Southwest")) {
                    p1 = s.getTotalPassengers() + " : " + s.getTotalPossible() + "\n\n";
                    for (int i = 0; i < s.passList.size(); i++) {
                        p1 += s.passList.get(i) + "\n";
                    }
                }
                p1 = p1.substring(0, p1.length() - 1);
                listOfPass.setText(p1);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        exit.setSize(40, 50);
        south.add(refresh);

        frame.add(south, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

}
