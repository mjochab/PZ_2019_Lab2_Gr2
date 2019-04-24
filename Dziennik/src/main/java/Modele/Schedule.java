package Modele;


import javax.persistence.*;

@Entity
@Table
public class Schedule {


    private long lessonId;
    private String day;
    private String time;
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

    public Schedule(long lessonId, String day, String time, int room, Classes clas, Subject subject) {
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
