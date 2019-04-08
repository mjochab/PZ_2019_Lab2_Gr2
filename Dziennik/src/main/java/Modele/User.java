package Modele;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class User {



    private long userId;

    private String username;

    private String passwrd;

    private Set<Backlog> backlogs;


    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "user_name")
    public String getUsername() {
        return username;
    }
    public void setUsername(String userName) {
        this.username = userName;
    }

    @Column(name = "passwrd", length = 20)
    public String getPasswrd() {
        return passwrd;
    }
    public void setPasswrd(String password) {
        this.passwrd = password;
    }


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Backlog> getBacklogs() {
        return backlogs;
    }
    public void setBacklogs(Set<Backlog> backlogs) {
        this.backlogs = backlogs;
    }

    public User() {}

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", passwrd='" + passwrd + '\'' +
                '}';
    }
}
