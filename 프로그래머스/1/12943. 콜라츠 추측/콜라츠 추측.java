class Solution {
    public int solution(int num) {
        long n = num;
        int answer = 0;
        int cnt = 0;
        
        for(int i=0; i<500; i++) {
        	if(n==1) break;
        	
        	if(n%2==0) n /= 2;
        	else n = (n*3) + 1;
        	cnt++;
        }
        answer = n!=1?-1:cnt;
        
        return answer;
    }
}