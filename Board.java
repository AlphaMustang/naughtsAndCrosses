public class Board{

  private char[][] actualBoard;

  public Board() {
    this.actualBoard = new char[3][3];
  }

  public boolean writeTo(Player player,int xCoord,int yCoord) {
    int inputXCoord = xCoord - 1;
    int inputYCoord = yCoord - 1;
    boolean isPositionEmpty = true;
    if (actualBoard[inputXCoord][inputYCoord] != '\u0000') {
      isPositionEmpty = false;
    }
    if (isPositionEmpty) {
      actualBoard[inputXCoord][inputYCoord] = player.getSymbol();
    }
    return isPositionEmpty;
  }

  public boolean checkIfWinner(Player player) {
    boolean isWinner = false;
    char playerSymbol = player.getSymbol();
    if (actualBoard[0][0] == playerSymbol && actualBoard[1][0] == playerSymbol && actualBoard[2][0] == playerSymbol) {
      return true;
    }
    else if (actualBoard[0][0] == playerSymbol && actualBoard[1][1] == playerSymbol && actualBoard[2][2] == playerSymbol) {
      return true;
    }
    else if (actualBoard[0][0] == playerSymbol && actualBoard[0][1] == playerSymbol && actualBoard[0][2] == playerSymbol) {
      return true;
    }
    else if (actualBoard[1][0] == playerSymbol && actualBoard[1][1] == playerSymbol && actualBoard[1][2] == playerSymbol) {
      return true;
    }
    else if (actualBoard[2][0] == playerSymbol && actualBoard[2][1] == playerSymbol && actualBoard[2][2] == playerSymbol) {
      return true;
    }
    else if (actualBoard[2][0] == playerSymbol && actualBoard[1][1] == playerSymbol && actualBoard[0][2] == playerSymbol) {
      return true;
    }
    else if (actualBoard[0][1] == playerSymbol && actualBoard[1][1] == playerSymbol && actualBoard[2][1] == playerSymbol) {
      return true;
    }
    else if (actualBoard[0][2] == playerSymbol && actualBoard[1][2] == playerSymbol && actualBoard[2][2] == playerSymbol) {
      return true;
    }
    else {
      return false;
    }
  }
  public void printboard() {
    System.out.println(boardPosition(0,0) + "|" + boardPosition(1,0) + "|" + boardPosition(2,0));
    System.out.println("-----");
    System.out.println(boardPosition(0,1) + "|" + boardPosition(1,1) + "|" + boardPosition(2,1));
    System.out.println("-----");
    System.out.println(boardPosition(0,2) + "|" + boardPosition(1,2) + "|" + boardPosition(2,2));
  }
  public char boardPosition(int x,int y) {
    if (actualBoard[x][y] == '\u0000') {
      return ' ';
    }
    else {
      return actualBoard[x][y];
    }
  }
}
