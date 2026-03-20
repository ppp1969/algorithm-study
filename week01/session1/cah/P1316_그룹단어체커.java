package cah;

import java.io.*;
import java.util.*;
    /*
      문제 요약
      - 각 단어에 대해 그룹 단어인지 판별하고 개수 출력

      핵심 아이디어
      - 이전 문자(prev)와 현재 문자(cur) 비교
      - 방문 여부(visited)로 재등장 체크

      시간 복잡도: O(N * 단어 길이)
     */
public class P1316_그룹단어체커 {
    static boolean isGroupWord(String s){
        boolean[] visited = new boolean[26]; // a~z 등장 여부 체크
        char prev = 0;

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);

            // 이전 문자와 동일 -> 같은 그룹으로 계속 진행
            if(cur == prev){
                prev = cur;

            // 이전 문자와 다른 경우
            }else{
                // 이미 등장한 문자 -> 그룹 단어 x
                if(visited[cur - 'a']){
                    return false;
                // 처음 등장한 문자 -> 방문 체크 후 진행
                }else{
                    visited[cur - 'a'] = true;
                    prev = cur;
                }
            }
        }
        // 모든 조건 통과 시 -> 그룹 단어
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0; // 그룹 단어 개수

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if(isGroupWord(s)) count++;
        }

        System.out.println(count);

    }
}