import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {
    private AdventureController adventureController;
    private Scanner sc = new Scanner(System.in);

    public void startProgram() {
        adventureController = new AdventureController();

        System.out.println("""
                Welcome to the game! Let's begin
                You are stuck in a maze. The objective of the game is to reach room 5.
                You navigate through the game using the commands Go north, Go east, Go south and Go west.
                To view your current room, type "look".
                If you forget the commands, type "help".
                If you want to pick up an item; type "take" and specify which item you want to take.
                If you want to drop an item; type "drop" and specify which item you want to drop.
                If you want to view your inventory, type "inventory".
                If you want to drink or eat an consumable, type either "drink" or "eat" and specify which consumable afterwards.
                If you want to equip a weapon from your inventory, type "equip weapon"
                If you want to attack with your equipped weapon, type "attack"
                If you want to view your current amount of ammo, type "show ammo"
                If you want to view your health, type "show health".
                If you want to quit the game, type "exit". 
                """);

        String userInput = " ";
        while (!userInput.equalsIgnoreCase("exit")) {
            System.out.println("\nYou are in " + adventureController.getPlayerCurrentRoomName());
            if (!adventureController.hasVisitedStatus()) {
                System.out.println(adventureController.playerLook());
                adventureController.setHasVisitedStatusToTrue();
            }
            if (adventureController.hasVisitedStatus()) {
                for (String s : adventureController.getCurrentRoomDoors()) {
                    if (s != null) System.out.println(s);
                }
            System.out.println("Choose an action");
            userInput = readString();
            command(userInput);
            }
        }
    }
    private void command(String userInput) {
        if(userInput.length() >= 3){
            switch (userInput) {
                case "north":
                    System.out.println(adventureController.playerGoNorth());
                    break;
                case "south":
                    System.out.println(adventureController.playerGoSouth());
                    break;
                case "east":
                    System.out.println(adventureController.playerGoEast());
                    break;
                case "west":
                    System.out.println(adventureController.playerGoWest());
                    break;
                case "look":
                    System.out.println("You are observing the room: ");
                    System.out.println("\t" + adventureController.playerLook());
                    adventureController.getCurrentRoomDoors();
                    break;
                case "help":
                    System.out.println(printHelp());
                    break;
                case "exit":
                    System.out.println("*Exiting game*");
                    System.exit(0);
                    break;
                case "take":
                    System.out.println("Which item do you want to pick up?");
                    String takeName = sc.nextLine();
                    System.out.println(adventureController.pickUpItem(takeName));
                    break;
                case "drop":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        System.out.println("Which item do you want to drop?");
                        String dropName = sc.nextLine();
                        System.out.println(adventureController.dropItem(dropName));
                    }
                    break;
                case "inventory":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        System.out.println("Your inventory contains: " + adventureController.showInventory());
                    }
                    break;
                case "eat food", "eat":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        System.out.println("What do you want to eat?");
                        String eatName = sc.nextLine();
                        System.out.println(adventureController.eatFood(eatName));
                        System.out.println("\n" + adventureController.showHealth());
                    }
                    break;
                case "drink liquid", "drink":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        System.out.println("What do you want to drink?");
                        String drinkName = sc.nextLine();
                        System.out.println(adventureController.drinkLiquid(drinkName));
                        System.out.println("\n" + adventureController.showHealth());
                    }
                    break;
                case "equip weapon", "equip":
                    if (adventureController.showInventory().isEmpty()) {
                        System.out.println("Your inventory is empty");
                    } else {
                        System.out.println("Which weapon you want to equip?");
                        String equipName = sc.nextLine();
                        System.out.println(adventureController.equipWeapon(equipName));
                    }
                    break;
                case "attack":
                    //  System.out.println("Who will you attack");
                    // string enemyToAttack = sc.nextLine();
                    System.out.println(adventureController.attack());
                    break;
                case "show ammo", "ammo":
                    System.out.println(adventureController.showCurrentAmmo());
                    break;
                case "show health", "health":
                    System.out.println(adventureController.showHealth());
                    break;
                default:
                    System.out.println("* Wrong input *");
                    break;
            }

        }
        else{
            System.out.println("input needs to be at least 3 chars");
        }
    }
    //Omdanner inputtet til lowercase så der ikke kommer fejl hvis man skrev med stort.
    public String readString() {
        String stringToLowercase = sc.nextLine();
        return stringToLowercase.toLowerCase();
    }
    public String printHelp() {
        return """
                 * Help - list of commands: *
                 - Go north:        north 
                 - Go south:        south 
                 - Go east:         east 
                 - Go west:         west 
                 - Look around:     look 
                 - Take item        take 
                 - Drop item        drop 
                 - view inventory   inventory 
                 - Eat food         Eat food / eat 
                 - equip weapon     equip weapon/ equip
                 - attack           attack
                 - Show ammo        Show ammo/ ammo
                 - Drink liquid     Drink liquid / drink 
                 - Player health    Show health / health 
                 - Exit:            exit
                """;
    }
}


