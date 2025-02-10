import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Stack<int []> s = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			int tmp= Integer.parseInt(st.nextToken());
			
			while(!s.isEmpty()) {
				if(tmp>s.peek()[1]) {
					s.pop();
				}else {
					sb.append(s.peek()[0]+" ");
					break;
				}
			}
			
			if(s.isEmpty()) {
				sb.append("0 ");
			}
			s.push(new int[] {i, tmp});
		}
		
		System.out.println(sb);
	}

}
