//Item er klassen som både Consumable og Weapon nedarver fra.
// Protected attributes bruges så det kun er klasserne der nedarver fra Item der har adgang til dem.
public class Item {
    protected String name;
    protected String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getItemName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}

