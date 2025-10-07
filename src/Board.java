import java.util.ArrayList;

public class Board {
    private final int size;
    private MoveSymbol[][] board;

    public Board(int s) {
        if (s <= 0) {
            throw new IllegalArgumentException("Board size must be positive");
        }
        size = s;
        board = new MoveSymbol[s][s];
    }

    public int getSize() {
        return size;
    }

    public void printBoard() {
        for (MoveSymbol[] moveSymbols : board) {
            for (MoveSymbol element: moveSymbols) {
                System.out.print(element + " ");
            }
            System.out.println("\n");
        }
    }

    public void clearBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = null;
            }
        }
    }

    public boolean isFull() {
        for (MoveSymbol[] moveSymbols : board) {
            for (MoveSymbol element: moveSymbols) {
                if (element == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public MoveSymbol getSymbol(int i, int j) {
        if (i>= size || j >= size || i<0 || j<0) {
            throw new IllegalArgumentException("Move poistion out of bounds");
        }
        return board[i][j];
    }

    public void placeSymbol(int i, int j, MoveSymbol m) {
        if (i>= size || j >= size) {
            throw new IllegalArgumentException("Move poistion out of bounds");
        }
        if (board[i][j] != null) {
            throw new IllegalArgumentException("Symbol "+board[i][j]+" already on position "+i+" "+j+". Overwrite not allowed ");
        }
        board[i][j] = m;
    }
}
