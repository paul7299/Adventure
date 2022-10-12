import java.util.ArrayList;
public class AdventureController {
    /**
     * AdventureController står for at videregive arbejdsopgaverne til alle de andre klasser.
     * Den indeholder ikke rigtig funktionel kode, og metoderne kalder blot metoderne i de specifikke klasser.
     */
    private final Room startRoom;
    private final Player player;
    private final AdventureCreator adventureCreator;

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

    public StringBuilder playerLook() {
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

    public String eatFood(String name){
        return player.eatFood(name);
    }

    public String drinkLiquid(String name){
        return player.drinkLiquid(name);
    }

    public String showHealth(){
        int health = player.getPlayerHealth();
        return "You have " + health + " health.";
    }

    public StringBuilder attack(){
        return player.attack();
    }

    public StringBuilder attack(String enemyName){
        return player.attack(enemyName);
    }

    public String equipWeapon(String name){
        return player.equipWeapon(name);
    }

    public String showCurrentAmmo(){
        return player.showCurrentAmmo();
    }

    public boolean isPlayerDead(){
        return player.getPlayerHealth() <= 0;
    }

}

