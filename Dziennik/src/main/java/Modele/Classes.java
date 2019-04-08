package Modele;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Classes {

    private long classId;
    private String className;
    private Set<Subject> subjects;
    private Set<Student> students;


    @Id
    @GeneratedValue
    @Column(name = "class_id")
    public long getClassId() {
        return classId;
    }
    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Column(name = "class_name", nullable = false, length = 100)
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    @OneToMany(mappedBy = "classes", cascade = CascadeType.ALL)
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "classes_subject",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    public Set<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", subjects=" + subjects +
                ", students=" + students +
                '}';
    }
}

