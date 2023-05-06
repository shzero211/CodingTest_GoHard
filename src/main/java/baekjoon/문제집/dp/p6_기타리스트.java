package baekjoon.문제집.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p6_기타리스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=0;
        int S = 0;
        int M=0;
        int[] nums = null;
        String[] nsm=br.readLine().split(" ");
        N=Integer.parseInt(nsm[0]);
        S=Integer.parseInt(nsm[1]);
        M=Integer.parseInt(nsm[2]);
        nums=new int[N];
        String[] sn=br.readLine().split(" ");
        for(int j=0;j<N;j++){
            nums[j]=Integer.parseInt(sn[j]);
        }

        int[] dp=new int[M+1];
        dp[S]=1;
        for(int i=1;i<=N;i++){
            int move=nums[i-1];//움직여야하는 거리
            for(int j=0;j<=M;j++){

                if(dp[j]==i){
                    if(0<=j+move&&j+move<=M){
                        dp[j+move]=i+1;
                    }

                    if(0<=j-move&&j-move<=M){
                        dp[j-move]=i+1;
                    }

                }
            }
        }
        int max=-1;
        for(int i=0;i<=M;i++){
            if(dp[i]==N+1)
                max=Math.max(max,i);
        }
        System.out.println(max);
    }
}
