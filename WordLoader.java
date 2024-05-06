package hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordLoader {
	
	private static ArrayList<String> wordList=new ArrayList<String>();
	private static Random random=new Random();
	
	static {
		loadWordList();
	}
	
	public static void loadWordList() {
		try {
			BufferedReader br=new BufferedReader(new FileReader("src/words.txt"));
			String word;
			while((word=br.readLine())!=null) {
				wordList.add(word.trim());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getRandomWord() {
		if(wordList.isEmpty()) {
			return null;
		}
		return wordList.get(random.nextInt(wordList.size()));
	}

}
