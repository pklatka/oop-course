package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap {
    public RectangularMap(int width, int height) {
        this.topRightVector = new Vector2d(width, height);
        this.bottomLeftVector = new Vector2d(0, 0);
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

    protected Vector2d[] getMapBounds() {
        return new Vector2d[]{bottomLeftVector, topRightVector};
    }
}