package ex02;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class listFile {
	private static String pathZip = "/mnt/monster/home/eleves/p/pgoffic/eclipse-workspace/hello/src/main/java/ex02/target.zip";
	protected static Logger log = Logger.getLogger(listFile.class);
	static final String path = "src/resources/log4j.properties";

	public static void main(String[] args) {
		PropertyConfigurator.configure(path);
		try (ZipFile zipFile = new ZipFile(pathZip)) {
			zipFile.stream().map(ZipEntry::getName).forEach(System.out::println);
		} catch (IOException e) {
			log.error("Canno't find the Zip File : " + e);
		}
	}
}
