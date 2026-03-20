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
		int N = Integer.parseInt(br.readLine()); 
		String alphabet[] = new String[N]; 
		for(int i = 0 ; i < N ; i++) {
			alphabet[i] = br.readLine();
		}
		
		// 테스트 
//		for(int i = 0 ; i < N ; i++) {
//			bw.write(alphabet[i] +  "\n");
//		}

		// 알고리즘 
		int cnt = 0 ; 
		for(int i = 0 ; i < N ; i++) {
			
			boolean isOk = true; 
			String currentAlphabet = alphabet[i];
			
			
			// 2. 총 갯수 세기 
			int count[] = new int[26]; 
			for(int j = 0 ; j < currentAlphabet.length() ; j++) {
				count[currentAlphabet.charAt(j)-'a']++; 
			}
			
			// 총 갯수 체크 테스트  
//			for(int j = 0 ; j < 26 ; j++) {
//				bw.write(count[j] + " ");
//			}
//			bw.write("\n");
			
            // 3. 중복갯수와 총갯수가 일치하는지 체크
			for(int j = 0 ; j < currentAlphabet.length() ; j++) {
				
				// 중복 갯수세기 
				int dupCount = 0; 
				char dupAlphabet = currentAlphabet.charAt(j);
				for(int k = j+1 ; k < currentAlphabet.length() ; k++) {
					if(dupAlphabet == currentAlphabet.charAt(k)) dupCount++;		
				}
				
				// 중복 갯수 테스트
//				bw.write(" dupCount : " + dupCount);


                // 중복갯수가 총 갯수와 일치 안하면 체크
				if(dupCount+1 != count[dupAlphabet-'a']) { isOk = false ; break;}
				
				// 중복 갯수만큼 전진 
				j += dupCount; 
			}
			
			if(isOk) cnt++; 	
//			bw.write("\n");
		}

		
		// 출력 
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

	 


	 
	
	


