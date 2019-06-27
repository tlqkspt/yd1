package co.kdw.command;

import co.kdw.controller.KeyIn;
import co.kdw.dao.SubjectDao;

public class SubjectUpdate {
	private SubjectDao dao = new SubjectDao();
	private String colum;
	private String value;
	// private String key;
	private int key;

	// sql 직접날리면 보안상 위험할수도있다 시퀄노출됨(권장하지않음) ssl레이어 쓰면 써도된다?(슈퍼컴 100년걸림)
	private void update() {
		dataInput();
		String sql = "update subject set " + colum + " = '" + value + "' where numid = " + key; // Integer.parseInt(key);
//														' 문자열표시?     '					//여기 숫자 < 문자
		if (dao.update(sql) != 0) {
			System.out.println("정상변경 되었습니다.");
		} else
			System.out.println("변경 실패!!!!!!!!");
		dao.close();
	}

	private void dataInput() {
		System.out.println("변경할 컬럼을 입력.( 수강과목 | 성적 ) 에서 하나 선택");
		colum = KeyIn.sc.nextLine();
		switch (colum) {
			case "수강과목":
				colum = "sname";
				break;
			case "성적":
				colum = "sgrade";
				break;
		}
		System.out.println("변경할 값을 입력하세요");
		value = KeyIn.sc.next();
		System.out.println("변경할 키값을 입력하세요");
		key = KeyIn.sc.nextInt();
		// Integer.parseInt(key); //////////////////////
	}

	public void run() {
		SubjectSelect view = new SubjectSelect();
		view.run();
		update();
		view.run();
	}
}
