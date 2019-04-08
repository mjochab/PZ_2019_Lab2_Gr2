package Modele;

import javax.persistence.*;

@Entity
@Table
public class Admin {

    private long adminId;
    private String firstNameA;
    private String lastNameA;
    private User user;


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
    public String getFirstName() {
        return this.firstNameA;
    }
    public void setFirstName(String firstName) {
        this.firstNameA = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return this.lastNameA;
    }
    public void setLastName(String lastName) {
        this.lastNameA = lastName;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public User getUser(){
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin() {
    }


    public String getFirstNameA() {
        return firstNameA;
    }

    public void setFirstNameA(String firstNameA) {
        this.firstNameA = firstNameA;
    }

    public String getLastNameA() {
        return lastNameA;
    }

    public void setLastNameA(String lastNameA) {
        this.lastNameA = lastNameA;
    }
}
