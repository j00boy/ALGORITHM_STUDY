package boj_16724_피리부는사나이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static char[][] map;
	static int[][] zone;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		zone = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			char[] arr = br.readLine().toCharArray();
			for(int c = 0; c < M; c++) {
				map[r][c] = arr[c];
			}
		}
		
		// 구역을 찾기
		int cnt = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(zone[r][c] == 0) {
					zone[r][c] = ++cnt;
//					System.out.println("cnt: " + cnt);
					int row = r;
					int col = c;
					while(true) {
						switch(map[row][col]) {
							case 'U': row -= 1; break;
							case 'D': row += 1; break;
							case 'L': col -= 1; break;
							default: col += 1; break;
						}
						
						if(zone[row][col] != 0) {
							break;
						} else {
							zone[row][col] = cnt;
						}
					}
				}
			}
		}
		
		printZone();
		
		System.out.println(cnt);
		
		
	}
	
	public static void printZone() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				System.out.print(zone[r][c]);
			}
			System.out.println();
		}
	}
	
	public static void print() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}		
	}
}
