import java.util.*;
import java.io.*; 


public class Main
{		
	
	private static BufferedReader br; 
	private static BufferedWriter bw; 
	
	
	 public static void main(String args[]) throws Exception {

		 br = new BufferedReader(new InputStreamReader(System.in)); 
		 bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		 
		// 1. 입출력 
		String s = br.readLine(); 

		// 2. 크로아티아 알파벳 저장 
		String alphabet_2[] = new String[7];
		String alphabet_3 = new String("dz="); 
		
		alphabet_2[0] = new String("c="); 
		alphabet_2[1] = new String("c-"); 
		alphabet_2[2] = new String("d-"); 
		alphabet_2[3] = new String("lj"); 
		alphabet_2[4] = new String("nj"); 
		alphabet_2[5] = new String("s="); 
		alphabet_2[6] = new String("z="); 
		
		
		// 테스트 
//		for(int i = 0 ; i < 7 ; i++) {
//			bw.write("alphabet : " + alphabet_2[i] + "\n");
//			bw.write("\n");
//		}
		
		// 3. 패딩 
		StringBuilder sb = new StringBuilder(s); 
		sb.append('A'); sb.append('A'); sb.append('A');
		s = sb.toString(); 
		
		// 테스트 
//		bw.write(s);
		
		// 알고리즘
		int cnt = 0;   
		int idx = 0; 
		while(true) {
			
			int current_idx = idx; 
			
            // 4. 의심 문자열 추출 
			StringBuilder sb_2 = new StringBuilder(s);
			String suspect_2 = sb_2.substring(idx,idx+2); 
			
			StringBuilder sb_3 = new StringBuilder(s); 
			String suspect_3 = sb_3.substring(idx,idx+3);
			
            // 테스트
//			System.out.println("suspect_2 : " + suspect_2); 
//			System.out.println("suspect_3 : " + suspect_3);
			
			// 5. 종료 조건 체크 
			// AA
			if(suspect_2.charAt(0) == 'A') break; 
			// vA
			if(suspect_2.charAt(1) == 'A') {cnt++ ; break; } 
			
            // 6. 의심 
			for(int i = 0 ; i < 7 ; i++) {
				if(suspect_2.equals(alphabet_2[i])) {cnt++; idx+=2; } 
			}
			if(suspect_3.equals(alphabet_3)) {cnt++; idx+=3; } 	
			if(current_idx == idx) {cnt++; idx++; } 
			
		}
		
		// 5.결과 출력 
		bw.write(cnt+"");
		
		

		
		
		
		
		
		
		bw.flush();
		bw.close();
		br.close();
		
		// 1157
		// 2941
		// 1316
		// 9996 
		
	 
	 }	
}

	 


	 
	
	


