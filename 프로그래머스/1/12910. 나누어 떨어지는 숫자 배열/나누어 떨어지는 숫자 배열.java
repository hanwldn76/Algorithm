import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<arr.length; i++) {
        	if(arr[i]%divisor==0) list.add(arr[i]);
        }
        
        if(list.size()==0) answer = new int[] {-1};
        else {
        	list.sort(null);
        	answer = new int[list.size()];
        	for(int i = 0; i<list.size(); i++) {
        		answer[i] = list.get(i);
        	}
        }
        return answer;
    }
}