import java.util.Scanner;

interface TicTacToe{
    static char[] board =new char[10];

    public void board();

    void chooseLetter();
    void displayBoard();
}

class TicTacToeService implements TicTacToe {

    @Override
    public void board() {
        for (int i = 1; i <= 9; i++) {
            board[i] = ' ';
        }
    }

    @Override
    public void chooseLetter() {

        char player_input;
        char computer_input;

        Scanner sc =new Scanner(System.in);
        System.out.println("Choose a Letter Between X or O");
        player_input = sc.next().toUpperCase().charAt(0);
        computer_input= (player_input=='X')?'O':'X';
    }

    @Override
    public void displayBoard() {
        System.out.println(board[1]+"||"+board[2]+"||"+board[3]);
        System.out.println("-------");
        System.out.println(board[4]+"||"+board[5]+"||"+board[6]);
        System.out.println("-------");
        System.out.println(board[7]+"||"+board[8]+"||"+board[9]);
    }
}


public class Main {
    public static void main(String[] args) {

        System.out.println("---Welcome To The Tic Tac Toe Game---");
        System.out.println("--------------------------------------");
        TicTacToeService play = new TicTacToeService();

        play.board();
        play.chooseLetter();
        play.displayBoard();
    }
}