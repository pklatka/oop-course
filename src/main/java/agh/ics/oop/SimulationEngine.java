package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {

    public MoveDirection[] directionArray;
    public IWorldMap map;
    // Use ArrayList to remember initial animal order
    private final ArrayList<Animal> animalsOrder = new ArrayList<>();

    public SimulationEngine(MoveDirection[] directionArray, IWorldMap map, Vector2d[] positionArray) {
        this.directionArray = directionArray;
        this.map = map;

        // Add animals to map
        for (Vector2d position : positionArray) {
            Animal newAnimal = new Animal(map, position);
            if (map.place(newAnimal)) {
                animalsOrder.add(newAnimal);
            }

        }
    }

    @Override
    public void run() {
        int n = animalsOrder.size();

        for (int i = 0; i < directionArray.length; i++) {
            animalsOrder.get(i % n).move(directionArray[i]);
            System.out.println(map.toString());
        }
    }

    public void runAnimation() {
        // Using SwingMapVisualizer
        int n = animalsOrder.size();
        int simulationSpeed = 10; // Range: [1 - 10], 10 -> optimal
        // Cast map to RectangularMap
        if (map.getClass() != RectangularMap.class) {
            return;
        }
        RectangularMap castMap = (RectangularMap) map;
        SwingMapVisualizer s = new SwingMapVisualizer(castMap.dimensions().x + 1, castMap.dimensions().y + 1, animalsOrder);

        for (int i = 0; i < directionArray.length; i++) {
            Vector2d oldPosition = animalsOrder.get(i % n).getPosition();
            MapDirection oldHeading = animalsOrder.get(i % n).getHeading();

            animalsOrder.get(i % n).move(directionArray[i]);
            switch (directionArray[i]) {
                case FORWARD, BACKWARD -> {
                    s.grid.moveAnimal(animalsOrder.get(i % n), i % n, oldPosition, directionArray[i], simulationSpeed);
                }
                case LEFT, RIGHT -> {
                    s.grid.rotateAnimal(animalsOrder.get(i % n), i % n, oldHeading, simulationSpeed);
                }
            }
        }
    }
}
