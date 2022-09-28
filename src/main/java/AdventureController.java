public class AdventureController extends Player {


    //TODO Mohamed currentRoom flyttes til player. Alle steder man kalder currentroom, skal man i stedet kalde player.getCurrentRoom.

    //TODO Asger de 9 rum til adventure creator
    Player player;

    public AdventureController() {
        this.player = new Player();
    }

    //TODO bruger en setter til east,north osv. med parameter nabo room
    //Starter mmed at bruge en setter eks. seteast til at forbinde det valte rum med et rum i paramteren
    // Tjekker at det valgte rum (this) ikke er forbundet til parameter rummet (eks. setEast), this er ikke west
    // hvis ikke, så brug set for omvendt retning
    // eks. room1.setEast(room2)
    // inde i set methoden: if room2.getwest != this
    //                              room2.setwest(this)
    //room2 bliver sat til east for room 1
    //room 1 bliver sat til west for room 2
    //i metoden refererer vi til room1 med this

    //TODO Asger flyt createMap() til adventureCreator

    //Opdaterer status for om man har besøgt et rum. True = Har besøgt et rum

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

