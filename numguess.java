import java.util.Random;
import java.util.Scanner;
public class numguess{
    public static void main(String[] args) {
        Random rand = new Random();	
        int num = rand.nextInt(100) + 1;
        int number_of_turns = 8;
	
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess a number between 1 and 100");
        int guess = sc.nextInt();

        while(number_of_turns!=1){
            if (guess == num){
                System.out.println("Congrats! You got it in " + number_of_turns + " guesses");
                System.exit(0);
            }
            else if (guess < num){
                System.out.println("Your guess is too low");
                number_of_turns--;
                System.out.println("You have " + number_of_turns + " guesses left");
                System.out.println("Enter your guess:");
                guess = sc.nextInt();
            }
            else if (guess > num){
                System.out.println("Your guess is too high");
                number_of_turns--;
                System.out.println("You have " + number_of_turns + " guesses left");
                System.out.println("Enter your guess:");
                guess = sc.nextInt();
            }
        }
            System.out.println("You ran out of guesses ..Better Luck Next Time !!!");
            System.out.println("The Number Is " + num);
            System.exit(0);
        }
        


}
