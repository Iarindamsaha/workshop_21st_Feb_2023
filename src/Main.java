import java.util.Scanner;

interface TicTacToe{
    static char[] board =new char[10];

    public void board();

    void choose_letter();
}

class TicTacToeService implements TicTacToe {

    @Override
    public void board() {
        for (int i = 1; i <= 9; i++) {
            board[i] = ' ';
        }
    }

    @Override
    public void choose_letter() {

        char player_input;
        char computer_input;

        Scanner sc =new Scanner(System.in);
        System.out.println("Choose a Letter Between X or O");
        player_input = sc.next().toUpperCase().charAt(0);
        computer_input= (player_input=='X')?'O':'X';
    }
}


public class Main {
    public static void main(String[] args) {

        System.out.println("---Welcome To The Tic Tac Toe Game---");
        System.out.println("--------------------------------------");
    }
}