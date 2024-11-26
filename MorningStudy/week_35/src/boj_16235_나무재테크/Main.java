package boj_16235_나무재테크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Land {
        ArrayList<Tree> land = new ArrayList<>();
    }

    static class Tree implements Comparable<Tree> {
        int age;

        @Override
        public int compareTo(Tree tree) {
            return this.age - tree.age;
        }

        public Tree(int age) {
            this.age = age;
        }
    }

    static int N;   // 맵의 크기
    static int M;   // 나무의 수
    static int K;   // K년이 지난 후 살아남은 나무의 수

    static int[][] nutrients;
    static int[][] S2D2;
    static Land[][] trees;

    // 상 하 좌 우 좌상 우상 좌하 우하
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nutrients = new int[N + 1][N + 1];
        S2D2 = new int[N + 1][N + 1];
        trees = new Land[N + 1][N + 1];

        for (int r = 0; r <= N; r++) {
            for (int c = 0; c <= N; c++) {
                trees[r][c] = new Land();
                nutrients[r][c] = 5;    // 초기 = 5
            }
        }

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                S2D2[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            trees[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())].land
                    .add(new Tree(Integer.parseInt(st.nextToken())));
        }

        int count = M;
        while (K > 0) {
            /*
             * 봄
             * - 나무가 자신의 나이만큼 양분을 먹고, 나이가 1씩 증가한다.
             * - 나무가 1X1 칸에 여러 칸이라면, 나이가 어린 나무부터 먹는다.
             * - 땅에 양분이 부족한 나무는 죽는다.
             */
            List<int[]> deadTrees = new ArrayList<>();
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    if (!trees[r][c].land.isEmpty()) {
                        if (trees[r][c].land.size() > 1) {
                            Collections.sort(trees[r][c].land);
                        }
                        for (int i = 0; i < trees[r][c].land.size(); i++) {
                            if (nutrients[r][c] >= trees[r][c].land.get(i).age) {
                                nutrients[r][c] -= trees[r][c].land.get(i).age;
                                trees[r][c].land.get(i).age++;
                            } else {
                                // 여름을 위한 봄 준비
                                for (int j = trees[r][c].land.size() - 1; j >= i; j--) {
                                    deadTrees.add(new int[]{r, c, trees[r][c].land.get(j).age});
                                    trees[r][c].land.remove(j);
                                }
                                break;
                            }
                        }
                    }
                }
            }

            /*
             * 여름
             * - 봄에 죽은 나무가 양분으로 변한다.
             * - 죽은 나무 / 2
             */
            for (int i = 0; i < deadTrees.size(); i++) {
                int[] dead = deadTrees.get(i);
                nutrients[dead[0]][dead[1]] += (dead[2] / 2);
            }
            deadTrees.clear();

            /*
             * 가을
             * - 나무가 번식한다. 8방 탐색
             */
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    if (!trees[r][c].land.isEmpty()) {
                        for(int i = 0; i < trees[r][c].land.size(); i++) {
                            if((trees[r][c].land.get(i).age % 5) == 0) {
                                for(int d = 0; d < 8; d++) {
                                    int nr = r + dr[d];
                                    int nc = c + dc[d];
                                    if(check(nr, nc)) {
                                        trees[nr][nc].land.add(new Tree(1));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            /*
             * 겨울
             * - S2D2가 A[r][c]만큼 양분을 땅에 공급한다.
             */
            for(int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    nutrients[r][c] += S2D2[r][c];
                }
            }

            K--;    // 해가 진다.
        }

        int sum = 0;
        for(int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if(!trees[r][c].land.isEmpty()) {
                    sum += trees[r][c].land.size();
                }
            }
        }

        System.out.println(sum);

    }
        public static boolean check ( int r, int c){
            return r >= 1 && c >= 1 && r <= N && c <= N;
        }

        public static void printTree () {
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    if (trees[r][c].land.size() != 0) {
                        System.out.print(trees[r][c].land.size() + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
        }
}