package ex02b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Pierre Goffic
 * @parameters pathSource pathDestination
 */
public class CopyFile {
	public static void main(String[] args) {
		String pathSource = null;
		String pathDestination = null;
		if (args == null || args.length == 0) {
			System.out.println("Please RTFM");
			System.exit(0);
		}
		System.out.println("Path source file : " + args[0] + ", Path destination file : " + args[1]);
		System.out.println("-----CHECKING-----");
		File fSource = new File(pathSource);
		File fDestination = new File(pathDestination);
		if (!fSource.exists()) {
			System.out.println("Sorry, but the source file doesn't exist !");
			System.exit(0);
		}
		if (fDestination.exists()) {
			System.out.println("Sorry, but the destination file already exist !");
			System.exit(0);
		}

		System.out.println("CHECK OK GO TO COPY FILE !");
		try {
			goToCopy(pathSource, pathDestination);
		} catch (IOException e) {
			System.out.println("Error to copy file, please check file");
			e.printStackTrace();
		}
		System.out.println("Copy is finish, Bye Bye");

	}

	private static void goToCopy(String source, String dest) throws IOException {
		BufferedInputStream fin = new BufferedInputStream(new FileInputStream(source));
		BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(dest));
		int i;
		do {
			i = fin.read();
			if (i != -1)
				fout.write(i);
		} while (i != -1);
		fin.close();
		fout.close();
	}

}
