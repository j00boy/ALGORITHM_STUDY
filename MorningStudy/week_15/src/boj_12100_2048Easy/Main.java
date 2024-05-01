package boj_12100_2048Easy;

/*
 * 자꾸 왜 못합치는거지?하고 보니 == 을 equals로 바꾸니까 됐는데..
 * == 연산은 주소를 비교하고 equals()는 주소도 비교하고 다르면 값도 비교하니까 그런거 같기도 하고
 * 자바 어렵다 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int playCnt;	// 1024번 다 돌아가는지 확인하려고
	static int max;		// 최대값 담는 배열
	static int count;	// 실행 횟수
	static int N;
	static int[][][] map;	// 3차원 배열로 한게, 각 횟수에 대한 맵 값을 가지고 있어야 함 -> 안 그러면 맵이 계속 바뀜

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		playCnt = 0;
		count = 1;
		max = 0;
		N = sc.nextInt();
		map = new int[N][N][6];	// map[r][c][0]에는 초기 입력값

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c][0] = sc.nextInt();
			}
		}

		play(count);

		System.out.println(max);
//		System.out.println("playCnt : " + playCnt);

	}

	public static void play(int cnt) {

		// 기저 조건
		if (cnt == 6) {
//			playCnt++;
//			print(cnt);
			getMax(cnt);
			return;
		}
		
		// 상 하 좌 우
		for (int d = 0; d < 4; d++) {
			
			/**
			 * beingEmpty() 함수
			 * 위 아래 좌 우 로 실행하면서 계속해서 맵이 바뀌기 때문에,
			 * 기존 실행횟수에서 새로 맵을 만들어줘야 함
			 * 한번 초기화를 안해주면 영향을 줄 수 있기 때문에 맵 청소하는 것
			 * 모든 원소를 0으로 초기화
			 * 하지만 밑에 로직에서는 다른 원소들도 모두 0으로 초기화를 직접해주기 때문에 사실 필요없음
			 */
			// ↑↑↑↑↑↑↑↑↑↑
			if(d == 0) {
				beingEmpty(cnt);
				for (int c = 0; c < N; c++) {
					List<Integer> list = new ArrayList<>();		// 0이 아닌 수를 담을 배열
					
					for (int r = 0; r < N; r++) {
						if (map[r][c][cnt - 1] != 0) {
							list.add(map[r][c][cnt - 1]);
						}
					}
					
					if (list.isEmpty()) {	// 모두 0이라면
						continue;			// continue
					} else if (list.size() == 1) {	// 숫자가 하나라면
						map[0][c][cnt] = list.get(0);	// 해당 방향의 맨 앞으로 당기기만 하고
						for (int i = 1; i < N; i++) {	// 나머지는 0으로
							map[i][c][cnt] = 0;
						}
						/*
						 * [2개 이상의 원소를 가지고 있다면, 2048 메서드 필요]
						 * 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다.
						 * 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다.
						 */
					} else {
						int idx = 0;
//						System.out.println("합치기 전: " + list);
						while (idx < list.size() - 1) {
							if (list.get(idx).equals(list.get(idx + 1))) {
								list.set(idx, list.get(idx) * 2);
								list.set(idx + 1, 0);
								idx += 2;
							} else {
								idx++;
							}
						}
//						System.out.println("합치기 후: " + list);

						int index = 0;
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i) != 0) {
								map[index][c][cnt] = list.get(i);
								index++;
							}
						}
						
						for (int i = index; i < N; i++) {
							map[i][c][cnt] = 0;
						}
					}
				}
				play(cnt + 1);
				
			// ↓↓↓↓↓↓↓↓↓↓
			} else if(d == 1) {
				beingEmpty(cnt);
				for (int c = 0; c < N; c++) {
					List<Integer> list = new ArrayList<>();
					for (int r = N - 1; r >= 0; r--) {
						if (map[r][c][cnt - 1] != 0) {
							list.add(map[r][c][cnt - 1]);
						}
					}
					
					if (list.isEmpty()) {
						continue;
					} else if (list.size() == 1) {
						map[N - 1][c][cnt] = list.get(0);
						for (int i = N - 2; i >= 0; i--) {
							map[i][c][cnt] = 0;
						}
					} else {
						int idx = 0;
//						System.out.println("합치기 전: " + list);
						while (idx < list.size() - 1) {
							if (list.get(idx).equals(list.get(idx + 1))) {
								list.set(idx, list.get(idx) * 2);
								list.set(idx + 1, 0);
								idx += 2;
							} else {
								idx++;
							}
						}
//						System.out.println("합치기 후: " + list);
						
						int index = N - 1;
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i) != 0) {
								map[index][c][cnt] = list.get(i);
								index--;
							}
						}
						for (int i = index; i >= 0; i--) {
							map[i][c][cnt] = 0;
						}
					}
				}
				play(cnt + 1);
			
			// ←←←←←←←←←←
			} else if(d == 2) {
				beingEmpty(cnt);
				for (int r = 0; r < N; r++) {
					List<Integer> list = new ArrayList<>();
					for (int c = 0; c < N; c++) {
						if (map[r][c][cnt - 1] != 0) {
							list.add(map[r][c][cnt - 1]);
						}
					}
					
					if (list.isEmpty()) {
						continue;
					} else if (list.size() == 1) {
						map[r][0][cnt] = list.get(0);
						for (int i = 1; i < N; i++) {
							map[r][i][cnt] = 0;
						}
					} else {
						int idx = 0;
//						System.out.println("합치기 전: " + list);
						while (idx < list.size() - 1) {
							if (list.get(idx).equals(list.get(idx + 1))) {
								list.set(idx, list.get(idx) * 2);
								list.set(idx + 1, 0);
								idx += 2;
							} else {
								idx++;
							}
						}
//						System.out.println("합치기 후: " + list);

						int index = 0;
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i) != 0) {
								map[r][index][cnt] = list.get(i);
								index++;
							}
						}
						
						for (int i = index; i < N; i++) {
							map[r][i][cnt] = 0;
						}
					}
				}
				play(cnt + 1);
			
			// →→→→→→→→→→
			} else {
				beingEmpty(cnt);
				for (int r = 0; r < N; r++) {
					List<Integer> list = new ArrayList<>();
					for (int c = N - 1; c >= 0; c--) {
						if (map[r][c][cnt - 1] != 0) {
							list.add(map[r][c][cnt - 1]);
						}
					}
					
					if (list.isEmpty()) {
						continue;
					} else if (list.size() == 1) {
						map[r][N - 1][cnt] = list.get(0);
						for (int i = N - 2; i >= 0; i--) {
							map[r][i][cnt] = 0;
						}
					} else {
						int idx = 0;
//						System.out.println("합치기 전: " + list);
						while (idx < list.size() - 1) {
							if (list.get(idx).equals(list.get(idx + 1))) {
								list.set(idx, list.get(idx) * 2);
								list.set(idx + 1, 0);
								idx += 2;
							} else {
								idx++;
							}
						}
//						System.out.println("합치기 후: " + list);

						int index = N - 1;
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i) != 0) {
								map[r][index][cnt] = list.get(i);
								index--;
							}
						}
						
						for (int i = index; i >= 0; i--) {
							map[r][i][cnt] = 0;
						}
					}
				}
				play(cnt + 1);
			}
		}

	}

	public static void getMax(int cnt) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c][cnt - 1] != 0) {
					max = Math.max(max, map[r][c][cnt - 1]);
				}
			}
		}
	}
	
	public static void beingEmpty(int cnt) {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c][cnt] = 0;
			}
		}
	}

	public static void print(int cnt) {
		System.out.println("----------------------------");
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c][cnt - 1] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}
}