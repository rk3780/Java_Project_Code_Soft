// 1. Prompt the user to enter a text or provide a file to count the words.
// 2. Read the input text or file and store it in a string.
// 3. Split the string into an array of words using space or punctuation as delimiters.
// 4. Initialize a counter variable to keep track of the number of words.
// 5. Iterate through the array of words and increment the counter for each word encountered.
// 6. Display the total count of words to the user.
//    You can further enhance the project by adding features such as:
// 7. Ignoring common words or stop words.
// 8. Providing statistics like the number of unique words or the frequency of each word.
// 9. Implementing input validation to handle empty inputs or file errors.
// 10. Adding a graphical user interface (GUI) for a more user-friendly experience.

import java.util.*;

public class WordCounter 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> word = new ArrayList<>();
        int[] ar = new int[128];
        int wordcount = 0, numbercount = 0, specialcount = 0;
        System.out.print("Enter the string : ");
        String s = sc.nextLine();

        //converting string into array
        for (int i = 0; i < s.length(); i++) 
        {
            char temp = s.charAt(i);
            word.add(temp);
        }
        System.out.println(word);

        //total number of words
        for (int i = 0; i < s.length(); i++) 
        {
            char temp = s.charAt(i);
            if(temp == '0' || temp == '1' || temp == '2' || temp == '3' || temp == '4' || temp == '5' || temp == '6' || temp == '7' || 
               temp == '8' || temp == '9')
            {
                numbercount++;
            }
            else if(temp != ' ' && temp != '`' && temp != '~' && temp != '!' && temp != '@' && temp != '#' && temp != '#' && temp != '$' &&
               temp != '%' && temp != '^' && temp != '&' && temp != '*' && temp != '(' && temp != ')' && temp != '_' && temp != '-' &&
               temp != '=' && temp != '+' && temp != '[' && temp != ']' && temp != '{' && temp != '}' && temp != ':' && temp != '|' &&
               temp != ';' && temp != '"' && temp != ',' && temp != '<' && temp != '>' && temp != '.' && temp != '?' && temp != '/' && 
               temp != '₹')
            {
                wordcount++;
            }
            else
                specialcount++;
        }
        System.out.println("Total number of words are : "+wordcount);
        System.out.println("Total number of number are : "+numbercount);
        System.out.println("Total number of special characters are : "+specialcount);

        //frequrncy of each word
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            int x=temp;
            ar[x]++;
        }
        for (int i = 0; i < ar.length; i++) {
            if(ar[i] != 0)
                System.out.println("There are "+ar[i]+" "+(char)i);
        }
        sc.close();
       }
}