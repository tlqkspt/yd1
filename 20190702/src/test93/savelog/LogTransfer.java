package test93.savelog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogTransfer {
	String fileName = "D:\\chatLog\\chatLogTest";

	String id;
	String chat;
	String date;

	public void txtRead() {
		String str;

//		File file = new File(src);
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//		String line;
//		data = new ArrayList<String>();
//		while ((line = br.readLine()) != null) {
//			Log.e("Flask_input", line);
//			data.add(line);
//		}
//		br.close();

		try {
			BufferedReader read = new BufferedReader(new FileReader(fileName));
//			BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
			while ((str = read.readLine()) != null) {
//			System.out.println(str);
				if (str != "서버시작") {
					String[] strArr = str.split("> ");
					date = str.substring(1, 21);
					System.out.println(date);
					strArr = str.split("     ");
					System.out.println(str);
					
					
					for (String id : strArr) {
						System.out.println("id ="+id);
				//		System.out.println("id ="+id);
					}
				}
			//	read.lines();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
