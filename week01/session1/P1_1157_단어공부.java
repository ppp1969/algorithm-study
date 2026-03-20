package week01.session1;

import java.util.HashMap;
import java.util.Scanner;

class P1_1157_단어공부 {
    public char solution(String input) {
        char answer = ' ';
        int max = Integer.MIN_VALUE;
        input = input.toUpperCase();

        HashMap<Character, Integer> hs = new HashMap<>();

        for (char x : input.toCharArray()) {
            hs.put(x, hs.getOrDefault(x, 0) + 1);
        }

        for (char x : hs.keySet()) {
            if(hs.get(x) > max){
                answer = x;
                max = hs.get(x);
            }
        }

        int cnt = 0;
        for (char x : hs.keySet()) {
            if(hs.get(x) == max){
                cnt++;
            }
        }

        if(cnt > 1) return '?';

        return answer;
    }
    public static void main(String[] args) {
        P1_1157_단어공부 T = new P1_1157_단어공부();
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        System.out.println(T.solution(input));
    }
}
