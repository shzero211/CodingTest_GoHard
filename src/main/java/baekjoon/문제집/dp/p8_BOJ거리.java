package baekjoon.문제집.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p8_BOJ거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        char[] arr=br.readLine().toCharArray();
        int[] dp=new int[n];

        for(int i=0;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }

        dp[0]=0;

        //각자리에서 이전 값에서 이동시에 최소거리값 저장 시키기
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int min = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                if(arr[j]=='B'&&arr[i]=='O'&&dp[j]!=Integer.MAX_VALUE){
                    dp[i]= min;
                }
                else if(arr[j]=='O'&&arr[i]=='J'&&dp[j]!=Integer.MAX_VALUE){
                    dp[i]= min;
                }
                else if(arr[j]=='J'&&arr[i]=='B'&&dp[j]!=Integer.MAX_VALUE){
                    dp[i]= min;
                }
            }
        }
        System.out.println(dp[n-1]==Integer.MAX_VALUE?-1:dp[n-1]);
    }
}
