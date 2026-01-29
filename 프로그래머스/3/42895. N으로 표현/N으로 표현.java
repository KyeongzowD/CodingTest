import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>()); // 0번 인덱스

        for (int k = 1; k <= 8; k++) {
            Set<Integer> cur = new HashSet<>();

            int concat = 0;
            for (int i = 0; i < k; i++) concat = concat * 10 + N;
            cur.add(concat);

            for (int i = 1; i < k; i++) {
                Set<Integer> A = dp.get(i);
                Set<Integer> B = dp.get(k - i);

                for (int a : A) {
                    for (int b : B) {
                        cur.add(a + b);
                        cur.add(a - b);
                        cur.add(a * b);
                        if (b != 0) cur.add(a / b);
                    }
                }
            }

            if (cur.contains(number)) return k;

            dp.add(cur);
        }
        return -1;
    }
}
