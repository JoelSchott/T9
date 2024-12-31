import java.awt.Color;

public class Game {
    private Player[] players;
    private Board board;
    private int turn = 0;

    public Game() {
        players = new Player[4];
        players[0] = new Player(Color.RED, "red");
        players[1] = new Player(Color.GREEN, "green");
        players[2] = new Player(Color.BLUE, "blue");
        players[3] = new Player(Color.YELLOW, "yellow");
        board = new Board();
    }

    public int getTurn(){
        return turn;
    }

    public Player getCurrentPlayer(){
        return players[turn];
    }

    public Player getPlayer(int index){
        return players[index];
    }

    public Board getBoard(){
        return board;
    }

    public void nextTurn(){
        turn = (turn + 1) % 4;
    }

    public boolean isDone(){
        return board.hasWinner() || !board.hasEmpty();
    }

    public boolean currentPlayerCanPlay(){
        boolean hasBig = getCurrentPlayer().canSelect(Selection.LEFT_BIG) || getCurrentPlayer().canSelect(Selection.CENTER_BIG) || getCurrentPlayer().canSelect(Selection.RIGHT_BIG);
        boolean hasMedium = getCurrentPlayer().canSelect(Selection.LEFT_MEDIUM) || getCurrentPlayer().canSelect(Selection.CENTER_MEDIUM) || getCurrentPlayer().canSelect(Selection.RIGHT_MEDIUM);
        boolean hasSmall = getCurrentPlayer().canSelect(Selection.LEFT_SMALL) || getCurrentPlayer().canSelect(Selection.CENTER_SMALL) || getCurrentPlayer().canSelect(Selection.RIGHT_SMALL);
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if (board.getRings(row, col).getBig() == -1 && hasBig){
                    return true;
                }
                if (board.getRings(row, col).getMedium() == -1 && hasMedium){
                    return true;
                }
                if (board.getRings(row, col).getSmall() == -1 && hasSmall){
                    return true;
                }
            }
        }
        return false;
    }

}
