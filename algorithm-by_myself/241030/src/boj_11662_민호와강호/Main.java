package boj_11662_민호와강호;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int Ax = Integer.parseInt(st.nextToken());
		int Ay = Integer.parseInt(st.nextToken());
		int Bx = Integer.parseInt(st.nextToken());
		int By = Integer.parseInt(st.nextToken());
		int Cx = Integer.parseInt(st.nextToken());
		int Cy = Integer.parseInt(st.nextToken());
		int Dx = Integer.parseInt(st.nextToken());
		int Dy = Integer.parseInt(st.nextToken());
		
		// 기울기 = (y2 - y1) / (x2 - x1)
		
		double A = (double) (By - Ay) / (double) (Bx - Ax);
		double B = (double) (Dy - Cy) / (double) (Dx - Cx);
		double gap = B / A;
		
		double min = Math.sqrt(Math.pow(Cx - Ax, 2) + Math.pow(Cy - Ay, 2));
		
		double left = 0;
		double right = Math.sqrt(Math.pow(Bx - Ax, 2) + Math.pow(By - Ay, 2));

		while(left <= right) {
			double mid = (left + right) / 2;
			
			
		}
	}
}
