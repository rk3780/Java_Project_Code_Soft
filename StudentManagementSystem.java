// 1. Create a Student class to represent individual students. Include attributes such as name, roll
//    number, grade, and any other relevant details.
// 2. Implement a StudentManagementSystem class to manage the collection of students. Include
//    methods to add a student, remove a student, search for a student, and display all students.
// 3 . Design the user interface for the Student Management System. This can be a console-based
//     interface or a graphical user interface (GUI) using libraries like Swing or JavaFX.
// 4. Implement methods to read and write student data to a storage medium, such as a file or a
//    database.
// 5. Allow users to interact with the Student Management System by providing options such as
//    adding a new student, editing an existing student's information, searching for a student, displaying all
//    students, and exiting the application.
// 6. Implement input validation to ensure that required fields are not left empty and that the student
//    data is in the correct format

import java.util.*;

class student
{
    String name;
    int roll;
    double grade;
    student(String name, int roll, double grade)
    {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }
}
public class StudentManagementSystem 
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<student> book = new ArrayList<>();

    public static void clearScreen() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void addStudent()
    {
        System.out.print("Enter number of students : ");
        int n = sc.nextInt();
        System.out.println("Enter student details\nName\tRoll Number\tGrade : ");
        for (int i = 0; i < n; i++) 
        {
            String name = sc.next();
            int roll = sc.nextInt();
            double grade = sc.nextDouble();
            student s = new student(name, roll, grade);
            book.add(s);
        }
    }

    public static void removeStudent()
    {
        System.out.print("Enter the name of student");
        String name = sc.next();
        for (int i = 0; i < book.size(); i++) 
        {
            if((book.get(i).name).equals(name))
            {
                book.remove(i);
                System.out.println(name+" is removed");
                return;
            }
        }
        System.out.println(name+" is not present.");
    }

    public static void searchStudent()
    {
        System.out.print("Enter the name of student");
        String name = sc.next();
        for (int i = 0; i < book.size(); i++) 
        {
            if((book.get(i).name).equals(name))
            {
                System.out.println(name+" is present.\nRoll = "+book.get(i).roll+"\nGrade = "+book.get(i).grade);
                return;
            }
        }
        System.out.println(name+" is not present.");
    }

    public static void displayStudent()
    {
        System.out.printf("NAME\tROLL\tGRADE\n");
        for (int i = 0; i < book.size(); i++) 
        {
            System.out.println(book.get(i).name+"\t"+book.get(i).roll+"\t"+book.get(i).grade);
        }
        System.out.println();
    }

    public static void editStudentDetails()
    {
        System.out.print("Enter the name of student : ");
        String name = sc.next();
        System.out.print("Enter the aspect to be changed : ");
        String x= sc.next();
        x.toLowerCase();
        for (int i = 0; i < book.size(); i++) 
        {
            if((book.get(i).name).equals(name))
            {
                if((x).equals("name"))
                {
                    System.out.print("Enter the new name: ");
                    book.get(i).name = sc.next();
                    return;
                }
                else if((x).equals("roll"))
                {
                    System.out.print("Enter the new roll: ");
                    book.get(i).roll = sc.nextInt();
                    return;
                }
                else if((x).equals("grade"))
                {
                    System.out.print("Enter the new grade: ");
                    book.get(i).grade = sc.nextDouble();
                    return;
                }
                else
                {
                    System.out.println("Wrong aspect");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        int choice=0;
        while(choice != 7)
        {
            System.out.println("\n\tMENU:");
            System.out.println("1:Add student details :");
            System.out.println("2:Remove a student :");
            System.out.println("3:Search a student :");
            System.out.println("4:Display all student details :");
            System.out.println("5:Edit student details :");
            System.out.println("6:Clear Screen");
            System.out.println("7:Exit:");
            System.out.print("Enter your choice : ");
            boolean validInput = false;
            while(!validInput)
            {
                try
                {
                    System.out.print("Enter your choice : ");
                    choice = sc.nextInt();
                    validInput = true;
                }
                catch(Exception e)
                {
                    System.out.println("\nInvalid Input!!!");
                    sc.nextLine();
                }
            }
            switch(choice)
            {
                case 1 : addStudent();
                        break;
                case 2 : removeStudent();
                        break;
                case 3 : searchStudent();
                        break;
                case 4 : displayStudent();
                        break;
                case 5 : editStudentDetails();
                        break;
                case 6 : clearScreen();
                        break;
                case 7 :System.out.println("Progeam ended"); 
                        return;
                default : System.out.println("Wrong choice!!");
                        break;
            }
        }    
    }
}
