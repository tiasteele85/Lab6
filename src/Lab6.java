import java.util.Random;
import java.util.Scanner;

public class Lab6 {

	public static void main(String[] args) {
		
		//variables
		Scanner in = new Scanner(System.in);//accept user input
		int sides; //value to hold the users choice in dice
		char choice = 'Y';//record user choice
		int count = 0;
		
		System.out.println("Welcome to the Grand Circus Casino!\n");
		
		
		//Prompt user for response
		System.out.println("How many sides does each die have?");
		sides = in.nextInt();
		
		do {	
			
			//display count
			count++;
			System.out.println("Roll: " + count);
								
			//Check for Craps game
			if(sides == 6) {
				
					checkingThatSix(sides);	
			}else {
				
				//call method to roll the chosen dice				
				System.out.println(generateRandomDieRoll(sides));
				System.out.println(generateRandomDieRoll(sides));
				
			}			
				
			//Prompt user to continue
			System.out.println("Roll again? (y/n)");
			choice = in.next().toUpperCase().charAt(0);
			
		}while(choice=='Y');
		
		System.out.println("Goodbye!");
		
		//close Scanner object
		in.close();

	}

	// method to assign a random number to a user determined sided dice
	public static int generateRandomDieRoll(int sides) {
		Random num = new Random();//create random object
		int roll = num.nextInt(sides) + 1;//assign random roll
				
		return roll;
		
	}

	//Checks for Craps dice game
	public static void checkingThatSix(int sides)
	{
		//rolls dice
		int first = generateRandomDieRoll(sides);
		int second = generateRandomDieRoll(sides);
		
		//checks cases for different wins and loses in craps
		switch(first) {
			case 1:
			{
				maybeUnlucky(first, second);
				break;
			}
			case 6:
			{
				maybeLucky(first, second);
				break;
			}
			default:
			{
				System.out.println(first + "\n" + second);
			}
		}
		
	}

	//Method to check for snake eyes and craps
	public static void maybeUnlucky(int first, int second) {
		
		
		
		if(second == 1)
		{
			//tested for snake eyes and printed it
			System.out.println(first);
			System.out.println(second);
			System.out.println("Snake Eyes");
			
		}else if(second == 2){
			//tested for craps and printed it
			System.out.println(first);
			System.out.println(second);
			System.out.println("Craps");
		}else {
			//print first and second dice normally
			System.out.println(first);
			System.out.println(second);			
		}
		
	}

	//Method to check for box cars
	public static void maybeLucky(int first, int second) {
			
			
		if(second == 6)
		{
			System.out.println(first);
			System.out.println(second);
			System.out.println("Box cars");
		}else {
			//print first and second dice normally
			System.out.println(first);
			System.out.println(second);			
		}
		
	}
}
