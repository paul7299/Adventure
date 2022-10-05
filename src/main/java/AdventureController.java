import java.util.ArrayList;

public class AdventureController {
    Room startRoom;
    Player player;
    AdventureCreator adventureCreator;

    public AdventureController() {
        adventureCreator = new AdventureCreator();
        adventureCreator.createMap();
        startRoom = adventureCreator.getRoom1();
        player = new Player(startRoom);
    }

    public String playerGoNorth() {
        return player.goNorth();
    }

    public String playerGoSouth() {
        return player.goSouth();
    }

    public String playerGoEast() {
        return player.goEast();
    }

    public String playerGoWest() {
        return player.goWest();
    }

    public String getPlayerCurrentRoomName() {
        return player.getCurrentRoomNameFromPlayer();
    }

    //Skal bruges senere til døre
    public String[] getCurrentRoomDoors() {
        return player.getCurrentRoomDoors();
    }

    public void setHasVisitedStatusToTrue() {
        player.setHasVisitedToTrue();
    }

    //bruges til at tjekke om man har besøgt et rum før
    public Boolean hasVisitedStatus() {
        return player.getHasVisitedStatus();
    }

    public String playerLook() {
        return player.look();
    }

    public ArrayList<Item> showInventory() {
        return player.showInventory();
    }

    public String pickUpItem(String name) {
        return player.pickUpItem(name);
    }

    public String dropItem(String name) {
        return player.dropItem(name);
    }
}

