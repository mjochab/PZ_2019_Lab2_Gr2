package Modele;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class User {



    private long userId;

    private String username;

    private String passwrd;

    private Teacher teacher;

    private Admin admin;

    private Student student;

    private Set<Backlog> backlogs;

    public User(long userId, String username, String passwrd, Teacher teacher) {
        this.userId = userId;
        this.username = username;
        this.passwrd = passwrd;
        this.teacher = teacher;
    }

    public User(long userId, String username, String passwrd, Admin admin) {
        this.userId = userId;
        this.username = username;
        this.passwrd = passwrd;
        this.admin = admin;
    }

    public User(long userId, String username, String passwrd, Student student) {
        this.userId = userId;
        this.username = username;
        this.passwrd = passwrd;
        this.student = student;
    }

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


    @OneToOne(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    public Admin getAdmin(){
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
