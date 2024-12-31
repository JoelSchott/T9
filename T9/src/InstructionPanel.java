import javax.swing.*;
import java.awt.*;

public class InstructionPanel extends JPanel {

    public InstructionPanel(Color background, int width, int height){
        this.setLayout(new GridBagLayout());
        this.setBackground(background);
        this.setPreferredSize(new Dimension(width, height));
        JLabel label = new JLabel("<html><div style='text-align: center;'>Welcome to T9, the game<br/>of stovetop tic-tac-toe.<br/>In this game, four players<br/>take turns placing a ring<br/>on the board.<br/>There are three ways to win.<br/>The first way is to have<br/>three rings of the same size<br/>along a row, a column,<br/>or a diagonal.<br/>The second way is to have<br/>a small ring, then a medium ring,<br/>then a large ring along<br/>a row, a column, or a diagonal.<br/>The third way is to have<br/>a concentric small ring,<br/>medium ring, and large ring.</div></html>");
        this.add(label);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
