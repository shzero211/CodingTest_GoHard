package baekjoon.문제집.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9_평범한배낭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[][] dp=new int[n+1][m+1];

        int[] ws=new int[n+1];
        int[] vs=new int[n+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            ws[i]=w;
            vs[i]=v;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=dp[i-1][j];
                if(j-ws[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-ws[i]]+vs[i]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
