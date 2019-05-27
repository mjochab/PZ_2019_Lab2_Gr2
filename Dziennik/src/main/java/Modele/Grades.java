package Modele;


import modelFX.StudentFx;
import modelFX.SubjectFx;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Grades implements Serializable {

    private long gradeId;
    private double grade;
    private Date dateCreated;
    private String details;
    private Student student;
    private Subject subject;



    public Grades() {
    }

<<<<<<< .merge_file_a08432
    public Grades(Date dateCreated, String reason, StudentFx student, SubjectFx subject,Double grade) {
        this.dateCreated = dateCreated;
        this.details = reason;
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

=======
>>>>>>> .merge_file_a05904

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
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
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
