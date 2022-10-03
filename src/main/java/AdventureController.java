import java.util.ArrayList;

public class AdventureController extends Player {
    Player player;
    AdventureCreator adventureCreator;
    Room startRoom;


    public AdventureController() {
        adventureCreator = new AdventureCreator();
        adventureCreator.createMap();
        startRoom = adventureCreator.getRoom1();
        player = new Player(startRoom);
    }

    public Item searchForItem(String searchName, ArrayList<Item> searchItemList) {
        for (Item n : searchItemList) {
            if (n.getItemName().contains(searchName)) {
                return n;
            }
        } return null;
    }

    public String getCurrentRoomName(){
        return player.getCurrentRoomNameFromPlayer();
    }

    public void dropItem(String name) {
        Item itemToTransfer = searchForItem(name, player.showInventory());
        if(itemToTransfer == null){
            System.out.println("No item found");
        }
        else {
            player.showInventory().remove(itemToTransfer);
            player.getCurrentRoom().getItemsInRoom().add(itemToTransfer);
            System.out.println("You have dropped " + itemToTransfer.getItemName() + " in " + player.currentRoom.getRoomName());
        }
    }

    public void pickUpItem(String name) {

        Item itemToTransfer = searchForItem(name, player.getCurrentRoom().getItemsInRoom());
        if (itemToTransfer == null) {
            System.out.println("No item found");
        } else {
            player.showInventory().add(itemToTransfer);
            player.getCurrentRoom().getItemsInRoom().remove(itemToTransfer);
            System.out.println("You have picked up " + itemToTransfer.getItemName());
        }
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

