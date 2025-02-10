import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Integer> s = new Stack<>();
	static int[] arr;
	static List<Integer> res = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = n-1; i>=0; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<n; i++) {
			int tmp = arr[i];
			
			while(!s.isEmpty()) {
				if(tmp < s.peek()) {
					res.add(s.peek());
					break;
				}else {
					s.pop();
				}
			}
			
			if(s.isEmpty()) {
				res.add(-1);
			}
			
			s.push(tmp);
		}
		
		for(int i = n-1; i>=0; i--) sb.append(res.get(i)+" ");
		
		System.out.println(sb);
	}
}