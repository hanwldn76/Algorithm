import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0);

        br.close();
        bw.close();
    }

    static void dfs(int cnt) throws IOException {
        // 종료 조건
        if(m == cnt) {
            for(int i = 0; i<cnt; i++) {
                bw.write(list.get(i)+" ");
            }
            bw.newLine();
            return;
        }else {
            for(int i = 1; i<=n; i++) {
                list.add(i);
                dfs(cnt+1);
                list.remove(list.size()-1);
            }
        }
    }
}