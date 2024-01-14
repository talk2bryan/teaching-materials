import java.util.Scanner;

public class TestXandOsSolution {
  public static void main(String [] args) {
    Scanner kbd = new Scanner(System.in);
    
    TicTacToe game = new TicTacToe();
    char next = 'x';
    
    while(!game.gameOver()) {
      System.out.println(game);
      System.out.println(next + "'s turn. Enter row col (0-2)");
      
      int row = kbd.nextInt();
      int col = kbd.nextInt();
      
      boolean inserted = game.validMove(next,row, col);
      if (inserted) {
        next = (next == 'x' ? 'o' : 'x'); // swaps x and o
      } else
        System.out.println("Try again");
    }
    
    System.out.println(game);
    System.out.println(game.getWinner() + " won"); 
  }
}

class TicTacToe {
  char [][]  board;
  
  public TicTacToe() {
    board = new char[3][3];
    fillBoard();
  }
  
  private void fillBoard() {
    for(int i = 0; i<board.length; i++){
      for(int j = 0; j <board[i].length; j++) {
        board[i][j] = '.';
      }
    }
  }
  
  public boolean gameOver() {
    return boardFull() || getWinner() != '.';
  }
  
  private boolean boardFull() {
    boolean result = true;
    for(int i = 0; i<board.length; i++){
      for(int j = 0; j <board[i].length; j++) {
        if (board[i][j] == '.')
          result = false;
      }
    }
    return result;
  }
  
  private boolean isEmpty(int r, int c) {
    return board[r][c] == '.';
  }
  
  public char getWinner() {
    char result = '.';
    char first;
    
    // rows
    for (int row = 0; result == '.' && row < board.length; row++) {
      first = board[row][0];
      if (first != '.' &&
          first == board[row][1] &&
          first == board[row][2]) {
        result = first;
      }
    }
    // cols
    for (int col = 0; result == '.' && col < board.length; col++) {
      first = board[0][col];
      if (first != '.' &&
          first == board[1][col] &&
          first == board[2][col]) {
        result = first;
      }
    }
    
    // diagonals - take home exercise
    // from left to right
      first = board[0][0];
      if (first != '.' &&
          first == board[1][1] &&
          first == board[2][2]) {
        result = first;
      }
      
      // the opposite diagonal
      first = board[0][2];
      if (first != '.' &&
          first == board[1][1] &&
          first == board[2][0]) {
        result = first;
      }
    return result;
  }
  
  public boolean validMove(char symbol, int row, int col) {
    boolean result = isEmpty(row, col);
    if (result)
      board[row][col] = symbol;
    return result;
  }
  
  public String toString() {
    String result = "";
    for(int i = 0; i<board.length; i++){
      for(int j = 0; j <board[i].length; j++) {
        result += board[i][j] + " " ;
      }
      result += "\n";
    }
    return result;
  }
}

