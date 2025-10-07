public class InProgressState implements GameState{
    @Override
    public void handleMove(Game game, int i, int j) {
        Player currentPlayer = game.getCurrentPlayer();
        game.getBoard().placeSymbol(i,j,currentPlayer.getMoveSymbol());
        game.checkResult(currentPlayer);
        if (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            game.switchPlayer();
        }
    }
}
