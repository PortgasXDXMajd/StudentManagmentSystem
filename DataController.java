import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class DataController 
{    
    public static void AddNewMajor(Scanner sc)
    {
        Major newMajor = Major.CreateNewMajor(sc);
        DB.majors.add(newMajor);
        try
        {
            FileWriter fstream = new FileWriter("majors.txt",true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("\n"+newMajor.id + " " + newMajor.majorTitle + " " + newMajor.majorYears);
            out.close();
        }
        catch (Exception e)
        {
           System.err.println("Error while writing to file: " +
            e.getMessage());
        }
    }
    public static void AddNewStudent(Scanner sc)
    {
        Student newStudent = Student.CreateNewStudent(sc);
        DB.students.add(newStudent);
        try
        {
            FileWriter fstream = new FileWriter("students.txt",true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("\n"+newStudent.id + " " + newStudent.fName + " " + newStudent.lName + " " + newStudent.gender + " " + newStudent.nationality + " " + newStudent.major.id + " " + newStudent.gpa);
            out.close();
        }
        catch (Exception e)
        {
           System.err.println("Error while writing to file: " +
            e.getMessage());
        }
    }
    public static void AddNewCourse(Scanner sc)
    {
        Course newCourse = Course.CreateNewCourse(sc);
        DB.courses.add(newCourse);
        try
        {
            FileWriter fstream = new FileWriter("courses.txt",true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("\n"+newCourse.id + " " + newCourse.courseName + " " + newCourse.courseCode + " " + newCourse.major.id);
            out.close();
        }
        catch (Exception e)
        {
           System.err.println("Error while writing to file: " +
            e.getMessage());
        }
    }
    public static void PrintNumberofStudents(Scanner sc)
    {
        System.out.println("Total number of students is " + DB.students.size() + " students");
    }
    public static void PrintNumberofCourses(Scanner sc)
    {
        System.out.println("Total number of courses is " + DB.courses.size() + " courses");
    }
    public static void PrintNumberofMajors(Scanner sc)
    {
        System.out.println("Total number of majors is " + DB.majors.size() + " majors");
    }
    public static void PrintDashboardInfo(Scanner sc)
    {
        PrintNumberofMajors(sc);
        printAllMajors();
        PrintNumberofCourses(sc);
        printAllCourses();
        PrintNumberofStudents(sc);
        printAllStudents();
    }
    public static void RemoveMajor(Scanner sc)
    {
        System.out.println("Removing a Major: \n");
        printAllMajors();
        System.out.println("Please enter the id of the major to delete from the table above: ");
        int _id;
        _id = sc.nextInt();

        Major majorToRemove = getMajorById(_id);

        if(majorToRemove != null)
        {
            DB.majors.remove(majorToRemove);
            try
            {
                FileWriter fstream = new FileWriter("majors.txt",false);
                BufferedWriter out = new BufferedWriter(fstream);
                for (Major major : DB.majors) 
                {
                    out.write(major.id + " " + major.majorTitle + " " + major.majorYears+"\n");
                }
                System.out.println(majorToRemove.majorTitle + " has been removed successfully\n");
                out.close();
            }
            catch (Exception e)
            {
                System.err.println("Error while writing to file: " +
                e.getMessage());
            }
        }
        else
        {
            System.out.println("The Major was not found.");
        }


    }
    public static void RemoveCourse(Scanner sc)
    {
        System.out.println("Removing a Course: \n");
        printAllCourses();
        System.out.println("Please enter the id of the course to delete from the table above: ");
        int _id;
        _id = sc.nextInt();

        Course courseToRemove = getCourseById(_id);

        if(courseToRemove != null)
        {
            DB.courses.remove(courseToRemove);
            try
            {
                FileWriter fstream = new FileWriter("courses.txt",false);
                BufferedWriter out = new BufferedWriter(fstream);
                for (Course course : DB.courses) 
                {
                    out.write(course.id + " " + course.courseName + " " + course.courseCode + " " + course.major.id+"\n");
                }
                System.out.println(courseToRemove.courseName + " has been removed successfully\n");
                out.close();
            }
            catch (Exception e)
            {
                System.err.println("Error while writing to file: " +
                e.getMessage());
            }
        }
        else
        {
            System.out.println("The Course was not found.");
        }
    }
    public static void RemoveStudent(Scanner sc)
    {
        System.out.println("Removing a Student: \n");
        printAllStudents();
        System.out.println("Please enter the id of the student to delete from the table above: ");
        int _id;
        _id = sc.nextInt();

        Student studentToRemove = getStudentById(_id);

        if(studentToRemove != null)
        {
            DB.students.remove(studentToRemove);
            try
            {
                FileWriter fstream = new FileWriter("students.txt",false);
                BufferedWriter out = new BufferedWriter(fstream);
                for (Student student : DB.students) 
                {
                    out.write(student.id + " " + student.fName + " " + student.lName + " " + student.gender + " " + student.nationality + " " + student.major.id + " " + student.gpa+"\n");
                }
                System.out.println(studentToRemove.fName + " " + studentToRemove.lName + " has been removed successfully\n");
                out.close();
            }
            catch (Exception e)
            {
                System.err.println("Error while writing to file: " +
                e.getMessage());
            }
        }
        else
        {
            System.out.println("The Student was not found.");
        }
    }
    public static void UpdateStudentGPA(Scanner sc)
    {
        System.out.println("Updating a Student GPA: \n");
        printAllStudents();
        System.out.println("Please enter the id of the student to update from the table above: ");
        int _id;
        double _gpa;
        _id = sc.nextInt();
        System.out.println("Enter the new GPA: \n");
        _gpa = sc.nextDouble();

        for (Student myStudent : DB.students)
        {
            if(myStudent.id == _id)
            {
                myStudent.gpa = _gpa;
                try
                {
                    FileWriter fstream = new FileWriter("students.txt",false);
                    BufferedWriter out = new BufferedWriter(fstream);
                    for (Student student : DB.students) 
                    {
                        out.write(student.id + " " + student.fName + " " + student.lName + " " + student.gender + " " + student.nationality + " " + student.major.id + " " + student.gpa+"\n");
                    }
                    out.close();
                    System.out.println("GPA got updated successfully \n");
                    return;
                }
                catch (Exception e)
                {
                    System.err.println("Error while writing to file: " +
                    e.getMessage());
                }
            } 
        }
        System.out.println("Student was not found. \n");
    }
    public static void printAllMajors()
    {
        System.out.println("\n\nMajors List");
        TableList tl = new TableList(3, "ID", "Title", "Years").sortBy(0).withUnicode(false);
        DB.majors.forEach(element -> tl.addRow(Integer.toString(element.id), element.majorTitle, Integer.toString(element.majorYears)));
        tl.print();
        System.out.println("\n\n");
    }
    public static void printAllStudents()
    {
        System.out.println("\n\nStudents List");
        TableList tl = new TableList(7, "ID", "Firstname", "Lastname", "Gender", "Nationality", "Major", "cGPA").sortBy(0).withUnicode(false);
        DB.students.forEach(element -> tl.addRow(
            Integer.toString(element.id),
            element.fName,
            element.lName,
            element.gender,
            element.nationality,
            element.major.majorTitle,
            Double.toString(element.gpa)));
        tl.print();
        System.out.println("\n\n");
    }
    public static void printAllCourses()
    {
        System.out.println("\nCourses List");
        TableList tl = new TableList(4, "ID", "Course Name", "Course Code", "Major").sortBy(0).withUnicode(false);
        DB.courses.forEach(element -> tl.addRow(
            Integer.toString(element.id),
            element.courseName,
            element.courseCode,
            element.major.majorTitle));
        tl.print();
        System.out.println("\n\n");
    }
    public static Major getMajorById(int id)
    {
        for (Major major : DB.majors)
        {
            if(major.id == id)
            {
                return major;
            }
        }
        return null;
    }
    public static Course getCourseById(int id)
    {
        for (Course course : DB.courses)
        {
            if(course.id == id)
            {
                return course;
            }
        }
        return null;
    }
    public static Student getStudentById(int id)
    {
        for (Student student : DB.students)
        {
            if(student.id == id)
            {
                return student;
            }
        }
        return null;
    }
}