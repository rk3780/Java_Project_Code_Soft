// 1. Generate a random number within a specified range, such as 1 to 100.
// 2. Prompt the user to enter their guess for the generated number.
// 3. Compare the user's guess with the generated number and provide feedback on whether the guess
// is correct, too high, or too low.
// 4. Repeat steps 2 and 3 until the user guesses the correct number.
//    You can incorporate additional details as follows:
// 5. Limit the number of attempts the user has to guess the number.
// 6. Add the option for multiple rounds, allowing the user to play again.
// 7. Display the user's score, which can be based on the number of attempts taken or rounds won.

import java.util.*;

public class numberGame 
{
    static Scanner sc = new Scanner(System.in);
    static int round = 0, all=0;

    public static void clearScreen() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    

    public static void isCorrectNumber(int x) 
    {
        clearScreen();
        System.out.println("Guess numbers between 0 to 100 to win.");
        int attempts = 10,n=0;
        all++;
        while (n != x && attempts > 0) 
        {
            System.out.println("Attempts left= " + attempts);
            boolean validInput = false;
            while (!validInput) 
            {
                try 
                {
                    System.out.print("Guess the number : ");
                    n = sc.nextInt();
                    validInput = true;
                }
                catch (Exception e) 
                {
                    System.out.println("\nInvalid input");
                    sc.nextLine(); // clear invalid input from scanner
                }
            }
            attempts--;
            if (n < x)
                System.out.println("Too Low");
            else if(n > x)
                System.out.println("Too High");
            else
            {
                round++;
                System.out.println("Number is correct");
            }
        }
        if (attempts <= 0)
            System.out.println("Out of Attempts!!");
    }

    public static void main(String[] args) 
    {
        int choice = 1;
        while (choice == 1) 
        {
            Random r = new Random();
            int x = r.nextInt(100);
            isCorrectNumber(x);
            boolean validInput = false;
            while (!validInput) 
            {
                try 
                {
                    System.out.print("To play again press 1 else press 0 \nEnter your choice : ");
                    choice = sc.nextInt();
                    validInput = true;
                }
                catch (Exception e) 
                {
                    System.out.println("\nInvalid input.");
                    sc.nextLine(); // clear invalid input from scanner
                }
            }
        }
        System.out.printf("You have won %d games out of %d\n",round,all);
        System.out.println("Game Ended!!");
    }
}