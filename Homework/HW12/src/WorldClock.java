import javax.swing.*;
import java.util.ArrayList;

/**
 * WordClock.java
 * <p>
 * Converts time from one timezone to another using simple GUI
 *
 * @author Varun Shah
 * @version 2019-14-11
 */
public class WorldClock {
    static final String TITLE = "World Clock";
    static final String[][] LOCATIONS = {
            {"Pago Pago"},  //-11
            {"Honolulu", "Papeete"},   //-10
            {"Anchorage"},  //-9
            {"Vancouver", "Los Angeles"},    //-8
            {"Edmonton", "Denver"},  //-7
            {"Mexico City", "Chicago"},  //-6
            {"Miami", "Toronto", "New York"}, //-5
            {"Santiago", "Halifax"}, //-4
            {"Rio De Janeiro"}, //-3
            {"King Edward Point"}, //-2
            {"Praia"},  //-1
            {"UTC", "Lisbon", "London"},  //0
            {"Madrid", "Paris", "Rome", "Berlin", "Stockholm"}, //+1
            {"Athens", "Cairo", "Jerusalem"}, //+2
            {"Moscow", "Jeddah"},    //+3
            {"Dubai"},  //+4
            {"Karachi"},    //+5
            {"Dhaka"},  //+6
            {"Bangkok"},    //+7
            {"Singapore", "Hong Kong", "Beijing", "Taipei"},   //+8
            {"Seoul", "Tokyo"}, //+9
            {"Guam", "Sydney"}, //+10
            {"Noumea"}, //+11
            {"Wellington"}  //+12
    };

    public static void main(String[] args) {
        boolean doAgain = true;
        String currTime = "";
        int choice = JOptionPane.showConfirmDialog(null, "Welcome to the World Clock",
                "World Clock", JOptionPane.OK_CANCEL_OPTION);
        if (choice == JOptionPane.OK_OPTION) {
            ArrayList<String> places = new ArrayList<String>();
            for (int i = 0; i < LOCATIONS.length; i++) {
                for (int j = 0; j < LOCATIONS[i].length; j++) {
                    places.add(LOCATIONS[i][j]);
                }
            }
            String startPlace = (String) JOptionPane.showInputDialog(null,
                    "Which city is in the local time zone?", "World Clock",
                    JOptionPane.INFORMATION_MESSAGE, null, places.toArray(), places.toArray()[0]);
            System.out.println(startPlace);
            if (!startPlace.equals("null")) {
                boolean time = false;
                while (!time) {
                    currTime = JOptionPane.showInputDialog(null, "What is the local time?"
                            + "(0-23):(0-59)", "World Clock", JOptionPane.OK_CANCEL_OPTION);
                    if (!verifyTime(currTime)) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid time. For example, 13:30.", "World Clock",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        time = true;
                    }
                }
                while (doAgain) {
                    String nextPlace = (String) JOptionPane.showInputDialog(null,
                            "Which city is in the destination time zone?", "World Clock",
                            JOptionPane.INFORMATION_MESSAGE, null, places.toArray(), places.toArray()[0]);
                    int finalZone = getZone(nextPlace);
                    int startZone = getZone(startPlace);
                    int finalHour = finalZone - startZone +
                            Integer.parseInt(currTime.substring(0, currTime.indexOf(":")));
                    int nextDay = (finalHour > 23) ? -1 : (finalHour < 0) ? 1 : 0;
                    if (nextDay == -1) {
                        finalHour = finalHour - 24;
                    } else if (nextDay == 1) {
                        finalHour = finalHour + 24;
                    }
                    String hour = String.valueOf(finalHour);
                    if (finalHour < 10) {
                        hour = "0" + hour;
                    }
                    String message = "In " + nextPlace + " it is " + hour + ":" +
                            currTime.substring(currTime.indexOf(":") + 1);
                    if (nextDay == -1) {
                        message += " in the next day";
                    } else if (nextDay == 1) {
                        message += " in the day before";
                    }
                    message += ".";
                    String[] opts = new String[]{"Enter Next Destination", "Quit"};
                    JOptionPane.showMessageDialog(null, message, "World Clock",
                            JOptionPane.PLAIN_MESSAGE);

                    int kk = JOptionPane.showOptionDialog(null,
                            "Continue with the World Clock?", "World Clock",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
                    if (kk == 1) {
                        doAgain = false;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Thank you for using the World Clock",
                "World Clock", JOptionPane.PLAIN_MESSAGE);
    }

    public static boolean verifyTime(String time) {
        if (!time.contains(":")) {
            return false;
        }
        String[] hNt = time.split(":");
        if (Integer.parseInt(hNt[0]) > 23 || Integer.parseInt(hNt[0]) < 0 || hNt[0].length() != 2 ||
                hNt[1].length() != 2) {
            return false;
        }
        return Integer.parseInt(hNt[1]) <= 59 && Integer.parseInt(hNt[1]) >= 0;
    }

    public static int getZone(String place) {
        int indexOfZero = 0;
        for (int i = 0; i < LOCATIONS.length; i++) {
            if (LOCATIONS[i][0].equals("UTC")) {
                indexOfZero = i;
            }
        }
        for (int i = 0; i < LOCATIONS.length; i++) {
            for (int j = 0; j < LOCATIONS[i].length; j++) {
                if (place.equals(LOCATIONS[i][j])) {
                    return i - indexOfZero;
                }
            }
        }
        return -1;
    }
}
