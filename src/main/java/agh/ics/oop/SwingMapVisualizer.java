package agh.ics.oop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// Note: w poleceniu 8. zotało napisane, że widżet biblioteki Swing ma być tekstowy,
// z rozpędu napisałem graficzny korzystając z Graphics2D.
public class SwingMapVisualizer extends JFrame {

    private final int squareSize = 50;
    private final Vector2d startPoint = new Vector2d(3, 3);
    private final int width;
    private final int height;

    private final ArrayList<Animal> animalList;
    private final int[][] animalInfo;
    public final Grid grid;

    public SwingMapVisualizer(int width, int height, ArrayList<Animal> animals) {
        this.width = width;
        this.height = height;

        this.animalInfo = new int[animals.size()][4];
        this.animalList = animals;

        // Initialize animalInfo array
        int i = 0;
        for (Animal animal : animals) {
            // Array consists of [x_coord_in_JFrame, y_coord_in_JFrame, rotation_angle, rotation_sign]
            Vector2d position = animal.getPosition();
            position = calculateNewPosition(position.x, (this.height - position.y - 1));
            this.animalInfo[i][0] = position.x;
            this.animalInfo[i][1] = position.y;
            this.animalInfo[i][2] = 0;
            this.animalInfo[i][3] = 0;
            i += 1;
        }

        // JFrame options
        setSize(Math.min(width * squareSize + 19, 1200), Math.min(height * squareSize + 41, 1200));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Animal observer :D");

        // Add app icon
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("/src/main/resources/");
        ImageIcon img = new ImageIcon(filePath.concat("head_south.png"));
        setIconImage(img.getImage());

        // Add grid component
        grid = new Grid();
        add(grid);

        setVisible(true);
    }


    // Utility for calculating position on JPanel
    private Vector2d calculateNewPosition(int x, int y) {
        return new Vector2d(startPoint.x + 5 + x * squareSize, startPoint.y + 5 + (y) * squareSize);
    }

    public class Grid extends JPanel {
        Image headSouth;
        Image headNorth;
        Image headEast;
        Image headWest;

        public Grid() {
            setBackground(Color.WHITE);

            // Download images
            try {
                String filePath = new File("").getAbsolutePath();
                filePath = filePath.concat("/src/main/resources/");

                BufferedImage img = ImageIO.read(new File(filePath.concat("head_north.png")));
                this.headNorth = img.getScaledInstance(40, 40, Image.SCALE_DEFAULT);

                img = ImageIO.read(new File(filePath.concat("head_south.png")));
                this.headSouth = img.getScaledInstance(40, 40, Image.SCALE_DEFAULT);


                img = ImageIO.read(new File(filePath.concat("head_east.png")));
                this.headEast = img.getScaledInstance(40, 40, Image.SCALE_DEFAULT);


                img = ImageIO.read(new File(filePath.concat("head_west.png")));
                this.headWest = img.getScaledInstance(40, 40, Image.SCALE_DEFAULT);

            } catch (IOException e) {
                System.out.println("Wrong image path in SwingMapVisualizer class");
                e.printStackTrace();
            }
        }

        public void moveAnimal(Animal animal, int animalIndex, Vector2d oldPosition, MoveDirection direct, int speed) {
            speed = Math.min(speed, 10);
            Vector2d currentPosition = animal.getPosition();

            MapDirection animalHeading = animal.getHeading();
            // Create unitVector
            Vector2d unitVector = animalHeading.toUnitVector();

            switch (animalHeading) {
                case NORTH, SOUTH -> {
                    Vector2d unitVectorTest = animalHeading.toUnitVector(); // Forward
                    unitVector = currentPosition.equals(oldPosition.add(unitVectorTest)) ? unitVectorTest.opposite() : unitVectorTest;
                }

                case EAST, WEST -> {
                    if (direct == MoveDirection.BACKWARD) {
                        unitVector = unitVector.opposite();
                    }
                }
            }


            boolean goingLeft = unitVector.x == -1 && unitVector.y == 0;
            boolean goingRight = unitVector.x == 1 && unitVector.y == 0;
            boolean goingUp = unitVector.x == 0 && unitVector.y == -1;
            boolean goingDown = unitVector.x == 0 && unitVector.y == 1;

            // Update animal position
            Vector2d positionToObtain = calculateNewPosition(currentPosition.x, height - currentPosition.y - 1);

            while ((positionToObtain.x < animalInfo[animalIndex][0] && positionToObtain.y == animalInfo[animalIndex][1] && goingLeft)
                    || (positionToObtain.x > animalInfo[animalIndex][0] && positionToObtain.y == animalInfo[animalIndex][1] && goingRight)
                    || (positionToObtain.x == animalInfo[animalIndex][0] && positionToObtain.y > animalInfo[animalIndex][1] && goingDown)
                    || (positionToObtain.x == animalInfo[animalIndex][0] && positionToObtain.y < animalInfo[animalIndex][1] && goingUp)
            ) {
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                animalInfo[animalIndex][0] += unitVector.x;
                animalInfo[animalIndex][1] += unitVector.y;
                repaint();
            }
        }

        public void rotateAnimal(Animal animal, int animalIndex, MapDirection oldDirection, int speed) {
            speed = Math.min(speed, 10);
            MapDirection currentHeading = animal.getHeading();

            final int sign = oldDirection.next() == currentHeading ? 1 : -1;
            int newTheta = sign * 90;

            animalInfo[animalIndex][3] = sign;
            while ((animalInfo[animalIndex][2] < newTheta && sign > 0) || (animalInfo[animalIndex][2] > newTheta && sign < 0)) {
                animalInfo[animalIndex][2] += sign;
                repaint();
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Reset rotate variables
            animalInfo[animalIndex][3] = 0;
            animalInfo[animalIndex][2] = 0;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Paint grid
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.GRAY);
            g2.setStroke(new BasicStroke(1.5F));
            for (int y = 0; y <= height; y++) {
                // Draw line
                int yCord = startPoint.y + y * squareSize;
                g2.draw(new Line2D.Float(startPoint.x, yCord, startPoint.x + squareSize * width, yCord));

            }
            for (int x = 0; x <= width; x++) {
                // Draw line
                int xCord = startPoint.x + x * squareSize;
                g2.draw(new Line2D.Float(xCord, startPoint.y, xCord, startPoint.y + squareSize * height));
            }


            // Draw animal
            for (int i = 0; i < animalList.size(); i++) {
                Vector2d position = animalList.get(i).getPosition();
                MapDirection heading = animalList.get(i).getHeading();

                Graphics2D g2d = (Graphics2D) g.create();

                Image img = switch (animalList.get(i).getHeading()) {
                    case NORTH -> headNorth;
                    case SOUTH -> headSouth;
                    case EAST -> headEast;
                    case WEST -> headWest;
                };

                // If animal is rotating -> rotate image
                if (Math.floorMod(animalInfo[i][2], 90) != 0) {
                    MapDirection oldDirection;
                    if (animalInfo[i][3] > 0) {
                        oldDirection = heading.previous();
                    } else {
                        oldDirection = heading.next();
                    }

                    img = switch (oldDirection) {
                        case NORTH -> headNorth;
                        case SOUTH -> headSouth;
                        case EAST -> headEast;
                        case WEST -> headWest;
                    };

                    g2d.rotate(animalInfo[i][2] * Math.PI / 180, startPoint.x + position.x * squareSize + 25, startPoint.y + (height - position.y - 1) * squareSize + 25);
                }
                g2d.drawImage(img, animalInfo[i][0], animalInfo[i][1], this);
                g2d.dispose();
            }
        }
    }
}

