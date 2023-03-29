package baekjoon.문제집.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2_1로만들기 {
    static int[] dp=new int[1000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        System.out.println(makeOne(num)-1);
    }
    public static int makeOne(int num){
        if(num==0){
            return 1;
        }
        if(num==1){
            return 1;
        }
        if(dp[num]==0){
            if(num%6==0){
                dp[num]=Math.min(makeOne(num-1),Math.min(makeOne(num/2),makeOne(num/3)))+1;
            }else if(num%3==0){
                dp[num]=Math.min(makeOne(num/3),makeOne(num-1))+1;
            }else if(num%2==0){
                dp[num]=Math.min(makeOne(num/2),makeOne(num-1))+1;
            }else{
                dp[num]=makeOne(num-1)+1;
            }
        }
        return dp[num];
    }

}
