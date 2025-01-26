import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> list = new ArrayList<>();
    static int n, m;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean [n];

        dfs(0, 1);
    }

    static void dfs(int cnt, int idx) {
        // 종료 조건
        if(m == cnt) {
            for(int i = 0; i<list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }

            System.out.println();
            return;
        }else {
            for(int i = idx; i<=n; i++) {
                if(!visited[i-1]) {
                    visited[i-1] = true;
                    list.add(i);
                    dfs(cnt+1, i);
                    visited[i-1] = false;
                    list.remove(list.size()-1);
                }
            }
        }
    }
}