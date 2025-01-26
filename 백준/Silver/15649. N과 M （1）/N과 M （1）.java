import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean [] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        f(0);

        br.close();
        bw.close();
    }

    static void f(int cnt) throws IOException {
        if(cnt == m){
            for(int l : list){
                bw.write(l + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(i+1);
                f(cnt+1);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}