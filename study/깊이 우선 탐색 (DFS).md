### 깊이 우선 탐색(DFS)

- 깊은 것을 우선적으로 탐색
- 스택 이용

<br>

**수행 과정**

1. 시작 노드를 스택에 삽입하며 시작하고, 그와 동시에 시작 노드를 **방문 처리** 한다.
2. 스택의 최상단 노드를 확인하여, 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 노드를 스택에 넣고 방문처리 한다. 이때, 방문하지 않은 인접 노드가 없을 경우 스택에서 최상단 노드를 뺀다.
3. 1~2번 과정을 더 이상 수행할 수 없을 때까지 반복한다.

<br>

**수행 과정 그림**

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/573fadc7-091b-4336-8fb9-76eb9205384d)

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/9e9a0f0e-9a06-4ef0-97ae-a2dcd33d754b)

시작 노드 1을 스택에 삽입하고, 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/cfb90a4c-5875-40d5-bf12-3a0217b0f20f)

스택의 최상단 노드 1에 방문하지 않은 인접 노드 2, 3 중에서 가장 작은 노드 2를 스택에 삽입하고, 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/9520fa79-16de-4e9a-8e9d-3fc6782f3d8c)

스택의 최상단 노드 2에 방문하지 않은 인접 노드 3, 4 중에서 가장 작은 노드 3을 스택에 삽입하고, 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/f903bfc9-4e3d-4627-a190-f74562aa80b4)

스택의 최상단 노드 3에 방문하지 않은 인접 노드 6, 8 중에서 작은 노드인 6을 스택에 삽입하고, 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/8f89478f-c027-41bb-acdf-ec4bf6b25243)

스택의 최상단 노드 6에 방문하지 않은 인접 노드 7을 스택에 삽입하고, 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/59984f88-502d-40a5-a83c-d44416c6b051)

스택의 최상단 노드 7에 방문하지 않은 인접 노드가 없으므로, 스택에서 7을 꺼냄

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/04157187-de23-44d8-a0c1-da1610807ada)

스택의 최상단 노드 6에 방문하지 않은 인접 노드가 없으므로, 스택에서 6을 꺼냄

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/329ce0ee-7bc9-4be9-89d2-0282a055b399)

스택의 최상단 노드 3에 방문하지 않은 인접 노드가 없으므로, 스택에서 3을 꺼냄

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/5d89b98d-bb89-414d-a044-4dcb5392338d)

스택의 최상단 노드 2에 방문하지 않은 인접 노드 4, 5 중에서 작은 노드인 4를 스택에 삽입하고, 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/1641b42b-aebe-4177-b3bf-1c13f5d5bd3b)

스택의 최상단 노드 4에 방문하지 않은 인접 노드 5 스택에 삽입하고, 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/4b374516-2f06-4458-8b5f-83fb30e60fa0)

스택의 최상단 노드 5에 방문하지 않은 인접 노드가 없으므로, 스택에서 5를 꺼냄

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/fe0e89c2-698c-4d9b-ab21-330e7044267b)

스택의 최상단 노드 4에 방문하지 않은 인접 노드가 없으므로, 스택에서 4를 꺼냄

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/b85683bc-eabe-4e8b-b047-5466b1451700)

스택의 최상단 노드 2에 방문하지 않은 인접 노드가 없으므로, 스택에서 2를 꺼냄

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/ba731663-9a70-4e9a-89a3-e406f9f72d75)

스택의 최상단 노드 1에 방문하지 않은 인접 노드가 없으므로, 스택에서 1 꺼냄

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/510aa46b-62cf-4858-b005-7b04c1de70ff)

노드의 탐색 순서(=스택에 들어간 순서)는 위와 같다.

<br>

**코드**

```
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
```

<br>
<br>

**입력**

<img width="59" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/924189fc-1284-4387-be82-a9020c28b264">

<br>
<br>

**출력**

<img width="455" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/0f050478-bf0e-4767-8b07-172d093f201b">

