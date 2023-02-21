interface TicTacToe{
    static char[] board =new char[10];
    public void board();
}

class TicTacToeService implements TicTacToe {

    @Override
    public void board() {
        for (int i = 1; i <= 9; i++) {
            board[i] = ' ';
        }
    }
}


public class Main {
    public static void main(String[] args) {

        System.out.println("---Welcome To The Tic Tac Toe Game---");
    }
}