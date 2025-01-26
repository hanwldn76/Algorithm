import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        f(0, 0);

        br.close();
        bw.close();
    }

    static void f(int cnt, int idx) throws IOException {
        if(cnt == m){
            for(int l : list){
                bw.write(l + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = idx; i<n; i++){
            list.add(i+1);
            f(cnt+1, i);
            list.remove(list.size()-1);
        }
    }
}