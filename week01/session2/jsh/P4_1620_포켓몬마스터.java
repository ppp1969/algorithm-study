package week01.session2.jsh;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P4_1620_포켓몬마스터 {
    public static void main(String[] args) throws IOException {
        /**
         * 포켓몬 마스터
         * 입력 :
         * 26(도감몹수) 5(문제)
         * Bulbasaur
         * Ivysaur
         * Venusaur
         * Charmander
         * Charmeleon
         * Charizard
         * Squirtle
         * Wartortle
         * Blastoise
         * Caterpie
         * Metapod
         * Butterfree
         * Weedle
         * Kakuna
         * Beedrill
         * Pidgey
         * Pidgeotto
         * Pidgeot
         * Rattata
         * Raticate
         * Spearow
         * Fearow
         * Ekans
         * Arbok
         * Pikachu
         * Raichu
         * 25
         * Raichu
         * 3
         * Pidgey
         * Kakuna
         *
         * 출력 :
         * Pikachu
         * 26
         * Venusaur
         * 16
         * 14
         *
         * 도감을 입력한 이후
         * 퀴즈에서
         * - 번호로 나오면 -> 이름 대답
         * - 이름으로 나오면 -> 번호 대답
         *
         * 유의 :
         * - N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수, N^2 등 불능
         * - 포켓몬의 이름은 모두 영어로, 첫 글자만 대문자이고, 나머지 문자는 소문자로만구성.
         * - 일부 포켓몬은 마지막 문자만 대문자 (lowwer 사용)
         *
         *
         * 기억하고 싶은 것:
         * - [0-9]*는 빈문자열도 매칭되기에 +를 사용하기.
         * - 문제에서 보장해준다면, charAt[0]만 비교해도 충분
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도감
        int m = Integer.parseInt(st.nextToken()); // 퀴즈

        String[] inputN = new String[n];
        String[] inputM = new String[m];

        for (int i=0; i<n; i++){
            inputN[i] = br.readLine();
        }
        for (int i=0; i<m; i++){
            inputM[i] = br.readLine();
        }

        String[] solution = Solution(inputN, inputM);

        for (String s : solution){
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static String[] Solution(String[] inputN, String[] inputM){
        // 도감에 저장
        Map<Integer, String> pokeIntStr = new HashMap<>();
        Map<String, Integer> pokeStrInt = new HashMap<>();

        for (int i=0; i<inputN.length; i++){
            pokeIntStr.put(i+1, inputN[i]); // 1-based로 변경
            pokeStrInt.put(inputN[i], i+1);
        }

        // inputM을 돌며, 이름 대답 or 번호 대답
        String[] result = new String[inputM.length];

        for (int i = 0; i < inputM.length; i++) {
            if (inputM[i].matches("[0-9]+")){ //
                result[i] = pokeIntStr.get(Integer.parseInt(inputM[i]));
            } else{
                result[i] = String.valueOf(pokeStrInt.get(inputM[i]));
            }
        }

        return result;
    }
}
