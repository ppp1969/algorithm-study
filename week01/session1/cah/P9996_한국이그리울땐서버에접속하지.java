package cah;

import java.io.*;
    /*
      문제 요약
      - 파일 이름 N개를 패턴과 일치하는지 여부를 출력

      핵심 아이디어
      - 정규 표현식 사용
      - "*"를 정규표현식 ".*"로 변환하여 처리
      - 문자열 전체 일치를 위해 ^, $ 사용

      시간 복잡도: O(N * 문자열 길이)
     */
public class P9996_한국이그리울땐서버에접속하지 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        // 정규 표현식에 맞게 변환
        String regex = "^" + pattern.replace("*", ".*") + "$";
        String[] result = new String[N]; // 결과 여부 배열

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if(s.matches(regex)) result[i] = "DA";
            else result[i] = "NE";
        }

        for(String s: result){
            System.out.println(s);
        }
    }
}
