// 1. Create a Contact class to represent individual contacts. Include attributes such as name, phone
//    number, email address, and any other relevant details.
// 2. Implement an AddressBook class to manage the collection of contacts. Include methods to add a
//    contact, remove a contact, search for a contact, and display all contacts.
// 3. Design the user interface for the Address Book System. This can be a console-based interface or a
//    graphical user interface (GUI) using libraries like Swing or JavaFX.
// 4. Implement methods to read and write contact data to a storage medium, such as a file or a
//    database.
// 5. Allow users to interact with the Address Book System by providing options such as adding a new
//    contact, editing an existing contact's information, searching for a contact, displaying all contacts, and
//    exiting the application.
// 6. Implement input validation to ensure that required fields are not left empty and that the contact
//    data is in the correct format.

import java.util.*;

class Contact
{
    String name, email;
    int number;
    Contact(String name, String email, int number)
    {
        this.name = name;
        this.email = email;
        this.number = number;
    }
}

public class AddressBookSystem 
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> register = new ArrayList<>();

    public static void clearScreen() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void addContact()
    {
        System.out.print("Enter number of person : ");
        int n = sc.nextInt();
        System.out.println("Enter person details\nName\tEmail\tNumber : ");
        for (int i = 0; i < n; i++) 
        {
            String name = sc.next();
            String email = sc.next();
            int number = sc.nextInt();
            Contact list = new Contact(name, email, number);
            register.add(list);
        }
    }

    public static void removeContact()
    {
        System.out.print("Enter the name of Person");
        String name = sc.next();
        for (int i = 0; i < register.size(); i++) 
        {
            if((register.get(i).name).equals(name))
            {
                register.remove(i);
                System.out.println(name+" is removed");
                return;
            }
        }
        System.out.println(name+" is not present.");
    }

    public static void searchContact()
    {
        System.out.print("Enter the name of Person");
        String name = sc.next();
        for (int i = 0; i < register.size(); i++) 
        {
            if((register.get(i).name).equals(name))
            {
                System.out.println(name+" is present.\nEmail = "+register.get(i).email+"\nNumber = "+register.get(i).number);
                return;
            }
        }
        System.out.println(name+" is not present.");
    }

    public static void displayContact()
    {
        System.out.printf("Name\tEmail\tNumber\n");
        for (int i = 0; i < register.size(); i++) 
        {
            System.out.println(register.get(i).name+"\t"+register.get(i).email+"\t"+register.get(i).number);
        }
        System.out.println();
    }

    public static void editPersonDetails()
    {
        System.out.print("Enter the name of person : ");
        String name = sc.next();
        System.out.print("Enter the aspect to be changed : ");
        String x= sc.next();
        x.toLowerCase();
        for (int i = 0; i < register.size(); i++) 
        {
            if((register.get(i).name).equals(name))
            {
                if((x).equals("name"))
                {
                    System.out.print("Enter the new name: ");
                    register.get(i).name = sc.next();
                    return;
                }
                else if((x).equals("email"))
                {
                    System.out.print("Enter the new roll: ");
                    register.get(i).email = sc.next();
                    return;
                }
                else if((x).equals("number"))
                {
                    System.out.print("Enter the new grade: ");
                    register.get(i).number = sc.nextInt();
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
            System.out.println("6:Clear Screen :");
            System.out.println("7:Exit:");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1 : addContact();
                        break;
                case 2 : removeContact();
                        break;
                case 3 : searchContact();
                        break;
                case 4 : displayContact();
                        break;
                case 5 : editPersonDetails();
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