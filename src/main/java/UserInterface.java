import java.util.Scanner;

public class UserInterface {
   private Adventure adventure = new Adventure();
   private Scanner sc = new Scanner(System.in);

    //TODO lav en readString() til at tage sig af case følsomhed

    public void startProgram() {
        System.out.println("Welcome to the game. let's start");
        command();
        }

        private void command(){
        String userInput;
        String action;
            System.out.println("Choose an action");
            userInput = sc.nextLine();

            //Todo lav en løkke rundt om switch hvis noget går galt
            switch (userInput) {
                case "North":
                    System.out.println("Going north");
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
    }
}


