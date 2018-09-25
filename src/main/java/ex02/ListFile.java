package ex02;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ListFile {
	private static String pathZip = "/mnt/monster/home/eleves/p/pgoffic/eclipse-workspace/hello/src/main/java/ex02/target.zip";
	protected static Logger log = Logger.getLogger(ListFile.class);
	public static final String path = "src/resources/log4j.properties";

	public static void main(String[] args) {
		PropertyConfigurator.configure(path);
		try (ZipFile zipFile = new ZipFile(pathZip)) {
			zipFile.stream().forEach(ze -> print(ze));
		} catch (IOException e) {
			log.error("Canno't find the Zip File : " + e);
		}
	}

	private static void print(ZipEntry zipEntry) {
		System.out.println("File name : " + zipEntry.getName() + " Time : " + TimeConverter(zipEntry.getTime())
				+ " size : " + zipEntry.getSize() + " Packed Size : " + zipEntry.getCompressedSize());
	}

	public static String TimeConverter(long dateIn) {
		Date date = new Date(dateIn);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formatted = format.format(date);
		return formatted;
	}
}
