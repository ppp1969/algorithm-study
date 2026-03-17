import java.util.*;
import java.io.*;

public class P1316_그룹단어체커 {
    public static void main(String[] args) throws  IOException{
        /**
         * 입력 :
         * - 첫째줄에 단어 개수
         * - 매 줄마다 단어
         * 출력 :
         * - 그룹단어의 개수
         *
         * ---
         *
         * 핵심 : 알파벳이 재등장하는 지에 대한 판별
         * - 무조건 소문자
         *
         *
         * 시간복잡도 : 개수 N, 길이 M O(NM)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean[] alpha = new boolean[30];
            char[] chars = br.readLine().toCharArray();
            char preChar = ' ';
            boolean isTrue = true;
            for (char c : chars){
                // chars 순회하며, 각 c에 대해서 alpha 배열에 기록
                // alpha에 true로 기록되어있다면 직전문자 체크
                int index = c - 'a';
                if (!alpha[index]){ // 미등장시
                    alpha[index] = true;
                    preChar = c;
                } else if(preChar != c){
                    isTrue = false;
                }
            }

            if (isTrue) count++;

        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
