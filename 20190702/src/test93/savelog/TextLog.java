package test93.savelog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import test93.server.ClientManagerThread;

public class TextLog {
	String text;
	String fileName = "D:\\chatLog\\chatLogTest";
	// String logDateTitle =
	// LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	String logDate;

	ClientManagerThread CMT;

	public TextLog() {
		// save("\r\n========================"+logDate);
		// TODO Auto-generated constructor stub
	}

	public void save(String text) {
		logDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		text = "[" + logDate + "]" + "  " + text + "\r\n";

		try {
			// 버퍼 라이터 와 파일라이터 조합해서 사용한다(속도up)
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));

			// 파일안에 문자열 쓰기
			fw.write(text);
			fw.flush();

			// 객체 닫기
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(String text, String m_id) {
		logDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		text = "[" + logDate + "]" + "  " + " <" + m_id + "> " + text + "\r\n";

		try {
			// 버퍼 라이터 와 파일라이터 조합해서 사용한다(속도up)
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));

			// 파일안에 문자열 쓰기
			fw.write(text);
			fw.flush();

			// 객체 닫기
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
