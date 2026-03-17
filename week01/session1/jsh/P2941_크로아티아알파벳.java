import java.util.*;
import java.io.*;

public class P2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException{
        /**
         * 크로아티아 알파벳 사전이 존재
         * 입력 : 최대 100글자의 단어
         * 출력 : 몇개의 크로아티아 알파벳로 이루어져있는 지 개수
         * - 사전에 존재하는 2~3길이의 알파벳 제외 모두 1개로 처리
         *
         * 시간복잡도 : O(N^2) - str replace활용
         *
         * 맨 처음에는 Set을 활용한 2-window로 접근하려 했지만,
         * dz=인 3개짜리때문에 3 window도 따로 처리해줘야해서 다른 방식으로 접근하게 됨.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = br.readLine()
                .replaceAll("c=", "a")
                .replaceAll("c-", "a")
                .replaceAll("dz=", "a")
                .replaceAll("d-", "a")
                .replaceAll("lj", "a")
                .replaceAll("nj", "a")
                .replaceAll("s=", "a")
                .replaceAll("z=", "a")
                .length();
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
