import java.util.Random;
import java.util.Scanner;

interface TicTacToeIF {
    static char[] board =new char[10];

    int toss();
    void board();
    void chooseLetter();
    void displayBoard();
    void playerMove();
    void computerMove();
    void checkFreeSpace();
    void checkWinner();
    void winnerWarning();
}

class TicTacToeService implements TicTacToeIF {
    private char player_input;
    private char computer_input;

    @Override
    public int toss() {
        Random random = new Random();
        int check = random.nextInt(0, 2);
        int value_return;
        if (check == 1) {
            System.out.println("Player plays First");
            value_return = 1;
        } else {
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


        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a Letter Between X or O");
        player_input = sc.next().toUpperCase().charAt(0);
        computer_input = (player_input == 'X') ? 'O' : 'X';
    }

    @Override
    public void displayBoard() {
        System.out.println(board[1] + "||" + board[2] + "||" + board[3]);
        System.out.println("-------");
        System.out.println(board[4] + "||" + board[5] + "||" + board[6]);
        System.out.println("-------");
        System.out.println(board[7] + "||" + board[8] + "||" + board[9]);
    }

    @Override
    public void playerMove() {
        int players_move;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose Board Location From 1 to 9");
            players_move = sc.nextInt();
            if (board[players_move] == ' ') {
                break;
            }

        }
        System.out.println("Player Move = " + "INDEX = " + players_move);
        board[players_move] = player_input;
    }

    @Override
    public void computerMove() {
        int computerMove;
        Random random = new Random();
        while(true){
            computerMove= random.nextInt(9)+1;
            if (board[computerMove]==' '){
                break;
            }
        }
        System.out.println("Computer Move: "+computerMove);
        board[computerMove]=computer_input;
    }


    @Override
    public void checkFreeSpace() {
        boolean space = false;
        int remaining_space = 0;

        for (int i = 0; i < 10; i++) {
            if (board[i] == ' ') {
                space = true;
                remaining_space++;
            }
        }
        if (space == false) {
            System.out.println("No more Space Available || Game is Draw");
            System.exit(0);
        } else {
            System.out.println("Spaces Available= " + remaining_space);
        }
    }

    @Override
    public void checkWinner() {
        if ((board[1] == player_input && board[2] == player_input && board[3] == player_input ||
                board[1] == player_input && board[4] == player_input && board[7] == player_input ||
                board[1] == player_input && board[5] == player_input && board[9] == player_input ||
                board[3] == player_input && board[5] == player_input && board[7] == player_input ||
                board[2] == player_input && board[5] == player_input && board[8] == player_input ||
                board[3] == player_input && board[6] == player_input && board[9] == player_input ||
                board[4] == player_input && board[5] == player_input && board[6] == player_input ||
                board[7] == player_input && board[8] == player_input && board[9] == player_input
        )) {
            System.out.println("Player Wins The Game");
            System.exit(0);
        } else if ((board[1] == computer_input && board[2] == computer_input && board[3] == computer_input ||
                board[1] == computer_input && board[4] == computer_input && board[7] == computer_input ||
                board[1] == computer_input && board[5] == computer_input && board[9] == computer_input ||
                board[3] == computer_input && board[5] == computer_input && board[7] == computer_input ||
                board[2] == computer_input && board[5] == computer_input && board[8] == computer_input ||
                board[3] == computer_input && board[6] == computer_input && board[9] == computer_input ||
                board[4] == computer_input && board[5] == computer_input && board[6] == computer_input ||
                board[7] == computer_input && board[8] == computer_input && board[9] == computer_input
        )) {
            System.out.println("Computer Won The Game");
            System.exit(0);
        }
    }

    @Override
    public void winnerWarning() {
        if(     //first row check

                board[1] == computer_input && board[2] == computer_input && board[3] == ' ' ||
                        board[1] == ' ' && board[2] == computer_input && board[3] == computer_input ||
                        board[1] == computer_input && board[2] == ' ' && board[3] == computer_input ||

                        //first column

                        board[1] == computer_input && board[4] == computer_input && board[7] == ' ' ||
                        board[1] == ' ' && board[4] == computer_input && board[7] == computer_input ||
                        board[1] == computer_input && board[4] == ' ' && board[7] == computer_input ||

                        //second column check

                        board[2] == computer_input && board[5] == computer_input && board[8] == ' ' ||
                        board[2] == ' ' && board[5] == computer_input && board[8] == computer_input ||
                        board[2] == computer_input && board[5] == ' ' && board[8] == computer_input ||

                        //third column check

                        board[3] == computer_input && board[6] == computer_input && board[9] == ' ' ||
                        board[3] == ' ' && board[6] == computer_input && board[9] == computer_input ||
                        board[3] == computer_input && board[6] == ' ' && board[9] == computer_input ||

                        //for second row

                        board[4] == computer_input && board[5] == computer_input && board[6] == ' '||
                        board[4] == ' ' && board[5] == computer_input && board[6] == computer_input ||
                        board[4] == computer_input && board[5] == ' ' && board[6] == computer_input||

                        //for third row

                        board[7] == computer_input && board[8] == computer_input && board[9] == ' '||
                        board[7] == ' ' && board[8] == computer_input && board[9] == computer_input ||
                        board[7] == computer_input && board[8] == ' ' && board[9] == computer_input ||

                        // for corners

                        board[1] == computer_input && board[5] == computer_input && board[9] == ' ' ||
                        board[1] == ' ' && board[5] == computer_input && board[9] == computer_input ||
                        board[1] == computer_input && board[5] == ' ' && board[9] == computer_input ||

                        board[3] == computer_input && board[5] == computer_input && board[7] == ' ' ||
                        board[3] == ' ' && board[5] == computer_input && board[7] == computer_input ||
                        board[3] == computer_input && board[5] == ' ' && board[7] == computer_input


        ){
            System.out.println("Computer Can Almost Win the Game Play Carefully");
        }
    }


}


public class TicTacToeMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
            play.computerMove();
            play.displayBoard();
            play.checkFreeSpace();
        }
        else {
            play.computerMove();
            play.displayBoard();
            play.checkFreeSpace();
        }

        while(true){

            play.playerMove();
            play.computerMove();
            play.displayBoard();
            play.checkFreeSpace();
            play.checkWinner();
            play.winnerWarning();


        }

    }
}