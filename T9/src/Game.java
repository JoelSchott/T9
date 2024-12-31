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

}
