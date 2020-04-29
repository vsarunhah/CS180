import javax.swing.*;
public class PersonalizedGreeting {
    public static void main(String[] args){
        String name;
        String section;
        String greeting;

        name = JOptionPane.showInputDialog("Please enter your name ");
        section = JOptionPane.showInputDialog("Please enter your section number: ");

        greeting = "Hello " + name + ". Welcome to CS 180, section " + section + "!";
        JOptionPane.showMessageDialog(null, greeting);
    }
}
