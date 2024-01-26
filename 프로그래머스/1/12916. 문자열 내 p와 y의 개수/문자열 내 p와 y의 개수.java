class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        
        String[] str = s.split("");
        int cnt = 0;
        
        for(int i = 0; i<str.length; i++) {
        	cnt += str[i].equals("p")?1:(str[i].equals("y")?-1:0);
        }
        
        answer = cnt==0?true:false;

        return answer;
    }
}