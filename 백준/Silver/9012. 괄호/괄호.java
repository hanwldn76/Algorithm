import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<n; i++) {
			char[] arr = br.readLine().toCharArray();
			Stack<Character> s = new Stack<>();
			int state = 0;
			for(int j = 0; j<arr.length; j++) {
				if(arr[j]=='(') s.push(arr[j]);
				else {
					if(s.isEmpty()) {
						state = 1;
						break;
					}
					if(s.peek()=='(') s.pop();
				}
			}
	
			if(state == 1) System.out.println("NO");
			else if(s.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}

	}
}