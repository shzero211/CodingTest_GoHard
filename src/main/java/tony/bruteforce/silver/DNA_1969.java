package tony.bruteforce.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DNA_1969 {
    public static  void solution() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] alpha=new int[m][26];//열의 알파벳 저장
        StringBuilder sb=new StringBuilder();
        int hammingDistance=0;
        String[] dna=new String[n];

        for(int i=0;i<n;i++){
            dna[i]=br.readLine();
            for(int j=0;j<m;j++){
                alpha[j][dna[i].charAt(j)-'A']++;//열의 알파벳 개수를 나타내는 행렬값 증가
            }
        }

        for(int i=0;i<m;i++){
            int max=alpha[i][0];
            char target='A';
            for(int j=0;j<26;j++){
                if(alpha[i][j]>max){
                    max=alpha[i][j];
                    target=(char)(j+'A');
                }
            }
            sb.append(target);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dna[i].charAt(j) != sb.charAt(j)) hammingDistance++;
            }
        }
        System.out.println(sb.toString());
        System.out.println(hammingDistance);
    }
    public static void main(String[] args) {
        try {
            solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
