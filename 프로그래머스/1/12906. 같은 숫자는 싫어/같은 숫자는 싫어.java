import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        List<Integer> list = new ArrayList<Integer>();

        int i = 0;
        while(true) {
        	int j = i+1;
        	
        	if(j>=arr.length) {
        		list.add(arr[i]);
        		break;
        	}
        	
        	while(arr[i]==arr[j]) {
        		j++;
        		if(j>=arr.length) break;
        	}
        	list.add(arr[i]);
        	i = j;
        	if(i>=arr.length) break;
        }
        
        answer = new int[list.size()];
        
        for(int k = 0; k<list.size(); k++) {
        	answer[k] = list.get(k);
        }
        	
        return answer;
    }
}