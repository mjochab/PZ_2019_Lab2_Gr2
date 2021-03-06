package Modele;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Warns implements Serializable {

    private long warnId;
    private Date dateCreated;
    private String content;
    private Student student;
    private Teacher teacher;

    public Warns(){}

    public Warns(Date dateCreated, String content, Student student, Teacher teacher) {
        this.dateCreated = dateCreated;
        this.content = content;
        this.student = student;
        this.teacher = teacher;
    }

    public Warns(long warnId, Date dateCreated, String content, Student student, Teacher teacher) {
        this.warnId = warnId;
        this.dateCreated = dateCreated;
        this.content = content;
        this.student = student;
        this.teacher = teacher;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warns_id")
    public long getWarnId(){
        return this.warnId;
    }
    public void setWarnId(long warnId){
        this.warnId = warnId;
    }

    @Column(name = "date_created", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateCreated(){
        return this.dateCreated;
    }
    public void setDateCreated(Date dateCreated){
        this.dateCreated = dateCreated;
    }

    @Column(name = "content", nullable = false, length = 250)
    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getStudent(){
        return this.student;
    }
    public void setStudent(Student student){
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Warns{" +
                "reportId=" + warnId +
                ", dateCreated=" + dateCreated +
                ", reportContent='" + content + '\'' +
                '}';
    }
}
