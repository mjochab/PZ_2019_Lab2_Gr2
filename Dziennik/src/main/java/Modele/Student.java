package Modele;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Student implements Serializable {

    private long studentId;
    private String firstNameS;
    private String lastNameS;
    private String pesel;

    private Classes classes;
    private Set<Warns> warns;
    private Set<Grades> grades;
    private Set<Frequently> frequently;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    public long getStudentId(){
        return this.studentId;
    }
    public void setStudentId(long id){
        this.studentId = id;
    }

    @Column(name = "first_name", nullable = false, length = 100)
    public String getFirstName(){
        return this.firstNameS;
    }
    public void setFirstName(String firstName){
        this.firstNameS = firstName;
    }



    @Column(name = "last_name", nullable = false, length = 100)
    public String getLastName(){
        return this.lastNameS;
    }
    public void setLastName(String lastName){
        this.lastNameS = lastName;
    }

    @Column(name = "pesel", nullable = false, length = 11)
    public String getPesel(){
        return this.pesel;
    }
    public void setPesel(String pesel){
        this.pesel = pesel;
    }



    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    public Set<Warns> getWarns(){
        return this.warns;
    }
    public void setWarns(Set<Warns> warns){
        this.warns = warns;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    public Set<Grades> getGrades(){
        return this.grades;
    }
    public void setGrades(Set<Grades> grades){
        this.grades = grades;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    public Set<Frequently> getFrequently() {
        return frequently;
    }
    public void setFrequently(Set<Frequently> frequently) {
        this.frequently = frequently;
    }

    @ManyToOne
    @JoinColumn(name = "class_id")
    public Classes getClasses() {
        return classes;
    }
    public void setClasses(Classes classes) {
        this.classes = classes;
    }


    public Student(){}
    public Student(String firstNameS,String lastNameS, String pesel ) {
        this.firstNameS = firstNameS;
        this.lastNameS = lastNameS;
        this.pesel = pesel;

    }

    @OneToOne(fetch = FetchType.LAZY)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstNameS='" + firstNameS + '\'' +
                ", lastNameS='" + lastNameS + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
