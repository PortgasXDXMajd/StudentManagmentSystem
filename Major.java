import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Major 
{
    int id;
    String majorTitle;
    int majorYears;
    List<Course> courses = new ArrayList<Course>();  

    public Major(int _id, String _title, int _year)
    {
        this.id = _id;
        this.majorTitle = _title;
        this.majorYears = _year;
    }
    public static Major CreateNewMajor(Scanner sc)
    {
        String _title;
        int _year;

        System.out.println("Create new Major:\n");
        System.out.println("Please add the following information:\n");

        System.out.print("Major Title: ");
        _title = sc.next();
        System.out.print("Major Number of study years: ");
        _year = sc.nextInt();
        

        Major newMajor = new Major(DB.majors.size() + 1,_title,_year);
        
        return newMajor;

    }
}
