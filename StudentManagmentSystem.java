import java.util.Scanner;

public class StudentManagmentSystem 
{
    static Scanner sc = new Scanner(System.in);
    
    private static int PrintOptions()
    {
        System.out.println("\n\nx----------------------------------------------------------------x");
        System.out.println("Choose one of the following: \n");
        System.out.println("1.\tShow Dashboard\n");
        System.out.println("2.\tShow All Students\n");
        System.out.println("3.\tShow All Majors\n");
        System.out.println("4.\tShow All Courses\n\n");
        System.out.println("x-----Creation-----x\n");
        System.out.println("5.\tAdd New Student\n");
        System.out.println("6.\tAdd New Major\n");
        System.out.println("7.\tAdd New Course\n\n");
        System.out.println("x-----Removing-----x\n");
        System.out.println("8.\tRemove a Student\n");
        System.out.println("9.\tRemove a Major\n");
        System.out.println("10.\tRemove a Course\n\n");
        System.out.println("x-----Updating-----x\n");
        System.out.println("11.\tUpdate a Student GPA\n\n");
        System.out.println("x------------------x\n");
        System.out.println("0.\tExit\n\n");
        System.out.println("x----------------------------------------------------------------x\n\n");
        System.out.println("Please choose what to do: ");
        int choise = sc.nextInt();
        return choise;
    }
    private static void ExecuteOption(int option)
    {
        switch(option)
        {
            case 1:  DataController.PrintDashboardInfo(sc); break;
            case 2:  DataController.printAllStudents(); break;
            case 3:  DataController.printAllMajors();; break;
            case 4:  DataController.printAllCourses(); break;
            case 5:  DataController.AddNewStudent(sc); break;
            case 6:  DataController.AddNewMajor(sc); break;
            case 7:  DataController.AddNewCourse(sc); break;
            case 8:  DataController.RemoveStudent(sc); break;
            case 9:  DataController.RemoveMajor(sc); break;
            case 10: DataController.RemoveCourse(sc); break;
            case 11: DataController.UpdateStudentGPA(sc); break;
            default: System.out.println("Wrong option number\n");
        }
    }
    public static void Start()
    {
        DB.initData();
        System.out.println("x--------------------------------Student Managment System--------------------------------x");
        while(true)
        {
            int option = PrintOptions();
            if(option == 0)
            {
                break;
            }
            else
            {
                ExecuteOption(option);
            }
        }
        System.out.println("x--------------------------------See you later--------------------------------x");
    }
}