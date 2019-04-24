package Modele;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Frequently implements Serializable {

    private long frequentlyId;
    private int absence;
    private Date absenceDate;
    private Student student;


    @Id
    @GeneratedValue
    @Column(name = "frequently_id")
    public long getFrequentlyId() {
        return frequentlyId;
    }
    public void setFrequentlyId(long frequentlyId) {
        this.frequentlyId = frequentlyId;
    }

    @Column(name="absence")
    public int getAbsence() {
        return absence;
    }
    public void setAbsence(int absence) {
        this.absence = absence;
    }

    @Column(name="absence_date", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getAbsenceDate() {
        return absenceDate;
    }
    public void setAbsenceDate(Date absenceDate) {
        this.absenceDate = absenceDate;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Frequently{" +
                "frequentlyId=" + frequentlyId +
                ", absence=" + absence +
                ", absenceDate=" + absenceDate +
                ", student=" + student +
                '}';
    }
}
