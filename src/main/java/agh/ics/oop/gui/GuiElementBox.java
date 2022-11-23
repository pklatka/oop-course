package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private Image image;
    private Label label;
    private VBox box;

    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        try {
            String filePath = new File("").getAbsolutePath();
            filePath = filePath.concat("/src/main/resources/");
            image = new Image(new FileInputStream(filePath.concat(element.getImageResource())));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(25);
            imageView.setFitHeight(25);

            label = new Label(element.getObjectLabel());

            box = new VBox(1);
            box.getChildren().addAll(imageView, label);
            box.setAlignment(Pos.CENTER);
            box.setPadding(new Insets(5, 0, 0, 0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public VBox getNode() {
        return box;
    }
}