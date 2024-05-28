package prog_조이스틱;

import java.util.*;

class Solution {
    
    public int solution(String name) {
        
        int answer = 0;
        
        int leng = name.length();
        
        if(leng == 1) {
            if(name.charAt(0) - 'A' <= 'Z' - name.charAt(0) + 1) {
                answer += name.charAt(0) - 'A';
            } else {
                answer += 'Z' - name.charAt(0) + 1;
            }
            
            return answer;
        } else {
            // 먼저 문자부터 바꾸고
            int start = 0;
            int end = 0;
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < leng; i++) {
                if(name.charAt(i) != 'A') {
                    list.add(i);
                    end = i;
                    
                    if(name.charAt(i) - 'A' <= 'Z' - name.charAt(i) + 1) {
                        answer += name.charAt(i) - 'A';
                    } else {
                        answer += 'Z' - name.charAt(i) + 1;
                    }
                }
            }
            
            // 이동방법
            int min = end;  // 처음부터 끝까지 가는거를 최소의 기준으로 둠
            
            // -> , <- , 끝에서 <-
            for(int i = 0; i < list.size() - 1; i++) {
                int begin = list.get(i);
                
                if(begin + begin + name.length() - list.get(i+1) < min) {
                    min = begin + begin + name.length() - list.get(i+1);
                }
            }
            
            // 끝에서 <- , 다시 ->해서 0으로 , 나머지 ->
            for(int i = list.size() - 1; i >= 1; i--) {
                int begin = name.length() - list.get(i);
                
                if(begin + begin + list.get(i-1) < min) {
                    min = begin + begin + list.get(i-1);
                }
            }
            
            System.out.println(min);
            
            answer += min;
            
            return answer;
        }
    }
}