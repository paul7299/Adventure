import java.util.Scanner;

public class UserInterface {
   private Adventure adventure = new Adventure();
   private Scanner sc = new Scanner(System.in);

    public void startProgram() {
        String direction; //TODO lav en readString() til at tage sig af case følsomhed

        System.out.println("Welcome to the game. let's start");


        }

        private String command(){
        String userInput;
        String action;
            System.out.println("Choose an action");
            userInput = sc.nextLine();

            switch (userInput) {
                case "North":
                    action = "North";
                    System.out.println("Going north");
                    return action;
                case "South":
                    System.out.println("Going south");
                    break;
                case "East":
                    System.out.println("Going east");
                    break;
                case "West":
                    System.out.println("going west");
                    break;
                case "Look":
                    System.out.println(adventure.look());
                default:
                    break;
            }
        return null;
    }
}


