package cah;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P7785_회사에있는사람{
    /*
     문제 요약
      - 직원들의 출근, 퇴근 기록을 보고 회사에 남아있는 직원 출력
      - 출력은 사전 역순
      - "enter": 출근, "leave": 퇴근

     핵심 아이디어
      - HashSet에 출근된 사람 기록
      - 출근 기록된 사람이 퇴근하면 Set에서 삭제
      - Set을 List로 변환해 내림차순 정렬해 출력

     시간 복잡도: O(n + k log k) (k: 회사에 남아 있는 사람 수)
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> inOffice = new HashSet<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String isEnter = st.nextToken();
            // 출근 기록
            if(isEnter.equals("enter")){
                inOffice.add(name);

            // 퇴근 기록
            }else{
                if(inOffice.contains(name)){ // 이미 출근 기록된 상태라면 삭제
                    inOffice.remove(name);
                }
            }
        }

        // ArrayList로 변환해 마지막에 한번 정렬
        List<String> inOfficeList = new ArrayList<>(inOffice.stream().collect(Collectors.toList()));

        inOfficeList.sort(Collections.reverseOrder());

        for(String employee: inOfficeList){
                System.out.println(employee);
        }

        br.close();
    }
}