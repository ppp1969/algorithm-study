package cah;

import java.util.*;
    /*
      문제 요약
      - 특정 문자열을 하나의 크로아티아 알파벳으로 보고 전체 개수 출력

      처리 대상
      - 3글자: 'dz='
      - 2글자: "c=", "c-", "d-", "lj", "nj", "s=", "z="

      핵심 아이디어
      - 문자열 앞에서부터 순차 탐색 (idx 기반)
      - 겹침 방지 위해 가장 긴 패턴부터 검사
      - 매칭되면 해당 길이만큼 idx 이동

      시간 복잡도: O(N)
     */
public class P2941_크로아티아알파벳{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int count = 0; // 크로아티아 알파벳 개수
        int idx = 0; // 현재 탐색 위치

        while(idx < s.length()){
            // 3글자 패턴 먼저 검사
            if(idx + 2 < s.length() && s.substring(idx, idx+3).equals("dz=")){
                count++;
                idx += 3;
            // 2글자 패턴 검사
            }else if(idx + 1 < s.length()){
                String s2 = s.substring(idx, idx + 2);

                // 크로아티아 알파벳에 해당하는 경우
                if(s2.equals("c=") || s2.equals("c-") || s2.equals("d-") ||
                s2.equals("lj") || s2.equals("nj") || s2.equals("s=") || s2.equals("z=")) {
                    count++;
                    idx += 2;

                // 일반 문자 처리
                }else{
                     count++;
                     idx++;
                }
            // 마지막 한 글자 처리
            }else{
                count++;
                idx++;
            }
        }

        System.out.println(count);
    }
}