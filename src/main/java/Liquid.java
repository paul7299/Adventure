public class Liquid extends Item {

    private int health;

    public Liquid(String name, String description, int health) {
        super(name, description);
        this.health = health;
    }
    public int getLiquidHealth(){
        return health;
    }

}
