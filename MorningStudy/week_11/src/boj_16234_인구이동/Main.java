package boj_16234_인구이동;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] A;	// 국가 
	static int N;		// 변의 길이
	static int L;
	static int R;
	static boolean[][] visited;	// 방문체크 배열
	static int[] dr = { -1, 1, 0, 0 };	// 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 };	// 상 하 좌 우
	static int count = 0;	// 함수 돌아가는 횟수 체크하는 변수
	static int day = 0;		// 하루하루 지나가는 날

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 변의 크기
		L = sc.nextInt(); // 인구차이 min
		R = sc.nextInt(); // 인구차이 max

		A = new int[N][N]; // 땅

		// 국가별 인구 입력받기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				A[r][c] = sc.nextInt();
			}
		}

		/*
		 *  count가 N*N이라는 뜻은
		 *  각 국가가 국경선을 개방한 게 없어서 국가마다 연합을 찾는 함수가 시행된 횟수가 N*N번이라는 뜻
		 *  즉, 더 이상 국경을 개방할 일이 없다는 뜻임
		 */
		while (true) {
			visited = new boolean[N][N];	// 하루 지날 때마다 방문체크 배열 초기화
			count = 0;						// count 초기화
			for (int r = 0; r < N; r++) {	
				for (int c = 0; c < N; c++) {
					if(!visited[r][c]) {	// 방문한 적이 없다면 연합찾는 함수 실행
						getUnion(r, c);		
						count++;			// 함수 실행 횟수++
					}
				}
			}
			
			day++;							// 국가를 끝까지 순회하면 하루가 지난 것임
			if(count == N * N) {			
				System.out.println(day-1);	// day-1을 하는 이유는, 마지막 day는 더 이상 국경을 열 필요가 없는지
				return;						// 확인하는 것이기 때문에 day-1 출력
			}
		}
	}

	// 연합을 찾는 함수 -> BFS
	public static void getUnion(int r, int c) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 한번 함수 실행에 연합을 이룬 국가 위치를 저장할 list
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();
		
		int cnt = 1;		// 연합 내 국가의 수
		int sum = A[r][c];	// 연합 내 총 인구 수
		visited[r][c] = true;	// 방문 체크

		queue.add(r);
		queue.add(c);
		row.add(r);
		col.add(c);

		while (!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];

				// 경계 조건 안에 있어야 국가별 인구 차이를 구할 수 있음
				if (check(nr, nc)) {
					int gap = Math.abs(A[now_r][now_c] - A[nr][nc]);

					// 방문한적 없고, 인구별 차이가 L이상 R이하라면
					if (!visited[nr][nc] && gap <= R && gap >= L) {
						queue.add(nr);
						queue.add(nc);
						row.add(nr);	// 연합으로 인정하고 r값 저장
						col.add(nc);	// 연합으로 저장하고 c값 저장
						cnt++;			// 연합 내 국가 수 ++
						sum += A[nr][nc];	// 총 인구 수 ++
						visited[nr][nc] = true;	// 방문 체크
					}
				}
			}
		}
		
//		System.out.println(row);
//		System.out.println(col);

		// 둘 다 int형이기 때문에 소수점 알아서 버림
		int avg = sum / cnt;

		// 아까 저장한 위치의 국가들 인구 수 수정
		for (int i = 0; i < row.size(); i++) {
			A[row.get(i)][col.get(i)] = avg;
		}
	}

	// 경계조건 체크하는 함수
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
