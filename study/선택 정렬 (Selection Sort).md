### 선택 정렬(Selection Sort)
>가장 작은 값을 선택해서 맨 앞으로 보내는 것

<br>

`*1* 10 5 8 7 6 4 3 2 9`

`*1* 10 5 8 7 6 4 3 2 9`

1은 10번(본인을 포함하여 비교)의 비교를 통해 최소값인 1과 위치를 바꿈

<br>

`1 *10* 5 8 7 6 4 3 2 9`

`1 *2* 5 8 7 6 4 3 10 9`

10은 9번의 비교를 통해 최소값인 2와 위치를 바꿈 

.
.
.

`1 2 3 4 5 6 7 8 *10* 9`

`1 2 3 4 5 6 7 8 *9* 10`

9는 2번의 비교를 통해 최소값인 9와 위치를 바꿈 

<br>

`1 2 3 4 5 6 7 8 9 *10*`

`1 2 3 4 5 6 7 8 9 *10*`

10는 1번의 비교(본인과 본인을 비교)를 통해 최소값인 10과 위치를 바꿈

<br>

**정렬 과정**

1. 주어진 리스트에서 최소값을 찾는다.

2. 최소값을 맨 앞 자리의 값과 교환한다.

3. 맨 앞 자리를 제외한 나머지 값들 중 최소값을 찾아 위와 같은 방법으로 반복한다. 

<br>

**코드**

```
package sort;

import java.util.*;

public class SelectionSort {
    public static void main(String[] args){
        int min, index = 0, temp;
        int [] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(array));

        for(int i = 0; i<array.length; i++){
            min = 9999;
            for(int j = i; j<array.length; j++){
                if(array[j] <= min){
                    min = array[j]; // min은 항상 최솟값이어야 함(처음 제외)
                    index = j;
                }
            }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        System.out.println("정렬 후");
        System.out.println(Arrays.toString(array));
    }
}
```

<img width="200" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/0762ff20-54ca-4ac9-9eee-c7b3a3c9857b">

<br>

<br>

**시간 복잡도**

- 배열의 크기가 n일때 => (n-1)*n/2

- 즉, 주어진 배열을 정렬하는데 O(n^2)의 시간이 걸림.

- 평균과 최악의 경우 O(n^2)로 동일.

- 데이터의 개수가 커지면, 아주 많은 연산을 처리해야 함.


