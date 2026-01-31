import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private int rollNo;
    private String grade;

    Student(String name, int rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Roll No: " + rollNo +
               ", Name: " + name +
               ", Grade: " + grade;
    }
}
