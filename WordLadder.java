//David Nagy
//6/5/18
//wordLadder.java
//Description: Designed for the user to enter two words and sucessfully match the words


package wordLadder;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Constructor fields
public class WordLadder {
	private List<String> words;
	private List<String> ladder;
	private int steps;
	public Scanner file;
	
	public WordLadder() {
	
		words= new ArrayList<String>();
		ladder=new ArrayList<String>();
		//Adding words.txt to wordladder
		try {
			file=new Scanner(new File("words.txt"));
			while (file.hasNext() ) {
				words.add(file.next());
			}
			
		}catch (FileNotFoundException error) {
			System.out.println("File does not exist");
			
			
			}
		}
	//printList Method
		private void printList(List<String> list) {
			for (String s : list) { 
				System.out.println(s);
				
			}
		}//inlist Method
		private	boolean inList(String word, List<String> list) {
				return list.contains(word);
			}//oneDiff method
		private boolean oneDiff(String word1, String word2) {
			int difference=0;
if(word1.length() == word2.length()) {
				for (int i=0; i<word1.length(); i++) {
					if (word1.toLowerCase().charAt(i) !=word2.toLowerCase().charAt(i)) {
						difference++;
					}
				}
			}
			return difference == 1;
		}//findLadder Method
		public boolean findLadder(String startWord, String endWord) {
			if (startWord.equals(endWord)) {
				System.out.println("Success!!!");
				this.printList(ladder);
				return true;
				
			}
			if (steps> startWord.length() + 1) {
				System.out.println("No word Ladder found!");
				return false;
			}
			
			for (int i=0; i<words.size(); i++) {
				if(this.oneDiff(startWord,words.get(i)) && !this.inList(words.get(i), ladder)) {
					if(!this.inList(startWord, ladder)) {
						ladder.add(startWord);
					}
					ladder.add(words.get(i));
					steps++;
					findLadder(words.get(i), endWord);
					return true;
					}
			}
		
			System.out.println("No word ladder found!");
			return false;
		}
		
}
	
