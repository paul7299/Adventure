import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    Room room1;
    Room room2;
    Room room4;

    @BeforeEach
    void setUpRooms() {
        room1 = new Room("Room 1", "The first room.");
        room2 = new Room("Room 2", "The second room.");
        room4 = new Room("Room 4", "The fourth room.");

    }

    @Test
    void setRooms() {
        String expectedRoom2Name = "Room 2";
        String expectedRoom4Name = "Room 4";


        room1.setRooms(null, room4, room2, null);

        assertEquals(expectedRoom2Name, room1.getRoomEast().getRoomName());
        assertEquals(expectedRoom4Name, room1.getRoomSouth().getRoomName());

    }
}