public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] ||
                    lost[i] - reserve[j] == 1 ||
                    lost[i] - reserve[j] == -1) {

                    reserve[j] = -1;
                    break;
                }

                if (j == reserve.length - 1) {
                    answer -= 1;
                }
            }
        }

        return answer;
    }
}