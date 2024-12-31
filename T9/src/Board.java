public class Board {
    private Rings[][] board;
    private int winner = -1;

    public Board(){
        board = new Rings[3][3];
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                board[row][col] = new Rings();
            }
        }
    }

    public boolean hasEmpty(){
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if (board[row][col].getBig() == -1 || board[row][col].getMedium() == -1 || board[row][col].getSmall() == -1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasWinner(){
        return winner != -1;
    }

    public int getWinner(){
        return winner;
    }

    public Rings getRings(int row, int col){
        return board[row][col];
    }

    public void place(int row, int col, Size size, int player){
        switch (size){
            case BIG:
                board[row][col].setBig(player);
                break;
            case MEDIUM:
                board[row][col].setMedium(player);
                break;
            case SMALL:
                board[row][col].setSmall(player);
                break;
        }
        checkWinner();
    }

    private void checkWinner(){
        // check each set of rings
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                wins(board[row][col].getBig(), board[row][col].getMedium(), board[row][col].getSmall());
            }
        }
        // check each row
        for (int row = 0; row < 3; row++){
            wins(board[row][0].getBig(),    board[row][1].getBig(),    board[row][2].getBig());
            wins(board[row][0].getMedium(), board[row][1].getMedium(), board[row][2].getMedium());
            wins(board[row][0].getSmall(),  board[row][1].getSmall(),  board[row][2].getSmall());
            wins(board[row][0].getBig(),    board[row][1].getMedium(), board[row][2].getSmall());
            wins(board[row][0].getSmall(),  board[row][1].getMedium(), board[row][2].getBig());
        }
        // check each column
        for (int col = 0; col < 3; col++){
            wins(board[0][col].getBig(),    board[1][col].getBig(),    board[2][col].getBig());
            wins(board[0][col].getMedium(), board[1][col].getMedium(), board[2][col].getMedium());
            wins(board[0][col].getSmall(),  board[1][col].getSmall(),  board[2][col].getSmall());
            wins(board[0][col].getBig(),    board[1][col].getMedium(), board[2][col].getSmall());
            wins(board[0][col].getSmall(),  board[1][col].getMedium(), board[2][col].getBig());
        }
        // check the diagonals
        wins(board[0][0].getBig(),    board[1][1].getBig(),    board[2][2].getBig());
        wins(board[0][0].getMedium(), board[1][1].getMedium(), board[2][2].getMedium());
        wins(board[0][0].getSmall(),  board[1][1].getSmall(),  board[2][2].getSmall());
        wins(board[0][0].getBig(),    board[1][1].getMedium(), board[2][2].getSmall());
        wins(board[0][0].getSmall(),  board[1][1].getMedium(), board[2][2].getBig());

        wins(board[0][2].getBig(),    board[1][1].getBig(),    board[2][0].getBig());
        wins(board[0][2].getMedium(), board[1][1].getMedium(), board[2][0].getMedium());
        wins(board[0][2].getSmall(),  board[1][1].getSmall(),  board[2][0].getSmall());
        wins(board[0][2].getBig(),    board[1][1].getMedium(), board[2][0].getSmall());
        wins(board[0][2].getSmall(),  board[1][1].getMedium(), board[2][0].getBig());
    }

    private void wins(int a, int b, int c){
        if (a != -1 && a == b && a == c){
            winner = a;
        }
    }
}
