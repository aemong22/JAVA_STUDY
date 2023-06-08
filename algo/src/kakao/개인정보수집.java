package src.kakao;
import java.util.*;
public class 개인정보수집 {
    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {

            // 개인정보 n개 약관마다 유효기간이 정해져있음 유효기간이 지나면 반드시 파기하기.
            // 모든달은 28일까지 있다고 가정

            // today : yyyy.mm.dd 형태
            // terms : 약관종류 유효기간(m)
            // 출력 : 파기해야할 개인정보의 번호를 오름차순 출력
            // 특수문자는 앞에 \\ or []로 감싸주기
            String[] tTemp = today.split("[.]");
            int tYear = Integer.parseInt(tTemp[0]);
            int tMonth = Integer.parseInt(tTemp[1]);
            int tDay = Integer.parseInt(tTemp[2]);

            // terms 값들을 hashMap에 저장
            Map<String, Integer> term = new HashMap<>();
            for(String s : terms) {
                String[] temp = s.split(" ");
                term.put(temp[0], Integer.parseInt(temp[1]));
            }

            int count = 0;
            boolean[] find = new boolean[privacies.length+1];


            int num = 1;
            for(String s : privacies){
                String[] temp = s.split(" ");
                String[] temp2 = temp[0].split("[.]");

                // 파기 날짜
                int year = Integer.parseInt(temp2[0]);
                int month = Integer.parseInt(temp2[1]);
                int day = Integer.parseInt(temp2[2]);

                month = month + term.get(temp[1]);
                if(month > 12) {
                    int t = month / 12;
                    int tt = month % 12;
                    if(tt == 0) {
                        year += t-1;
                        month = 12;
                    }
                    else {
                        year += t;
                        month = tt;
                    }

                }

                if(year < tYear || (year == tYear && month < tMonth ) || (year == tYear && month == tMonth && day <= tDay )){
                    count+=1;
                    find[num] = true;
                }
                num++;
            }


            int[] answer = new int[count];
            int idx = 0;
            for(int i = 1; i <= privacies.length; i++){
                if(find[i]) {
                    answer[idx] = i;
                    idx++;
                }
            }
            return answer;
        }
    }
}
