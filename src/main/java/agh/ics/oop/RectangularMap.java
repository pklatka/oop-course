package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    public int width;
    public int height;
    public final ArrayList<Animal> occupationList = new ArrayList<>();
    public final Vector2d topRightVector;
    public final Vector2d bottomLeftVector;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.topRightVector = new Vector2d(width, height);
        this.bottomLeftVector = new Vector2d(0, 0);
    }

    public Vector2d dimensions() {
        return new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !occupationList.contains(new Animal(this, position))
                && position.precedes(topRightVector)
                && position.follows(bottomLeftVector);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            occupationList.add(animal);
            return true;
        }
        return false;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return occupationList.contains(new Animal(this, position));
    }

    @Override
    public Object objectAt(Vector2d position) {
        Animal testAnimal = new Animal(this, position);

        if (!occupationList.contains(testAnimal)) {
            return null;
        }

        for (Animal a : occupationList) {
            if (a.equals(testAnimal)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(bottomLeftVector, topRightVector);
    }
}