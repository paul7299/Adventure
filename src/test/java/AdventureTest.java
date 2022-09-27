
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventureTest {

    Room room1;
    Room room2;
    Room room4;
    Room currentRoom;

    @BeforeEach
    void setUpRooms() {
        room1 = new Room("Room 1", "The first room.");
        room2 = new Room("Room 2", "The second room.");
        room4 = new Room("Room 4", "The fourth room.");
        currentRoom = room1;
        room1.setRooms(null,room4,room2, null);

    }

    @Test
    void goEast() {
        String expectedRoomName = "Room 2";

        if(currentRoom.getRoomEast() == null){
            System.out.println("You cannot go east from here");
        }
        else{
            currentRoom = currentRoom.getRoomEast();
        }

        Assertions.assertEquals(expectedRoomName,currentRoom.getRoomName());
    }
}