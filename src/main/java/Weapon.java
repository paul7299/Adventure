public abstract class Weapon extends Item {
 
    protected int damage;

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public abstract String canUse();

    public abstract String getAmmo();

}
