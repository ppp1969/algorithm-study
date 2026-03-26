package week01.session2.jsh;

import java.io.*;
import java.util.*;

public class P3_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        /**
         * 듣지도 못한 & 보지도 못한
         * 교집합
         *
         * 입력 :
         * 3 4
         * ohhenrie
         * charlie
         * baesangwook
         * obama
         * baesangwook
         * ohhenrie
         * clinton
         *
         * 출력 :
         * 2
         * baesangwook
         * ohhenrie
         *
         * 유의
         * - 듣보잡의 수와 그 명단을 사전순으로 출력한다.
         * - 이름은 띄어쓰기 없이 알파벳 소문자로만 그 길이는 20 이하
         * - N, M은 500,000 이하의 자연수
         *
         * 기억할 내용
         * - 교집합 : arrayList.retainAll(arrayList2);
         * - 차집합 : arrayList.removeAll(arrayList2);
         * - 합집합 : arrayList.addAll(arrayList2);
         * - 부분집합 판별 : arrayList2.containsAll(arrayList3);
         * - 간단하게는 TreeSet, 빠를 필요가 있거나 복잡한 경우 Hash이후 Collections.sort
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] inputN = new String[n];
        String[] inputM = new String[m];

        for (int i=0; i<n; i++){
            inputN[i] = br.readLine();
        }
        for (int i=0; i<m; i++){
            inputM[i] = br.readLine();
        }

        Set<String> solution = Solution(inputN, inputM);
        ArrayList<String> list = new ArrayList<>(solution);
        Collections.sort(list);
        // sb.append(solution.size()).append("\n");
        sb.append(list.size()).append("\n");
        for (String s : list){ // solution
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static Set<String> Solution(String[] inputN, String[] inputM){
        // N과 M에 대한 Set을 만들어서, 교집합 후 사전순으로 출력
        // 1. TreeSet을 사용. -> 444ms
        // 2. Set으로 교집합 이후, Arrays.sort로 정렬 -> 312ms
        // 3. 위와 같고, Collections로 정렬 -> 300ms
        // 정렬 조건이 복잡한 경우, Hash로 필터링 이후 정렬조건 걸기
        Set<String> n = new HashSet<>(); // Tree
        Set<String> m = new HashSet<>();

        for (String s : inputN){
            n.add(s);
        }

        for(String s: inputM){
            m.add(s);
        }
        n.retainAll(m); // n을 교집합 결과로 바꾼다.. 교집합을 리턴하지 않음
        return n;
    }
}
