package ex02;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ListFile {
	protected static Logger log = Logger.getLogger(ListFile.class);
	public static final String path = "src/resources/log4j.properties";

	public static void main(String[] args) {
		PropertyConfigurator.configure(path);
		try (ZipFile zipFile = new ZipFile("target.zip")) {
			// WITH STREAM zipFile.stream().forEach(ze -> print(ze));
			Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
			while (zipEntries.hasMoreElements()) {
				print(zipEntries.nextElement());
			}
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
