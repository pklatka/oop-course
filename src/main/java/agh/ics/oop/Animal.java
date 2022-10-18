package agh.ics.oop;

public class Animal {
    private MapDirection heading = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    @Override
    public String toString() {
        return "heading=" + heading +
                ", position=" + position;
    }

    public boolean isAt(Vector2d position) {
        return this.position.x == position.x && this.position.y == position.y;
    }

    public void move(MoveDirection direction) {
        // direction handling
        switch (direction) {
            case RIGHT -> this.heading = this.heading.next();
            case LEFT -> this.heading = this.heading.previous();
            case FORWARD, BACKWARD -> {
                // Simulate position change
                Vector2d newPosition = new Vector2d(this.position.x, this.position.y);
                Vector2d unitVector = this.heading.toUnitVector();
                if (direction == MoveDirection.BACKWARD) {
                    unitVector = unitVector.opposite();
                }
                newPosition = newPosition.add(unitVector);
                if (newPosition.x <= 4 && newPosition.x >= 0 && newPosition.y <= 4 && newPosition.y >= 0) {
                    this.position = this.position.add(unitVector);
                }
            }
        }
    }
}
