import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int map[][];
	static int[] tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine()); 
            int[] boxes = new int[N]; 

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            int maxDrop = 0;

            for(int i = 0; i<N; i++) {
            	int cnt = 0;
            	for(int j = i+1; j<N; j++) {
            		if(boxes[i]>boxes[j]) cnt++;
            	}
            	maxDrop = Math.max(maxDrop, cnt);
            }
            
            System.out.println("#" + test_case + " " + maxDrop);
        }
    }
}
