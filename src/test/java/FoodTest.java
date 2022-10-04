import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    Food f1;
    Food f2;
    Player player;
    Room testRoom;

    @BeforeEach
    void setUpFood(){
        f1 = new Food("Hotdog", "Juicy Hotdog", -10);
        f2 = new Food("Æble", "Pose æbler", 10);
        player = new Player(testRoom = new Room("testRoom", "for testing"));
        testRoom.getItemsInRoom().add(new Food ("Kebab", "Med ekstra chilli", 10));
    }

    @Test
    void eatFood(){
        int expectedHealthAfterHotdog = 40;
        int expectedItemsAfterEat = 0;

        ArrayList <Item> testlist = player.showInventory();
        //Food f1 = (Food) testlist.get(0);
       int f1h = f1.getFoodHealth();
       int p1h = player.getPlayerHealth();

       p1h += f1h;
       assertEquals(expectedHealthAfterHotdog,p1h);
    }

    @Test
    void pickUpFood(){
        int expectedListSize = 1;
        String expectedNameInIndex0 = "Kebab";

        player.pickUpItem("Kebab");

        assertEquals(expectedListSize, player.showInventory().size());
        assertEquals(expectedNameInIndex0, player.showInventory().get(0).getItemName());

    }
}