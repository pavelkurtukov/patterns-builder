public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст должен быть больше 0");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    // Создаём человека (объект класса Person)
    public Person build() {
        Person person;

        if (this.name == null) {
            throw new IllegalArgumentException("Должно быть указано имя человека");
        }

        if (this.surname == null) {
            throw new IllegalArgumentException("Должна быть указана фамилия человека");
        }

        // Создаём человека с обязательными полями
        if (this.age > 0) {
            person = new Person(this.name, this.surname, this.age);
        } else {
            person = new Person(this.name, this.surname);
        }

        // Указываем адрес проживания (если он задан)
        if (this.address != null) person.setAddress(this.address);

        return person;
    }
}