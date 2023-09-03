package cf.mindaugas._02_designPatterns._01_creational;

public class _03_Builder {
    public static void main(String[] args) {
        // When you have multiple possibly optional fields in the object you can

        // 0. Pass nulls into a regular constructor
        // var human = new Human("John", null, null, null, 55, null);

        // 1. Have telescoping constructors
        // https://yobriefca.se/blog/2015/05/13/the-builder-pattern/

        // 2. Builder Pattern
        var weapon = new Weapon.Builder()
                .withDamage(100)
                .withType("Dagger")
                .build();

        System.out.println(weapon);
    }
}

class Human {
    private String name;
    private Integer age;

    public Human(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name) {
        this.name = name;
    }
    public Human(Integer age) {
        this.name = name;
    }

    public Human() {
    }
}

class Weapon {
    private String type;
    private String name;
    private Integer damage;
    private Long durability;

    private Weapon(final String type, final String name, final Integer damage, final Long durability) {
        this.type = type;
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(final Integer damage) {
        this.damage = damage;
    }

    public Long getDurability() {
        return durability;
    }

    public void setDurability(final Long durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        // return "Weapon{" +
        //         "type='" + type + '\'' +
        //         ", name='" + name + '\'' +
        //         ", damage=" + damage +
        //         ", durability=" + durability +
        //         '}';
        return "Weapon{"
                + (type != null ? "type='" + type + '\'' : "")
                + (name != null ? ", name='" + name + '\'' : "") +
                ", damage=" + damage +
                ", durability=" + durability +
                '}';
    }

    public static class Builder {
        private String type;
        private String name;
        private Integer damage;
        private Long durability;

        // configuring methods
        public Builder withType(final String type) {
            this.type = type;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withDamage(final Integer damage) {
            this.damage = damage;
            return this;
        }

        public Builder withDurability(final Long durability) {
            this.durability = durability;
            return this;
        }

        // creates the target object
        public Weapon build() {
            return new Weapon(type, name, damage, durability);
        }
    }
}