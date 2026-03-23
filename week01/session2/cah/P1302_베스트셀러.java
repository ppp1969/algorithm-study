package cah;

import java.io.*;
import java.util.*;

public class P1302_베스트셀러 {
    /*
     문제 요약
      - 팔린 책들 중 가장 많이 팔린 책 제목 출력
      - 가장 많이 팔린 책이 여러 개면 사전순 첫 번째 출력

     핵심 아이디어
      - 가장 HashMap에 책 이름 + 팔린 개수 저장
      - for문 돌면서 저장 시, maxCount값도 같이 갱신
      - maxCount의 value를 가진 key를 가져와 리스트에 넣고 정렬해 출력

     시간 복잡도: O(N + k + t log t) (k: 서로 다른 책 제목 수, T: 최다 판매 책 후보 수)
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> selling = new HashMap<>();
        int maxSellCount = -1; // 가장 많이 팔린 책 개수

        // 판매된 책 기록 & 최댓값 기록
        for(int i = 0; i < N; i++){
            String book = br.readLine();
            int count = selling.getOrDefault(book, 0) + 1;

            selling.put(book, count); // 기록
            maxSellCount = Integer.max(maxSellCount, count); // 최댓값 갱신
        }

        // max 개수의 책 찾기
        List<String> maxSaleBook = new ArrayList<>();
        for(Map.Entry<String, Integer> sell: selling.entrySet()){
            if(sell.getValue() == maxSellCount)
                maxSaleBook.add(sell.getKey());
        }

        // 사전순 첫 번째값 출력
        Collections.sort(maxSaleBook);
        System.out.println(maxSaleBook.get(0));

        br.close();
    }
}
