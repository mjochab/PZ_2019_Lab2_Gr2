package Modele;

import javax.persistence.*;

@Entity
@Table
public class Admin {

    private long adminId;
    private String firstNameA;
    private String lastNameA;



    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    public long getTeacherId() {
        return this.adminId;
    }
    public void setTeacherId(long teacherId) {
        this.adminId = teacherId;
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

    public Admin() {
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
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
