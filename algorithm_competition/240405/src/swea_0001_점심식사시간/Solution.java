package swea_0001_점심식사시간;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
     
    static ArrayList<Integer> group1; // 1번 계단
    static ArrayList<Integer> group2; // 2번 계단
    static int limit1;  // 1번 계단 limit
    static int limit2;  // 2번 계단 limit
     
    static int N;
    static int[][] room;
    static ArrayList<int[]> stairs;
    static ArrayList<int[]> people;
    static int minTime;
    static int time;
    static boolean[] sel;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        // test case
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            room = new int[N][N];
            stairs = new ArrayList<>();
            people = new ArrayList<>();
            minTime = Integer.MAX_VALUE;
             
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    room[r][c] = sc.nextInt();
                    if(room[r][c] >= 2) {
                        stairs.add(new int[] {r, c});
                    } else if(room[r][c] == 1) {
                        people.add(new int[] {r, c});
                    }
                }
            }
             
            sel = new boolean[people.size()];
             
            divide(0);
             
            System.out.printf("#%d %d\n", tc, minTime);
        }
        // test case
    }
     
    // 그룹 이분 ( 조합 )
    public static void divide(int idx) {
        if(idx >= sel.length) {
            group1 = new ArrayList<>();
            group2 = new ArrayList<>();
             
            for(int i = 0; i < sel.length; i++) {
                if(sel[i]) {
                    group1.add(i);
                } else {
                    group2.add(i);
                }
            }
             
            // 각 그룹에 대한 시간 계산
            getTime();
            return;     // 종료
             
        }
         
        sel[idx] = false;
        divide(idx + 1);
        sel[idx] = true;
        divide(idx + 1);
         
    }
     
    public static void getTime() {
        int[] time1 = new int[group1.size()];
        int[] time2 = new int[group2.size()];
        int limit1 = 3;
        int limit2 = 3;
        int cnt = 0;
         
        int time = 0;
         
        for(int i = 0; i < time1.length; i++) {
            time1[i] = Math.abs(people.get(group1.get(i))[0] - stairs.get(0)[0]) + Math.abs(people.get(group1.get(i))[1] - stairs.get(0)[1]);
        }
         
        for(int i = 0; i < time2.length; i++) {
            time2[i] = Math.abs(people.get(group2.get(i))[0] - stairs.get(1)[0]) + Math.abs(people.get(group2.get(i))[1] - stairs.get(1)[1]);
        }
         
        Arrays.sort(time1);
        Arrays.sort(time2);
         
        while(true) {

            // 1그룹
            for(int i = 0; i < time1.length; i++) {
                if(time1[i] < -room[stairs.get(0)[0]][stairs.get(0)[1]] - 1) {
                    continue;
                }
                 
                if(time1[i] == -room[stairs.get(0)[0]][stairs.get(0)[1]] - 1) {
                    cnt++;
                    time1[i]--;
                    limit1++;
                } else if(time1[i] == -1) {
                    if(limit1 > 0) {
                        limit1--;
                        time1[i]--;
                    } else {
                        continue;
                    }
                } else {
                    time1[i]--;
                }
                 
                if(cnt == people.size()) {
                    break;
                }
            }
             
            // 한 쪽이 더 늦게 끝날 경우를 대비해서 중간 체크
            if(cnt == people.size()) {
                break;
            }
            
            // 2그룹
            for(int i = 0; i < time2.length; i++) {
                if(time2[i] < -room[stairs.get(1)[0]][stairs.get(1)[1]] - 1) {
                    continue;
                }
                 
                if(time2[i] == -room[stairs.get(1)[0]][stairs.get(1)[1]] - 1) {
                    cnt++;
                    time2[i]--;
                    limit2++;
                } else if(time2[i] == -1) {
                    if(limit2 > 0) {
                        limit2--;
                        time2[i]--;
                    } else {
                        time2[i] = -1;
                    }
                } else {
                    time2[i]--;
                }
                 
            }
            
            // 2그룹이 더 늦게 끝나는 경우 대비
            if(cnt == people.size()) {
                break;
            }
            
            time++;
        }
         
        minTime = Math.min(time, minTime);
    }
     
}