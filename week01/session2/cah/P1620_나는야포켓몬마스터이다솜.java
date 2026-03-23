package cah;

import java.io.*;
import java.util.*;

public class P1620_나는야포켓몬마스터이다솜 {
    /*
     문제 요약
      - 포켓몬 이름이 입력되면 해당 줄 번호를 가지는 포켓몬 도감 생성
      - 포켓몬 이름이 입력되면 번호, 번호가 입력되면 해당 포켓몬 이름 출력

     핵심 아이디어
      - 포켓몬 이름에 해당 번호를 저장하기 위한 HashMap
      - 번호에 해당하는 포켓몬 번호를 저장하기 위한 String 배열 사용
      - 문제가 번호인지 문자인지 charAt() + isDigit() 을 이용해 판단

     시간 복잡도: O(N + M)
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameBook = new HashMap<>();
        String[] numBook = new String[N];

        // book에 포켓몬 이름 + 번호 저장
        for(int i = 0; i < N; i++){
            String pocketmon = br.readLine();
            nameBook.put(pocketmon, i+1);
            numBook[i] = pocketmon;
        }

        // 문제 맞추기
        for(int i = 0; i < M; i++){
            // 숫자인지 문자인지 확인
            String line = br.readLine();
            if(Character.isDigit(line.charAt(0))) { // 숫자라면 numBook에서 찾기
                System.out.println(numBook[Integer.parseInt(line)-1]);
            }else{ // 문자라면 nameBook에서 찾기
                System.out.println(nameBook.get(line));
            }
        }

        br.close();
    }
}
