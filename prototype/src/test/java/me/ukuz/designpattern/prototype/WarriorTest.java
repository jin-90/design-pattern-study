package me.ukuz.designpattern.prototype;

public class WarriorTest {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("A", "战士");
        warrior.addWeapon(new Weapon("斧"));

        Warrior warrior2 = warrior.clone();
        warrior2.addWeapon(new Weapon("真.斧"));

        System.out.println(warrior);
        System.out.println(warrior2);

        System.out.println(warrior.getWeapons() == warrior2.getWeapons());
    }

}