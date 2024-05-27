package swea_1251_하나로_크루스칼구현;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N;
	static double E;
	static int[] p;
	static double answer;
	static int pick;

	// 간선 클래스
	static class Bridge implements Comparable<Bridge> {
		int x;		// 섬 하나
		int y;		// 다른 섬 하나
		double cost;	// 가는데 드는 비용

		// 간선 생성자
		public Bridge(int x, int y, double cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bridge brid) {
			return Double.compare(this.cost, brid.cost);	// Double.compare 때문에 1시간 날림
		}
	}

	static List<Bridge> list;

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src/swea_1251_하나로_크루스칼구현/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case 시작
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			p = new int[N + 1];	// 루트 배열 생성
			answer = 0.0;	// 정답도 매번 초기화
			pick = 0;		// 정점 고르기도 매번 초기화

			list = new ArrayList<Bridge>(); // 매번 초기화

			int[] island_x = new int[N + 1];	// 섬 좌표
			int[] island_y = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {	// 루트 배열 초기화
				p[i] = i;
			}

			// x 좌표 저장 + p 배열 초기화
			for (int i = 1; i <= N; i++) {
				island_x[i] = sc.nextInt();
			}

			// y 좌표 저장
			for (int i = 1; i <= N; i++) {
				island_y[i] = sc.nextInt();
			}

			E = sc.nextDouble();		// 세율

			// 섬끼리 잇는 노선 list 업데이트
			for (int i = 1; i < N; i++) {
				for (int j = i + 1; j <= N; j++) {
					// 리스트에 양쪽 섬, 환경부담금 저장
					list.add(new Bridge(i, j,
							E * (Math.pow(island_x[i] - island_x[j], 2) + Math.pow(island_y[i] - island_y[j], 2))));
				}
			}

			// cost 기준 오름차순 정렬 - 이게 빡
			Collections.sort(list);

			for (Bridge b : list) {
				int px = findSet(b.x);
				int py = findSet(b.y);
				
				if(px != py) {
					union(px, py);
					answer += b.cost;
					pick++;
				}
				
				if(pick == N-1) {	// 정점이 N개면, 간선은 N-1개
					break;
				}
			}
			
			System.out.println("#" + tc + " " + Math.round(answer));	// 반올림 함수
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