package 부분집합;

public class 부분집합_재귀호출 {
	
	static boolean[] sel;
	static int N;
	static String[] materials;
	
	public static void main(String[] args) {
		
		materials = new String[] {"fish", "meat", "cucumber", "carrot"};
		N = materials.length;
		sel = new boolean[N];
		
		
		powerSet(0);
	}
	
	static void powerSet(int idx) {
		if(idx >= N) {
			String tmp = "";
			for(int i = 0; i < N; i++) {
				if(sel[i]) {
					tmp += materials[i] + " ";
				}
			}
			System.out.println(tmp);
			return;
		}
		
		sel[idx] = false;
		powerSet(idx+1);
		sel[idx] = true;
		powerSet(idx+1);
	}
}
