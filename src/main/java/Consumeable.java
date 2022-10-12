//Comsumable nedarves fra Item, og deler sig så yderligere i Liquid og Food
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
