public class AdventureController extends Player {
    Player player;
    AdventureCreator adventureCreator;
    Room startRoom = adventureCreator.getRoom1();


    public AdventureController() {
        adventureCreator = new AdventureCreator();
        player = new Player(startRoom);
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
        player.getCurrentRoom().setHasVisitedToTrue();
    }

    //bruges til at tjekke om man har besøgt et rum før
    public Boolean hasVisitedStatus() {
        return player.getCurrentRoom().getHasVisited();
    }
}
