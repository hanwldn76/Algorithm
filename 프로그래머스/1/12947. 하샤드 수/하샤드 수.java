class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int y = x;
        while(x>0) {
        	sum += x%10;
        	x /= 10;
        }
        answer = y%sum==0?true:false;
        return answer;
    }
}