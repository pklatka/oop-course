package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class SimulationEngine implements IEngine, Runnable {

    private MoveDirection[] directionArray;
    private IWorldMap map;
    // Use ArrayList to remember initial animal order
    private final ArrayList<Animal> animalsOrder = new ArrayList<>();
    private int moveDelay = 1000;
    private final ArrayList<App> observers = new ArrayList<>();

    public SimulationEngine(IWorldMap map, Vector2d[] positionArray) {
        this.map = map;

        // Add animals to map
        for (Vector2d position : positionArray) {
            Animal newAnimal = new Animal(map, position);
            if (map.place(newAnimal)) {
                animalsOrder.add(newAnimal);
            }

        }
    }

    public SimulationEngine(IWorldMap map, Vector2d[] positionArray, MoveDirection[] directionArray) {
        this(map, positionArray);
        this.directionArray = directionArray;
    }

    public SimulationEngine(IWorldMap map, Vector2d[] positionArray, MoveDirection[] directionArray, App observer) {
        this(map, positionArray, directionArray);
        this.observers.add(observer);
    }

    public SimulationEngine(IWorldMap map, Vector2d[] positionArray, MoveDirection[] directionArray, App observer, int moveDelay) {
        this(map, positionArray, directionArray, observer);
        this.moveDelay = moveDelay;
    }


    // Use it when you need to wait for thread
    private void runAndWait() throws InterruptedException {
        try {
            // Why using CountDownLatch?
            // Rendering grid might be time-consuming, so we must be ensured, that old grid has already been rendered.
            CountDownLatch doneLatch = new CountDownLatch(observers.size());
            for (App app : observers) {
                Platform.runLater(() -> {
                    try {
                        app.renderGrid();
                    } finally {
                        doneLatch.countDown();
                    }
                });
            }
            doneLatch.await();
        } catch (InterruptedException e) {
            throw new InterruptedException(e.getMessage());
        }
    }

    private void dispatchAnimation() {
        for (App app : observers) {
            Platform.runLater(app::renderGrid);
        }
    }

    @Override
    public void run() {
        int n = animalsOrder.size();

        try {
            dispatchAnimation();
            for (int i = 0; i < directionArray.length; i++) {
                animalsOrder.get(i % n).move(directionArray[i]);
                dispatchAnimation();
                Thread.sleep(moveDelay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        Vector2d[] dimensions = castMap.getMapBounds();
        SwingMapVisualizer s = new SwingMapVisualizer(dimensions[1].x - dimensions[0].x + 1,
                dimensions[1].y - dimensions[0].y + 1, animalsOrder);

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

    public void setDirectionArray(MoveDirection[] directionArray) {
        this.directionArray = directionArray;
    }

}