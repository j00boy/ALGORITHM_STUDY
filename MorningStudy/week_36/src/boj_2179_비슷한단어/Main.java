package boj_2179_비슷한단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int max; // 접두사 최대 길이
    static int idx; // S가 입력되는 순서대로 제일 앞쪽에 있는 단어를 출력, 그런 경우도 여러 개 있을 때에는 그 중에서 T가 제일 앞쪽에 있는 단어
    static String S;
    static String T;

    static int N;   // 2 <= N <= 20000
    static List<String> list;
    static List<String> same;

    static Trie root;

    static class Trie {
        Map<Character, Trie> children;
        boolean isEnd;
        int depth;

        public Trie(int depth) {
            this.children = new HashMap<>();
            this.isEnd = false;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        max = 0;
        idx = Integer.MAX_VALUE;
        same = new ArrayList<>();
        root = new Trie(1);
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(String.valueOf(br.readLine()));
        }

        Trie now;
        for(String word : list) {
            now = root;
            char[] chars = word.toCharArray();
            for(char c : chars) {

                if(!now.children.containsKey(c)) {
                    now.children.put(c, new Trie(now.depth + 1));
                } else {
                    if(now.depth > max) {
//                        System.out.println("이전 max: " + max);
                        same.clear();
                        same.add(word);
                        max = now.depth;
//                        T = word;
//                        System.out.println("다음 max: " + max + ", T: " + T);
                    } else if(now.depth == max) {
                        same.add(word);
                    }
                }

                now = now.children.get(c);
            }
            now.isEnd = true;
        }

        int idxP = Integer.MAX_VALUE;

        for(String s : same) {
            String prefix = s.substring(0, max);
//            System.out.println("prefix: " + prefix);
            for(String word : list) {
                if(word.equals(s) || word.length() < prefix.length()) continue;
                if(word.substring(0, max).equals(prefix)) {
                    if(list.indexOf(word) < idx) {
                        idx = list.indexOf(word);
                        S = word;
                        T = s;
//                        System.out.println("S:T = " + S  + ":" + T);
                        break;
                    }
                }
            }
        }

        System.out.println(S);
        System.out.println(T);
    }
}
