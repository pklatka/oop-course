package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {

    private AbstractWorldMap map;

    private Integer cellWidth = 20;
    private Integer cellHeight = 20;
    private Double borderWidth = 1.2;

    public void init() throws IllegalArgumentException {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionsParser().parse(args);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            this.map = new GrassField(10);
            IEngine engine = new SimulationEngine(directions, map, positions);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Platform.exit();
            System.exit(0);
        }
    }


    public void start(Stage primaryStage) {

        String inlineStyle = "-fx-border-color: darkgray; " +
                "-fx-min-width: " + cellWidth + ";" +
                "-fx-min-height:" + cellHeight + ";";

        GridPane grid = new GridPane();
//        grid.setGridLinesVisible(true); // Replaced with custom inline-css because why not :)


        // Iinitialize coordinates
        Label label = new Label("y/x");
        label.setAlignment(Pos.CENTER);
        label.setStyle(inlineStyle + "-fx-border-width:" + borderWidth + ";");
        grid.getColumnConstraints().add(new ColumnConstraints(cellWidth));
        grid.getRowConstraints().add(new RowConstraints(cellHeight));
        grid.add(label, 0, 0);


        Vector2d[] mapBounds = map.getMapBounds();

        // For debug purposes
        System.out.println(map);

        Integer value = mapBounds[0].x;
        for (int x = 1; x <= mapBounds[1].x - mapBounds[0].x + 1; x++) {
            grid.getColumnConstraints().add(new ColumnConstraints(cellWidth));
            label = new Label(value.toString());
            label.setStyle(inlineStyle + "-fx-border-width:" + borderWidth + " " + borderWidth + " " + borderWidth + " 0;");
            label.setAlignment(Pos.CENTER);
            grid.add(label, x, 0);
            value += 1;
        }


        value = mapBounds[1].y;
        for (int y = 1; y <= mapBounds[1].y - mapBounds[0].y + 1; y++) {
            grid.getRowConstraints().add(new RowConstraints(cellHeight));
            label = new Label(value.toString());
            label.setStyle(inlineStyle + "-fx-border-width: 0 " + borderWidth + " " + borderWidth + " " + borderWidth + ";");
            label.setAlignment(Pos.CENTER);
            grid.add(label, 0, y);
            value -= 1;
        }

        inlineStyle += "-fx-border-width: 0 " + borderWidth + " " + borderWidth + " 0;";

        int yCoord = mapBounds[1].y;
        for (int y = 1; y <= mapBounds[1].y - mapBounds[0].y + 1; y++) {
            int xCoord = mapBounds[0].x;
            for (int x = 1; x <= mapBounds[1].x - mapBounds[0].x + 1; x++) {
                // Translate y coord, because (0,0) is in the upper left corner
                Object object = map.objectAt(new Vector2d(xCoord, yCoord));
                if (object == null) {
                    label = new Label(" ");
                } else {
                    label = new Label(object.toString());
                }
                label.setStyle(inlineStyle);
                label.setAlignment(Pos.CENTER);
                grid.add(label, x, y);
                xCoord += 1;
            }
            yCoord -= 1;
        }

        grid.setAlignment(Pos.CENTER);
        // Detect width of map and create scene with this value
        Scene scene = new Scene(grid, Math.min(1300, (mapBounds[1].x - mapBounds[0].x + 2) * (cellWidth + 1)),
                Math.min(1300, (mapBounds[1].y - mapBounds[0].y + 2) * (cellHeight + 1)));
        primaryStage.setTitle("WorldMap");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
    