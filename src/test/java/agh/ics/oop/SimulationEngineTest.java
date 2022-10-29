package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationEngineTest {
    @Test
    public void testRun() {
        // Using MapVisualizer
        // f b r l f f r r f f f f f f f f.
        MoveDirection[] directions = new MoveDirection[]{
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD
        };
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        // Expected output:
        IWorldMap expectedMap = new RectangularMap(10, 5);
        Animal animal1 = new Animal(expectedMap, new Vector2d(2, 0));
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.RIGHT);
        expectedMap.place(animal1);
        Animal animal2 = new Animal(expectedMap, new Vector2d(3, 5));
        expectedMap.place(animal2);
        MapVisualizer expectedVisualization = new MapVisualizer(new RectangularMap(10, 5));

        // Check MapVisualizer output
        String output1 = map.toString();
        String output2 = expectedMap.toString();
        assertTrue(output2.equals(output1));


        // What if MapVisualizer fails?
        Object isAnimal1 = map.objectAt(new Vector2d(2, 0));
        assertTrue(isAnimal1.getClass() == Animal.class);
        Animal testAnimal1 = (Animal) isAnimal1;
        MapDirection mapDirectionTest1 = testAnimal1.getHeading();
        assertTrue(mapDirectionTest1 == MapDirection.SOUTH);

        Object isAnimal2 = map.objectAt(new Vector2d(3, 5));
        assertTrue(isAnimal2.getClass() == Animal.class);
        Animal testAnimal2 = (Animal) isAnimal2;
        MapDirection mapDirectionTest2 = testAnimal2.getHeading();
        assertTrue(mapDirectionTest2 == MapDirection.NORTH);
    }

    @Test
    public void testNorthAndSouthSides() {
        MoveDirection[] directions = new MoveDirection[]{
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD
        };
        IWorldMap map = new RectangularMap(3, 3);
        Vector2d[] positions = {new Vector2d(1, 1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        // Expected output:
        IWorldMap expectedMap = new RectangularMap(3, 3);
        Animal animal1 = new Animal(expectedMap, new Vector2d(1, 3));
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.RIGHT);
        expectedMap.place(animal1);

        // Check MapVisualizer output
        String output1 = map.toString();
        String output2 = expectedMap.toString();
        assertTrue(output2.equals(output1));


        // What if MapVisualizer fails?
        Object isAnimal1 = map.objectAt(new Vector2d(1, 3));
        assertTrue(isAnimal1.getClass() == Animal.class);
        Animal testAnimal1 = (Animal) isAnimal1;
        MapDirection mapDirectionTest1 = testAnimal1.getHeading();
        assertTrue(mapDirectionTest1 == MapDirection.SOUTH);

    }


    @Test
    public void testEastAndWestSides() {
        MoveDirection[] directions = new MoveDirection[]{
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD
        };
        IWorldMap map = new RectangularMap(3, 3);
        Vector2d[] positions = {new Vector2d(1, 1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        // Expected output:
        IWorldMap expectedMap = new RectangularMap(3, 3);
        Animal animal1 = new Animal(expectedMap, new Vector2d(0, 1));
        animal1.move(MoveDirection.RIGHT);
        expectedMap.place(animal1);

        // Check MapVisualizer output
        String output1 = map.toString();
        String output2 = expectedMap.toString();
        assertTrue(output2.equals(output1));


        // What if MapVisualizer fails?
        Object isAnimal1 = map.objectAt(new Vector2d(0, 1));
        assertTrue(isAnimal1.getClass() == Animal.class);
        Animal testAnimal1 = (Animal) isAnimal1;
        MapDirection mapDirectionTest1 = testAnimal1.getHeading();
        assertTrue(mapDirectionTest1 == MapDirection.EAST);

    }

    @Test
    public void testCorners() {
        MoveDirection[] directions = new MoveDirection[]{
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
        };
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = {new Vector2d(2, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        // Expected output:
        IWorldMap expectedMap = new RectangularMap(4, 4);
        Animal animal1 = new Animal(expectedMap, new Vector2d(0, 4));
        animal1.move(MoveDirection.RIGHT);
        expectedMap.place(animal1);

        // Check MapVisualizer output
        String output1 = map.toString();
        String output2 = expectedMap.toString();
        assertTrue(output2.equals(output1));


        // What if MapVisualizer fails?
        Object isAnimal1 = map.objectAt(new Vector2d(0, 4));
        assertTrue(isAnimal1.getClass() == Animal.class);
        Animal testAnimal1 = (Animal) isAnimal1;
        MapDirection mapDirectionTest1 = testAnimal1.getHeading();
        assertTrue(mapDirectionTest1 == MapDirection.EAST);

    }
}


