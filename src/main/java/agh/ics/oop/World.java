package agh.ics.oop;

import java.lang.System;

public class World {

    public static void run(Direction[] args){
        System.out.println("Start");
        for(Direction arg : args){
            switch (arg){
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
        System.out.println("Stop");
}

    public static void main(String[] args){
        System.out.println("system wystartował");

        // Convert string to enum
        Direction enumArgs[] = new Direction[args.length];
        for (int i = 0; i < args.length; i++) {
            enumArgs[i] = switch (args[i]){
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.UNDEFINED;
            };
        }

        run(enumArgs);
        System.out.println("system zakończył działanie");
    }
}
