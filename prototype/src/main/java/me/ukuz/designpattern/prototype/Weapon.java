package me.ukuz.designpattern.prototype;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author ukuz90
 * @date 2019-05-11
 */
public class Weapon implements Serializable {
    private String name;

    public Weapon(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Weapon weapon = (Weapon) o;
        return Objects.equals(name, weapon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                '}';
    }
}
