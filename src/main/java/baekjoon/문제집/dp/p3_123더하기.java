package baekjoon.문제집.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3_123더하기 {
    static int[] dp=new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int len= Integer.parseInt(br.readLine());
        int[] nums=new int[len];

        for(int i=0;i<len;i++){
            int num=Integer.parseInt(br.readLine());
            nums[i]=num;
        }
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        dp[4]=7;
        for(int i=0;i<nums.length;i++){
            System.out.println(method(nums[i]));
        }

    }

    public static int method(int num){
        if(dp[num]==0){
            return dp[num]=method(num-1)+method(num-2)+method(num-3);
        }
        return dp[num];
    }
}
