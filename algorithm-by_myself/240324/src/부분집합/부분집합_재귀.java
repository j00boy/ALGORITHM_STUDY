package 부분집합;

public class 부분집합_재귀 {
	
	static String[] materials;
	static boolean[] selected;
	static int N;
	
	public static void main(String[] args) {
		materials = new String[] {"fish", "meat", "cucumber", "carrot"};
		N = materials.length;
		selected = new boolean[N];
		
		powerSet(0);
	}
	
	public static void powerSet(int idx) {
		if(idx >= N) {
			String tmp = "";
			for(int i = 0; i < N; i++) {
				if(selected[i]) {
					tmp += materials[i] + " ";
				}
			}
			System.out.println(tmp);
			return;
		}
		
		selected[idx] = false;
		powerSet(idx + 1);
		
		selected[idx] = true;
		powerSet(idx + 1);
		
	}
}
