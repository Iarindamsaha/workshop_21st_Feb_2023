import java.util.Scanner;

interface TicTacToeIF {
    static char[] board =new char[10];


    void board();
    void chooseLetter();
    void displayBoard();
    void playerMove();
}

class TicTacToeIFService implements TicTacToeIF {
    char player_input;
    char computer_input;

    @Override
    public void board() {
        for (int i = 1; i <= 9; i++) {
            board[i] = ' ';
        }
    }

    @Override
    public void chooseLetter() {


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

    @Override
    public void playerMove() {
        int players_move;
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose Board Location From 1 to 9");
            players_move = sc.nextInt();
            if(board[players_move]==' '){
                break;
            }

        }
        System.out.println("Player Move = "+"INDEX = "+players_move);
        board[players_move]=player_input;
    }
}


public class TicTacToeMain {
    public static void main(String[] args) {

        System.out.println("---Welcome To The Tic Tac Toe Game---");
        System.out.println("--------------------------------------");
        TicTacToeIFService play = new TicTacToeIFService();

        play.board();
        play.chooseLetter();
        play.displayBoard();
        play.playerMove();
        play.displayBoard();

    }
}