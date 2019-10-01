import java.util.Scanner;

/**
 * Palindrome Checker - checks if a user input (word or phrase) is a palindrome.
 * 
 * @author Elijah Tungul
 * @version 1.0
 * 
 */

public class PalindromeChecker {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);                                                    //Scanner takes user input
        boolean hasQuit = false;
        System.out.println("PALINDROME CHECKER");
        System.out.println("Please input a phrase:"); 
        while(!hasQuit){                                                                        //While the user has not quit
            String phrase = in.nextLine();                                                      //Take in user input from the whole command line
            switch(phrase){
                case "Q":                                                                       //Case that quits the program when typed
                    hasQuit = true;
                    break;
                default:                                                                        //Word or phrase that is not "Q" is run through the program
                    try{
                        phrase = clean(phrase);                                                 //Removes any punctuation/whitespace from the input
                        if(phrase.length() == 0){
                            throw new NullPointerException();                                   //If the phrase length is 0, throw a NullPointerException
                        }
                        String reversePhrase = new StringBuilder(phrase).reverse().toString();  //Reverses the string
                        if(phrase.equals(reversePhrase)){
                            System.out.println("Word or phrase is a palindrome!");              //If the phrase matches the reverse phrase, the input is a palindrome
                        }   
                        else { 
                            System.out.println("Word or phrase is not a palindrome.");          //Otherwise, the input is not a palindrome
                        }
                    }
                    catch(NullPointerException e){
                        System.out.println("ERROR: No input detected!");                        //Catches the NullPointerException if phrase is empty
                    }
                    
            }
        }
    }


public static String clean(String phrase){
    return phrase.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
}
    
}