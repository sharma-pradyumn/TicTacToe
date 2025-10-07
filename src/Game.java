import java.util.HashMap;
import java.util.Map;

public class Game {
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;
    private GameStatus gameStatus;
    private Player currentPlayer;
    private GameState gameState;

    private final GameState inProgressState = new InProgressState();
    private final GameState drawGameState = new DrawState();
    private final GameState winnerGameState = new WinnerState();

    private Map<String, Integer> scoreboard;

    public Game(Player player1, Player player2) {

        if (player1.getMoveSymbol() == player2.getMoveSymbol()) {
            throw new IllegalArgumentException("Players must have different moveSymbols. "+player1+" "+player2);
        }
        firstPlayer = player1;
        currentPlayer = player1;
        secondPlayer = player2;

        board = new Board(3); // hardcoded for now
        gameStatus = GameStatus.IN_PROGRESS;
        gameState = inProgressState;
        scoreboard = new HashMap<>();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void checkResult(Player player) {
        // check if current symbol won
        boolean gameWin = checkWin(player.getMoveSymbol());
        if (gameWin) {
            System.out.println("Game is over. "+player+" is the Winner");
            gameState = winnerGameState;
            gameStatus = (player.getMoveSymbol().equals(MoveSymbol.X)) ? GameStatus.WINNER_X : GameStatus.WINNER_O;
            scoreboard.put(player.getName(), scoreboard.getOrDefault(player.getName(), 0)+1);

        } else if (board.isFull()) {
            System.out.println("Game is over. Game is a draw");
            gameStatus = GameStatus.DRAW;
            gameState = drawGameState;
        }
    }

    public void switchPlayer() {
        if (gameStatus.equals(GameStatus.IN_PROGRESS)) {
            if (currentPlayer.equals(firstPlayer)) {
                currentPlayer = secondPlayer;
            }
            else {
                currentPlayer = firstPlayer;
            }
        }
        else {
            throw new IllegalStateException("Game already over. Game state is "+gameStatus);
        }
    }

    public void handleMove(int i, int j) {
        gameState.handleMove(this, i, j);
    }

    // tbd -> move to individual stratergies
    public boolean checkWin(MoveSymbol moveSymbol) {
        // check rows
        for (int i = 0; i < board.getSize(); i++) {
            boolean isRow = true;
            for (int j = 0; j < board.getSize(); j++) {
                if (!(board.getSymbol(i,j) == moveSymbol)){
                    isRow = false;
                    break;
                }
            }
            if (isRow) {
                return true;
            }
        }


        // check cols

        for (int i = 0; i < board.getSize(); i++) {
            boolean isCol = true;
            for (int j = 0; j < board.getSize(); j++) {
                if (!(board.getSymbol(j,i) == moveSymbol)){
                    isCol = false;
                    break;
                }
            }
            if (isCol) {
                return true;
            }
        }

        // check diag
        boolean isDiag = true;
        boolean isReverseDiag = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (!(board.getSymbol(i,i) == moveSymbol)) {
                isDiag = false;
            }
        }
        if (isDiag) {
            return true;
        }

        for (int i = 0; i < board.getSize(); i++) {
            if (!(board.getSymbol(i,board.getSize()-1-i) == moveSymbol)) {
                isReverseDiag = false;
            }
        }
        if (isReverseDiag) {
            return true;
        }
        return false;
    }

    public void printBoard() {
        board.printBoard();
    }

    public Map<String, Integer> getScoreboard() {
        return scoreboard;
    }
}
