import java.util.Random;
import java.util.Scanner;

interface TicTacToeIF {
    static char[] board =new char[10];

    int toss();
    void board();
    void chooseLetter();
    void displayBoard();
    void playerMove();
    void checkFreeSpace();
}

class TicTacToeService implements TicTacToeIF {
    private char player_input;
    private char computer_input;

    @Override
    public int toss() {
        Random random = new Random();
        int check = random.nextInt(0,2);
        int value_return;
        if(check == 1){
            System.out.println("Player plays First");
            value_return=1;
        }
        else{
            System.out.println("Computer Plays First");
            value_return = 0;
        }
        return value_return;
    }

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

    @Override
    public void checkFreeSpace() {
        boolean space = false;
        int remaining_space = 0;

        for(int i = 1; i<=9; i++){
            if(board[i]==' '){
                space=true;
                remaining_space++;
            }
        }
        if (space==false){
            System.out.println("No more Space Available");
        }
        else{
            System.out.println("Spaces Available= " + remaining_space);
        }
    }
}


public class TicTacToeMain {
    public static void main(String[] args) {

        System.out.println("---Welcome To The Tic Tac Toe Game---");
        System.out.println("--------------------------------------");
        TicTacToeService play = new TicTacToeService();

        //Creating The Board

        play.board();
        play.chooseLetter();

        //Tossing To See Which Player Will Play First

        if(play.toss() == 1){
            play.playerMove();
            play.displayBoard();
            play.checkFreeSpace();
        }
        play.playerMove();
        play.displayBoard();
        play.checkFreeSpace();

    }
}