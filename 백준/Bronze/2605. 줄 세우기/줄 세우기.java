import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int index;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            index = Integer.parseInt(st.nextToken());
            list.add(index, i+1);
        }

        for(int i = n-1; i>=0; i--){
            bw.write(list.get(i)+" ");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}