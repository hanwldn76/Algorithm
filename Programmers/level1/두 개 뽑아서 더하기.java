import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new TreeSet<Integer>();

        for(int i = 0; i< numbers.length; i++){
            for(int j = 1; j< numbers.length; j++){
                if(i==j) continue;
                set.add(numbers[i]+numbers[j]);
            }
        }

        Integer[] arr = set.toArray(new Integer[0]);
        answer = new int [set.size()];

        for(int i = 0; i<set.size(); i++){
            answer[i] = arr[i];
        }

        return answer;
    }
}