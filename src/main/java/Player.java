import java.util.ArrayList;

public class Player {

    private int playerHealth;
    private Room currentRoom;
    private Weapon currentWeapon;

    private final ArrayList<Item> inventory = new ArrayList<>();

    // Constructor
    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.playerHealth = 50;
        this.currentWeapon = null;
    }

    public ArrayList<Item> showInventory() {
        return inventory;
    }

    //Metoden der bruges til at gå nord fra ens nuværende rum. Hvis det ikke kan lade sig gøre, returnerer den det.
    public String goNorth() {
        String goingNorthResult;
        if (currentRoom.getRoomNorth() == null) {
            goingNorthResult = "* You cannot go north from here *\n";
        } else {
            goingNorthResult = "* Going north *\n";
            currentRoom = currentRoom.getRoomNorth();
        }
        return goingNorthResult;
    }

    //Metoden der bruges til at gå syd fra ens nuværende rum. Hvis det ikke kan lade sig gøre, returnerer den det.
    public String goSouth() {
        String goingSouthResult;
        if (currentRoom.getRoomSouth() == null) {
            goingSouthResult = "* You cannot go south from here *\n";
        } else {
            goingSouthResult = "* Going south *\n";
            currentRoom = currentRoom.getRoomSouth();
        }
        return goingSouthResult;
    }

    //Metoden der bruges til at gå øst fra ens nuværende rum. Hvis det ikke kan lade sig gøre, returnerer den det.
    public String goEast() {
        String goingEastResult;
        if (currentRoom.getRoomEast() == null) {
            goingEastResult = "* You cannot go east from here *\n";
        } else {
            goingEastResult = "* Going east *\n";
            currentRoom = currentRoom.getRoomEast();
        }
        return goingEastResult;
    }

    //Metoden der bruges til at gå vest fra ens nuværende rum. Hvis det ikke kan lade sig gøre, returnerer den det.
    public String goWest() {
        String goingWestResult;
        if (currentRoom.getRoomWest() == null) {
            goingWestResult = "* You cannot go west from here *\n";
        } else {
            goingWestResult = "* Going west *\n";
            currentRoom = currentRoom.getRoomWest();
        }
        return goingWestResult;
    }

    //Metoden der bruges til at kigge sig omkring i det nuværende rum, der returnerer en samlet streng med både Items, beskrivelse af rummet samt fjender
    public StringBuilder look() {
        StringBuilder a = new StringBuilder();
        if (currentRoom.getItemsInRoom().isEmpty())
            a.append(currentRoom.getRoomDescription() + "\n" + "There is nothing in the section");
        else {
            a.append(currentRoom.getRoomDescription() + "\n" + "In the section you can see the following:"
                    + currentRoom.getItemsInRoom());
        }
        if (currentRoom.getEnemiesInRoom().isEmpty()) {
            a.append("\n");
            a.append("There are no enemies in the section");
        } else {
            a.append("\nThere's enemies in the section: " + currentRoom.getEnemiesInRoom());
        }
        return a;
    }

    public String getCurrentRoomNameFromPlayer() {
        return currentRoom.getRoomName();
    }

    public void setHasVisitedToTrue() {
        currentRoom.setHasVisitedToTrue();
    }

    public boolean getHasVisitedStatus() {
        return currentRoom.getHasVisited();
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    //Bruges til at søge arraylists efter en specifik item
    public Item searchForItem(String searchName, ArrayList<Item> arrayList) {
        for (Item n : arrayList) {
            String itemName = n.getItemName().toLowerCase();
            if (itemName.contains(searchName.toLowerCase())) {
                return n;
            }
        }
        return null;
    }

    //Bruges til at samle et specifikt item op fra det nuværende rum. metoden fjerner Item fra rummet og tilføjer den til spillerens inventory
    public String pickUpItem(String name) {
        Item itemToTransfer = searchForItem(name, currentRoom.getItemsInRoom());
        if (itemToTransfer == null) {
            return "No item found\n";
        } else {
            inventory.add(itemToTransfer);
            currentRoom.getItemsInRoom().remove(itemToTransfer);
            return ("You have picked up " + itemToTransfer.getItemName() + "\n");
        }
    }

    //Bruges til at droppe et specifikt item op fra det nuværende rum. metoden fjerner Item fra spillerens inventory og tilføjer den til rummet
    public String dropItem(String name) {
        Item itemToTransfer = searchForItem(name, inventory);
        if (itemToTransfer == null) {
            return "No item found\n";
        } else {
            inventory.remove(itemToTransfer);
            currentRoom.getItemsInRoom().add(itemToTransfer);
            if (currentWeapon == itemToTransfer) {
                currentWeapon = null;
            }
            return ("You have dropped " + itemToTransfer.getItemName() + " in " + currentRoom.getRoomName() + "\n");
        }
    }

    //Bruges til at udskrive hvilke døre der er i det nuværende rum
    public String[] getCurrentRoomDoors() {
        String doorNorth = null;
        String doorSouth = null;
        String doorEast = null;
        String doorWest = null;

        if (currentRoom.getRoomNorth() != null) {
            doorNorth = ("There is a section North");
        }
        if (currentRoom.getRoomSouth() != null) {
            doorSouth = ("There is a section South");
        }
        if (currentRoom.getRoomEast() != null) {
            doorEast = ("There is a section East");
        }
        if (currentRoom.getRoomWest() != null) {
            doorWest = ("There is a section West");
        }
        return new String[]{doorNorth, doorSouth, doorEast, doorWest};
    }

    // Metoden bruges til spise en Food der findes i inventory, og justere playerhealth alt efter hvad man intager
    // Den sikrer at man kun kan spise Food
    public String eatFood(String name) {
        Item foodToEat = searchForItem(name, inventory);
        if (foodToEat == null) {
            return "You don't have this item\n";
        } else if (foodToEat instanceof Food) {
            inventory.remove(foodToEat);
            playerHealth += ((Food) foodToEat).getConsumeableHealth();
            return "You have eaten " + foodToEat.getItemName() + "\n";
        } else {
            return "You cannot eat this\n";
        }
    }

    // Metoden bruges til drikke en Liquid der findes i inventory, og justere playerhealth alt efter hvad man intager
    // Den sikrer at man kun kan indtage Liquid
    public String drinkLiquid(String name) {
        Item liquidToDrink = searchForItem(name, inventory);
        if (liquidToDrink == null) {
            return "You don't have this item\n";
        } else if (liquidToDrink instanceof Liquid) {
            inventory.remove(liquidToDrink);
            playerHealth += ((Liquid) liquidToDrink).getConsumeableHealth();
            return "You have drinked " + liquidToDrink.getItemName() + "\n";
        } else {
            return "You cannot drink this\n";
        }
    }

    // Metoden bruges til equippe et våben der findes i inventory
    // Den sikrer at man kun equippe et våben
    public String equipWeapon(String name) {
        Item weaponToEquip = searchForItem(name, inventory);
        if (weaponToEquip == null) {
            return "You don't have this item\n";
        } else if (weaponToEquip instanceof Weapon) {
            currentWeapon = (Weapon) weaponToEquip;
            return "You have equipped " + weaponToEquip.getItemName() + "\n";
        } else {
            return "You cannot equip this\n";
        }
    }

    //Attack hvis man ikke vælger et target
    public StringBuilder attack() {
        StringBuilder sb = new StringBuilder();

        if (currentWeapon != null) {    //Tjekker om man har et våben klar
            if (currentWeapon.canUse()) { //Tjekker om våbnet kan bruges Her om et ranged våben har ammo.
                if (currentRoom.getEnemiesInRoom().isEmpty()) { //Hvis der ikke er fjender i rummet
                    sb.append("* You hit the air with " + currentWeapon.getItemName() + " *");
                } else if (!currentRoom.getEnemiesInRoom().isEmpty()) { //Hvis der er fjender (Der er ikke tomt)
                    for (Enemy n : currentRoom.getEnemiesInRoom()) {
                        sb.append(attackSequence(n));
                        break; //Break for at man kun angriber den første fjende i et rum.
                    }
                }
            } else {
                sb.append(currentWeapon.failMessage()); //Fejl besked hvis canUse() retunerer false.
            }
        } else {
            sb.append("* You do not have a weapon equipped *\n"); //Hvis currentWeapon er null
        }
        return sb;
    }

    //Attack hvis man vælger et target
    public StringBuilder attack(String enemySearchName) {
        StringBuilder sb = new StringBuilder();

        if (currentWeapon != null) { //Tjekker om man har et våben klar
            if (currentWeapon.canUse()) { //Tjekker om våbnet kan bruges Her om et ranged våben har ammo.
                for (int i = currentRoom.getEnemiesInRoom().size()-1; i>=0; i--) {
                    Enemy n = currentRoom.getEnemiesInRoom().get(i);
                    if (n.getEnemyName().contains(enemySearchName)) {
                        sb.append(attackSequence(n));
                    }
                }
            } else {
                sb.append(currentWeapon.failMessage());
            }
        } else {
            sb.append("* You do not have a weapon equipped *\n");
        }
        return sb;
    }

    private StringBuilder attackSequence(Enemy n) {
        StringBuilder sb = new StringBuilder();
        //Tager væk fra fjendens liv, der kommer en besked om man har angrebet...
        // ...og spillet tjekker og fortæller om fjenden døde eller ej (hasEnemyDied)
        n.setEnemyHealth(n.getEnemyHealth() - currentWeapon.getDamage());
        sb.append(currentWeapon.attackMessage(n.getEnemyName()));
        sb.append("\n" + n.hasEnemyDied());
        if (n.getEnemyHealth() > 0) { //If løkke tjekker om fjenden er i live. Hvis de er så angribes spilleren.
            playerHealth -= n.getEnemyWeaponDamage();
            sb.append("Enemy has attacked you for " + n.getEnemyWeaponDamage() + " damage");
        } else {
            currentRoom.getEnemiesInRoom().remove(n);
        }
        return sb;
    }

    //showCurrentAmmo returnerer hvor meget ammo der er tilbage i det nuværende våben, hvis man har et våben equipped
    public String showCurrentAmmo() {
        if (currentWeapon != null) {
            return currentWeapon.getAmmo();
        } else {
            return "* You have nothing equipped * ";
        }
    }
}

