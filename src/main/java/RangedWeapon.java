public class RangedWeapon extends Weapon {

    protected int ammo;

    public RangedWeapon(String name, String description, int damage, int ammo) {
        super(name, description, damage);
        this.ammo = ammo;
    }

    public String getAmmo(){
        return name + ":\t" + ammo + " ammo";
    }

    public void useAmmo(){
        ammo--;
    }

    //Metoden tjekker at der er ammunation i våbnet. Hvis ammunation er 0 eller under returneres false.
    public boolean canUse() {
        boolean isUseable;
        if (ammo > 0) {
            isUseable = true;
        } else {
            isUseable = false;
        }
        return isUseable;
    }
}
