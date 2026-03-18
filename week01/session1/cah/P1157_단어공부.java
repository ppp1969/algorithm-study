package cah;

import java.util.*;
import java.io.*;

public class P1157_단어공부 {
    /*
      문제 사항
      - 알파벳 대소문자 미 구분 문자열 1줄 입력
      - 가장 많이 나온 알파벳을 대문자로 출력
      - 동일하게 가장 많이 나온다면 "?" 출력

      성능 요구 사항
      -  단어 길이: 최대 1,000,000
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // 알파벳 개수 저장할 배열
        int[] count = new int[26];

        // 문자열 순회하며 알파벳 개수 카운트
        for(int i = 0; i < s.length(); i++){
            char c = Character.toUpperCase(s.charAt(i));
            count[c - 'A']++; // 해당 알파벳 위치의 카운트 증가
        }

        // 최대 빈도수 찾기
        int max = -1;
        char result = '?'; // 결과 문자, default는 '?'

        // 배열 순회하며 최댓값과 중복 여부 확인
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