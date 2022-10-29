package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void testPlace() {
        IWorldMap map = new RectangularMap(10, 5);
        // Add animal
        map.place(new Animal(map, new Vector2d(3, 3)));

        assertFalse(map.place(new Animal(map, new Vector2d(3, 3))));
        assertTrue(map.place(new Animal(map, new Vector2d(3, 5))));
    }

    @Test
    public void testCanMoveTo() {
        IWorldMap map = new RectangularMap(10, 5);
        // Add animal
        map.place(new Animal(map, new Vector2d(3, 3)));

        assertTrue(map.canMoveTo(new Vector2d(3, 4)));
        assertFalse(map.canMoveTo(new Vector2d(3, 3)));
    }

    @Test
    public void testIsOccupied() {
        IWorldMap map = new RectangularMap(10, 5);
        // Add animal
        map.place(new Animal(map, new Vector2d(3, 3)));

        assertFalse(map.isOccupied(new Vector2d(3, 4)));
        assertTrue(map.isOccupied(new Vector2d(3, 3)));
    }

    @Test
    public void testObjectAt() {
        IWorldMap map = new RectangularMap(10, 5);
        // Add animal
        Animal animal = new Animal(map, new Vector2d(3, 3));
        map.place(animal);

        assertEquals(map.objectAt(new Vector2d(3, 3)), animal);
        assertNull(map.objectAt(new Vector2d(3, 4)));
    }

    @Test
    public void testToString() {
        IWorldMap map = new RectangularMap(5, 5);
        // Add animal
        Animal animal1 = new Animal(map, new Vector2d(3, 3));
        map.place(animal1);
        Animal animal2 = new Animal(map, new Vector2d(1, 3));
        animal2.move(MoveDirection.RIGHT);
        map.place(animal2);

        System.out.println(map.toString());
    }

}
