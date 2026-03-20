package week01.session1;

import java.util.HashSet;
import java.util.Scanner;

class P3_1316_그룹단어체커 {
    public int solution(int n, String[] input) {
        int answer = 0;

        for (String x : input) {
            HashSet<Character> hs = new HashSet<>();
            char a = ' ';
            boolean flag = true;
            for(char w : x.toCharArray()){
                if(a != w && hs.contains(w)){
                    flag = false;
                    break;
                }
                a = w;
                hs.add(w);
            }
            if(flag){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P3_1316_그룹단어체커 T = new P3_1316_그룹단어체커();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.next();
        }

        System.out.println(T.solution(n, input));
    }
}
