import java.util.Scanner;

public class Course 
{
    int id;
    String courseName;
    String courseCode;
    Major major;

    public Course(int _id, String _name, String code, int _majorId)
    {
        this.id = _id;
        this.courseName = _name;
        this.courseCode = code;

        DB.majors.forEach(major -> {
            if(major.id == _majorId)
            {
                this.major = major;
            }
        });
    }
    public static Course CreateNewCourse(Scanner sc)
    {
        String _name;
        String _code;
        int _majorId;

        System.out.println("Create new Course:\n");
        System.out.println("Please add the following information:\n");

        System.out.print("Course Title: ");
        _name = sc.next();
        System.out.print("Course code: ");
        _code = sc.next();
        System.out.print("Major id: ");
        _majorId = sc.nextInt();
        

        Course newCourse = new Course(DB.courses.size() + 1,_name,_code,_majorId);
        
        return newCourse;

    }
    
}
