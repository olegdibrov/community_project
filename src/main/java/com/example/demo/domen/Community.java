package domen;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<domen.Person> personList;

    public Community() {
    }

    public Community(String name, List<domen.Person> personList) {
        this.name = name;
        this.personList = personList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<domen.Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<domen.Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Community community = (Community) o;
        return Objects.equals(name, community.name) &&
                Objects.equals(personList, community.personList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, personList);
    }

    @Override
    public String toString() {
        return "Community{" +
                "name='" + name + '\'' +
                ", personList=" + personList +
                '}';
    }
}
