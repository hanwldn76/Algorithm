import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        // 1: 북(위), 2: 남(아래), 3: 서(왼쪽), 4: 동(오른쪽)
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        map = new int[n];

        int dg = 0;

        for(int i = 0; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()), loc = Integer.parseInt(st.nextToken());
            int tmp = 0;

            switch (dir){
                case 1:
                    tmp = loc;
                    break;
                case 2:
                    tmp = x + y + x - loc;
                    break;
                case 3:
                    tmp = x + y + x + y - loc;
                    break;
                case 4:
                    tmp = x + loc;
                    break;
            }

            if(i < n){
                map[i] = tmp;
            }else{
                dg = tmp;
            }
        }
        int res = 0;
        for(int i = 0; i<n; i++){
            int path1 = Math.abs(map[i] - dg);
            int path2 = x + x + y + y -path1;
            res += Math.min(path1, path2);
        }

        System.out.println(res);

        br.close();
    }
}