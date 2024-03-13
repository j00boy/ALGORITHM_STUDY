package boj_10158_개미;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		int p = sc.nextInt();
		int q = sc.nextInt();
		
		int time = sc.nextInt();
		
		p = ((p + time) % (2 * W)) <= W ? (p + time) % (2 * W) : 2*W - ((p + time) % (2 * W));
		q = ((q + time) % (2 * H)) <= H ? ((q + time) % (2 * H)) : 2*H - ((q + time) % (2 * H));

		System.out.println(p + " " + q);
		
	}

}
