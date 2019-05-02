package Modele;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Classes implements Serializable {

    private long classId;
    private String className;
    private Set<Student> students;
    private Set<Schedule>schedules;

    public Classes(String name) {
        this.className = name;
    }

    public Classes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "classes",fetch=FetchType.EAGER, cascade = CascadeType.DETACH)
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }


    @OneToMany(mappedBy = "clas",cascade = CascadeType.ALL)
    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }


    @Override
    public String toString() {
        return "Classes{" +
                "className='" + className + '\'' +
                '}';
    }
}


