package java_prep;

import org.testng.annotations.Test;

public class Reverse_String {	

	@Test
	public void stringConcat() {
		String name = "Tester";
		String rev = "";
		int len = name.length();

		for (int i = len - 1; i >= 0; i--) {
			rev = rev + name.charAt(i);
		}
		System.out.println(rev);
	}

	@Test
	public void charArray() {
		String name = "Tester12";
		String rev = "";

		char a[] = name.toCharArray();
		int len = a.length;
		for (int i = len - 1; i >= 0; i--) {
			rev = rev + a[i];
		}
		System.out.println(rev);
	}

	@Test
	public void StrBuffer() {
		String name = "123edr";
		StringBuffer sb = new StringBuffer(name);
		StringBuffer rev = sb.reverse();
		System.out.println(rev);

	}

}
