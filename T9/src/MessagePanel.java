import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {

    private JLabel label;

    public MessagePanel(Color background, int width, int height){
        this.setLayout(new GridBagLayout());
        this.setBackground(background);
        this.setPreferredSize(new Dimension(width, height));
        label = new JLabel("");
        this.add(label);
    }

    public void setMessage(String msg){
        label.setText(msg);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
