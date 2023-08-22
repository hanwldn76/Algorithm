### 너비 우선 탐색 (BFS)

- 시작점에서 가까운 것 위주 탐색
- 방문한 노드를 차례로 저장한 후 꺼낼 수 있는 큐 이용
- 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법 사용
- 노드 방문 여부 검사(무한루프 방지)
- FIFO 원칙으로 탐색
- 큐 이용

<br>

**수행 과정**

1. 시작 노드를 큐에 삽입하고 방문처리 한다.
2. 큐에서 하나의 노드를 꺼낸다.
3. 해당 노드에 연결된 노드 중 방문하지 않은 노드를 방문하고, 차례로 큐에 삽입한다.
4. 2~3번 과정을 더 이상 수행할 수 없을 때까지 반복한다.

<br>

**수행 과정 그림**

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/b3f9cee0-7f04-4275-8260-8881e7ceaa3d)

-----

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/1e6ea757-7c6a-49da-84ac-1b7ef2293682)

큐에 1을 삽입.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/aea46d18-30f2-4ac1-adec-24b8add56931)

-----

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/cfd4f23e-1405-40f0-8d25-2b7b309cb18e)

큐에서 1을 꺼냄.

1에 연결된 노드 중 방문하지 않은 노드인 2와 3을 차례로 큐에 삽입함.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/163b8d9d-9e1e-4e00-907e-1eb339bf6ae7)

-----

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/fb3c346a-1dbd-4608-aa19-06dd4b4f15b1)

큐에서 2를 꺼냄.

2에 연결된 노드 중 방문하지 않은 노드인 4와 5를 차례로 큐에 삽입함.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/a93e2f88-0784-4d28-a8ac-48589b1f3d77)

-----

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/12b2fb68-e554-4a1b-9e54-e8c2ba200464)

큐에서 3을 꺼냄.

3에 연결된 노드 중 방문하지 않은 노드인 6과 7을 차례로 큐에 삽입함.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/ac2cc5d3-1059-4900-a72d-b77381957bc8)

-----

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/3c98e519-5e68-4b64-ae7f-529db07a43bd)

방문하지 않은 노드가 없으므로 큐에서 순차적으로 노드를 꺼냄.

<br>

<br>

**코드**

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/a0089db1-3850-4da8-b9c4-2b79ed4781c8)

<br>

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

<br>

**입력**

<img width="55" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/9d29eb6b-96ae-4597-8af5-490ea0331930">

<br>

<br>

**출력**

<img width="461" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/4e03a6da-b470-4868-89db-951dc77f90c6">
