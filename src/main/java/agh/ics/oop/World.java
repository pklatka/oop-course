package agh.ics.oop;

import java.lang.System;

public class World {

    public static void run(String[] args){
        System.out.println("Start");
        for(String arg : args){
            switch (arg){
                case "f":
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case "b":
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case "r":
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case "l":
                    System.out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
        System.out.println("Stop");
}

    public static void main(String[] args){
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył działanie");
    }
}
