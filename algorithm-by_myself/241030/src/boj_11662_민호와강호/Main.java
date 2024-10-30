package boj_11662_민호와강호;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double Ax = Double.parseDouble(st.nextToken());
		double Ay = Double.parseDouble(st.nextToken());
		double Bx = Double.parseDouble(st.nextToken());
		double By = Double.parseDouble(st.nextToken());
		double Cx = Double.parseDouble(st.nextToken());
		double Cy = Double.parseDouble(st.nextToken());
		double Dx = Double.parseDouble(st.nextToken());
		double Dy = Double.parseDouble(st.nextToken());
		
		List<Double> minho = new ArrayList<>();
		List<Double> kangho = new ArrayList<>();
		
		double minhoX = (Bx - Ax) / 1000000;
		double minhoY = (By - Ay) / 1000000;
		
		double kanghoX = (Dx - Cx) / 1000000;
		double kanghoY = (Dy - Cy) / 1000000;
		
		double min = Double.MAX_VALUE;
		
		for(int i = 0; i <= 1000000; i++) {
			double xGap = (Cx - Ax) + (kanghoX - minhoX) * i;
			double yGap = (Cy - Ay) + (kanghoY - minhoY) * i;
			
			double totalGap = Math.sqrt(Math.pow(xGap, 2) + Math.pow(yGap, 2));
			
			min = Math.min(totalGap, min);
		}
		
		System.out.println(min);
	}
}
