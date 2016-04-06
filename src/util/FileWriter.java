package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import register.RentRegister;

public class FileWriter {

	public void FileWriter() throws IOException {
		RentRegister out = new RentRegister();
		String fileSave = out.printNote().toString();
		String localSave = (System.getProperty("user.home"));
		Files.write(new File(localSave + "Rent Ticket" + ".txt").toPath(), fileSave.getBytes());

	}
}
