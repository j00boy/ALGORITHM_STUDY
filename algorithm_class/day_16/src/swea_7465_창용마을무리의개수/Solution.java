package swea_7465_창용마을무리의개수;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int M;
	static int[] p;
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(new File("src/swea_7465_창용마을무리의개수/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case 시작
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();	// 마을 사람들 수
			M = sc.nextInt();	// 간선의 수
			
			int count = 0;		// 그룹 개수를 카운트할 변수
			
			p = new int[N+1];	// 유니온파인드 배열 생성
			
			// 자기 index로 초기값 초기화
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			int[][] edges = new int[M][2];	// 간선의 정보 배열, 가중치가 없으니까 연결성만 찾음
			
			// 간선 정보 입력받기
			for(int i = 0; i < M; i++) {
				edges[i][0] = sc.nextInt();
				edges[i][1] = sc.nextInt();
			}
			
			// 연결하기
			for(int i = 0; i < M; i++) {
				union(findSet(edges[i][0]), findSet(edges[i][1]));
			}
			
			// 그룹 개수 세기
			List<Integer> list = new ArrayList<>();
			for(int i = 1; i <= N; i++) {
				// target을 p[i]로 두면, union 과정에서 자식 노드로 갖고 있는 노드까지 부모 노드가 바뀌지는 않음
				// 그래서 집합 확인 과정에서 findSet() 메서드를 한 번 더 돌아야 함
				int target = findSet(i);
				if(!list.contains(target)) {
					list.add(target);
					count++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
			
		}
		// test case 끝
	}
	
	// 연결된 부모노드를 찾는 메서드
	// 여기서 재귀 스택을 빠져나오면서 거치는 호출된 모든 노드를 루트 노드값으로 변경함
	static int findSet(int n) {
		if(n == p[n]) return n;
		return findSet(p[n]);
	}
	
	// 집합끼리 합치는 메서드
	static void union(int n1, int n2) {
		p[findSet(n2)] = findSet(n1); 	// n2가 속한 집합의 부모노드가 가리키는 노드는 n1의 부모 노드
	}
}