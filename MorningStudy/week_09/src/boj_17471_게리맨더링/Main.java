/*
 * 1. 선거구 단순하게 나누기
 * - 2^10 = 1024이므로 가능할 것 같음
 * 2. 각 선거구끼리 연결되어 있는지 확인하기
 * - BFS 사용하면 될 듯함
 * 3. - 1, 2번 만족 시 인구 차 구하기
 */

package boj_17471_게리맨더링;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> group_A = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> group_B = new ArrayList<ArrayList<Integer>>();
	static int[] p;
	static boolean[] sel;
	static boolean[] visited;
	static int depth;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p = new int[N + 1];
		visited = new boolean[N + 1];
		

		for (int i = 1; i <= N; i++) {
			p[i] = sc.nextInt();
		}

		// 인접리스트 초기화
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 1; i <= N; i++) {
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				list.get(i).add(sc.nextInt());
			}
		}
		
		for(int i = 1; i < N / 2; i++) {
			sel = new boolean[N+1];
		}

		
		
	}

	// 1. 단순한 조합 구하기 (6개 모두)
	public static void comb(int idx, int sidx, int depth) {
		if(sidx == depth) {
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			for(int i = 1; i <= N; i++) {
				if(sel[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			group_A.add(A);
			group_B.add(B);
		}
		
		sel[idx] = true;
		comb(idx + 1, sidx + 1, depth);
		comb(idx + 1, sidx, depth);
	}
	
	
}