public abstract class Weapon extends Item {
 
    protected int damage;

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public abstract String attackMessage(String enemyName);

    public abstract String failMessage();

    public abstract Boolean canUse();

    public abstract String getAmmo();

    public int getDamage() {
        return damage;
    }

}
