import java.util.*;
import java.io.*;

public class P9996_한국이그리울땐서버에접속하지 {
    public static void main(String[] args) throws IOException{
        /**
         * 입력 :
         * - 개수
         * - 패턴
         * - 각 문자열
         * 출력 :
         * - 각 문자열 별로 DA(일치) or NE(불일치) 출력
         *
         *
         * 핵심 : 패턴의 규칙 중 별표는 좌우 끝에 위치하지않음.
         * - 별표는 문자열의 시작과 끝에 있지 않다.
         * - regex 사용하면 될 것 같음.
         *
         * 시간복잡도 : N 개수, M 길이 O(NM)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("[*]");
        String regex = pattern[0] + ".*" + pattern[1]; // *을 regex의 .으로 변경주의!

        for (int i=0; i<n; i++){
            String target = br.readLine();
            if (target.matches(regex)){
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
