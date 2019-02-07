class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int lostSize = lost.length;
        int rsvSize = reserve.length;
        int result = n - lostSize;
        int tmpIndex = 0;

        for(int i = 0; i < lostSize; i ++) {
            int lostValue = lost[i];
            for(int j = 0; j < rsvSize; j++) {
                int rsvValue = reserve[j];
                if(lostValue > 0 && rsvValue > 0 && lostValue == rsvValue) {
                    reserve[j] = -1;
                    lost[i] = -1;
                    result++;
                    break;
                }
            }
        }

        for(int rsvIdx = 0; rsvIdx < rsvSize; rsvIdx++) {
            int rsvValue = reserve[rsvIdx];

            if(rsvValue == -1) {
                continue;
            }

            for(int lostIdx = tmpIndex; lostIdx <lostSize; lostIdx++) {
                int lostValue = lost[lostIdx];

                if(lostValue == -1) {
                    continue;
                }

                if(lostValue == rsvValue - 1|| lostValue == rsvValue +1) {
                    result++;
                    tmpIndex++;
                    break;

                }
            }
        }
        return result;
    }
}