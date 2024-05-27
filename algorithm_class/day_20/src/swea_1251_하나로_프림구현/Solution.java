package swea_1251_하나로_프림구현;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	static final int INF = Integer.MAX_VALUE;

	// 간선 클래스
	static class Bridge implements Comparable<Bridge> {
		int end;
		double cost;	// 가는데 드는 비용

		// 간선 생성자
		public Bridge(int end, double cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bridge brid) {
			return Double.compare(this.cost, brid.cost);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_1251_하나로_프림구현/input.txt"));

		int T = sc.nextInt();

		// test case 시작
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			double answer = 0.0;	// 정답도 매번 초기화
			ArrayList<Bridge>[] adjList = new ArrayList[N+1];
			
			
			for(int i = 0; i <= N; i++) {
				adjList[i] = new ArrayList<>();
			}

			int[] island_x = new int[N + 1];	// 섬 좌표
			int[] island_y = new int[N + 1];
			
			// x 좌표 저장
			for (int i = 1; i <= N; i++) {
				island_x[i] = sc.nextInt();
			}

			// y 좌표 저장
			for (int i = 1; i <= N; i++) {
				island_y[i] = sc.nextInt();
			}

			double E = sc.nextDouble();		// 세율

			// 섬끼리 잇는 노선 list 업데이트
			for (int i = 1; i < N; i++) {
				for (int j = i + 1; j <= N; j++) {
					double w = E * (Math.pow(island_x[i] - island_x[j], 2) + Math.pow(island_y[i] - island_y[j], 2));
					adjList[i].add(new Bridge(j, w));
					adjList[j].add(new Bridge(i, w));
				}
			}
			
			boolean[] visited = new boolean[N+1];

			PriorityQueue<Bridge> pq = new PriorityQueue<>();
			
			visited[1] = true;
			int pick = 1;
			
			pq.addAll(adjList[1]);
			
			while(pick < N) {
				Bridge b = pq.poll();
				
				if(visited[b.end]) {
					continue;
				}
				
				answer += b.cost;
				visited[b.end]= true;
				pick++;
				
				pq.addAll(adjList[b.end]);
			}
			
			System.out.println("#" + tc + " " + Math.round(answer));	// 반올림 함수
		}
		// test case 끝
	}

}