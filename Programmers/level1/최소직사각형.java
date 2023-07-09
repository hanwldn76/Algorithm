class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int height = 0, length = 0;

        for(int [] array: sizes){
            length = Math.max(length, Math.max(array[0], array[1]));
            height = Math.max(height, Math.min(array[0], array[1]));
        }

        answer = length * height;

        return answer;
    }
}