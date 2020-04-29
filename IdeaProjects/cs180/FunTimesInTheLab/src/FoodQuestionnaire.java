import javax.swing.*;
public class FoodQuestionnaire {
    public static void main(String[] args){
        String food = JOptionPane.showInputDialog("What food would you like to eat?");
        JOptionPane.showMessageDialog(null, "Great choice! You can never go wrong with " + food + ".");
    }
}
