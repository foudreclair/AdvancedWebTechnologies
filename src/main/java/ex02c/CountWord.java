package ex02c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class CountWord {

	public static void main(String[] args) throws IOException {
		String pathFile = "test.txt";
		System.out.println("Number of words : " + countWords(pathFile));
		System.out.println("Go to write in File");
		FileWriter fw;
		try {
			fw = new FileWriter(new File("log.txt"));
			fw.write("Number of words : " + countWords(pathFile));
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Go to read the file");
	}

	public static int countWords(String pathFile) throws IOException {
		int count = 0;
		BufferedReader BF = new BufferedReader(new FileReader(pathFile));
		String line;
		try {
			while ((line = BF.readLine()) != null) {
				StringTokenizer words = new StringTokenizer(line);
				while (words.hasMoreTokens()) {
					count++;
					words.nextToken();
				}
			}
			return count;
		} catch (FileNotFoundException e) {
			System.out.println("File not found !" + e);
		} finally {
			BF.close();
		}
		return count;
	}

}
