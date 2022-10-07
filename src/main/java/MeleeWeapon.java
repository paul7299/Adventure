public class MeleeWeapon extends Weapon{

    public MeleeWeapon (String name, String description, int damage){
        super(name, description, damage);
    }

    //Sender altid true, da melee weapons altid kan bruges
    public boolean canUse(){
        return true;
    }

    @Override
    public String getAmmo() {
        return name + ":\tdoes not use ammo\n";
    }
}
