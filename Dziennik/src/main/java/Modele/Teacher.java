package Modele;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public  class Teacher implements Serializable {

    private long teacherId;
    private String firstNameT;
    private String lastNameT;
    private String linkedAcc;
    private Set<Warns> warns;
    private Subject subject;
    private User user;

    public Teacher(String name, String lname, Subject subject, String linkedAcc) {
        this.firstNameT = name;
        this.lastNameT = lname;
        this.subject = subject;
        this.linkedAcc = linkedAcc;
    }

    public Teacher(long id,String name, String lname, Subject subject, String linkedAcc) {
        this.teacherId =id;
        this.firstNameT = name;
        this.lastNameT = lname;
        this.subject = subject;
        this.linkedAcc = linkedAcc;
    }


    public Teacher() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    public long getTeacherId() {
        return this.teacherId;
    }
    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }



    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return this.firstNameT;
    }
    public void setFirstName(String firstNameT) {
        this.firstNameT = firstNameT;
    }


    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return this.lastNameT;
    }
    public void setLastName(String lastNameT) {
        this.lastNameT = lastNameT;
    }

    @Column(name = "linked_acc", nullable = false, length = 50)
    public String getLinkedAcc() {
        return linkedAcc;
    }

    public void setLinkedAcc(String linkedAcc) {
        this.linkedAcc = linkedAcc;
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    public Set<Warns> getWarns() {
        return warns;
    }
    public void setWarns(Set<Warns> warns) {
        this.warns = warns;
    }

    @ManyToOne
    @JoinColumn(name = "subject_id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }




    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstNameT='" + firstNameT + '\'' +
                ", lastNameT='" + lastNameT + '\'' +
                ", linkedAcc='" + linkedAcc + '\'' +
                ", warns=" + warns +
                ", subject=" + subject +
                ", user=" + user +
                '}';
    }


    public String toString1() {
        return "Teacher{" +
                "firstNameT='" + firstNameT + '\'' +
                '}';
    }


    public String toString2() {
        return "Teacher{" +
                "lastNameT='" + lastNameT + '\'' +
                '}';
    }
}


