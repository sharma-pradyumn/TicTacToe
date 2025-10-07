public class Player {
    private final String name;
    private MoveSymbol moveSymbol;

    public Player (String name, MoveSymbol moveSymbol) {
        this.name = name;
        this.moveSymbol = moveSymbol;
    }

    public MoveSymbol getMoveSymbol() {
        return moveSymbol;
    }

    public String getName() {
        return name;
    }

    public void setMoveSymbol(MoveSymbol moveSymbol) {
        if(moveSymbol == null) {
            throw new IllegalArgumentException("MoveSymbol cannot be null");
        }
        this.moveSymbol = moveSymbol;
    }

    @Override
    public String toString() {
        return "[Name:"+name+", MoveSymbol:"+moveSymbol+"]";
    }
}
