package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void testPlace() {
        IWorldMap map = new GrassField(10);
        // Add animal
        map.place(new Animal(map, new Vector2d(3, 3)));

        assertFalse(map.place(new Animal(map, new Vector2d(3, 3))));
    }

    @Test
    public void testCanMoveTo() {
        IWorldMap map = new GrassField(10);
        // Add animal
        map.place(new Animal(map, new Vector2d(3, 3)));

        assertFalse(map.canMoveTo(new Vector2d(3, 3)));
    }

    @Test
    public void testIsOccupied() {
        IWorldMap map = new GrassField(10);
        // Add animal
        map.place(new Animal(map, new Vector2d(3, 3)));

        assertTrue(map.isOccupied(new Vector2d(3, 3)));
    }

    @Test
    public void testObjectAt() {
        IWorldMap map = new GrassField(10);
        // Add animal
        Animal animal = new Animal(map, new Vector2d(3, 3));
        map.place(animal);

        assertEquals(map.objectAt(new Vector2d(3, 3)), animal);
    }

    @Test
    public void testToString() {
        IWorldMap map = new GrassField(10);
        // Add animal
        Animal animal1 = new Animal(map, new Vector2d(3, 3));
        map.place(animal1);
        Animal animal2 = new Animal(map, new Vector2d(1, 3));
        animal2.move(MoveDirection.RIGHT);
        map.place(animal2);

        System.out.println(map.toString());
    }

    @Test
    public void testGrassPlacement() {
        IWorldMap map = new GrassField(10);

        int countGrass = 0;

        int side = (int) Math.sqrt(10 * 10) + 1;

        for (int row = 0; row < side; row++) {
            for (int col = 0; col < side; col++) {
                Object testObject = map.objectAt(new Vector2d(row, col));
                if (testObject != null && testObject.toString().equals("*")) {
                    countGrass += 1;
                }
            }
        }

        assertTrue(countGrass == 10);
    }

}
