package agh.ics.oop;
public class World {
    public static void main(String[] args){
        // Test Vectod2d methods
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        // Test MapDirection methods
        MapDirection direction = MapDirection.NORTH;
        System.out.println(direction.toString());
        System.out.println(direction.previous().toString());
        System.out.println(direction.next().toString());
        System.out.println(direction.toUnitVector().toString());
    }
}
