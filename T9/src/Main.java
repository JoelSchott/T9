import javax.swing.*;
import java.awt.*;

public class Main {

    private static final int GAME_WIDTH = 600;
    private static final int INSTRUCTION_WIDTH = 200;
    private static final int MESSAGE_HEIGHT = 50;

    public static void main(String[] args){
        Game game = new Game();
        GamePanel gamePanel = new GamePanel(game, new Color(200, 150, 100), GAME_WIDTH);
        MessagePanel messagePanel = new MessagePanel(new Color(255, 255, 255), GAME_WIDTH, MESSAGE_HEIGHT);
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(gamePanel);
        leftPanel.add(messagePanel);
        InstructionPanel instructionPanel = new InstructionPanel(new Color(255, 255, 255), INSTRUCTION_WIDTH, GAME_WIDTH + MESSAGE_HEIGHT);
        JFrame frame = new JFrame("T9");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        frame.add(leftPanel);
        frame.add(instructionPanel);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        while (!game.isDone()){
            if (game.currentPlayerCanPlay()) {
                messagePanel.setMessage("<html><font color='" + game.getCurrentPlayer().getColorName() + "'>Player " + (game.getTurn() + 1) + "</font>, select a ring</html>");
                frame.repaint();
                // wait for player ring selection
                while (game.getCurrentPlayer().getSelection() == Selection.NONE) {
                    sleep();
                }
                messagePanel.setMessage("<html><font color='" + game.getCurrentPlayer().getColorName() + "'>Player " + (game.getTurn() + 1) + "</font>, place the ring or select a new ring</html>");
                frame.repaint();
                // wait for the player to place the ring
                while (game.getCurrentPlayer().getSelection() != Selection.NONE) {
                    sleep();
                }
            }
            game.nextTurn();
        }
        if (game.getBoard().hasWinner()){
            messagePanel.setMessage("<html>Congratulations <font color='" + game.getPlayer(game.getBoard().getWinner()).getColorName() + "'>Player " + (game.getBoard().getWinner() + 1) + "</font>! You win!</html>");
        } else {
            messagePanel.setMessage("Tie Game!");
        }
        frame.repaint();
    }

    private static void sleep(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
