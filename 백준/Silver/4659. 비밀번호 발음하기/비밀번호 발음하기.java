import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int S;
	static int[] arr;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			char[] arr = br.readLine().toCharArray();
			
			if(String.valueOf(arr).equals("end")) break;
			
			if(check_1(arr) && check_2(arr) && check_3(arr)) {
				System.out.println("<"+String.valueOf(arr)+"> is acceptable.");
			}else {
				System.out.println("<"+String.valueOf(arr)+"> is not acceptable.");
			}
		}
	}
	
	// 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
	static boolean check_1(char[] arr) {
		String[] mo = {"a", "e", "i", "o", "u"};
		String pass = String.valueOf(arr);
		
		for(String s : mo) {
			if(pass.contains(s)) return true;
		}
		return false;
	}
	
	// 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
	static boolean check_2(char[] arr) {
		StringBuilder tmp = new StringBuilder();
		for(int i = 0; i<arr.length-2; i++) {
			tmp.setLength(0);
			tmp.append(arr[i]).append(arr[i+1]).append(arr[i+2]);
			if(isThree(tmp.toString())) {
				return false;
			}
		}
		
		return true;
	}
	
	// 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
	static boolean check_3(char[] arr) {
		StringBuilder tmp = new StringBuilder();
		
		for(int i = 0; i<arr.length-1; i++) {
			tmp.setLength(0);
			tmp.append(arr[i]).append(arr[i+1]);
			
			if((arr[i]=='e'&&arr[i+1]=='e') || (arr[i]=='o'&&arr[i+1]=='o')) {
				
			}else if(arr[i]==arr[i+1]) {
				return false;
			}
		}
		
		return true;
	}
	

	static boolean isThree(String tmp) {
		char[] mo = {'a', 'e', 'i', 'o', 'u'};
		int cnt = 0;
		for(int i = 0; i<tmp.length(); i++) {
			for(int j = 0; j<mo.length; j++) {
				if(tmp.charAt(i)==mo[j]) cnt++;
			}
		}
		
		if(cnt>2) return true;
		if(cnt==0) return true;
		
		return false;
	}
}
