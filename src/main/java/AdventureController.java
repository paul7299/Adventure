import java.util.ArrayList;

public class AdventureController {
    Player player;
    AdventureCreator adventureCreator;
    Room startRoom;


    public AdventureController() {
        adventureCreator = new AdventureCreator();
        adventureCreator.createMap();
        startRoom = adventureCreator.getRoom1();
        player = new Player( startRoom);
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


    public String getCurrentRoomName(){
        return player.getCurrentRoomNameFromPlayer();
    }

    //Skal bruges senere til døre
    public void getCurrentRoomDoors() {
        if (player.getCurrentRoom().getRoomNorth() != null) {
            System.out.println("There is a door north");
        }
        if (player.getCurrentRoom().getRoomSouth() != null) {
            System.out.println("There is a door south");
        }
        if (player.getCurrentRoom().getRoomEast() != null) {
            System.out.println("There is a door east");
        }
        if (player.getCurrentRoom().getRoomWest() != null) {
            System.out.println("There is a door west");
        }
    }

    public void setHasVisitedStatusToTrue() {
        player.setHasVisitedToTrue();
    }

    //bruges til at tjekke om man har besøgt et rum før
    public Boolean hasVisitedStatus() {
        return player.getHasVisitedStatus();
    }

    public String playerLook(){
       return player.look();
    }
    public String pickUpItem(String name){
        return player.pickUpItem(name);
    }
    public String dropItem(String name){
        return player.dropItem(name);
    }

}

