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
                To view your current room, type "look"
                If you forget the commands, type "help".
                """);


        String userInput = " ";


        while (!userInput.equalsIgnoreCase("exit")) {

            System.out.println("You are in " + adventureController.getplayerCurrentRoomName());

            if (!adventureController.hasVisitedStatus()) {
                System.out.println(adventureController.playerLook());
                adventureController.setHasVisitedStatusToTrue();
            }
            System.out.println("Choose an action");
            userInput = readString();

            command(userInput);
        }
    }

    private void command(String userInput) {

        switch (userInput) {
            case "north", "n":
                System.out.println(adventureController.playerGoNorth());
                break;
            case "south", "s":
                System.out.println(adventureController.playerGoSouth());
                break;
            case "east", "e":
                System.out.println(adventureController.playerGoEast());
                break;
            case "west", "w":
                System.out.println(adventureController.playerGoWest());
                break;
            case "look", "l":
                System.out.println("You are observing the room:");
                System.out.println("\t" + adventureController.playerLook());
                adventureController.getCurrentRoomDoors();
                break;
            case "help", "h":
                System.out.println(printHelp());
                break;
            case "exit":
                System.out.println("*Exiting game*");
                System.exit(0);
                break;
            case "take", "t":
                System.out.println("Which item do you want to pick up?");
                String takeName = sc.nextLine();
                System.out.println(adventureController.pickUpItem(takeName));
                break;
            case "drop":
                System.out.println("Which item do you want to drop?");
                String dropName = sc.nextLine();
                System.out.println(adventureController.dropItem(dropName));
                break;
            case "View i", "i":
                System.out.println("Your inventory contains: " + adventureController.player.showInventory());
                break;
            default:
                System.out.println("*Wrong input*");
                break;
        }

    }

        //Omdanner inputtet til lowercase så der ikke kommer fejl hvis man skrev med stort.
        public String readString () {
            String stringToLowercase = sc.nextLine();
            return stringToLowercase.toLowerCase();
        }


        public String printHelp () {
            return
                    """
                             * Help - list of commands: *
                             - Go north:        north / n
                             - Go south:        south / s
                             - Go east:         east / e
                             - Go west:         west / w
                             - Look around:     look / l
                             - Take item        take / t
                             - Drop item        drop / d
                             - view inventory   view i / i
                             - Exit:            exit
                            """;
        }
}


