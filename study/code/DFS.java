import java.util.*;

public class DFS {
    static List<Integer>[] connections;
    static boolean [] visited;

    static void dfs(int v){
        visited[v] = true;

        System.out.print(v + " ");

        for(int i : connections[v]){
            if(!visited[i])
                dfs(i);
        }
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 탐색을 시작할 정점의 번호

        connections = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i<=n; i++){
            connections[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            connections[x].add(y);
            connections[y].add(x);
        }

        System.out.println("그래프");
        System.out.println(Arrays.toString(connections));
        dfs(v);
    }
}
