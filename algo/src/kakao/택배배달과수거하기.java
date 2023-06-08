package src.kakao;

public class 택배배달과수거하기 {
    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            // 그리디 알고리즘
            long answer = 0;

            // 방문할 집 (가장 먼 곳)
            int current = n-1;

            int[] deliveries2 = deliveries.clone();
            int[] pickups2 = pickups.clone();
            while(current >= 0) {
                if(pickups2[current] == 0 && deliveries2[current] == 0){
                    current--;
                    continue;
                }
                answer += (current+1) * 2;
                // 배달
                int deliverBox = 0;
                for(int i = current; i >= 0 ; i--) {
                    if(deliveries2[i]+deliverBox > cap) {
                        deliveries2[i] -= cap - deliverBox;
                        break;
                    }
                    deliverBox += deliveries2[i];
                    deliveries2[i] = 0;
                }

                // 수거
                int pickBox = 0;
                for(int i = current; i >= 0 ; i--) {
                    if(pickups2[i]+pickBox > cap) {
                        pickups2[i] -= cap - pickBox;
                        break;
                    }
                    pickBox += pickups2[i];
                    pickups2[i] = 0;
                }

                if(pickups2[current] == 0 && deliveries2[current] == 0){
                    current--;
                }

            }

            return answer;
        }
    }
}
