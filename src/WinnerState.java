public class WinnerState implements GameState{
    @Override
    public void handleMove(Game game, int i, int j) {
        System.out.println("Game is won already by player "+game.getCurrentPlayer());
    }
}
