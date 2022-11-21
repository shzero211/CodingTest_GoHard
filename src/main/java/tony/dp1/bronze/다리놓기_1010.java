package tony.dp1.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 다리놓기_1010 {
    static int [][]arr=new int[30][30];
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        for(int i=0;i<num;i++){
            int b=scanner.nextInt();
            int a=scanner.nextInt();
            System.out.println(combi(a,b));
        }
    }
    static int combi(int a, int b){
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        if(arr[a][b]>0){
            return arr[a][b];
        }
        if(a==b||b==0){
            return arr[a][b]=1;
        }
        return arr[a][b]=combi(a-1,b-1)+combi(a-1,b);
    }

}
