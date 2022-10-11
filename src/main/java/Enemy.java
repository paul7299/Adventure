public class Enemy {

    private String enemyName;
    private Weapon enemyWeapon;
    private int enemyHealth;
    private Room currentRoom;

    public Enemy(String enemyName, Weapon enemyWeapon, Room currentRoom){
    this.enemyName = enemyName;
    this.enemyHealth = 30;
    this.enemyWeapon = enemyWeapon;
    this.currentRoom = currentRoom;
    }
    public String getEnemyName(){
        return enemyName;
    }

    public Weapon getEnemyWeapon(){
        return enemyWeapon;
    }

    public int getEnemyWeaponDamage(){
        return enemyWeapon.getDamage();
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getEnemyHealth(){
        return enemyHealth;
    }

    public void setEnemyName(){
        this.enemyName = ("dead" + enemyName);
    }
    public String hasEnemyDied() {
        if (enemyHealth <= 0) { //Tjekker om fjenden er død ved at se om liv er under 0
            Item itemToTransfer = enemyWeapon;
            currentRoom.getItemsInRoom().add(itemToTransfer);
            return (enemyName + " has died, and dropped " + itemToTransfer.getItemName() + " in " + currentRoom.getRoomName() + "\n");
        } else {
            return (enemyName + " has " + enemyHealth + " health left\n");
        }
    }

    @Override
    public String toString() {
        return enemyName;
    }
}
