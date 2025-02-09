import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			char[] arr = br.readLine().toCharArray();
			if(arr.length==1&&arr[0]=='.') break;
			
			Stack<Character> s = new Stack<>();
			boolean isBalanced = true;
			
			for(int i = 0; i<arr.length; i++) {
				if(arr[i]=='(' || arr[i]=='[') s.push(arr[i]);
				else if(arr[i]==')' || arr[i]==']'){
					if(s.isEmpty() ||
						(s.peek()!='(' && arr[i]==')') ||
						(s.peek()!='[' && arr[i]==']')) {
						isBalanced = false;
						break;
					}
					s.pop();
				}
			}
	
			System.out.println(isBalanced && s.isEmpty() ? "yes" : "no");
		}
	}
}