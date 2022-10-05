public class Consumeable extends Item {

    protected int health;

    public Consumeable(String name, String description, int health) {
        super(name, description);
        this.health = health;
    }


    public int getConsumeableHealth(){
        return health;
    }
}
