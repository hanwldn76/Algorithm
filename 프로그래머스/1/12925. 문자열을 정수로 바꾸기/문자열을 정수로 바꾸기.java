class Solution {
    public int solution(String s) {
        int answer = 0;
        answer = s.charAt(0)=='-'?-1*Integer.valueOf(s.substring(1, s.length())):Integer.valueOf(s);
        return answer;
    }
}