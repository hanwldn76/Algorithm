import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		hanoi(1, 3, N);
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	static void hanoi(int a, int b, int n) {
		if(n==1) {
			cnt++;
			sb.append(a+" ").append(b+"\n");
			return;
		}
		
		hanoi(a, 6-a-b, n-1);
		cnt++;
		sb.append(a+" ").append(b+"\n");
		hanoi(6-a-b, b, n-1);
	}
}