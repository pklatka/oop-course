package agh.ics.oop;

import java.lang.System;

public class World {

    public static void run(String[] args){
        if(args.length == 0) return;

        for (int i = 0; i < args.length-1; i++) {
            System.out.print(args[i] + ", ");
        }
        System.out.println(args[args.length-1]);

}

    public static void main(String[] args){
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył działanie");
    }
}
