package Walmart;

public class strreverse {
	
	public static String reverseString(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		char[] sArr = s.toCharArray();
		
		int start = 0;
		int end = s.length()-1;
		
		while(start < end) {
			char temp = sArr[start];
			sArr[start] = sArr[end];
			sArr[end] = temp;
			start++;
			end--;
		}
		
		
		
		for(char c:sArr)
			sb.append(c);
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(reverseString("hardi"));

	}

}
