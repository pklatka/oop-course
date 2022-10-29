package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void testAnimalOrientationNorth() {
        Animal testAnimal = new Animal();
        assertEquals("N", testAnimal.toString());
    }

    @Test
    public void testAnimalOrientationEast() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.RIGHT);
        assertEquals("E", testAnimal.toString());
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.LEFT);
        assertEquals("E", testAnimal.toString());

    }

    @Test
    public void testAnimalOrientationSouth() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.RIGHT);
        assertEquals("S", testAnimal.toString());
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.LEFT);
        assertEquals("S", testAnimal.toString());
    }


    @Test
    public void testAnimalOrientationWest() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.LEFT);
        assertEquals("W", testAnimal.toString());
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.RIGHT);
        assertEquals("W", testAnimal.toString());
    }


    @Test
    public void testAnimalPositionOrientationNorth() {
        Animal testAnimal = new Animal();
        // Orientation - NORTH

        Vector2d expectedForward1 = new Vector2d(2, 3);
        Vector2d expectedForward2 = new Vector2d(2, 4);
        Vector2d expectedBackward = new Vector2d(2, 3);

        // Test FORWARD
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(expectedForward1));

        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(expectedForward2));

        // Test BACKWARD
        testAnimal.move(MoveDirection.BACKWARD);
        assertTrue(testAnimal.isAt(expectedBackward));
    }

    @Test
    public void testAnimalPositionOrientationEast() {
        Animal testAnimal = new Animal();
        // Orientation - EAST
        testAnimal.move(MoveDirection.RIGHT);

        Vector2d expectedForward1 = new Vector2d(3, 2);
        Vector2d expectedForward2 = new Vector2d(4, 2);
        Vector2d expectedBackward = new Vector2d(3, 2);

        // Test FORWARD
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(expectedForward1));

        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(expectedForward2));

        // Test BACKWARD
        testAnimal.move(MoveDirection.BACKWARD);
        assertTrue(testAnimal.isAt(expectedBackward));
    }

    @Test
    public void testAnimalPositionOrientationSouth() {
        Animal testAnimal = new Animal();
        // Orientation - SOUTH
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.RIGHT);

        Vector2d expectedForward1 = new Vector2d(2, 1);
        Vector2d expectedForward2 = new Vector2d(2, 0);
        Vector2d expectedBackward = new Vector2d(2, 1);

        // Test FORWARD
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(expectedForward1));

        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(expectedForward2));

        // Test BACKWARD
        testAnimal.move(MoveDirection.BACKWARD);
        assertTrue(testAnimal.isAt(expectedBackward));
    }

    @Test
    public void testAnimalPositionOrientationWest() {
        Animal testAnimal = new Animal();
        // Orientation - WEST
        testAnimal.move(MoveDirection.LEFT);

        Vector2d expectedForward1 = new Vector2d(1, 2);
        Vector2d expectedForward2 = new Vector2d(0, 2);
        Vector2d expectedBackward = new Vector2d(1, 2);

        // Test FORWARD
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(expectedForward1));

        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(expectedForward2));

        // Test BACKWARD
        testAnimal.move(MoveDirection.BACKWARD);
        assertTrue(testAnimal.isAt(expectedBackward));
    }

    @Test
    public void testAnimalBoundariesNorth() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(new Vector2d(2, 4)));
    }

    @Test
    public void testAnimalBoundariesEast() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(new Vector2d(4, 2)));

    }

    @Test
    public void testAnimalBoundariesSouth() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        assertTrue(testAnimal.isAt(new Vector2d(2, 0)));

    }

    @Test
    public void testAnimalBoundariesWest() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(new Vector2d(0, 2)));
    }


    @Test
    public void testAnimalBoundariesNorthEast() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        System.out.println(testAnimal.getPosition());
        assertTrue(testAnimal.isAt(new Vector2d(4, 4)));
    }


    @Test
    public void testAnimalBoundariesNorthWest() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(new Vector2d(0, 4)));
    }

    @Test
    public void testAnimalBoundariesSouthEast() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.RIGHT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(new Vector2d(4, 0)));
    }

    @Test
    public void testAnimalBoundariesSouthWest() {
        Animal testAnimal = new Animal();
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.BACKWARD);
        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        testAnimal.move(MoveDirection.FORWARD);
        assertTrue(testAnimal.isAt(new Vector2d(0, 0)));
    }
}
