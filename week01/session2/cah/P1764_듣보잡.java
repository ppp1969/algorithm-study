package cah;

import java.io.*;
import java.util.*;

public class P1764_듣보잡 {
    /*
     문제 요약
      - 듣도 못한 N명, 보도 못한 M명에서 듣도 보도 못한 명단 출력
      - 결과는 사전순 출력

     핵심 아이디어
      - HashSet과 ArrayList 함께 사용
      - Set에는 듣지 못한 사람, List에는 Set에 있고 & 보지 못한 사람만 저장
      - 마지막에 리스트 정렬해 출력

     시간 복잡도: O(N + M + k log k) (k: 듣도 보도 못한 사람 수)
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> noHeard = new HashSet<>();
        List<String> noHeardAndSaw = new ArrayList<>();

        // 듣도 못한 사람 -> set에 넣기
        for(int i = 0; i < N; i++){
            noHeard.add(br.readLine());
        }

        // 보도 못한 사람
        // set에 있다면 -> list에 넣기
        for(int i = 0; i < M; i++){
            String s = br.readLine();
            if(noHeard.contains(s)){
                noHeardAndSaw.add(s);
            }
        }

        Collections.sort(noHeardAndSaw); // 사전순 정렬
        System.out.println(noHeardAndSaw.size());

        for(String s: noHeardAndSaw){
            System.out.println(s);
        }

        br.close();
    }
}
