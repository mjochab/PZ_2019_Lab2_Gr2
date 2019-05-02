package Modele;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Grades implements Serializable {

    private long gradeId;
    private int grade;
    private Date dateCreated;
    private String details;
    private Student student;
    private Subject subject;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    public long getGradeId() {
        return gradeId;
    }
    public void setGradeId(long gradeId) {
        this.gradeId = gradeId;
    }

    @Column(name = "grade")
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Column(name = "date_created", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "other_details")
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "subject_id")
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    @Override
    public String toString() {
        return "Grades{" +
                "gradeId=" + gradeId +
                ", grade=" + grade +
                ", dateCreated=" + dateCreated +
                ", otherDetails='" + details + '\'' +
                '}';
    }
}
