import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        List<Integer> list = new ArrayList<Integer>();
        
        int j = 0;
        for(int i = 0; i<10; i++) {
        	if(numbers[j]!=i) list.add(i);
        	else {
        		j++;
        		if(j>=numbers.length) j--;
        	}
        }
        for(int i =0; i<list.size(); i++) answer += list.get(i);
        
        return answer;
    }
}