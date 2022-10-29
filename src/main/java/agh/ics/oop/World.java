package agh.ics.oop;

/*
 * Co zostało zmienione?
 * - do klasy RectangularMap została dodana metoda dimensions(), któa potrzebna jest dla działania metody runAnimation()
 * - dodano gettery do klasy Animal (które nie zwracają referencji do pól prywatnych :))
 * - do klasy SimulationEngine dodano metodę runAnimation do uruchomienia wizualizacji SwingMapVisualizer
 *
 * */

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.runAnimation();
    }
}