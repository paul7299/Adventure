public abstract class Weapon extends Item {
    /**
     * Weapon er klassen som både RangedWepon og MeleeWeapon nedarver fra
     * Det er en abstract klasse for at man ikke direkte kan instanciere weapon, og altså skal kalde enten Ranged eller Melee weapon
     * Det betyder også at vi kan have abstracte metoder, som ikke indeholder noget, og altså overskrives i subclasserne
     * Protected attributes bruges så det kun er klasserne der nedarver fra Item der har adgang til dem.
     */
 
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
