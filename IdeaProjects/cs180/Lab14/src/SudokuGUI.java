import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SudokuGUI {

    public void initGridGUI() {
        //TODO: create JFrame and gridGUI of JPanels within the JFrame
        JPanel[][] gridGUI = new JPanel[9][9];
        JFrame frame = new JFrame("Sudoku");
        frame.setSize(720,720);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        LayoutManager gridLayout = new GridLayout(9,9);
        frame.setLayout(gridLayout);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                gridGUI[i][j] = new JPanel();
                JPanel currentPanel = gridGUI[i][j];
                currentPanel.setBorder(blackline);
                frame.add(currentPanel);
            }
        }
        //frame.setVisible(true);
        //TODO: loop through each JPanel and add either a label or a TextField based on the value of that location in
        // the solution (SudokuModel.game[i][j]).
        //if value is zero, in addition to the JTextField, include the code below
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int x = i;
                int y = j;
                JPanel currentPanel = gridGUI[i][j];
                if(SudokuModel.game[i][j] != 0){
                    JLabel num = new JLabel(String.valueOf(SudokuModel.game[i][j]));
                    currentPanel.add(num);
                }
                else{
                    JTextField jt = new JTextField(1);
                    jt.setMinimumSize(new Dimension(70,70));
                    jt.setSize(new Dimension(70,70));
                    currentPanel.add(jt);
                    JLabel jl = new JLabel(Integer.toString(0));
                    jl.setVisible(false);
                    currentPanel.add(jl);
                    KeyListener enterListener = new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                int in = Integer.parseInt(jt.getText());
                                if (checkValid(x, y, in)) {
                                    jt.setVisible(false);
                                    jl.setText(Integer.toString(in));
                                    jl.setVisible(true);
                                    gridGUI[x][y].add(jl);
                                }
                            }
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {

                        }
                    };
                    jt.addKeyListener(enterListener);
                }
            }
        }
        //TODO: create keyListener for the 'enter' key
        //when the enter key is pressed the following code should be run (note: this assumes jt is the name of the
        // JTextField variable)
        frame.setVisible(true);
    }

    private boolean checkValid(int x, int y, int in){
        if (SudokuModel.solution[x][y]==in){
            return true;
        }return false;
    }

    public static void main(String[] args) {
        SudokuGUI gui = new SudokuGUI();
        SudokuModel sm = new SudokuModel();
        gui.initGridGUI();
    }
}
