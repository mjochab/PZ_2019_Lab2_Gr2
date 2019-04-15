package Modele;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Teacher {

    private long teacherId;
    private String firstNameT;
    private String lastNameT;
    private String linkedAcc;
    private Set<Classes> classes;
    private Set<Warns> warns;
    private Set<Subject> subjects;
    private User user;

    @Id
    @GeneratedValue
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

    @Column(name = "linked_acc")
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "teacher_classes",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id")})
    public Set<Classes> getClasses() {
        return classes;
    }
    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "teacher_subject",
            joinColumns  = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    public Set<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @OneToOne(fetch = FetchType.LAZY)
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
                ", classes=" + classes +
                ", warns=" + warns +
                ", subjects=" + subjects +
                ", user=" + user +
                '}';
    }
}
