public class Player{
  private String playerName;
  private char playerSymbol;

  public Player(String name, char symbol) {
    this.playerName = name;
    this.playerSymbol = symbol;
  }

  public char getSymbol() {
    return this.playerSymbol;
  }
  public String getName() {
    return this.playerName;
  }
}
