class Solution {
    public int solution(String name) {
        int len = name.length();

        int answer = 0; // 알파벳 조이스틱
        for (int i = 0; i < len; i++) {
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff, 26 - diff);
        }

        int move = len - 1;  // 위치 조이스틱
        for (int i = 0; i < len; i++) {
            int next = i + 1;

            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, 2 * i + (len - next));
            move = Math.min(move, i + 2 * (len - next));
        }

        return answer + move;
    }
}