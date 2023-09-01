### 크루스칼 알고리즘 (Kruskal Algorithm)

- 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘
- 최소 비용 신장 트리를 만들기 위한 대표적 알고리즘
- 단순하게 노드를 연결해서 모든 노드가 다 하나로 연결이 되도록 만드는데 가장 적은 비용을 사용함
  <br>
  ex) 여러 개의 도시가 있을때 각 도시를 도로를 이용해 연결하고, 비용을 최소한으로 하고자 할때 적용되는 알고리즘

-----

### **(들어가기 전에)**

- 노드 = 정점 = 도시 : 그래프에서 동그라미에 해당하는 부분
- 간선 = 거리 = 비용 : 그래프에서 선에 해당하는 부분
- 즉 아래의 그래프의 노드는 7개, 간선은 11개

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/04adb76b-2367-4184-a6c5-0f8c1ad88097)

<br>

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/a7185d5c-c565-417b-aa47-bbc8bd9e2c12)

**신장 트리(Spanning Tree)란?**

- 위의 그림 그래프에서 아래 그래프 모두 신장 트리(3개 말고 더 있을 수 있음)
- 그래프의 모든 정점을 포함하는 트리
- 그래프의 최소 연결 부분 그래프로 사이클이 없음
- 정점의 개수 n개면 간선의 개수 n-1개 가짐
- 하나의 그래프에 많은 신장 트리 존재

<br>

<br>

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/c4c562f0-f3e3-4907-a550-a362e4c345af)

**최소 신장 트리(Minimum Spanning Tree)란?**

- 가운데 신장 트리는 신장 트리 중 가중치 합이 가장 최소
- 신장 트리 중 간선의 가중치 합이 최소인 트리(= 가장 적은 비용으로 모든 노드를 연결)

-----

**모든 노드를 하나로 연결하는데 가장 적은 비용을 들여서 연결하는 방법? (최소 신장 트리 알고리즘)**

-> **크루스칼 알고리즘**, 프림 알고리즘

<br>

**크루스칼 알고리즘 핵심 개념**

- 간선을 거리가 짧은 순서대로 그래프에 포함
- 단 최소 비용 신장 트리를 만들때 사이클이 형성되면x

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/5d464bdc-a602-4c49-8843-ee2f0fd3ae72)

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/e39b11e7-efb2-477a-b387-40d02dc4a373)

- 위처럼 모든 간선들을 **거리(비용)** 을 기준으로 먼저 오름차순 정렬을 수행함.
- 다음 알고리즘에 맞게 그래프를 연결하면 최소 비용 신장 트리가 만들어짐.
  <br>
  1. 정렬된 순서에 맞게 그래프에 포함.
  2. 포함시키기 전에 **사이클 테이블**을 확인함.
  3. 사이클을 형성하는 경우 간선을 포함하지 않음.

<br>

**과정**

Union-Find 알고리즘을 사용해서 사이클 여부 확인
> Union -> 연결
> Find -> 사이클 발생 여부 확임

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/ad1ad57a-ec07-48ec-a13f-dbffc7805da6)

<br>

첫 번째 간선 선택

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/0988e57d-b748-460d-b36a-88b401e11d74)

-----

두 번째 간선 선택

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/8ec495a7-f3e2-4f1e-85b7-0e2dd89e875c)

-----

세 번째 간선 선택

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/f2ec10b2-1e9b-4e1a-bdcd-b7f253eee364)

-----

네 번째 간선 선택

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/ba48bbac-699b-4da9-9d99-183c7a4ac8fb)

-----

다섯 번째 간선 선택

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/75ea9a58-f803-4792-8b0a-fda96360d190)

-----

이미 1과 4가 연결되어 있으므로(=사이클 테이블의 값이 동일) 무시하고 넘어감.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/586bc266-5c76-4cbd-8707-8873a82ff162)

-----

여섯 번째 간선 선택

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/c385de61-5dd7-46bd-b864-54bd0a3495d2)

-----

사이클 테이블의 모든 값이 1이 되면서 최소 비용 신장 트리 만들어짐.

나머지 남은 간선 4개는 무시하고 넘어감.

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/79585f01-ad8f-4dd4-a5c3-8c3647b1052a)

<br>

**코드**

```
import java.util.*;

public class Kruskal {
    // 부모노드를 찾는 함수(특정한 노드의 부모를 찾을 수 있도록 함)
    static int getParent(int parent[], int x){
        if(parent[x]==x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    // 각 부모 노드를 합침
    static void unionParent(int parent[], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    // 같은 부모를 가지는지 확인
    static boolean findParent(int parent[], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a==b) return true;
        return false;
    }

    static void kruskal(int[][] graph, int[] parent){
        int final_cost = 0;
        for(int i = 0; i<graph.length; i++){
            // 사이클이 발생하지 않는 경우 그래프에 포함
            if(!findParent(parent, graph[i][0] - 1, graph[i][1] - 1)){
                final_cost += graph[i][2];
                unionParent(parent, graph[i][0] - 1, graph[i][1] - 1);
            }
        }

        System.out.println(final_cost);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // n : 정점 개수, m : 간선 개수
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] graph = new int[m][3];
        for (int i = 0; i < m; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
            graph[i][2] = sc.nextInt();
        }

        // 간선의 비용을 기준으로 오름차순 정렬
        // o1[2] - o2[2] 세번째 숫자 기준 오름차순
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        // 각 정점이 포함된 그래프가 어디인지 저장
        int [] parent = new int [n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        kruskal(graph, parent);
    }
}
```

<br>

**입력 & 출력1**

<img width="51" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/bbb4dafa-d9e0-4711-8356-7b12ad6b60d3">

<br>

**입력 & 출력2**

<img width="55" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/35ce4906-8c9e-4562-bb47-7497363f8dc8">

