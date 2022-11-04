package agh.ics.oop;

import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap {

    private final int noOfGrassFields;

    public GrassField(int noOfGrassFields) {
        this.noOfGrassFields = noOfGrassFields;
        this.topRightVector = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.bottomLeftVector = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (int i = 0; i < noOfGrassFields; i++) {
            grassList.add(generateGrass());
        }
    }

    private Grass generateGrass() {
        Vector2d grassPosition;
        do {
            grassPosition = new Vector2d(
                    ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(noOfGrassFields * 10) + 1),
                    ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(noOfGrassFields * 10) + 1)
            );
        } while (isOccupied(grassPosition));
        return new Grass(grassPosition);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return occupationList.contains(new Animal(this, position)) || grassList.contains(new Grass(position));
    }

    @Override
    public Object objectAt(Vector2d position) {
        Animal testAnimal = new Animal(this, position);
        Grass testGrass = new Grass(position);

        // OLD APPROACH (O(n) but what if new grass is generated where item has been already drawn?)
        // Because MapVisualizer uses this method for obtaining objects, we can delete grass right here
        //if (occupationList.contains(testAnimal) && grassList.contains(testGrass)) {
        //    grassList.remove(testGrass);

        // Add new grass
        //    grassList.add(generateGrass());
        //}

        // Animal has greater priority than Grass
        for (Animal a : occupationList) {
            if (a.equals(testAnimal)) {
                return a;
            }
        }

        for (Grass g : grassList) {
            if (g.equals(testGrass)) {
                return g;
            }
        }

        return null;
    }

    // NEW APPROACH: O(n^2), but it allows to update map before using .toString().
    private void updateGrass() {
        int removedGrass = 0;
        for (Animal a : occupationList) {
            Grass testGrass = new Grass(a.getPosition());
            if (grassList.contains(testGrass)) {
                grassList.remove(testGrass);
                removedGrass += 1;
            }
        }

        while (removedGrass > 0) {
            grassList.add(generateGrass());
            removedGrass -= 1;
        }
    }

    protected Vector2d[] getMapBounds() {
        updateGrass();

        // Find the farthest point
        int minOX = Integer.MAX_VALUE;
        int minOY = Integer.MAX_VALUE;
        int maxOX = Integer.MIN_VALUE;
        int maxOY = Integer.MIN_VALUE;

        for (Animal a : occupationList) {
            Vector2d animalPosition = a.getPosition();
            minOX = Math.min(animalPosition.x, minOX);
            minOY = Math.min(animalPosition.y, minOY);
            maxOX = Math.max(animalPosition.x, maxOX);
            maxOY = Math.max(animalPosition.y, maxOY);
        }

        for (Grass g : grassList) {
            Vector2d grassPosition = g.getPosition();
            minOX = Math.min(grassPosition.x, minOX);
            minOY = Math.min(grassPosition.y, minOY);
            maxOX = Math.max(grassPosition.x, maxOX);
            maxOY = Math.max(grassPosition.y, maxOY);
        }

        return new Vector2d[]{new Vector2d(minOX, minOY), new Vector2d(maxOX, maxOY)};
    }
}