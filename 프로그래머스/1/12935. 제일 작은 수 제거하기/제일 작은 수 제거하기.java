class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
		if(arr.length-1==0) {
			answer = new int[] {-1};
			return answer;
		}
		int min = arr[0];
        for(int i = 1; i<arr.length; i++) {
        	if(min>arr[i]) min = arr[i];
        }
        
		int j = 0;
		answer = new int[arr.length-1];
		
        for(int i = 0; i<arr.length; i++) {
        	if(arr[i]==min) continue;
        	if(j>=answer.length) break;
        	answer[j] = arr[i];
        	j++;
        }
        
        return answer;
    }
}