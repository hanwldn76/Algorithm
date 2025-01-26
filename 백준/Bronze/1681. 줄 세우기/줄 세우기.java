import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = st.nextToken();

        int num = 0;
        int cnt = 0;

        while(cnt<n){
            num++;
            if(!String.valueOf(num).contains(l)){
                cnt++;
            }
        }
        System.out.println(num);

        br.close();
    }
}