import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DB 
{
    static List<Major> majors = new ArrayList<Major>();
    static List<Student> students = new ArrayList<Student>();
    static List<Course> courses = new ArrayList<Course>();

    public static void initData()
    {
        initMajorData();
        initStudentData();
        initCoursesData();
    }
    private static void initMajorData()
    {
        try {
            File myFile = new File("majors.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] splited = data.split(" ");
              Major major = new Major(Integer.parseInt(splited[0]),splited[1],Integer.parseInt(splited[2]));
              majors.add(major);
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }  
    }
    private static void initStudentData()
    {
        try {
            
            File myFile = new File("students.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] splited = data.split(" ");
              Student student = new Student(
                  Integer.parseInt(splited[0]),
                  splited[1],
                  splited[2],
                  splited[3],
                  splited[4],
                  Integer.parseInt(splited[5]),
                  Float.parseFloat(splited[6])
                );
              students.add(student);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }  
    }
    private static void initCoursesData()
    {
        try {
            
            File myFile = new File("courses.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] splited = data.split(" ");
              Course course = new Course(
                  Integer.parseInt(splited[0]),
                  splited[1],
                  splited[2],
                  Integer.parseInt(splited[3])
                );
              courses.add(course);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }  
    }
}