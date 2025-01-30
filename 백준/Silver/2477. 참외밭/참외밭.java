import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        int [][] info = new int[6][6];

        int outH = 0, outHIdx = -1;
        int outW = 0, outWIdx = -1;
        for(int i = 0; i<6; i++){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken()); // 방향
            info[i][1] = Integer.parseInt(st.nextToken()); // 길이

            if((info[i][0] == 1 || info[i][0] == 2) && outH < info[i][1]){
                outH = info[i][1];
                outHIdx = i;
            }
            if((info[i][0] == 3 || info[i][0] == 4) && outW < info[i][1]){
                outW = info[i][1];
                outWIdx = i;
            }
        }

        int inH = info[(outHIdx+3)%6][1];
        int inW = info[(outWIdx+3)%6][1];
        int res = (outH*outW) - (inH*inW);

        System.out.println(res*k);

        br.close();
    }
}