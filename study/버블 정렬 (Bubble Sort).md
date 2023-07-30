### 버블 정렬

>옆에 있는 값과 비교해서 더 작은 값을 앞으로 보내는 것

<br>

`*1* *10* 5 8 7 6 4 3 2 9`

`*1* *10* 5 8 7 6 4 3 2 9`

<br>

`1 *10* *5* 8 7 6 4 3 2 9`

`1 *5* *10* 8 7 6 4 3 2 9`

<br>

`1 5 *10* *8* 7 6 4 3 2 9`

`1 5 *8* *10* 7 6 4 3 2 9`

<br>

`1 5 8 *10* *7* 6 4 3 2 9`

`1 5 8 *7* *10* 6 4 3 2 9`

<br>

`1 5 8 7 *10* *6* 4 3 2 9`

`1 5 8 7 *6* *10* 4 3 2 9`

<br>

`1 5 8 7 6 *10* *4* 3 2 9`

`1 5 8 7 6 *4* *10* 3 2 9`

<br>

`1 5 8 7 6 4 *10* *3* 2 9`

`1 5 8 7 6 4 *3* *10* 2 9`

<br>

`1 5 8 7 6 4 3 *10* *2* 9`

`1 5 8 7 6 4 3 *2* *10* 9`

<br>

`1 5 8 7 6 4 3 2 *10* *9*`

`1 5 8 7 6 4 3 2 *9* *10*`

<br>

작은 값을 앞으로 보내면 가장 큰 값이 맨 뒤로 오게 됨

=> 뒤부터 정렬하여 뒤에서 부터 index 크기를 하나씩 감소

<br>

**ex)**

1번째 반복 index 0~9번 값을 비교하여 index 9번값을 정렬

2번째 반복 index 0~8번 값을 비교하여 index 8번값을 정렬

3번째 반복 index 0~7번 값을 비교하여 index 7번값을 정렬

...

<br>

**정렬 과정**

1. 앞에서부터 현재 원소와 바로 다음의 원소를 비교

2. 현재 원소가 다음 원소보다 크면 원소를 교환

3. 위 작업 반복

<br>

**코드**

```
package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int temp;
        int [] array = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(array));

        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<9-i; j++){
                if(array[j] >= array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.println("정렬 후");
        System.out.println(Arrays.toString(array));
    }
}
```

<img width="198" alt="image" src="https://github.com/hanwldn76/Algorithm/assets/138774991/915a04f9-0515-4ad6-b278-e453f42e667e">

<br>

**시간 복잡도**




