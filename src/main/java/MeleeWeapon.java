public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String name, String description, int damage) {
        super(name, description, damage);
    }

    //Sender altid true, da melee weapons altid kan bruges
    public String attackMessage(String enemyName) {
        return "You swung the " + name + " at " + enemyName + " for " + damage + " damage";
    }

    @Override
    public Boolean canUse() {
        return true;
    }


    @Override
    public String failMessage(){
    return "Attack with " + name + " failed";
    }


    @Override
    public String getAmmo() {
        return name + ": does not use ammo\n";
    }
}
