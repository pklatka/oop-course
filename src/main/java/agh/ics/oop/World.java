package agh.ics.oop;

/*
 * Ważne informacje
 * - Koncepcja: Animal to publisher (subject) -> ten co wysyła komunikaty,
 *      IWorldMap to subscriber (observer) -> ten co odbiera komunikaty i je przetwarza
 * */

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
//        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        //  f b r l f f r r f f f f f f f f
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
//        SimulationEngine engine = new SimulationEngine(directions, map, positions);
//        engine.runAnimation();
    }
}