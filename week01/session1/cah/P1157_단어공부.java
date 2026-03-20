package cah;

import java.util.*;
import java.io.*;
    /*
      문제 요약
      - 문자열에서 가장 많이 등장한 알파벳 출력(대소문자 구분 X)
      - 결과는 대문자로 출력
      - 최댓값이 여러개라면 "?" 출력

      핵심 아이디어
      - 모든 문자를 대문자로 변환 처리
      - 알파벳 빈도를 배열(count[26])로 관리
      - 최댓값을 찾으며 중복 여부 함께 체크

      시간 복잡도: O(N)
     */
public class P1157_단어공부 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] count = new int[26]; // A~Z까지 빈도 저장 배열

        // 알파벳 빈도 카운트
        for(int i = 0; i < s.length(); i++){
            char c = Character.toUpperCase(s.charAt(i)); // 대문자로 통일
            count[c - 'A']++; // 해당 알파벳 위치의 카운트 증가
        }

        int max = -1; // 최대 빈도수
        char result = '?'; // 결과 문자, default는 '?'

        // 최댓값과 중복 여부 확인
        for(int i = 0; i < 26; i++){
            if(count[i] > max){
                // 더 큰 최댓값 찾은 경우 갱신
                max = count[i];
                result = (char)(i + 'A');
            } else if(count[i] == max){
                // 최댓값이 동일하다면 default로
                result = '?';
            }
        }

        System.out.println(result);
    }
}