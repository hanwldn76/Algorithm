import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] DP;
    
	// dp 배열의 역추적 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		DP = new int[N+2];
		
		DP[1] = 0;
		DP[2] = 1;
		
		for(int i = 3; i<=N; i++) {
			DP[i] = DP[i-1] + 1;
			if(i%2==0) DP[i] = Math.min(DP[i], DP[i/2] +1);
			if(i%3==0) DP[i] = Math.min(DP[i], DP[i/3] +1);
		}
		
		StringBuilder sb = new StringBuilder();
		
        // dp배열을 역추적하여 경로 찾음.
        int start = N;

        while(start > 1) {
            sb.append(start + " ");

            if ((start % 3 == 0) && (DP[start / 3] == DP[start] - 1)) {
                start /= 3;
            } else if((start % 2 == 0) && (DP[start/2] == DP[start] - 1)) {
                start /= 2;
            } else if(DP[start - 1] == (DP[start] - 1)) {
                start -= 1;
            }
        }
        sb.append(1);
		
		System.out.println(DP[N]);
		System.out.println(sb);
	}

}