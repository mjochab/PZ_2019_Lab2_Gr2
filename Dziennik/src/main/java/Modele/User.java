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

    private String linkedAcc;

    private Admin admin;

    private Student student;



    public User(long userId, String username, String passwrd,String linkedAcc, Teacher teacher) {
        this.userId = userId;
        this.username = username;
        this.passwrd = passwrd;
        this.linkedAcc = linkedAcc;
        this.teacher = teacher;
    }

    public User(long userId, String username, String passwrd,String linkedAcc, Admin admin) {
        this.userId = userId;
        this.username = username;
        this.passwrd = passwrd;
        this.linkedAcc = linkedAcc;
        this.admin = admin;
    }

    public User(long userId, String username, String passwrd,String linkedAcc, Student student) {
        this.userId = userId;
        this.username = username;
        this.passwrd = passwrd;
        this.linkedAcc = linkedAcc;
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

    @Column(name = "linked_acc")
    public String getLinkedAcc() {
        return linkedAcc;
    }
    public void setLinkedAcc(String linkedAcc) {
        this.linkedAcc = linkedAcc;
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



    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", passwrd='" + passwrd + '\'' +
                ", linkedAcc='" + linkedAcc + '\'' +
                '}';
    }
}
