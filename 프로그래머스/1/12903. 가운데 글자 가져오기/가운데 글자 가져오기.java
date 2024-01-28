class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length()/2;
        answer += s.length()%2==0?s.substring(len-1,len+1):s.charAt(len);
        return answer;
    }
}