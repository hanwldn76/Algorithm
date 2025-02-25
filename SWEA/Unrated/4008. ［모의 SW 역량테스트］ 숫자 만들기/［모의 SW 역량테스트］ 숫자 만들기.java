import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * [아이디어]
 * 숫자는 가만히 있고 연산자만 움직임 => 연산자에 대한 순열?
 * 연산자 N-1개 중 N-1개를 뽑아서 순열만듦
 * 
 */
public class Solution {

    static int N, max, min;
    static int[] num, operator; // num: 숫자 배열, operator: 연산자 개수 배열 {+, -, *, /}
//    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); 

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            num = new int[N];
            operator = new int[4]; // {+, -, *, /} 순서

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            dfs(1, num[0]);

            sb.append("#").append(test_case).append(" ").append(max - min).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int cnt, int sum) {
        if (cnt == N) { // 숫자를 다 사용했으면 최댓값, 최솟값 갱신
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
        	// visited안쓰고 연산자를 개수별로 사용하면서 백트래킹 하는식으로 해봄 
            if (operator[i] > 0) { // 사용 가능한 연산자라면
                operator[i]--; // 사용 처리
                int newSum = calc(sum, num[cnt], i);
                dfs(cnt + 1, newSum);
                operator[i]++;
            }
        }
    }

    static int calc(int a, int b, int op) {
        if (op == 0) return a + b; 
        if (op == 1) return a - b;
        if (op == 2) return a * b;
        if (op == 3) return a / b;
        return 0;
    }
}
