package domen;

import com.example.demo.domen.Role;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Transient
    transient private String confirmPassword;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    public User() {
    }

    public User(String email, String password, String confirmPassword, Role role) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
