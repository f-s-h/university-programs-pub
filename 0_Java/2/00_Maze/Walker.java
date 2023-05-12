package gad.maze;

// Anmerkung: Abgabe stammt aus meiner eigenen Abgabe aus dem letzten Semester

public class Walker {
    private boolean[][] maze;
    private Position startingPosition;
    private Position currentPosition;
    private Direction direction;

    public Walker(boolean[][] maze) {
        this.maze = maze;
        addStartingPosition();
    }

    private void addStartingPosition() {
        startingPosition = new Position(1, 0);
        currentPosition = new Position(1, 0);
        direction = Direction.DOWN;
    }

    public boolean walk() {
        moveForward();
        do {
            walkForwardUntilAction();
            checkForAction();
        } while (!isEntrance() && !isExit());
        return isExit();
    }

    private void walkForwardUntilAction() {
        while (isWallOnRightSide() && !isWallAhead() && !isExit() && !isEntrance()) {
            moveForward();
        }
    }

    private boolean isWallOnRightSide() {
        Position positionOnRightSide = getPositionOnRightSide();
        return maze[positionOnRightSide.getX() + currentPosition.getX()][positionOnRightSide.getY() + currentPosition.getY()];
    }

    private Position getPositionOnRightSide() {
        int x = 0;
        int y = 0;

        switch (direction) {
            case UP -> x = 1;
            case RIGHT -> y = 1;
            case DOWN -> x = -1;
            case LEFT -> y = -1;
        }

        return new Position(x, y);
    }

    private boolean isWallAhead() {
        if (!isEntrance() && !isExit()) {
            Position positionAhead = getPositionAhead();
            return maze[currentPosition.getX() + positionAhead.getX()][currentPosition.getY() + positionAhead.getY()];
        }
        return true;
    }

    private Position getPositionAhead() {
        int x = 0;
        int y = 0;

        switch (direction) {
            case UP -> y = -1;
            case RIGHT -> x = 1;
            case DOWN -> y = 1;
            case LEFT -> x = -1;
        }
        return new Position(x, y);
    }

    private void moveForward() {
        Position positionAhead = getPositionAhead();
        currentPosition.addToPosition(positionAhead);
    }

    private void checkForAction() {
        if (!isWallOnRightSide()) {
            turnRight();
            if (!isExit() && !isEntrance()) {
                moveForward();
            }
        } else if (isWallAhead()) {
            if (isWallOnRightSide()) {
                turnLeft();
                if (isWallAhead()) {
                    turnLeft();
                }
            } else {
                turnRight();
                if (!isEntrance() && !isExit()) {
                    moveForward();
                }
            }
        }
    }

    private void turnRight() {
        switch (direction) {
            case DOWN -> direction = Direction.LEFT;
            case LEFT -> direction = Direction.UP;
            case UP -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.DOWN;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case DOWN -> direction = Direction.RIGHT;
            case LEFT -> direction = Direction.DOWN;
            case UP -> direction = Direction.LEFT;
            case RIGHT -> direction = Direction.UP;
        }
    }

    private boolean isEntrance() {
        return currentPosition.equals(startingPosition);
    }

    private boolean isExit() {
        int x = currentPosition.getX();
        int y = currentPosition.getY();

        int xMin = 0;
        int xMax = maze.length - 1;

        int yMin = 0;
        int yMax = maze[0].length - 1;

        return (x == xMin || x == xMax || y == yMin || y == yMax) && !isEntrance();
    }

}
