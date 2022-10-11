package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    public void testNextNorth(){
        MapDirection direction = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, direction.next());
    }

    @Test
    public void testNextSouth(){
        MapDirection direction = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, direction.next());
    }

    @Test
    public void testNextEast(){
        MapDirection direction = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, direction.next());
    }

    @Test
    public void testNextWest(){
        MapDirection direction = MapDirection.WEST;
        assertEquals(MapDirection.NORTH, direction.next());
    }

    @Test
    public void testPreviousNorth(){
        MapDirection direction = MapDirection.NORTH;
        assertEquals(MapDirection.WEST, direction.previous());
    }

    @Test
    public void testPreviousSouth(){
        MapDirection direction = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, direction.previous());
    }

    @Test
    public void testPreviousEast(){
        MapDirection direction = MapDirection.EAST;
        assertEquals(MapDirection.NORTH, direction.previous());
    }

    @Test
    public void testPreviousWest(){
        MapDirection direction = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH, direction.previous());
    }
}
