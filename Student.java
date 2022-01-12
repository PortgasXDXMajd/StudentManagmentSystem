import java.util.Scanner;

public class Student 
{
    int id;
    String fName;
    String lName;
    String gender;
    String nationality;
    Major major;
    double gpa;
    
    public Student(int _id, String _fn, String _ln, String _g, String _n, int _majorId,double d)
    {
        this.id = _id;
        this.fName = _fn;
        this.lName = _ln;
        this.gender = _g;
        this.nationality = _n;
        this.gpa = d;

        DB.majors.forEach(major -> {
            if(major.id == _majorId)
            {
                this.major = major;
            }
        });
    }
    public static Student CreateNewStudent(Scanner sc)
    {
        String _fn;
        String _ln;
        String _g;
        String _n;
        int _majorId;
        
        System.out.println("Create new Student:\n");
        System.out.println("Please add the following information:\n");

        System.out.print("Firstname: ");
        _fn = sc.next();
        
        System.out.print("Lastname: ");
        _ln = sc.next();

        System.out.print("Gender: ");
        _g = sc.next();

        System.out.print("Nationality: ");
        _n = sc.next();

        System.out.print("Major Id: ");
        _majorId = sc.nextInt();
        
        Student newStudent = new Student(DB.students.size() + 1, _fn, _ln, _g, _n, _majorId, 0.0);
        
        return newStudent;
    }
}