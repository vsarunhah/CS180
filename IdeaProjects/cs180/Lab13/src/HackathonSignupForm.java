import javax.naming.InvalidNameException;
import javax.swing.*;
import java.awt.*;

class HackathonSignupForm implements Runnable {

    public void run() {
        String firstName = "";
        String lastName = "";
        String age;
        String major = "";
        String numHackathonsAttended;
        int hasAttendedHackathonsBefore;
        int allFieldsLookCorrect;
        boolean correctFirstName;
        boolean correctLastName;
        boolean correctMajor;
        String[] ageChoices = {"18", "19", "20", "21", "22", "23", "24", "25", "25+"};
        // DO NOT MODIFY ABOVE
        boolean valid = false;
        JOptionPane.showMessageDialog(null, "Welcome to CS 180 Hackathon! Before you can " +
                        "begin hacking, we just need you to fill in a few details.", "CS180 Hackathon Signup Form",
                JOptionPane.INFORMATION_MESSAGE);
        while (!valid) {
            boolean first = false;
            while(!first) {
                firstName = JOptionPane.showInputDialog(null, "What is your first name?",
                        "First name?", JOptionPane.QUESTION_MESSAGE);
                try {
                    verifyNameOrMajor(firstName);
                    first = true;
                } catch (InvalidNameException e) {
                    JOptionPane.showMessageDialog(null, "Please input a valid name!");
                }
            }
            boolean last = false;
            while(!last) {
                lastName = JOptionPane.showInputDialog(null, "What is your last name?",
                        "Last name?", JOptionPane.QUESTION_MESSAGE);
                try {
                    verifyNameOrMajor(lastName);
                    last = true;
                } catch (InvalidNameException e) {
                    JOptionPane.showMessageDialog(null, "Please input a valid name!");
                    //lastName = JOptionPane.showInputDialog(null, "What is your last name?",
                            //"Last name?", JOptionPane.QUESTION_MESSAGE);
                }
            }

            age = (String) JOptionPane.showInputDialog(null, "How old are you? Choose from the choices below.",
                    "Age?", JOptionPane.QUESTION_MESSAGE, null, ageChoices, ageChoices[0]);

            boolean maj = false;
            while(!maj) {
                major = JOptionPane.showInputDialog(null, "What is your major?",
                        "Major?", JOptionPane.QUESTION_MESSAGE);
                try {
                    verifyNameOrMajor(major);
                    maj = true;

                } catch (InvalidNameException e) {
                    JOptionPane.showMessageDialog(null, "Please make sure your major contians no numbers!!");
                    //major = JOptionPane.showInputDialog(null, "What is your major?",
                           // "Major?", JOptionPane.QUESTION_MESSAGE);
                }
            }
            // DO NOT MODIFY BELOW
            hasAttendedHackathonsBefore = JOptionPane.showConfirmDialog(null, "Have you attended any " +
                    "hackathons before?", "Prior Experience", JOptionPane.YES_NO_OPTION);
            if (hasAttendedHackathonsBefore == JOptionPane.YES_OPTION) {
                numHackathonsAttended = JOptionPane.showInputDialog(
                        null, "How many hackathons have attended?", "Prior Experience",
                        JOptionPane.QUESTION_MESSAGE);
            } else {
                numHackathonsAttended = "No";
            }
            String message = "Please make sure your information is correct.\nName: " + firstName + " " + lastName + "\n" +
                    "Age: " + age + "\nMajor: " + major + "\nHackathons Attended Before: ";
            if (numHackathonsAttended.equals("No")) {
                message += "No";
            } else {
                message += "Yes\nNumber of Hackathons Attended Before: " + numHackathonsAttended;
            }
            int confirmed = JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for the info! Happy Hacking!",
                        "Thank you!", JOptionPane.PLAIN_MESSAGE);
                valid = true;
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new HackathonSignupForm());
    }

    private static void verifyNameOrMajor(String name) throws InvalidNameException {
        if (name == null) {
            throw new InvalidNameException("Can't input a null name!");
        }

        if (name.equals("")) {
            throw new InvalidNameException("Can't input an empty name!");
        }

        char[] nameAsChars = name.toCharArray();

        for (char c : nameAsChars) {
            if (Character.isDigit(c)) {
                throw new InvalidNameException("Name can only have letters! No digits!");
            }
        }
    }
}