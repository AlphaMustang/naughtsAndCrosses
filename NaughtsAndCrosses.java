import java.util.Scanner;

public class NaughtsAndCrosses{

  private static Board board;
  private static Player player1;
  private static Player player2;
  private static Scanner input_reading;
  private static int turns = 0;
  private static boolean gameWon = false;
  private static Player winner;

  public static void main(String[] args) {
    board = new Board();
    input_reading = new Scanner(System.in);
    System.out.println("Creating player 1: ");
    player1 = createPlayer(1);
    System.out.println("Creating player 2: ");
    player2 = createPlayer(2);
    System.out.println("Player 1 is " + player1.getName() + " and their symbol is " + player1.getSymbol());
    System.out.println("Player 2 is " + player2.getName() + " and their symbol is " + player2.getSymbol());
    do {
      board.printboard();
      if (turns % 2 == 0) {
        gameTurn(player1);
        if (board.checkIfWinner(player1)) {
          gameWon = true;
          board.printboard();
          winner = player1;
        }
      }
      else {
        gameTurn(player2);
        if(board.checkIfWinner(player2)) {
          gameWon = true;
          board.printboard();
          winner = player2;
        }
      }
      turns++;
    } while (turns < 9 && !gameWon);
    if (turns == 9) {System.out.println("The game finished in a draw!");}
    else {
      System.out.println(winner.getName() + " won the game!");
    }
  }

  public static Player createPlayer(int playerNo) {
    System.out.println("Please enter player's name: ");
    String name = input_reading.nextLine();
    char symbol = 'a';
    if (playerNo == 1) {
      do {
        System.out.println("Which symbol would you like, X or O?");
        symbol = input_reading.nextLine().charAt(0);
      } while (symbol != 'x' && symbol != 'X' && symbol != 'o' && symbol != 'O');
    }
    else {
      if (player1.getSymbol() == 'x' || player1.getSymbol() == 'X') {
        symbol = 'O';
      } else {
        symbol = 'X';
      }
    }
    input_reading.reset();
    Player player = new Player(name,symbol);
    return player;
  }
  public static void gameTurn(Player player) {
    int xCoord, yCoord;
    boolean didWriteWork;
    do {
      System.out.println(player.getName() + " please enter the x coordinate (between 1 and 3) of where you would like to place your symbol");
      do {
        xCoord = input_reading.nextInt();
      } while (xCoord != 1 && xCoord != 2 && xCoord != 3);
      System.out.println("Please enter the y coordinate (between 1 and 3) of where you would like to place your symbol");
      do {
        yCoord = input_reading.nextInt();
      } while (yCoord != 1 && yCoord != 2 && yCoord != 3);
      didWriteWork = board.writeTo(player,xCoord,yCoord);
    } while (!didWriteWork);
  }
}
