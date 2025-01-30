import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        boolean [][] visited = new boolean[r][c];

        if(c*r < k){
            System.out.println("0");
            return;
        }

        // 아래 : 0, 오른쪽 : 1, 위 : 2, 왼쪽 : 3
        int [] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};

        int state = 0;
        int x = 0, y = 0;

        for(int i = 0; i<k-1; i++){
            visited[y][x] = true;

            int nextX = x + dx[state];
            int nextY = y + dy[state];

            if(nextX < 0 || nextX >= c || nextY < 0 || nextY >= r || visited[nextY][nextX]){
                state = (state+1)%4;
                nextX = x + dx[state];
                nextY = y + dy[state];
            }

            x = nextX;
            y = nextY;
        }

        System.out.println((x+1)+" "+(y+1));

        br.close();
    }
}