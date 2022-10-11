import org.w3c.dom.ranges.Range;

import java.util.ArrayList;

public class Player {

    private int playerHealth;
    private Room currentRoom;
    private Weapon currentWeapon;

    private ArrayList<Item> inventory = new ArrayList<>();

    public ArrayList<Item> showInventory() {
        return inventory;
    }

    // Constructor
    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.playerHealth = 50;
        this.currentWeapon = null;
    }

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

    public String look() {
        if (currentRoom.getItemsInRoom().isEmpty())
            return currentRoom.getRoomDescription() + "\n" + "there are no items in the room\n";
        else
            return currentRoom.getRoomDescription() + "\n" + "In the room you can see the following: " + currentRoom.getItemsInRoom() + "\n";

    }

    public String getCurrentRoomNameFromPlayer() {
        return currentRoom.getRoomName();
    }

    public void setHasVisitedToTrue() {
        currentRoom.setHasVisitedToTrue();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean getHasVisitedStatus() {
        return currentRoom.getHasVisited();
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    //TODO ret contains i metoden til at minimum 3 bogstaver skal matche søge ordet
    public Item searchForItem(String searchName, ArrayList<Item> arrayList) {
        for (Item n : arrayList) {
            if (n.getItemName().contains(searchName)) {
                return n;
            }
        }
        return null;
    }

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

    public String[] getCurrentRoomDoors() {
        String doorNorth = null;
        String doorSouth = null;
        String doorEast = null;
        String doorWest = null;

        if (currentRoom.getRoomNorth() != null) {
            doorNorth = ("There is a door North");
        }
        if (currentRoom.getRoomSouth() != null) {
            doorSouth = ("There is a door South");
        }
        if (currentRoom.getRoomEast() != null) {
            doorEast = ("There is a door East");
        }
        if (currentRoom.getRoomWest() != null) {
            doorWest = ("There is a door West");
        }
        return new String[]{doorNorth, doorSouth, doorEast, doorWest};
    }

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

    // TODO ^kan man droppe et item man har equipped? -paul


    //TODO Har lavet hjælpe metoder til attack for at gøre koden pænere og have færre gentagelser.
    // Diskuter om man kan lide den eller den skal have et bedre navn
    //Attack hvis man ikke vælger et target
    public StringBuilder attack() {
        StringBuilder sb = new StringBuilder();

        if (currentWeapon != null) {    //Tjekker om man har et våben klar
            if (currentWeapon.canUse()) { //Tjekker om våbnet kan bruges Her om et ranged våben har ammo.
                if (currentRoom.getEnemiesInRoom().isEmpty()) { //Hvis der ikke er fjender i rummet
                    sb.append("* You hit the air with " + currentWeapon.getItemName() + " *");
                } else if (!currentRoom.getEnemiesInRoom().isEmpty()) { //Hvis der er fjender (Der er ikke tomt)
                    for (Enemy n : currentRoom.getEnemiesInRoom()) {
                  /*      //Tager væk fra fjendens liv, der kommer en besked om man har angrebet...
                        // ...og spillet tjekker og fortæller om fjenden døde eller ej (hasEnemyDied)
                        n.setEnemyHealth(n.getEnemyHealth() - currentWeapon.getDamage());
                        sb.append(currentWeapon.attackMessage(n.getEnemyName()));
                        sb.append("\n" + n.hasEnemyDied());
                        if (n.getEnemyHealth() > 0) { //If løkke tjekker om fjenden er i live. Hvis de er så angribes spilleren.
                            playerHealth -= n.getEnemyWeaponDamage();
                            sb.append(" Enemy damage you for " + n.getEnemyWeaponDamage() + " damage");
                        }*/
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
                for (Enemy n : currentRoom.getEnemiesInRoom()) {
                    if (enemySearchName.contains(n.getEnemyName())) {
                     /*   //Tager væk fra fjendens liv, der kommer en besked om man har angrebet...
                        // ...og spillet tjekker og fortæller om fjenden døde eller ej (hasEnemyDied)
                        n.setEnemyHealth(n.getEnemyHealth() - currentWeapon.getDamage());
                        sb.append(currentWeapon.attackMessage(n.getEnemyName()));
                        sb.append("\n" + n.hasEnemyDied());
                        if (n.getEnemyHealth() > 0) { //If løkke tjekker om fjenden er i live. Hvis de er så angribes spilleren.
                            playerHealth -= n.getEnemyWeaponDamage();
                            sb.append(" Enemy damage you for " + n.getEnemyWeaponDamage() + " damage");
                        }*/
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

    private StringBuilder attackSequence(Enemy n){
        StringBuilder sb = new StringBuilder();
        //Tager væk fra fjendens liv, der kommer en besked om man har angrebet...
        // ...og spillet tjekker og fortæller om fjenden døde eller ej (hasEnemyDied)
        n.setEnemyHealth(n.getEnemyHealth() - currentWeapon.getDamage());
        sb.append(currentWeapon.attackMessage(n.getEnemyName()));
        sb.append("\n" + n.hasEnemyDied());
        if (n.getEnemyHealth() > 0) { //If løkke tjekker om fjenden er i live. Hvis de er så angribes spilleren.
            playerHealth -= n.getEnemyWeaponDamage();
            sb.append(" Enemy damage you for " + n.getEnemyWeaponDamage() + " damage");
        }
        return sb;
    }

    // TODO ^ Skal sættes ind i UI med sout(stringbuilder)

    public String showCurrentAmmo() {
        if (currentWeapon != null) {
            return currentWeapon.getAmmo();
        } else {
            return "* You have nothing equipped * ";
        }
    }
}

