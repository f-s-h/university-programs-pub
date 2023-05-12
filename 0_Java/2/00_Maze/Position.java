package gad.maze;

// Anmerkung: Abgabe stammt aus meiner eigenen Abgabe aus dem letzten Semester

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addToPosition(Position other) {
        this.x += other.x;
        this.y += other.y;
    }

    public boolean equals(Position other) {
        return this.x == other.x && this.y == other.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
