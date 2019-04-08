package Modele;



import javax.persistence.*;

import java.util.Date;

@Entity
@Table
public class Backlog {

    private long logId;
    private Date dateCreated;
    private String content;
    private User user;



    @Id
    @GeneratedValue
    @Column(name = "log_id")
    public long getLogId() {
        return logId;
    }
    public void setLogId(long logId) {
        this.logId = logId;
    }
    @Column(name = "date_created", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

