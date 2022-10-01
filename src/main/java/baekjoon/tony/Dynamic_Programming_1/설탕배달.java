package baekjoon.tony.Dynamic_Programming_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        int k=0;
        while(true){
            if(a%5==0){
                 k+=a/5;
                System.out.println(k);
                break;
            }else{
                a-=3;
                k++;
            }
            if(a<=-1){
                System.out.println(-1);
                return;
            }
        }
    }
}
