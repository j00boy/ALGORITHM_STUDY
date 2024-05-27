package swea_1251_하나로_크루스칼구현;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution2 {

    static int N;
    static double E;
    static int[] p;
    static double answer;

    static class Bridge implements Comparable<Bridge> {
        int x;
        int y;
        double cost;

        public Bridge(int x, int y, double cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bridge brid) {
            return Double.compare(this.cost, brid.cost);
        }
    }

    static List<Bridge> list;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/swea_1251_하나로_크루스칼구현/input.txt"));
        // Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        // test case 시작
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            p = new int[N + 1];
            answer = 0.0;    // 정답도 매번 초기화

            list = new ArrayList<Bridge>(); // 매번 초기화

            int[] island_x = new int[N + 1];
            int[] island_y = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                p[i] = i;
                island_x[i] = sc.nextInt();
            }

            // y 좌표 저장
            for (int i = 1; i <= N; i++) {
                island_y[i] = sc.nextInt();
            }

            E = sc.nextDouble();

            // 섬끼리 잇는 노선 list 업데이트
            for (int i = 1; i < N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    double distance = Math.pow(island_x[i] - island_x[j], 2) + Math.pow(island_y[i] - island_y[j], 2);
                    list.add(new Bridge(i, j, distance));
                }
            }

            // cost 기준 오름차순 정렬
            Collections.sort(list);

            int edgesAdded = 0;
            for (Bridge b : list) {
                int px = findSet(b.x);
                int py = findSet(b.y);

                if (px != py) {
                    union(px, py);
                    answer += b.cost;
                    edgesAdded++;
                }

                if (edgesAdded == N - 1) {
                    break;
                }
            }

            System.out.println("#" + tc + " " + Math.round(answer));
        }
        // test case 끝
    }

    static int findSet(int n) {
        if (n != p[n]) {
            p[n] = findSet(p[n]);
        }
        return p[n];
    }

    static void union(int a, int b) {
        p[b] = a;
    }
}
