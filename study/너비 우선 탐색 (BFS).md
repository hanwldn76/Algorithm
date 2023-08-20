### 너비 우선 탐색 (BFS)

- 시작점에서 가까운 것 위주 탐색
- 방문한 노드를 차ㄹ로 저장한 후 꺼낼 수 있는 큐 이용
- 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법 사용
- 노드 방문 여부 검사(무한루프 방지)
- FIFO 원칙으로 탐색

<br>

**코드**

```
import java.util.*;

public class BFS {
    static List<Integer>[] connections;
    static boolean [] visited;

    static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.print(x + " ");
            for(int i : connections[x]){
                if(visited[i] == false){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
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
        bfs(v);
    }
}

```
