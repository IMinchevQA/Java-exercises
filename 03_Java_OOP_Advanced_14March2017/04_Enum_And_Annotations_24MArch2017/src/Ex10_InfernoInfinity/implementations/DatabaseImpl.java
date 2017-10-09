package Ex10_InfernoInfinity.implementations;

import Ex10_InfernoInfinity.interfaces.Database;
import Ex10_InfernoInfinity.interfaces.Weapon;

import java.util.HashMap;

public class DatabaseImpl implements Database {
    private HashMap<String, Weapon> weapons;

    public DatabaseImpl() {
        this.weapons = new HashMap<>();
    }

    @Override
    public void addWeapon(Weapon weapon) {
        this.weapons.put(weapon.getName(), weapon);
    }

    @Override
    public Weapon getWeapon(String weaponName) {
        if (this.weapons.containsKey(weaponName)) {
            return this.weapons.get(weaponName);
        }
        return null;
    }
}
