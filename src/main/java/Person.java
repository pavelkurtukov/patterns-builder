import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age; // -1 означает, что возраст неизвестен
    protected String address;

    // Конструктор человека с неизвестным возрастом
    public Person(String name, String surname) {
        this(name, surname, -1);
    }

    // Конструктор человека с известным возрастом
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    // Известен ли возраст
    public boolean hasAge() {
        return this.age > -1;
    }

    // Известен ли адрес
    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return this.age > 0 ? OptionalInt.of(this.age) : OptionalInt.empty();
    }

    public String getAddress() {
        return this.address != null ? this.address : "неизвестен";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAddress(this.address);
    }

    @Override
    public String toString() {
        String ageString = hasAge() ? String.valueOf(age) : "неизвестен";
        return String.format("{%s %s (Возраст: %s; Адрес: %s)}", name, surname, ageString, getAddress());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
