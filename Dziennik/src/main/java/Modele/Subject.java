package Modele;




import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Subject implements Serializable {

    private long subjectId;
    private String subjectName;
    private Set<Grades> grades;
    private Set<Teacher> teachers;

    public Subject(String name) {
        this.subjectName = name;
    }

    public Subject() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    public long getSubjectId(){
        return this.subjectId;
    }
    public void setSubjectId(long subjectId){
        this.subjectId = subjectId;
    }

    @Column(name = "subject_name", nullable = false, length = 50)
    public String getSubjectName(){
        return this.subjectName;
    }
    public void setSubjectName(String subjectName){
        this.subjectName = subjectName;
    }

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    public Set<Grades> getGrades() {
        return grades;
    }
    public void setGrades(Set<Grades> grades) {
        this.grades = grades;
    }

    @OneToMany(mappedBy = "subject",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", grades=" + grades +
                '}';
    }
}
