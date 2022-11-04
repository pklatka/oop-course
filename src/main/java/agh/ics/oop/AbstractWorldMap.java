package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final ArrayList<Animal> occupationList = new ArrayList<>();
    protected final ArrayList<Grass> grassList = new ArrayList<>();

    protected Vector2d topRightVector;
    protected Vector2d bottomLeftVector;

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

    protected abstract Vector2d[] getMapBounds();

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        Vector2d[] mapBounds = getMapBounds();
        return mapVisualizer.draw(mapBounds[0], mapBounds[1]);
    }
}
