package java_prep;

public class Reverse_Character {
	public static void main(String[] args) {
		char[] inputArray = { 'h', 'e', 'l', 'l', 'o' };
		System.out.print("Original Array: ");
		printCharArray(inputArray);
		reverseString(inputArray);
		System.out.print("Reversed Array: ");
		printCharArray(inputArray);
	}

	public static void printCharArray(char[] arr) {
		for (char c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
// *********************** Only this code is important  ************************
	public static void reverseString(char[]s) {
		int len = s.length;
		int start=0;
		int end = len-1;
		
		while(start<end) {
			char temp = s[start];
			s[start]=s[end];
			s[end]=temp;
			start++;
			end--;
		}
	}

}
