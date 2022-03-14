package Utility;

import java.io.File;


public class DeleteTempFiles {

	public static void delete(String filePath) {
		File directory = new File(filePath);
		
		File file1 = new File(filePath);
		
		file1.delete();
		if (directory.isDirectory()) {

			String files[] = directory.list();
			for (String temp : files) {
				File fileDelete = new File(directory, temp);
				fileDelete.delete();
			}
			if (directory.list().length == 0) {
				directory.delete();

			} else {

			}
		}
		
		directory.delete();
	}
}