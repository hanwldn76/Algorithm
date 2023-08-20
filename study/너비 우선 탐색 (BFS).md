### 너비 우선 탐색 (BFS)

- 시작점에서 가까운 것 위주 탐색
- 방문한 노드를 차ㄹ로 저장한 후 꺼낼 수 있는 큐 이용
- 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법 사용
- 노드 방문 여부 검사(무한루프 방지)
- FIFO 원칙으로 탐색

<br>

**수행 과정**

1. 시작 노드를 큐에 삽입하고 방문처리 한다.
2. 큐에서 하나의 노드를 꺼낸다.
3. 해당 노드에 연결된 노드 중 방문하지 않은 노드를 방문하고, 차례로 큐에 삽입한다.
4. 2~3번 과정을 더 이상 수행할 수 없을 때까지 반복한다.

<br>

**수행 과정 그림**

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/cffc55ea-48d2-4d6a-a450-824708dc3a7e)

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/50c7f034-3844-482c-9444-ffeb7398e313)

큐에 1을 삽입.

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/126803d8-4e59-4e6e-bd42-998e7ef3345b)

큐에서 1을 꺼냄.

1에 연결된 노드 중 방문하지 않은 노드인 2와 3을 차례로 큐에 삽입함.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/d1c54294-f1f3-4766-bfc6-c7957300723e)

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/97da7ab1-dfcf-4c8e-806f-0070fee01787)

큐에서 2를 꺼냄.

2에 연결된 노드 중 방문하지 않은 노드인 4와 5를 차례로 큐에 삽입함.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/bc0be990-66ac-41c6-ab8e-99337dddd1da)

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/63a51706-5b39-4d96-ac1f-0ea22263af3b)

큐에서 3을 꺼냄.

3에 연결된 노드 중 방문하지 않은 노드인 6과 7을 차례로 큐에 삽입함.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/a30188f3-4acf-4eb8-ae1a-ce3c99328c0a)

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/63a51706-5b39-4d96-ac1f-0ea22263af3b)
방문하지 않은 노드가 없으므로 큐에서 순차적으로 노드를 꺼냄.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/833d4398-6a99-4bbb-bf88-3650736f7165)

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
