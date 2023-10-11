import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println(constants.INVALID_MESSAGE);
		} else if (args[0].equals(constants.SHOW_ALL)) {
			System.out.println(constants.LOADED_DATA);
			try {
				BufferedReader bufferreader = readfile();
				String studentnames[] = bufferreader.readLine().split(constants.COMMA);
				for (String name : studentnames) {
					System.out.println(name.trim());
				}
				bufferreader.close();
			} catch (Exception e) {
			}
			System.out.println(constants.DATA_LOADED);
		} else if (args[0].equals(constants.RANDOM_NAME)) {
			System.out.println(constants.LOADED_DATA);
			try {
				BufferedReader bufferreader = readfile();
				String studentnames[] = bufferreader.readLine().split(constants.COMMA);
				int randomindex = new Random().nextInt(studentnames.length);
				System.out.println(studentnames[randomindex].trim());
				bufferreader.close();
			} catch (Exception e) {
			}
			System.out.println(constants.DATA_LOADED);
		} else if (args[0].contains(constants.PLUS)) {
			System.out.println(constants.LOADED_DATA);
			try {
				BufferedWriter bufferwriter = writefile();
				String name = args[0].substring(1);
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat(constants.DATE);
				String formatdate = dateFormat.format(date);
				bufferwriter.write(constants.COMMA + name + constants.LAST_UPDATE_MESSAGE + formatdate);
				bufferwriter.close();
			} catch (Exception e) {
			}

			System.out.println(constants.DATA_LOADED);
		} else if (args[0].contains(constants.FIND)) {
			System.out.println(constants.LOADED_DATA);
			try {
				BufferedReader bufferreader = readfile();
				String studentnames[] = bufferreader.readLine().split(constants.COMMA);
				boolean done = false;
				String name = args[0].substring(1);
				for (int index = 0; index < studentnames.length && !done; index++) {
					if (studentnames[index].trim().equals(name)) {
						System.out.println(constants.WE_FOUND_MESSAGE);
						done = true;
					}
				}
				bufferreader.close();
			} catch (Exception e) {
			}
			System.out.println(constants.DATA_LOADED);
		} else if (args[0].contains(constants.COUNT)) {
			System.out.println(constants.LOADED_DATA);
			try {
				BufferedReader bufferreader = readfile();
				char names[] = bufferreader.readLine().toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char ch : names) {
					if (ch == constants.SPACE) {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + constants.FOUND_MESSAGE);
				bufferreader.close();
			} catch (Exception e) {
			}
			System.out.println(constants.DATA_LOADED);
		} else {
			System.out.println(constants.INVALID_MESSAGE);
		}
	}

	private static BufferedWriter writefile() throws IOException {
		return new BufferedWriter(
				new FileWriter(constants.FILE_NAME, true));
	}

	private static BufferedReader readfile() throws FileNotFoundException {
		return new BufferedReader(
				new InputStreamReader(
						new FileInputStream(constants.FILE_NAME)));
	}
}