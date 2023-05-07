package baekjoon.문제집.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p7_크리보드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] dp=new long[101];

        //6까지는 순수하게 A를 1개씩추가한것이 최대값이다.
        for(int i=1;i<=6;i++){
            dp[i]=i;
        }

        //붙여넣기횟수에 따른 최대값 구해주는 연산
        for(int i=7;i<=n;i++){
            for(int j=3;j<=i;j++){
                long printed=dp[i-j];
                long cliped=dp[i-j];
                long ctrlV_cnt=j-2;
                dp[i]=Math.max(dp[i],(cliped*ctrlV_cnt)+printed);
            }
        }

        System.out.println(dp[n]);
    }
}
