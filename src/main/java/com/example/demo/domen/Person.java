package domen;

import com.example.demo.domen.Role;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;

public class Person extends domen.User {
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToMany
    private List<domen.Community> communities;

    public Person(String name, String surname, List<domen.Community> communities) {
        this.name = name;
        this.surname = surname;
        this.communities = communities;
    }


    public Person(String email, String password, String confirmPassword, Role role, String name, String surname, List<domen.Community> communities) {
        super(email, password, confirmPassword, role);
        this.name = name;
        this.surname = surname;
        this.communities = communities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<domen.Community> getCommunities() {
        return communities;
    }

    public void setCommunities(List<domen.Community> communities) {
        this.communities = communities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(communities, person.communities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, communities);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", communities=" + communities +
                '}';
    }
}
