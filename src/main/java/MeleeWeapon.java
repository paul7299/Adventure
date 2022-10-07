public class MeleeWeapon extends Weapon{

    public MeleeWeapon (String name, String description, int damage){
        super(name, description, damage);
    }

    //Sender altid true, da melee weapons altid kan bruges
    public String canUse(){
        return "You swing the " + name + " like a badass";
    }

    @Override
    public String getAmmo() {
        return name + ":\tdoes not use ammo\n";
    }
}
