import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        f(0);

        for(String s : set){
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static private void f(int cnt) throws IOException {
        if(cnt == m){
            for(int l : list){
                sb.append(l).append(" ");
            }
            set.add(sb.toString().trim());
            sb.delete(0, sb.length());
            return;
        }
        else{
            for(int i = 0; i<n; i++){
                if(!visited[i]){
                    visited[i] = true;
                    list.add(arr[i]);
                    f(cnt+1);
                    visited[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }
    }
}