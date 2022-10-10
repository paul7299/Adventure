public class RangedWeapon extends Weapon {

    protected int ammo;

    public RangedWeapon(String name, String description, int damage, int ammo) {
        super(name, description, damage);
        this.ammo = ammo;
    }

    @Override
    public String getAmmo(){
        return name + ": " + ammo + " ammo";
    }


    public String attackMessage(String enemyName){
        /*String message;
        if(canUse()){*/
           String message ="* You shot " + enemyName + " with the " + name + " for " + damage + " damage *\n";
        /*}
        else{
            message = "* " + name + " does not have more ammo *\n";
        }*/
        return message;
    }

    public String failMessage(){
        return "* " + name + " does not have more ammo *\n";
    }

    //Metoden tjekker at der er ammunation i våbnet. Hvis ammunation er 0 eller under returneres false.
    @Override
    public Boolean canUse() {
        boolean attack;
        if (ammo > 0) {
            attack = true;
            ammo--;
        } else {
            attack = false;
        }
        return attack;
    }
}
