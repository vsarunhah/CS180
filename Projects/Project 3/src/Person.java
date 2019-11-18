import java.io.Serializable;

/**
 * @author varun
 * @version 1.0
 */
public class Person implements Identifiable, Serializable {
    private String name;
    private int age;

    public Person(String name, int age) throws NullPointerException, IllegalArgumentException {
        if (name == null) {
            throw new NullPointerException();
        }
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return p.getAge() == getAge() && p.getName().equals(getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person[" + getName() + ", " + getAge() + "]";
    }
}
