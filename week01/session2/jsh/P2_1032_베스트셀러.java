package week01.session2.jsh;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class P2_1032_베스트셀러 {
    public static void main(String[] args) throws IOException {
        /**
         * 가자 많이 팔린 책을 출력
         * 입력 :
         * 5
         * top
         * top
         * top
         * top
         * kimtop
         *
         * 출력 :
         * top
         *
         * 유의
         *  - N은 1,000보다 작거나 같은 자연수
         *  - 책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 구성
         *  - 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        String result = Solution(input);

        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }

    public static String Solution(String[] strings){
        // 개수 세는 것은 Map 활용
        // 사전순이므로, HashMap보다 TreeMap 활용
        Map<String, Integer> map = new TreeMap<>();

        for(String s : strings){
            map.put(s, map.getOrDefault(s,0) + 1);
        }

        int max = Collections.max(map.values());

        for(String s : map.keySet()){
            if (max == map.get(s)){
                return s;
            }
        }
        return null;
    }
}
