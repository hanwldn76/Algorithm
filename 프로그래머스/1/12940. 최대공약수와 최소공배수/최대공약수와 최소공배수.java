class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a = n;
        int b = m;
        int c;
        while(a%b!=0) {
        	c = a % b;
        	a = b;
        	b = c;
        }
        answer[0] = b;
        answer[1] = n*m/answer[0];
        return answer;
    }
}