package agh.ics.oop;

import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected final HashMap<Vector2d, Animal> animalHashMap = new HashMap<>();
    protected final HashMap<Vector2d, Grass> grassHashMap = new HashMap<>();

    protected Vector2d topRightVector;
    protected Vector2d bottomLeftVector;

    // Helper for updating animal position (overriden in GrassField)
    protected void updateAnimalPosition(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalHashMap.get(oldPosition);
        animalHashMap.remove(oldPosition);
        animalHashMap.put(newPosition, animal);
    }

    @Override
    public boolean positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (canMoveTo(newPosition)) {
            updateAnimalPosition(oldPosition, newPosition);
            return true;
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animalHashMap.containsKey(position)
                && position.precedes(topRightVector)
                && position.follows(bottomLeftVector);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animalHashMap.put(animal.getPosition(), animal);
            animal.addObserver(this);
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
