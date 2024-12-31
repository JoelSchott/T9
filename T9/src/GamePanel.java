import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel {

    private Game game;
    private Color background;
    private int width;
    private final static Color EMPTY = new Color(100, 100, 100);
    private final static Color SELECTED = new Color(255, 255, 255);

    public GamePanel(Game game, Color background, int width){
        this.game = game;
        this.background = background;
        this.setBackground(background);
        this.width = width;
        this.setPreferredSize(new Dimension(width, width));
        this.addMouseListener(new GameMouseListener());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // constants
        final int loc1 = width / 6;
        final int loc2 = 2 * width / 6;
        final int loc3 = 3 * width / 6;
        final int loc4 = 4 * width / 6;
        final int loc5 = 5 * width / 6;
        final int big = 3 * loc1 / 4;
        final int medium = 2 * loc1 / 4;
        final int small = loc1 / 4;
        final int ringWidth = loc1 / 16;
        // draw frame
        g.setColor(Color.BLACK);
        g.fillRect((loc1 + loc2) / 2 - ringWidth / 2, (loc1 + loc2) / 2 - ringWidth / 2, ringWidth, 3 * loc1);
        g.fillRect((loc1 + loc2) / 2 - ringWidth / 2, (loc1 + loc2) / 2 - ringWidth / 2, 3 * loc1, ringWidth);
        g.fillRect((loc4 + loc5) / 2 - ringWidth / 2, (loc1 + loc2) / 2 - ringWidth / 2, ringWidth, 3 * loc1);
        g.fillRect((loc1 + loc2) / 2 - ringWidth / 2, (loc4 + loc5) / 2 - ringWidth / 2, 3 * loc1 + ringWidth, ringWidth);
        // draw first player left
        g.setColor(game.getPlayer(0).canSelect(Selection.LEFT_BIG) ? game.getPlayer(0).getColor() : EMPTY);
        drawCircle(g, loc2, loc5, big, ringWidth);
        g.setColor(game.getPlayer(0).canSelect(Selection.LEFT_MEDIUM) ? game.getPlayer(0).getColor() : EMPTY);
        drawCircle(g, loc2, loc5, medium, ringWidth);
        g.setColor(game.getPlayer(0).canSelect(Selection.LEFT_SMALL) ? game.getPlayer(0).getColor() : EMPTY);
        drawCircle(g, loc2, loc5, small, ringWidth);
        // draw first player center
        g.setColor(game.getPlayer(0).canSelect(Selection.CENTER_BIG) ? game.getPlayer(0).getColor() : EMPTY);
        drawCircle(g, loc3, loc5, big, ringWidth);
        g.setColor(game.getPlayer(0).canSelect(Selection.CENTER_MEDIUM) ? game.getPlayer(0).getColor() : EMPTY);
        drawCircle(g, loc3, loc5, medium, ringWidth);
        g.setColor(game.getPlayer(0).canSelect(Selection.CENTER_SMALL) ? game.getPlayer(0).getColor() : EMPTY);
        drawCircle(g, loc3, loc5, small, ringWidth);
        // draw first player right
        g.setColor(game.getPlayer(0).canSelect(Selection.RIGHT_BIG) ? game.getPlayer(0).getColor() : EMPTY);
        drawCircle(g, loc4, loc5, big, ringWidth);
        g.setColor(game.getPlayer(0).canSelect(Selection.RIGHT_MEDIUM) ? game.getPlayer(0).getColor() : EMPTY);
        drawCircle(g, loc4, loc5, medium, ringWidth);
        g.setColor(game.getPlayer(0).canSelect(Selection.RIGHT_SMALL) ? game.getPlayer(0).getColor() : EMPTY);
        drawCircle(g, loc4, loc5, small, ringWidth);
        // draw second player left
        g.setColor(game.getPlayer(1).canSelect(Selection.LEFT_BIG) ? game.getPlayer(1).getColor() : EMPTY);
        drawCircle(g, loc1, loc2, big, ringWidth);
        g.setColor(game.getPlayer(1).canSelect(Selection.LEFT_MEDIUM) ? game.getPlayer(1).getColor() : EMPTY);
        drawCircle(g, loc1, loc2, medium, ringWidth);
        g.setColor(game.getPlayer(1).canSelect(Selection.LEFT_SMALL) ? game.getPlayer(1).getColor() : EMPTY);
        drawCircle(g, loc1, loc2, small, ringWidth);
        // draw second player center
        g.setColor(game.getPlayer(1).canSelect(Selection.CENTER_BIG) ? game.getPlayer(1).getColor() : EMPTY);
        drawCircle(g, loc1, loc3, big, ringWidth);
        g.setColor(game.getPlayer(1).canSelect(Selection.CENTER_MEDIUM) ? game.getPlayer(1).getColor() : EMPTY);
        drawCircle(g, loc1, loc3, medium, ringWidth);
        g.setColor(game.getPlayer(1).canSelect(Selection.CENTER_SMALL) ? game.getPlayer(1).getColor() : EMPTY);
        drawCircle(g, loc1, loc3, small, ringWidth);
        // draw second player right
        g.setColor(game.getPlayer(1).canSelect(Selection.RIGHT_BIG) ? game.getPlayer(1).getColor() : EMPTY);
        drawCircle(g, loc1, loc4, big, ringWidth);
        g.setColor(game.getPlayer(1).canSelect(Selection.RIGHT_MEDIUM) ? game.getPlayer(1).getColor() : EMPTY);
        drawCircle(g, loc1, loc4, medium, ringWidth);
        g.setColor(game.getPlayer(1).canSelect(Selection.RIGHT_SMALL) ? game.getPlayer(1).getColor() : EMPTY);
        drawCircle(g, loc1, loc4, small, ringWidth);
        // draw third player left
        g.setColor(game.getPlayer(2).canSelect(Selection.LEFT_BIG) ? game.getPlayer(2).getColor() : EMPTY);
        drawCircle(g, loc4, loc1, big, ringWidth);
        g.setColor(game.getPlayer(2).canSelect(Selection.LEFT_MEDIUM) ? game.getPlayer(2).getColor() : EMPTY);
        drawCircle(g, loc4, loc1, medium, ringWidth);
        g.setColor(game.getPlayer(2).canSelect(Selection.LEFT_SMALL) ? game.getPlayer(2).getColor() : EMPTY);
        drawCircle(g, loc4, loc1, small, ringWidth);
        // draw third player center
        g.setColor(game.getPlayer(2).canSelect(Selection.CENTER_BIG) ? game.getPlayer(2).getColor() : EMPTY);
        drawCircle(g, loc3, loc1, big, ringWidth);
        g.setColor(game.getPlayer(2).canSelect(Selection.CENTER_MEDIUM) ? game.getPlayer(2).getColor() : EMPTY);
        drawCircle(g, loc3, loc1, medium, ringWidth);
        g.setColor(game.getPlayer(2).canSelect(Selection.CENTER_SMALL) ? game.getPlayer(2).getColor() : EMPTY);
        drawCircle(g, loc3, loc1, small, ringWidth);
        // draw third player right
        g.setColor(game.getPlayer(2).canSelect(Selection.RIGHT_BIG) ? game.getPlayer(2).getColor() : EMPTY);
        drawCircle(g, loc2, loc1, big, ringWidth);
        g.setColor(game.getPlayer(2).canSelect(Selection.RIGHT_MEDIUM) ? game.getPlayer(2).getColor() : EMPTY);
        drawCircle(g, loc2, loc1, medium, ringWidth);
        g.setColor(game.getPlayer(2).canSelect(Selection.RIGHT_SMALL) ? game.getPlayer(2).getColor() : EMPTY);
        drawCircle(g, loc2, loc1, small, ringWidth);
        // draw fourth player left
        g.setColor(game.getPlayer(3).canSelect(Selection.LEFT_BIG) ? game.getPlayer(3).getColor() : EMPTY);
        drawCircle(g, loc5, loc4, big, ringWidth);
        g.setColor(game.getPlayer(3).canSelect(Selection.LEFT_MEDIUM) ? game.getPlayer(3).getColor() : EMPTY);
        drawCircle(g, loc5, loc4, medium, ringWidth);
        g.setColor(game.getPlayer(3).canSelect(Selection.LEFT_SMALL) ? game.getPlayer(3).getColor() : EMPTY);
        drawCircle(g, loc5, loc4, small, ringWidth);
        // draw fourth player center
        g.setColor(game.getPlayer(3).canSelect(Selection.CENTER_BIG) ? game.getPlayer(3).getColor() : EMPTY);
        drawCircle(g, loc5, loc3, big, ringWidth);
        g.setColor(game.getPlayer(3).canSelect(Selection.CENTER_MEDIUM) ? game.getPlayer(3).getColor() : EMPTY);
        drawCircle(g, loc5, loc3, medium, ringWidth);
        g.setColor(game.getPlayer(3).canSelect(Selection.CENTER_SMALL) ? game.getPlayer(3).getColor() : EMPTY);
        drawCircle(g, loc5, loc3, small, ringWidth);
        // draw fourth player right
        g.setColor(game.getPlayer(3).canSelect(Selection.RIGHT_BIG) ? game.getPlayer(3).getColor() : EMPTY);
        drawCircle(g, loc5, loc2, big, ringWidth);
        g.setColor(game.getPlayer(3).canSelect(Selection.RIGHT_MEDIUM) ? game.getPlayer(3).getColor() : EMPTY);
        drawCircle(g, loc5, loc2, medium, ringWidth);
        g.setColor(game.getPlayer(3).canSelect(Selection.RIGHT_SMALL) ? game.getPlayer(3).getColor() : EMPTY);
        drawCircle(g, loc5, loc2, small, ringWidth);
        // draw the board
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                int x = (2 + col) * width / 6;
                int y = (2 + row) * width / 6;
                g.setColor(getRingColor(game.getBoard().getRings(row, col).getBig()));
                drawCircle(g, x, y, big, ringWidth);
                g.setColor(getRingColor(game.getBoard().getRings(row, col).getMedium()));
                drawCircle(g, x, y, medium, ringWidth);
                g.setColor(getRingColor(game.getBoard().getRings(row, col).getSmall()));
                drawCircle(g, x, y, small, ringWidth);
            }
        }
        // draw the selected ring
        if (game.getTurn() == 0){
            switch (game.getCurrentPlayer().getSelection()){
                case LEFT_BIG:
                    drawSelected(g, loc2, loc5, big, ringWidth);
                    break;
                case LEFT_MEDIUM:
                    drawSelected(g, loc2, loc5, medium, ringWidth);
                    break;
                case LEFT_SMALL:
                    drawSelected(g, loc2, loc5, small, ringWidth);
                    break;
                case CENTER_BIG:
                    drawSelected(g, loc3, loc5, big, ringWidth);
                    break;
                case CENTER_MEDIUM:
                    drawSelected(g, loc3, loc5, medium, ringWidth);
                    break;
                case CENTER_SMALL:
                    drawSelected(g, loc3, loc5, small, ringWidth);
                    break;
                case RIGHT_BIG:
                    drawSelected(g, loc4, loc5, big, ringWidth);
                    break;
                case RIGHT_MEDIUM:
                    drawSelected(g, loc4, loc5, medium, ringWidth);
                    break;
                case RIGHT_SMALL:
                    drawSelected(g, loc4, loc5, small, ringWidth);
                    break;
            }
        }
        else if (game.getTurn() == 1){
            switch (game.getCurrentPlayer().getSelection()){
                case LEFT_BIG:
                    drawSelected(g, loc1, loc2, big, ringWidth);
                    break;
                case LEFT_MEDIUM:
                    drawSelected(g, loc1, loc2, medium, ringWidth);
                    break;
                case LEFT_SMALL:
                    drawSelected(g, loc1, loc2, small, ringWidth);
                    break;
                case CENTER_BIG:
                    drawSelected(g, loc1, loc3, big, ringWidth);
                    break;
                case CENTER_MEDIUM:
                    drawSelected(g, loc1, loc3, medium, ringWidth);
                    break;
                case CENTER_SMALL:
                    drawSelected(g, loc1, loc3, small, ringWidth);
                    break;
                case RIGHT_BIG:
                    drawSelected(g, loc1, loc4, big, ringWidth);
                    break;
                case RIGHT_MEDIUM:
                    drawSelected(g, loc1, loc4, medium, ringWidth);
                    break;
                case RIGHT_SMALL:
                    drawSelected(g, loc1, loc4, small, ringWidth);
                    break;
            }
        }
        else if (game.getTurn() == 2){
            switch (game.getCurrentPlayer().getSelection()){
                case LEFT_BIG:
                    drawSelected(g, loc4, loc1, big, ringWidth);
                    break;
                case LEFT_MEDIUM:
                    drawSelected(g, loc4, loc1, medium, ringWidth);
                    break;
                case LEFT_SMALL:
                    drawSelected(g, loc4, loc1, small, ringWidth);
                    break;
                case CENTER_BIG:
                    drawSelected(g, loc3, loc1, big, ringWidth);
                    break;
                case CENTER_MEDIUM:
                    drawSelected(g, loc3, loc1, medium, ringWidth);
                    break;
                case CENTER_SMALL:
                    drawSelected(g, loc3, loc1, small, ringWidth);
                    break;
                case RIGHT_BIG:
                    drawSelected(g, loc2, loc1, big, ringWidth);
                    break;
                case RIGHT_MEDIUM:
                    drawSelected(g, loc2, loc1, medium, ringWidth);
                    break;
                case RIGHT_SMALL:
                    drawSelected(g, loc2, loc1, small, ringWidth);
                    break;
            }
        }
        else if (game.getTurn() == 3){
            switch (game.getCurrentPlayer().getSelection()){
                case LEFT_BIG:
                    drawSelected(g, loc5, loc4, big, ringWidth);
                    break;
                case LEFT_MEDIUM:
                    drawSelected(g, loc5, loc4, medium, ringWidth);
                    break;
                case LEFT_SMALL:
                    drawSelected(g, loc5, loc4, small, ringWidth);
                    break;
                case CENTER_BIG:
                    drawSelected(g, loc5, loc3, big, ringWidth);
                    break;
                case CENTER_MEDIUM:
                    drawSelected(g, loc5, loc3, medium, ringWidth);
                    break;
                case CENTER_SMALL:
                    drawSelected(g, loc5, loc3, small, ringWidth);
                    break;
                case RIGHT_BIG:
                    drawSelected(g, loc5, loc2, big, ringWidth);
                    break;
                case RIGHT_MEDIUM:
                    drawSelected(g, loc5, loc2, medium, ringWidth);
                    break;
                case RIGHT_SMALL:
                    drawSelected(g, loc5, loc2, small, ringWidth);
                    break;
            }
        }
    }

    private Color getRingColor(int i){
        if (i == -1){
            return EMPTY;
        }
        return game.getPlayer(i).getColor();
    }

    private void drawCircle(Graphics g, int center_x, int center_y, int diameter, int width){
        int x = center_x - diameter / 2;
        int y = center_y - diameter / 2;
        g.fillOval(x, y, diameter, diameter);
        g.setColor(background);
        x += width;
        y += width;
        g.fillOval(x, y, diameter - 2 * width, diameter - 2 * width);
    }

    private void drawSelected(Graphics g, int center_x, int center_y, int diameter, int width){
        int x = center_x - diameter / 2;
        int y = center_y - diameter / 2;
        g.setColor(SELECTED);
        g.drawOval(x, y, diameter, diameter);
        x += width;
        y += width;
        g.drawOval(x, y, diameter - 2 * width, diameter - 2 * width);
    }

    private class GameMouseListener implements MouseListener{

        public void mouseClicked(MouseEvent e) {
            // no need to do anything if the game has a winner already
            if (game.getBoard().hasWinner()){
                return;
            }
            // constants
            final int loc1 = width / 6;
            final int loc2 = 2 * width / 6;
            final int loc3 = 3 * width / 6;
            final int loc4 = 4 * width / 6;
            final int loc5 = 5 * width / 6;
            final int big = 3 * loc1 / 8;
            final int medium = 2 * loc1 / 8;
            final int small = loc1 / 8;
            final int ringWidth = loc1 / 16;
            // determine left, center, and right centers based on the current turn
            int leftX = 0;
            int leftY = 0;
            int centerX = 0;
            int centerY = 0;
            int rightX = 0;
            int rightY = 0;
            if (game.getTurn() == 0){
                leftX = loc2;
                leftY = loc5;
                centerX = loc3;
                centerY = loc5;
                rightX = loc4;
                rightY = loc5;
            } else if (game.getTurn() == 1){
                leftX = loc1;
                leftY = loc2;
                centerX = loc1;
                centerY = loc3;
                rightX = loc1;
                rightY = loc4;
            } else if (game.getTurn() == 2){
                leftX = loc4;
                leftY = loc1;
                centerX = loc3;
                centerY = loc1;
                rightX = loc2;
                rightY = loc1;
            } else if (game.getTurn() == 3){
                leftX = loc5;
                leftY = loc4;
                centerX = loc5;
                centerY = loc3;
                rightX = loc5;
                rightY = loc2;
            }
            // check distances to select a ring
            double leftDist = Utils.distance(e.getX(), e.getY(), leftX, leftY);
            if (leftDist >= big - ringWidth && leftDist <= big){
                game.getCurrentPlayer().select(Selection.LEFT_BIG);
            } else if (leftDist >= medium - ringWidth && leftDist <= medium){
                game.getCurrentPlayer().select(Selection.LEFT_MEDIUM);
            } else if (leftDist >= small - ringWidth && leftDist <= small){
                game.getCurrentPlayer().select(Selection.LEFT_SMALL);
            }
            double centerDist = Utils.distance(e.getX(), e.getY(), centerX, centerY);
            if (centerDist >= big - ringWidth && centerDist <= big){
                game.getCurrentPlayer().select(Selection.CENTER_BIG);
            } else if (centerDist >= medium - ringWidth && centerDist <= medium){
                game.getCurrentPlayer().select(Selection.CENTER_MEDIUM);
            } else if (centerDist >= small - ringWidth && centerDist <= small){
                game.getCurrentPlayer().select(Selection.CENTER_SMALL);
            }
            double rightDist = Utils.distance(e.getX(), e.getY(), rightX, rightY);
            if (rightDist >= big - ringWidth && rightDist <= big){
                game.getCurrentPlayer().select(Selection.RIGHT_BIG);
            } else if (rightDist >= medium - ringWidth && rightDist <= medium){
                game.getCurrentPlayer().select(Selection.RIGHT_MEDIUM);
            } else if (rightDist >= small - ringWidth && rightDist <= small){
                game.getCurrentPlayer().select(Selection.RIGHT_SMALL);
            }
            // check locations to place a ring
            if (game.getCurrentPlayer().getSelection() != Selection.NONE) {
                int x;
                int y;
                double dist = 0;
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        x = (col + 2) * width / 6;
                        y = (row + 2) * width / 6;
                        dist = Utils.distance(e.getX(), e.getY(), x, y);
                        if (dist > big - ringWidth &&
                            dist < big &&
                            game.getBoard().getRings(row, col).getBig() == -1 &&
                            game.getCurrentPlayer().getSelectionSize() == Size.BIG
                        ) {
                            game.getBoard().place(row, col, Size.BIG, game.getTurn());
                            game.getCurrentPlayer().place();
                        } else if (dist > medium - ringWidth &&
                                   dist < medium &&
                                   game.getBoard().getRings(row, col).getMedium() == -1 &&
                                   game.getCurrentPlayer().getSelectionSize() == Size.MEDIUM
                        ) {
                            game.getBoard().place(row, col, Size.MEDIUM, game.getTurn());
                            game.getCurrentPlayer().place();
                        } else if (dist > small - ringWidth &&
                                   dist < small &&
                                   game.getBoard().getRings(row, col).getSmall() == -1 &&
                                   game.getCurrentPlayer().getSelectionSize() == Size.SMALL
                        ) {
                            game.getBoard().place(row, col, Size.SMALL, game.getTurn());
                            game.getCurrentPlayer().place();
                        }
                    }
                }
            }
            repaint();
        }

        public void mousePressed(MouseEvent e) {}

        public void mouseReleased(MouseEvent e) {}

        public void mouseEntered(MouseEvent e) {}

        public void mouseExited(MouseEvent e) {}
    }
}
