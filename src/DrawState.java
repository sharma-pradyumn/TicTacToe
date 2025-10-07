public class DrawState implements GameState{
    @Override
    public void handleMove(Game game, int i, int j) {
        System.out.println("Game is Drawn already. Cannot make move for player "+game.getCurrentPlayer()+" for "+i+" ,"+j);
    }
}
