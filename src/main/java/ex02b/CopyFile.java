package ex02b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
			goToCopy(fSource, fDestination);
		} catch (IOException e) {
			System.out.println("Error to copy file, please check file");
			e.printStackTrace();
		}
		System.out.println("Copy is finish, Bye Bye");

	}

	private static void goToCopy(File source, File dest) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
		} finally {
			in.close();
			out.close();
		}
	}

}
