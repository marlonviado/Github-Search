package com.marlonviado.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Singleton FileUtil class
 * @author marlon_viado
 * For Dev Branch
 *
 */
public class FileUtil {

	private FileUtil() {
	}

	public static class FileUtilHelper {
		private static FileUtil fileUtil =
				new FileUtil();
	}

	public static FileUtil open() {
		return FileUtilHelper.fileUtil;
	}

	public BufferedReader openFile(String fileName) {

		BufferedReader bufferedReader=null;

		File file =
				new File(fileName);

		try {

			FileReader fileReader =
					new FileReader(file);

			bufferedReader =
					new BufferedReader(fileReader);

			return bufferedReader;
		}
		catch(IOException ioException) {
			System.out.println("FileUtil.opeFile() : " + ioException.getMessage());
		}

		return bufferedReader;

	}

	public boolean deleteFile(String fileName) throws IOException {
		Path path =
				Paths.get(fileName);

		return Files.deleteIfExists(path);
	}

	public FileWriter writeFile(String fileName, File file) {

		FileWriter fileWriter=null;
		String logFileLocation = logFileLocation();

		file =
				new File(logFileLocation.substring(1, logFileLocation.length()) + fileName);

		try {

			fileWriter =
					new FileWriter(file);

			return fileWriter;
		}
		catch(IOException ioException) {
			System.out.println("FileUtil.opeFile() : " + ioException.getMessage());
		}

		return fileWriter;

	}

	public boolean createFile(String filename) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(".").getFile() + "/" + filename);
		if (file.createNewFile()) {
		    return true;
		} else {
		    return false;
		}
	}

	public File createFile(String filename,String f) throws IOException {
		String logFileLocation = logFileLocation();
		File file = new File(logFileLocation.substring(1, logFileLocation.length()) + filename);
		if (file.createNewFile()) {
		} else {
		}
		return file;
	}

	public String logFileLocation() {
		ClassLoader classLoader =
				getClass().getClassLoader();
		String location =
				classLoader.getResource(".").getFile();
		return location;
	}



}
