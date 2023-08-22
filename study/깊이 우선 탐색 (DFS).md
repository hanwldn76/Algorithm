### 깊이 우선 탐색(DFS)

- 깊은 것을 우선적으로 탐
- 스택 이용

<br>

**수행 과정**

1. 시작 노드를 스택에 삽입하며 시작하고, 그와 동시에 시작 노드를 **방문 처리** 한다.
2. 스택의 최상단 노드를 확인하여, 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 노드를 스택에 넣고 방문처리 한다. 이때, 방문하지 않은 인접 노드가 없을 경우 스택에서 최상단 노드를 뺀다.
3. 1~2번 과정을 더 이상 수행할 수 없을 때까지 반복한다.

<br>

**수행 과정 그림**

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/c83f5087-e188-4115-8bbc-baf59733d4f4)

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/641b8558-b11e-48cb-b226-4368ca387c6d)

시작 노드 1을 스택에 삽입하고 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/fb332fc2-8719-4f7e-8278-9b3b0fe1affd)

스택의 최상단 노드 1에 방문하지 않은 인접 노드 2, 3 중에서 가장 작은 노드 2를 스택에 삽입하고, 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/5c4cfa35-bad4-4dd6-b454-5b5dd6127a90)

스택의 최상단 노드 2에 방문하지 않은 인접 노드 3을 스택에 삽입하고 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/f9425eee-66c5-4cbd-b147-a452cce5414a)

스택의 최상단 노드 3에 방문하지 않은 인접 노드 6, 8 중에서 작은 노드인 6을 스택에 삽입하고, 방문 처리

-----

![image](https://github.com/hanwldn76/Algorithm/assets/138774991/0480d4ab-3030-4710-8374-e2a61e096ff5)



**코드**
