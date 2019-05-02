package Modele;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Schedule implements Serializable {


    private long lessonId;
    private String day;
    private String time;
    private String room;
    private Classes clas;
    private Subject subject;

    public Schedule() {

    }

    public Schedule(String day, String time, String room, Classes clas, Subject subject) {
        this.day = day;
        this.time = time;
        this.room = room;
        this.clas = clas;
        this.subject = subject;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    public long getlessonId() {
        return lessonId;
    }
    public void setlessonId(long lessonId) {
        this.lessonId = lessonId;
    }

    @Column(name = "day")
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    @Column(name = "time")
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Column(name = "room")
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
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

    public Schedule(long lessonId, String day, String time, String room, Classes clas, Subject subject) {
        this.lessonId = lessonId;
        this.day = day;
        this.time = time;
        this.room = room;
        this.clas = clas;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "lessonId=" + lessonId +
                ", day=" + day +
                ", time=" + time +
                ", room=" + room +
                ", class=" + clas +
                ", subjects=" + subject +
                '}';
    }
}
