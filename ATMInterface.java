// 1.Create a class to represent the ATM machine.
// 2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
//    checking the balance.
// 3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
//    checkBalance().
// 4. Create a class to represent the user's bank account, which stores the account balance.
// 5. Connect the ATM class with the user's bank account class to access and modify the account
//    balance.
// 6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
// 7. Display appropriate messages to the user based on their chosen options and the success or failure

import java.util.*;
class ATM
{
    double balance;
    ATM(double balance)
    {
        this.balance = balance;
    }
    public void withdraw(double amount)
    {
        balance -= amount;
    }
    public void deposit(double amount)
    {
        balance += amount;
    }
    public double checkBalance()
    {
        return balance;
    }
}
public class ATMInterface
{
    public static void clearScreen() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double balance = 0.0d;
        boolean validInput = false;
        while (!validInput) 
        {
            try 
            {
                System.out.print("Enter the amount: ");
                balance = sc.nextDouble();
                validInput = true;
            }
            catch (InputMismatchException e) 
            {
                System.out.println(e+"\nInvalid input. Please enter a numeric value.");
                sc.nextLine(); // clear invalid input from scanner
            }
        }
        ATM a = new ATM(balance);
        int choice = 0;
        while(choice != 4)
        {
            clearScreen();
            double amount = 0.0 ;
            System.out.print("\tMENU:\n1:Withdraw\n2:Deposit\n3:Check Balance\n4:Exit\nEnter your choice : ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1 :try 
                        {
                            System.out.print("Enter the amount to be withdrawn : ");
                            amount = sc.nextDouble();
                            if(a.checkBalance() < amount)
                                System.out.println("Insufficient Funds");
                            else
                                a.withdraw(amount);
                            System.out.println("Balance left= "+a.checkBalance());
                        }
                        catch (Exception e) 
                        {
                            System.out.println(e+"\nInvalid input. Please enter a numeric value.");
                            sc.nextLine();//clear invalid input from scanner
                        }
                        break;
                case 2 : try 
                        {
                            System.out.print("Enter the amount to be deposited : ");
                            amount = sc.nextDouble();
                            a.deposit(amount);
                            System.out.println("Current amount = "+a.checkBalance());
                        }
                        catch(Exception e)
                        {
                            System.out.println(e+"\nInvalid input. Please enter a numeric value.");
                            sc.nextLine();//clear invalid input from scanner
                        }                        
                        break;
                case 3 :System.out.println("Present amount = "+a.checkBalance());
                        break;
                case 4 : System.out.print("Program exitted. ");
                        return;
                default : System.out.println("Wrong Input");
                          break;
            }
        }
        sc.close();
    }
}