//RangedWeapon nedarver fra Weapon, som er en abstract Klasse. Derfor bruger vi Override flere steder.
public class RangedWeapon extends Weapon {
    
    protected int ammo;
    
    public RangedWeapon(String name, String description, int damage, int ammo) {
        super(name, description, damage);
        this.ammo = ammo;
    }
    
    @Override
    public String getAmmo() {
        return name + ": " + ammo + " ammo";
    }
    
    //Returnerer en attackmessage der beskriver fjenden, våbnet og hvor meget skade det har lavet
    public String attackMessage(String enemyName) {
        /*String message;
        if(canUse()){*/
        String message = "* You shot " + enemyName + " with the " + name + " for " + damage + " damage *\n";
        /*}
        else{
            message = "* " + name + " does not have more ammo *\n";
        }*/
        return message;
    }
    
    //Returnerer en fejlbesked hvis man er løbet tør for ammunition
    public String failMessage() {
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
