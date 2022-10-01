package baekjoon.tony.brute_force.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=1;i<n;i++){
            int start=i;
            int sum=i;
            while(start!=0){
                sum=sum+start%10;
                start/=10;
            }
            if(sum==n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
        return;
    }
}
