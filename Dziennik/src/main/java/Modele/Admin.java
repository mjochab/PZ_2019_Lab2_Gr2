package Modele;

import javax.persistence.*;

@Entity
@Table
public class Admin {

    private long adminId;
    private String firstNameA;
    private String lastNameA;
    private User user;
    private String linkedAcc;


    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    public long getAdminId() {
        return this.adminId;
    }
    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstNameA() {
        return this.firstNameA;
    }
    public void setFirstNameA(String firstNameA) {
        this.firstNameA = firstNameA;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastNameA() {
        return this.lastNameA;
    }
    public void setLastNameA(String lastNameA) {
        this.lastNameA = lastNameA;
    }

    @Column(name = "linked_acc")
    public String getLinkedAcc() {
        return linkedAcc;
    }
    public void setLinkedAcc(String linkedAcc) {
        this.linkedAcc = linkedAcc;
    }

    @OneToOne(fetch = FetchType.LAZY)
    public User getUser(){
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin() {
    }



    }

