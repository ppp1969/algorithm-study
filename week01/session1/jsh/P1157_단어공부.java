import java.util.*;
import java.io.*;

public class P1157_단어공부 {
    public static void main(String[] args) throws IOException{
        /**
         * 입력 : 알파벳 대소문자로 된 단어
         * 출력 : 가장 많이 사용된 알파벳 대문자
         * - 대소문자 구별 x
         * - 단어 길이는 1,000,000 이하
         * - 여러개 존재하는 경우 ? 출력
         *
         * 시간복잡도 -> 단어 길이를 N이라 하면 O(N)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toLowerCase();
        int[] alphaCount = new int[30];

        // 1. 각 '알파벳' - 'a'를 index로 ++ 증가
        char[] chars = str.toCharArray();

        for(char c : chars){
            alphaCount[c - 'a'] += 1;
        }

        // 2. chars 순회하며, 가장 많은 경우 조회
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        boolean result = true;

        for(int i=0; i<alphaCount.length; i++){
            if(max < alphaCount[i]){
                max = alphaCount[i];
                maxIndex = i;
                result = true;
            } else if (max == alphaCount[i]) {
                result = false;
            }
        }

        if (result){
            char temp = (char)('a' + maxIndex - ('a' - 'A'));
            System.out.println(temp);
        } else {
            System.out.println('?');
        }
    }
}
