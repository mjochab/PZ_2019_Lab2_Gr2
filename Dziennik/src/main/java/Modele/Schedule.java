package Modele;


import javax.persistence.*;


import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Schedule {


    private long lessonId;
    private Date date;
    private Date time;
    private int room;
    private Classes clas;
    private Subject subject;


    @Id
    @GeneratedValue
    @Column(name = "lesson_id")
    public long getlessonId() {
        return lessonId;
    }
    public void setlessonId(long lessonId) {
        this.lessonId = lessonId;
    }
    @Column(name = "date", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Column(name = "time", columnDefinition="TIME")
    @Temporal(TemporalType.TIME)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Column(name = "room")
    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
    @ManyToOne
    @JoinColumn(name = "class")
    public Classes getClas() {
        return clas;
    }

    public void setClas(Classes clas) {
        this.clas = clas;
    }
    @ManyToOne
    @JoinColumn(name = "subject_id")
    public Subject getSubjects() {
        return subject;
    }

    public void setSubjects(Subject subject) {
        this.subject = subject;
    }

    public Schedule(long lessonId, Date date, Date time, int room, Classes clas, Subject subject) {
        this.lessonId = lessonId;
        this.date = date;
        this.time = time;
        this.room = room;
        this.clas = clas;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "lessonId=" + lessonId +
                ", date=" + date +
                ", time=" + time +
                ", room=" + room +
                ", clas=" + clas +
                ", subjects=" + subject +
                '}';
    }
}
