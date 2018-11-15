//David Nagy
//6/5/18
//Driver.java
//Description:The Driver that Controls the output of the WordLadder


package wordLadder;

import java.util.*;
import java.util.Scanner;

public class Driver {
//  Scanner Console, User Enters two words.
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String input = "Y";
		while (input.charAt(0) != 'N' ){
			System.out.print("Enter word 1:");
			String word1=console.next();
			System.out.print("Enter word 2:");
			String word2=console.next();
			System.out.println();
			
			WordLadder ladder= new WordLadder();
			ladder.findLadder(word1, word2);
			
			System.out.println();
			System.out.print("Do you want to try again Y/N");
			input=console.next().toUpperCase();
			
			
				
		}
		// TODO Auto-generated method stub

	}

}
