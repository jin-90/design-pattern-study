package me.ukuz.designpattern.prototype;

import java.io.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author ukuz90
 * @date 2019-05-11
 */
public class Warrior implements Serializable {

    private String name;
    private String job;

    private Set<Weapon> weapons;

    public Warrior(String name, String job) {
        this.name = name;
        this.job = job;
        this.weapons = new HashSet<>();
    }

    public void addWeapon(Weapon weapon) {
        Optional.of(weapon).ifPresent(this.weapons::add);
    }

    @Override
    public Warrior clone() {
        return deepClone();
    }

    private Warrior deepClone() {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {

            oos.writeObject(this);

            try (ByteArrayInputStream dais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(dais)){

                return (Warrior) ois.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", weapons=" + weapons +
                '}';
    }


}
