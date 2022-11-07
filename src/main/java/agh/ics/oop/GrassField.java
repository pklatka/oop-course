package agh.ics.oop;

import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap {

    private final int noOfGrassFields;
    private int minCoordinateOX = Integer.MAX_VALUE;
    private int minCoordinateOY = Integer.MAX_VALUE;
    private int maxCoordinateOX = Integer.MIN_VALUE;
    private int maxCoordinateOY = Integer.MIN_VALUE;


    public GrassField(int noOfGrassFields) {
        this.noOfGrassFields = noOfGrassFields;
        this.topRightVector = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.bottomLeftVector = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (int i = 0; i < noOfGrassFields; i++) {
            addGrass();
        }
    }

    private void addGrass() {
        Vector2d grassPosition;
        do {
            grassPosition = new Vector2d(
                    ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(noOfGrassFields * 10) + 1),
                    ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(noOfGrassFields * 10) + 1)
            );
        } while (isOccupied(grassPosition));
        updateMapBoundaries(grassPosition);
        grassHashMap.put(grassPosition, new Grass(grassPosition));
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animalHashMap.containsKey(position) || grassHashMap.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animalHashMap.containsKey(position)) {
            return animalHashMap.get(position);
        }

        if (grassHashMap.containsKey(position)) {
            return grassHashMap.get(position);
        }

        return null;
    }

    @Override
    protected void updateAnimalPosition(Vector2d oldPosition, Vector2d newPosition) {
        super.updateAnimalPosition(oldPosition, newPosition);
        updateMapBoundaries(newPosition);

        // Eat grass
        if (grassHashMap.containsKey(newPosition)) {
            grassHashMap.remove(newPosition);
            addGrass();
        }
    }

    private void updateMapBoundaries(Vector2d position) {
        minCoordinateOX = Math.min(position.x, minCoordinateOX);
        minCoordinateOY = Math.min(position.y, minCoordinateOY);
        maxCoordinateOX = Math.max(position.x, maxCoordinateOX);
        maxCoordinateOY = Math.max(position.y, maxCoordinateOY);
    }

    protected Vector2d[] getMapBounds() {
        return new Vector2d[]{new Vector2d(minCoordinateOX, minCoordinateOY),
                new Vector2d(maxCoordinateOX, maxCoordinateOY)};
    }
}