package fileRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FileRead {
	public static void main(String[] args) {
		System.out.println("InputStream으로 읽기");
		System.out.println(new String(readFile2("utf8.txt")));
		System.out.println("utf8.txt -- 읽기완료");

		System.out.println(new String(readFile2("ansi.txt")));
		System.out.println("ansi.txt -- 읽기완료");

		try {
			System.out.println(new String(readFile2("ansi.txt"), "euc-kr"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("ansi.txt -- 읽기완료");
	}

	public static byte[] readFile2(String fileName) {
		FileInputStream fis = null;
		byte[] data = null;
		try {
			fis = new FileInputStream(fileName);
			data = new byte[fis.available()];
			fis.read(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				;
			}
		}
		return data;
	}

}
