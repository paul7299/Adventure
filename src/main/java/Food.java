public class Food extends Item {

   private int health;

    public Food(String name, String description, int health) {
        super(name, description);
        this.health = health;
    }

    public int getFoodHealth(){
        return health;
    }

}
