public class MeleeWeapon extends Weapon {
    /**
     * MeleeWeapon nedarver fra Weapon, som er en abstract Klasse. Derfor bruger vi Override flere steder.
     */
    
    public MeleeWeapon(String name, String description, int damage) {
        super(name, description, damage);
    }
    
    //Returnerer en attackmessage der beskriver fjenden, våbnet og hvor meget skade det har lavet
    @Override
    public String attackMessage(String enemyName) {
        return "You swung the " + name + " at " + enemyName + " for " + damage + " damage";
    }
    
    @Override
    public Boolean canUse() {
        //returnerer altid true, da melee weapons altid kan bruges
        return true;
    }
    
    @Override
    public String failMessage() {
        return "Attack with " + name + " failed";
    }
    
    @Override
    public String getAmmo() {
        return name + ": does not use ammo\n";
    }
}
