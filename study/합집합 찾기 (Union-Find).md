#### 합집합 찾기 (Union-Find)

- 대표적인 그래프 알고리즘
- 서로소 집합(Disjoint-set) 알고리즘이라고도 함. (== 서로 같은 집합이 아닌 걸 찾는 것)
- 여러 개의 노드가 존재할때 두 개의 노드를 선택해서 현재 이 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘

<br>

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/452a7fcc-e12b-4bf3-aeb7-58e3a627f25c)

- 모두 연결되어 있지x
- 각자 자기 자신만을 집합의 원소로 가지고 있음

<br>

위의 그래프를 아래의 배열로 표현

|1|2|3|4|5|6|7|8|
|-|-|-|-|-|-|-|-|
|1|2|3|4|5|6|7|8|

위는 노드의 번호를 의미, 아래는 부모노드의 번호를 의미

-> 전부 자기 자신을 부모로 가지고 있음.

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/175a6e62-862a-40e3-aeab-a9b7275dca3a)

1과 2가 연결됨.

-> 그렇다면 이러한 연결성을 컴퓨터상 즉, 프로그래밍 언어로 어떻게 표현할 수 있을까?

<br>

|1|2|3|4|5|6|7|8|
|-|-|-|-|-|-|-|-|
|1|**1**|3|4|5|6|7|8|

1과 2 중에서 더 작은 값을 부모로 가지도록 함. (부모를 합칠 때는 일반적으로 더 작은 값 쪽으로 합침)

-> Union(합침), 2번째 인덱스 값에 1이 들어갔음

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/c1a065b2-5416-40f9-bae3-b473b9220c75)

2와 3이 연결됨.

-> 그럼 1, 2, 3은 서로 연결되어 있는 그래프라고 할 수 있음

<br>

|1|2|3|4|5|6|7|8|
|-|-|-|-|-|-|-|-|
|1|1|**2**|4|5|6|7|8|

이전과 같이 2와 3 중에서 더 작은 값을 부모로 가지도록 함.

-> Union(합침), 3번째 인덱스 값에 2가 들어갔음

--> 그림을 보면 2와 3이 연결됨으로써 1과 3 또한 연결된 형태임. 하지만 1의 인덱스 값은 1, 3의 인덱스 값은 2로 서로 다름.

---> 1과 3이 연결되어있는지 파악하기 위해선 부모 노드만 보고 파악할 수 x, 때문에 **재귀 함수**를 사용

<br>

|1|2|3|4|5|6|7|8|
|-|-|-|-|-|-|-|-|
|1|1|**2**|4|5|6|7|8|

먼저 3과 2가 연결되었으니까 3번째 인덱스 값에 2를 넣어 줌.

그 다음 재귀함수를 사용해서 인덱스 2의 부모가 누군지 확인 함.(== 인덱스 2의 값이 뭔지 확인 함.)

<br>

**3의 부모를 찾는 과정**

1. 3이 가리키고 있는 2를 찾음.(3의 부모 2를 찾음.)
2. 2의 부모 1이 가리키고 있는 1을 찾음.
3. 3의 최종적인 부모는 1임을 알 수 있음.

<br>

|1|2|3|4|5|6|7|8|
|-|-|-|-|-|-|-|-|
|**1**|**1**|**1**|4|5|6|7|8|

결과적으로 Union(합침) 연산이 다 수 행되고 나면 위와 같이 배열이 만들어짐.

노드 1, 2, 3,의 부모가 모두 1이기 때문에 이 세가지 노드는 같은 그래프에 속함.

-----

Find 알고리즘은 두 개의 노드의 부모 노드를 확인하여 현재 같은 집합에 속하는지 확인해줌.

-----

<br>

**코드**

```
import java.util.*;

public class UnionFind {
    static int getParent(int parent[], int x){
        if(parent[x]==x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    static void unionParent(int parent[], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    static boolean findParent(int parent[], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a==b) return true;
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int [] parent = new int [11];
        for(int i = 1; i<=10; i++){
            parent[i] = i;
        }

        int n = sc.nextInt();

        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(parent, a, b);
        }

        /*
        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 3, 4);
        unionParent(parent, 5, 6);
        unionParent(parent, 6, 7);
        unionParent(parent, 7, 8);
         */

        System.out.println("1과 5는 연결되어 있나요? "+ (findParent(parent, 1, 5)?"예":"아니오"));
        unionParent(parent, 1, 5);
        System.out.println("1과 5는 연결되어 있나요? "+ (findParent(parent, 1, 5)?"예":"아니오"));
    }
}
```

<br>

**입력**

<img width="38" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/3f69f14a-a7ba-46b4-b009-a0a12169e629">

<br>

**출력1**

<img width="172" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/6f982e88-2309-472f-82a8-a0bb440ff50b">

<br>

<br>

```
        // 위 코드 동일

        System.out.println("1과 5는 연결되어 있나요? "+ (findParent(parent, 1, 5)?"예":"아니오"));
        unionParent(parent, 1, 6); // 1과 6을 연결해도 1과 5는 연결됨
        System.out.println("1과 5는 연결되어 있나요? "+ (findParent(parent, 1, 5)?"예":"아니오"));

```

<br>

**출력2**

<img width="172" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/c25caa7e-83ef-4e24-aebb-1c606b8fe69b">

