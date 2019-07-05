package test93.savelog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogTransfer {
	String fileName = "D:\\chatLog\\chatLogTest";

	String id;
	String chat;
	String date;
	List<logDTO> logList = new ArrayList<logDTO>();

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

				if (str.length() > 15) { // 서버시작 라인 날림
					String date;
					String id = null;
					String chat;
					logDTO log = new logDTO();

					date = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
					// System.out.println(date);
					log.setDate(date);

					if (str.indexOf("<") > 0)	// < 없는 서버메세지 필터
						id = str.substring(str.indexOf("<") + 1, str.indexOf(">"));
					
					if(id == null)	//서버메세지
						id = "server";
					log.setId(id);
					// System.out.println(id);

					chat = str.substring(str.indexOf(">") + 2, str.length());
					log.setChat(chat);
					// System.out.println(chat);

					logList.add(log);

				}

				// System.out.println(str);
			}
			
			logDAO dao = new logDAO();
			int n =0;
			if(( n= dao.setLog(logList)) != 0)
				System.out.println("저장성공");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	// System.exit(0);
}
