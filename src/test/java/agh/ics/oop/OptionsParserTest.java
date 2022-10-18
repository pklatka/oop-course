package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionsParserTest {

    @Test
    public void testParse() {
        OptionsParser parser = new OptionsParser();
        String[] testDirections = new String[]{
                "f", "co-ja-tu-robie", "forward", "l", "DROP DATABASE main",
                "left", ":)", "right", "turn left", "r", "b", "\u0062", "@", "b",
                "\uFFFF", "\u0000", "backward", "r", "\u1F493"
        };


        MoveDirection[] expectedDirections = new MoveDirection[]{
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
        };

        assertArrayEquals(expectedDirections, parser.parse(testDirections));
    }

}