package swea_0002_디저트카페;

import java.util.HashMap;
import java.util.Scanner;
 
public class Solution {
 
    static int N;
    static int[][] map;
    static int count;
    static int maxCnt;
    static boolean[][] visited;
    static HashMap<Integer, Integer> list;
    static int[] dr = { 1, 1, -1, -1 };     // 우하 좌하 좌상 우상
    static int[] dc = { 1, -1, -1, 1 };     // 우하 좌하 좌상 우상
    static int now_r;
    static int now_c;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        // test case
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            maxCnt = 0;
 
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = sc.nextInt();
                }
            }
 
            for (int r = 0; r < N; r++) {
                for (int c = 1; c < N - 1; c++) {
                    visited = new boolean[N][N];
                    now_r = r;
                    now_c = c;
                    count = 1;
                    list = new HashMap<>();
                    list.put(map[r][c], 1);
                    visited[r][c] = true;
                    DFS(r, c, 0, count);    // 여기가 꼭짓점인 최대 가능 디저트 종류를 찾음
                }
            }
             
            if (maxCnt == 0) {
                System.out.printf("#%d %d\n", tc, -1);
            } else {
                System.out.printf("#%d %d\n", tc, maxCnt);
            }
        }
        // test case
    }
 
    // 카페 찾기
    public static void DFS(int r, int c, int dir, int cnt) {
        for(int d = dir; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
             
            if(nr == now_r && nc == now_c && cnt >= 4) {
                maxCnt = Math.max(maxCnt, cnt);
                return;
            }
             
            if (check(nr, nc) && !list.containsKey(map[nr][nc]) && !visited[nr][nc]) {
                visited[nr][nc] = true;
                list.put(map[nr][nc], 1);   
                DFS(nr, nc, d, cnt + 1);
                visited[nr][nc] = false;    // 딴 방향으로 가는 것도 있기 때문에
                list.remove(map[nr][nc]);   // 딴 방향으로 가는 것도 있기 때문에
            }
        }
    }
 
    public static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}