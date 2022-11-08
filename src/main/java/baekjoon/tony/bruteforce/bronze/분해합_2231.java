package baekjoon.tony.bruteforce.bronze;

import java.io.BufferedReader;
import java.util.Scanner;

public class 분해합_2231 {
    private static void solution(){
        Scanner sc=new Scanner(System.in);
        int value=sc.nextInt();
        int min=0;
        for(int i=value;i>0;i--){
            String str=String.valueOf(i);
            char[] cs=str.toCharArray();
            int sum=0;
            for(char c:cs ){
                sum+=(c-'0');
            }
            if(sum+i==value){
                min=i;
            }
        }
        System.out.println(min);
    }
    public static void main(String[] args) {
        solution();
    }
}
