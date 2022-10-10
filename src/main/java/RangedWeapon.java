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


    //Metoden tjekker at der er ammunation i våbnet. Hvis ammunation er 0 eller under returneres false.
    @Override
    public String canUse() {
        String attack;
        if (ammo > 0) {
            attack = "* You shot with the " + name + " *\n";
            ammo--;
        } else {
            attack = "* " + name + " does not have more ammo *\n";
        }
        return attack;
    }
}
