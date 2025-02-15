import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		BigInteger result = BigInteger.ONE.shiftLeft(N).subtract(BigInteger.ONE);
        System.out.println(result);
		
		if(N <= 20) {
			hanoi(1, 3, N);
			System.out.println(sb);
		}
	}
	
	static void hanoi(int a, int b, int n) {
		if(n==1) {
			sb.append(a+" ").append(b+"\n");
			return;
		}
		
		hanoi(a, 6-a-b, n-1);
		sb.append(a+" ").append(b+"\n");
		hanoi(6-a-b, b, n-1);
	}
}