package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection heading = MapDirection.NORTH;
    private Vector2d position;
    private IWorldMap map;

    public Animal() {
        this.map = new RectangularMap(4, 4);
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map) {
        this.map = map;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    @Override
    public String toString() {
        return switch (heading) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }

    // Changing equals and hashCode methods to use HashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(position, animal.position) && Objects.equals(map, animal.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, map);
    }

    public Vector2d getPosition() {
        return new Vector2d(position.x, position.y);
    }

    public MapDirection getHeading() {
        return switch (heading) {
            case NORTH -> MapDirection.NORTH;
            case WEST -> MapDirection.WEST;
            case SOUTH -> MapDirection.SOUTH;
            case EAST -> MapDirection.EAST;
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.x == position.x && this.position.y == position.y;
    }

    public void move(MoveDirection direction) {
        // direction handling
        switch (direction) {
            case RIGHT -> heading = heading.next();
            case LEFT -> heading = heading.previous();
            case FORWARD, BACKWARD -> {
                // Simulate position change
                Vector2d newPosition = new Vector2d(position.x, position.y);
                Vector2d unitVector = heading.toUnitVector();
                if (direction == MoveDirection.BACKWARD) {
                    unitVector = unitVector.opposite();
                }
                newPosition = newPosition.add(unitVector);
                if (map.canMoveTo(newPosition)) {
                    position = position.add(unitVector);
                }
            }
        }

    }
}
