//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Player A = new Player("A", MoveSymbol.X);
        Player B = new Player("B", MoveSymbol.O);

        Game g = new Game(A, B);

        g.handleMove(0,0);
        g.handleMove(0,1);

        g.handleMove(1,0);
        g.handleMove(2,0);

        g.handleMove(0,2);
        g.handleMove(1,2);

        g.handleMove(1,1);
        g.handleMove(2,1);


        g.printBoard();

        System.out.println(g.getScoreboard());

    }
}