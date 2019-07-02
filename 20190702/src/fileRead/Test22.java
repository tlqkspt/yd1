package fileRead;

import java.nio.charset.Charset;

public class Test22 {
	public static void main(String[] args) {
		String helloString = "안녕하세요. ㄱㄴㄷㄹㅁㅂㅆㅢ 놟쐛씗쀍 ";
		System.out.println("Source : " + helloString);

		// String 을 euc-kr 로 인코딩.
		byte[] euckrStringBuffer = helloString.getBytes(Charset.forName("euc-kr"));
		System.out.println();

		System.out.println("euc-kr - length : " + euckrStringBuffer.length);
		String decodedFromEucKr = new String(euckrStringBuffer, "euc-kr");
		System.out.println("String from euc-kr : " + decodedFromEucKr);

		// String 을 utf-8 로 인코딩.

		byte[] utf8StringBuffer = decodedFromEucKr.getBytes("utf-8");

		System.out.println();
		System.out.println("utf-8 - length : " + utf8StringBuffer.length);
		String decodedFromUtf8 = new String(utf8StringBuffer, "utf-8");
		System.out.println("String from utf-8 : " + decodedFromUtf8);
	}
}
