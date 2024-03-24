package 조합;

public class 조합_재귀호출 {
	
	static String[] materials;
	static String[] inputs;
	static int N;
	static int R;
	
	public static void main(String[] args) {
		materials = new String[] {"fish", "meat", "cucumber", "carrot"};
		N = materials.length;
		R = 2;
		inputs = new String[R];
		
		combination(0, 0);
	}
	
	public static void combination(int idx, int sidx) {
		if(sidx >= R) {
			String tmp = "";
			for(int i = 0; i < R; i++) {
				tmp += inputs[i] + " ";
			}
			System.out.println(tmp);
			return;
		}
		
		if(idx >= N) {
			return;
		}
		
		inputs[sidx] = materials[idx];
		combination(idx + 1, sidx + 1);
		combination(idx + 1, sidx);
	}
}
