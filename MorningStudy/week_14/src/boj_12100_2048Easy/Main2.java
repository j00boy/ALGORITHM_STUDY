package boj_12100_2048Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	static int playCnt;
	static int max;
	static int count;
	static int N;
	static int[][][] map;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		playCnt = 0;
		count = 1;
		max = 0;
		N = sc.nextInt();
		map = new int[N][N][6];

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

		if (cnt == 2) {
			playCnt++;
			print(cnt);
			getMax(cnt);
			return;
		}

		for (int d = 0; d < 4; d++) {
			switch (d) {
			case 0:
				beingEmpty(cnt);
				for (int c = 0; c < N; c++) {
					List<Integer> list = new ArrayList<>();
					for (int r = 0; r < N; r++) {
						list.add(map[r][c][cnt - 1]);
					}
					if (list.isEmpty()) {
						continue;
					} else if (list.size() == 1) {
						for (int i = 0; i < list.size(); i++) {
							map[i][c][cnt] = list.get(i);
						}
						for (int i = list.size(); i < N; i++) {
							map[i][c][cnt] = 0;
						}
					} else {
						int idx = 0;
						while (idx < list.size() - 1) {
							if (list.get(idx) == list.get(idx + 1)) {
								list.set(idx, list.get(idx) + list.get(idx + 1));
								list.set(idx + 1, 0);
								idx += 2;
							} else {
								idx++;
							}
						}

						int index = 0;
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i) != 0) {
								map[index++][c][cnt] = list.get(i);
							} else {
								continue;
							}
						}
						for (int i = index; i < N; i++) {
							map[i][c][cnt] = 0;
						}
					}
				}
				play(cnt + 1);
				break;
			case 1:
				beingEmpty(cnt);
				for (int c = 0; c < N; c++) {
					List<Integer> list = new ArrayList<>();
					for (int r = N - 1; r >= 0; r--) {
						if (map[r][c][cnt - 1] == 0) {
							continue;
						} else {
							list.add(map[r][c][cnt - 1]);
						}

					}
					if (list.isEmpty()) {
						continue;
					} else if (list.size() == 1) {
						for (int i = 0; i < list.size(); i++) {
							map[N - 1 - i][c][cnt] = list.get(i);
						}
						for (int i = N - 1 - list.size(); i >= 0; i--) {
							map[i][c][cnt] = 0;
						}
					} else {
						int idx = 0;
						while (idx < list.size() - 1) {
							if (list.get(idx) == list.get(idx + 1)) {
								list.set(idx, list.get(idx) + list.get(idx + 1));
								list.set(idx + 1, 0);
								idx += 2;
							} else {
								idx++;
							}
						}

						int index = N - 1;
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i) != 0) {
								map[index][c][cnt] = list.get(i);
								index--;
							} else {
								continue;
							}
						}
						for (int i = index; i >= 0; i--) {
							map[i][c][cnt] = 0;
						}
					}
				}
				play(cnt + 1);
				break;
			case 2:
				beingEmpty(cnt);
				for (int r = 0; r < N; r++) {
					List<Integer> list = new ArrayList<>();
					for (int c = 0; c < N; c++) {
						if (map[r][c][cnt - 1] == 0) {
							continue;
						} else {
							list.add(map[r][c][cnt - 1]);
						}

					}
					if (list.isEmpty()) {
						continue;
					} else if (list.size() == 1) {
						for (int i = 0; i < list.size(); i++) {
							map[r][i][cnt] = list.get(i);
						}
						for (int i = list.size(); i < N; i++) {
							map[r][i][cnt] = 0;
						}
					} else {
						int idx = 0;
						while (idx < list.size() - 1) {
							if (list.get(idx) == list.get(idx + 1)) {
								list.set(idx, list.get(idx) + list.get(idx + 1));
								list.set(idx + 1, 0);
								idx += 2;
							} else {
								idx++;
							}
						}

						int index = 0;
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i) != 0) {
								map[r][index++][cnt] = list.get(i);
							} else {
								continue;
							}
						}
						for (int i = index; i < N; i++) {
							map[r][i][cnt] = 0;
						}
					}
				}
				play(cnt + 1);
				break;
			default:
				beingEmpty(cnt);
				for (int r = 0; r < N; r++) {
					List<Integer> list = new ArrayList<>();
					for (int c = N - 1; c >= 0; c--) {
						if (map[r][c][cnt - 1] == 0) {
							continue;
						} else {
							list.add(map[r][c][cnt - 1]);
						}

					}
					if (list.isEmpty()) {
						continue;
					} else if (list.size() == 1) {
						for (int i = 0; i < list.size(); i++) {
							map[r][N - 1 - i][cnt] = list.get(i);
						}
						for (int i = N - 1 - list.size(); i >= 0; i--) {
							map[r][i][cnt] = 0;
						}
					} else {
						int idx = 0;
						while (idx < list.size() - 1) {
							if (list.get(idx) == list.get(idx + 1)) {
								list.set(idx, list.get(idx) + list.get(idx + 1));
								list.set(idx + 1, 0);
								idx += 2;
							} else {
								idx++;
							}
						}

						int index = N - 1;
						for (int i = 0; i < list.size(); i++) {
							if (list.get(i) != 0) {
								map[r][index][cnt] = list.get(i);
								index--;
							} else {
								continue;
							}
						}
						for (int i = index; i >= 0; i--) {
							map[r][i][cnt] = 0;
						}
					}
				}
				play(cnt + 1);
				break;
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
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
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