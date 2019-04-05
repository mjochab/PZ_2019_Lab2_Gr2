package Modele;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    @Column(name = "idUser")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "haslo")
    private String haslo;

    public User(){};

    public User(Integer id, String login, String haslo){
        this.id = id;
        this.login = login;
        this.haslo = haslo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                '}';
    }
}
