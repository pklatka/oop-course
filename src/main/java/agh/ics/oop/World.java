package agh.ics.oop;

import java.util.Arrays;
import java.util.stream.*;

public class World {

    public static void run(Direction[] args){
        System.out.println("Start");
        Stream.of(args).map(e->
            switch (e) {
                case FORWARD -> "Zwierzak idzie do przodu\n";
                case BACKWARD ->"Zwierzak idzie do tyłu\n";
                case RIGHT -> "Zwierzak skręca w prawo\n";
                case LEFT -> "Zwierzak skręca w lewo\n";
                default -> "";
            }
        ).forEach(System.out::print);
        System.out.println("Stop");
}

    public static void main(String[] args){
        System.out.println("system wystartował");

        Direction[] enumArgs = Arrays.stream(args).map(e->{
            // Swap string to enum
            // There might be a better solution using Direction.valueOf(String e)
            // but it requires enum names to be the same as string
            return switch (e){
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.UNDEFINED;
            };
        }).toArray(Direction[]::new);

        run(enumArgs);
        System.out.println("system zakończył działanie");
    }
}
