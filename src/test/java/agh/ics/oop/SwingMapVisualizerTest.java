package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class SwingMapVisualizerTest {
    // Best way to check if it's working is to see visualization by yourself :)

    @Test
    public void testAnimalMovement() {
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
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
        SimulationEngine engine = new SimulationEngine(map, positions, directions);
        engine.runAnimation();
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
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
        SimulationEngine engine = new SimulationEngine(map, positions, directions);
        engine.runAnimation();
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
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
        SimulationEngine engine = new SimulationEngine(map, positions, directions);
        engine.runAnimation();
    }

    @Test
    public void testNorthSouthEastWestSides() {
        MoveDirection[] directions = new MoveDirection[]{
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
        };
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = {new Vector2d(2, 2)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
        SimulationEngine engine = new SimulationEngine(map, positions, directions);
        engine.runAnimation();
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
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
        SimulationEngine engine = new SimulationEngine(map, positions, directions);
        engine.runAnimation();
    }

}